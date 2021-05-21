package cn.wfy.service;

import cn.wfy.dao.IplogDao;
import cn.wfy.dao.JitangDao;
import cn.wfy.util.SnowId;
import cn.wfy.util.SnowflakeIdWorker;
import cn.wfy.vo.Iplog;
import cn.wfy.vo.Soul;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/9/13
 */
@Service
public class JitangService {
    @Autowired
    private JitangDao jitangDao;
    @Autowired
    private IplogDao iplogDao;
    public Soul getJitang(HttpServletRequest request) {
        Soul soul =  strategy(null);
        String ip = getIp(request);
        Iplog iplog=new Iplog();
        iplog.setId(SnowId.getId());
        iplog.setIp(ip);
        iplog.setDate(new Date());
        iplog.setSoulId(String.valueOf(soul.getId()));

        Iplog save = iplogDao.save(iplog);
        System.out.println(save);
        return soul;
    }

    /***
     * 10分钟内是短期
     * 近期看过了不会再看到，hit越大越容易看到
     * @return
     */
    private Soul strategy(String ip) {
        //判断是否是短期
        Iplog iplog = iplogDao.findLastOne(ip);
        Date date = iplog.getDate();
        Date shortDate = new Date(System.currentTimeMillis() - 10 * 60 * 1000);
        if (date.before(shortDate)){
            //短期
        }
        Example example = Example.create(Soul.class);

//        jitangDao.findOne()
        Soul soul = jitangDao.selectRand();
        return soul;
    }

    /**
     * 获取ip
     */
    private String getIp(HttpServletRequest request) {
        List<String> ipHeadList = Stream.of("X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "X-Real-IP").collect(Collectors.toList());
        for (String ipHead : ipHeadList) {
            if (checkIP(request.getHeader(ipHead))) {
                return request.getHeader(ipHead).split(",")[0];
            }
        }
        return "0:0:0:0:0:0:0:1".equals(request.getRemoteAddr()) ? "127.0.0.1" : request.getRemoteAddr();

    }

    /**
     * 检查ip存在
     */
    private boolean checkIP(String ip) {
        return !(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip));
    }
}
