package cn.wfy.plugins;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.*;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/21
 */
@Component
@Intercepts(@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, org.apache.ibatis.session.ResultHandler.class}))
public class MyPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler target = (StatementHandler) invocation.getTarget();
        ParameterHandler parameterHandler = target.getParameterHandler();

        BoundSql boundSql = target.getBoundSql();
        String sql = boundSql.getSql();
        System.out.println(sql);

        Object parameterObject = parameterHandler.getParameterObject();
        if (parameterObject instanceof String) {
            String map = (String) parameterObject;
            oneParam(map, sql);
        }
        if (parameterObject instanceof Map) {
            Map<String, String> map = (Map) parameterObject;
            manyParam(map, sql);
        }

        Object proceed = invocation.proceed();
        return proceed;
    }

    private void oneParam(String map, String sql) {
        sql = sql.replaceFirst("\\?", map);
        System.out.println(sql);
    }

    private void manyParam(Map<String, String> map, String sql) {
        Set<String> strings = map.keySet();
        int count = 0;
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key != null && key.contains("param")) {
                count++;
            }
        }

        for (int i = 1; i <= count; i++) {
            String value = map.get("param" + i);
            if (value != null) {
                if (value instanceof String) {
                    value = "\"" + value + "\"";
                }
                sql = sql.replaceFirst("\\?", value);
            }
        }
        System.out.println(sql);
    }


    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
