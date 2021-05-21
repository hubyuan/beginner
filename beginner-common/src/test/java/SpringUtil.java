import cn.wfy.util.Shell;
import cn.wfy.util.SpringContextUtils;

public class SpringUtil {
    public static void main(String[] args) {
        Shell bean = SpringContextUtils.getBean(Shell.class);
        if (bean == null) {
            System.out.println("================");
        }
        System.out.println(bean);

    }
}
