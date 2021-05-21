package cn.wfy.abc;

public class Abcd implements Abc{
    @Override
    public void add() {
        System.out.println("zizizizizizizi");
    }

    public static void main(String[] args) {
        Abcd abcd = new Abcd();

        abcd.add();
        Abd.toAb(abcd);
        abcd.add();
    }
}
