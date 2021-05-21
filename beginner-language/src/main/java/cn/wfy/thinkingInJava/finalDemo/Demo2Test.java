package cn.wfy.thinkingInJava.finalDemo;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/4
 */
public class Demo2Test extends Demo2 {

    @Override
    void aaa(int a) {

        a++;
        System.out.println("zizizi");
    }

    public static void main(String[] args) {
        Demo2Test demo2Test = new Demo2Test();
        demo2Test.aaa(1);
    }


}
