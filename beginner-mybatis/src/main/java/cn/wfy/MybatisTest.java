package cn.wfy;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/21
 */
public class MybatisTest {
    public static void main(String[] args) {
        String sql = "asdasd e ? sadfas e ?";
        String p1 = sql.replaceFirst("\\?", "p1");
        System.out.println(p1);

    }
}
