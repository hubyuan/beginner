package cn.wfy.assembly;

import java.util.ArrayList;
import java.util.stream.IntStream;

/***
 *
 * @Description AssemblyCode
 * @Author wfy
 * @Date 2021/5/6 18:05
 */
public class AssemblyCode {

    public static class ClassIt {
        private String name;
        private String age;

        public ClassIt() {
        }

        public ClassIt(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "ClassIt{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }

    public AssemblyCode() {


        ArrayList<String> arrayList = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> arrayList.add(String.valueOf(i)));

//            long a = System.currentTimeMillis();
        arrayList.stream().forEach(array -> {
            ClassIt classIt = new ClassIt();
            classIt.setAge(array + "a");
            classIt.setName(array + "a");

            ClassIt classIt1 = new ClassIt();
            classIt1.setAge(array + "a");
            classIt1.setName(array + "a");

        });
//
//
//            long b = System.currentTimeMillis();
//            System.out.println(b - a + "ms");


    }


    public static void main(String[] args) {
        new AssemblyCode();
    }
}