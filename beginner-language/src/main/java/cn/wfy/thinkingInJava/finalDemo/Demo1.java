package cn.wfy.thinkingInJava.finalDemo;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/3
 */
public  class Demo1 {
    public Demo1() {
    }

    private Demo1(int a) {
    }

    private void testFinal() {
        System.out.println(1);
    }

    public void testFina2() {
        System.out.println(1);
    }

    protected void testFina3() {
        System.out.println(1);
    }

    void testFina4() {
        System.out.println(1);
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.testFinal();
        demo1.testFina2();
        demo1.testFina3();
        demo1.testFina4();
    }

}

