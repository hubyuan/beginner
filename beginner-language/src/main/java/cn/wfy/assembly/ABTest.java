package cn.wfy.assembly;

/***
 *
 * @Description ABTest
 * @Author wfy
 * @Date 2021/5/8 10:56
 */
public class ABTest {
    public static void main(String[] args) {
        B b = new B();
        for (int i = 0; i < 100; i++) {
            b.doing("kkk");
        }
        A a = new A();
        a.doing("asfsad");

    }
}
