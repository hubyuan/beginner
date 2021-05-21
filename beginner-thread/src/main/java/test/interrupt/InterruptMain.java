package test.interrupt;

public class InterruptMain {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            ThreadInterrupt threadInterrupt = new ThreadInterrupt();

            threadInterrupt.run();
            Thread.sleep(1000);

        }
    }
}
