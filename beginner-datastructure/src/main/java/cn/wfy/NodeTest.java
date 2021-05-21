package cn.wfy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class NodeTest {
   static class AAA{
        private int id;
        private String name;

        public AAA() {
        }

        public AAA(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {


        Node node = new Node();
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);

        System.out.println(node);



        int[] aaa = {1,2,3,4,5,6,7,9};
        LinkedList<Object> objects = new LinkedList<>();
        ArrayList<Object> objects1 = new ArrayList<>();
        objects.add(1);
        objects.add(11);
        objects.add(12);
        objects.add(13);
        objects1.add(2);
        objects1.add(20);
        objects1.add(21);
        objects1.add(23);
        objects1.add(24);
        objects.forEach(System.out::println);
        objects1.forEach(System.out::println);


        ClassLoader classLoader1 = node.getClass().getClassLoader();
        System.out.println(classLoader1.getParent());

        cn.wfy.LinkedList<Object> objectLinkedList = new cn.wfy.LinkedList<>();
        ClassLoader classLoader = objectLinkedList.getClass().getClassLoader();
        System.out.println(classLoader.getParent());


        ClassLoader classLoader2 = StringBuffer.class.getClassLoader();
        System.out.println(classLoader2.getParent());
    }
}
