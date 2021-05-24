package cn.wfy.assembly.asmTest;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/***
 *
 * @Description Client
 * @Author wfy
 * @Date 2021/5/24 14:27
 */
public class Client {
    public static void main(String[] args) {
        //将代理类存到本地磁盘
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code\\github\\beginner\\beginner-language\\src\\main\\java\\cn\\wfy\\assembly\\asmTest");
        //实例化增强器
        Enhancer enhancer = new Enhancer();
        //设置需要代理的目标类
        enhancer.setSuperclass(DaoOne.class);
        //设置拦截对象 回调的实现类
        // enhancer.setCallback(new DaoProxy());
        enhancer.setCallbacks(new Callback[]{new DaoOneProxy(), new DaoAnotherProxy(), NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoFilter());
        //使用create 返回Object 生成代理类并返回实例
        DaoOne dao = (DaoOne) enhancer.create();
        //select优先级高 使用DaoProxy
        dao.select();
        //无法代理被final修饰的方法
        dao.delete();
        dao.insert();

    }
}
