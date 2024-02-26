import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @auther wfy
 * @since 2023/8/27
 */
public class Test123 {

    public static void main(String[] args) {
//        c
        ArrayList<String> arrayList = new ArrayList<>();
        while (true){
            new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    String name = thread.getName();
                    String asdfasdf = name+"================sfdhaslkdfjal;skdjfl;kasdjfl;kasdjf;lasdf";
                    arrayList.add(asdfasdf);
                    asdfasdf=null;

                }
            }.run();

        }



    }

    String vari ;
    private void abc(int number) {
//        numberOne.asdfasd
         vari += String.valueOf(number);
        System.out.println(vari);

    }

}
