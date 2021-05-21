package cn.wfy.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GeneralScrect {

    static Writer writer = null;
    static String name = "aaa.txt";

    {
        try {
            writer = new FileWriter(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        GeneralScrect generalScrect = new GeneralScrect();
        for (int i = 9909999; i < 10000000; i++) {
            builder.append(i + "\n");
            if (i % 33333 == 0) {
                generalScrect.writeIt(builder.toString());
                builder.delete(0, builder.length());
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private void writeIt(String str) {
        try {
            if (writer == null) {
                writer = new FileWriter(name);
            }
            writer.write(str);

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
