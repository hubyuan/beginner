package cn.wfy.node;

import java.util.LinkedList;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/7/8
 */
public class NodeTest {

    public static void main(String[] args) {
//        LinkedList linkedList=new LinkedList();
//        linkedList.remove();
        Node node = new Node();

        node.add("hu1");
        node.add("li2");
        node.add("dd3");
        node.add("op4");
        System.out.println(node.toString());
        System.out.println(node.size());
        node.remove(1);
        System.out.println(node.toString());
    }
}
