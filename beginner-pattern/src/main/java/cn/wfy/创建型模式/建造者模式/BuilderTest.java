package cn.wfy.创建型模式.建造者模式;

/***
 *
 * @Description BuilderTest
 * @Author wfy
 * @Date 2021/5/24 17:06
 */
public class BuilderTest {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("").setIo("12").build();
        String s = computer.toString();
        System.out.println(s);
    }
}
