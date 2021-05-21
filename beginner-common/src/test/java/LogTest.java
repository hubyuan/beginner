import cn.wfy.util.LogManager;
import cn.wfy.util.LogUtil;

public class LogTest {
    public static void main(String[] args) {
        LogUtil logger = LogManager.getLogger();
        logger.info("hi");
        logger.info("hi");
        logger.info("hi");
        logger.info("hi");
        logger.info("hi");
    }
}
