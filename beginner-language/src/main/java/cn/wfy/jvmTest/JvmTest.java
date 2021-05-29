package cn.wfy.jvmTest;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/2/14
 */
public class JvmTest {


    public static void main(String[] args) {

        JvmTest jvmTest = new JvmTest();
        jvmTest.bbb();
        while (true) {
            byte[] bytes = new byte[1024 * 1024];
        }
    }

    private void bbb() {
        Bbb bbb = new Bbb();
        String age = bbb.aaa.getAge();
    }

}
