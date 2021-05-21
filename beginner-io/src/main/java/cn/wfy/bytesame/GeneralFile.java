package cn.wfy.bytesame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class GeneralFile {
    public static void main(String[] args) throws IOException {
        genaral();
    }

    private static void genaral() throws IOException {

        Long byteSize = 1000000000l;
        String str = "fsd32sdfSDFS0昆仑山地方看23478fkljsa士大夫立刻时间234@#！13方法2123";
        String[] strArray = str.split("");
        System.out.println(strArray.length);

        Writer fileWriter = new FileWriter("E:\\code\\gitee\\beginner\\beginner\\beginner-io\\src\\main\\resources\\file\\do.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        Random random = new Random();


        Random runRandom = new Random(random.nextLong());
        for (int i = 0; i < byteSize; i++) {
            int key = runRandom.nextInt(strArray.length);
            try {
                bufferedWriter.write(strArray[key]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (i % (1024 * 1024) == 0) {
                try {
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        bufferedWriter.close();


    }
}
