package cn.wfy.assembly;

/***
 *
 * @Description ThreadVolitile
 * @Author wfy
 * @Date 2021/5/7 10:59
 */
public class ThreadVolitile {
    private static int a = 0, b = 0;
    private static int x = 0, y = 0;

    public static void main(String[] args) {
        try {
            int i = 0;
            for (; ; ) {
                i++;
                a = 0;
                b = 0;
                x = 0;
                y = 0;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        a = 1;
                        x = b;
                    }
                });
                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        b = 1;
                        y = a;
                    }
                });
                // 按预期，无论2个线程如何执行，x,y不可能同时为0；
                thread.start();
                thread1.start();
                thread.join();
                thread1.join();
                if (x == 0 && y == 0) {
                    System.out.println("执行第" + i + "次，" + "指令重排序");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}