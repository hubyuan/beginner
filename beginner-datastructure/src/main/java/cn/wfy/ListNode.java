package cn.wfy;

public class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }


    public static void main(String[] args) {

        ListNode nodeSta = new ListNode(0);    //创建首节点
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                      //指向首节点

        //创建链表
        for (int i = 1; i < 10; i++) {
            ListNode node = new ListNode(i);  //生成新的节点
            nextNode.next = node;               //把心节点连起来
            nextNode = nextNode.next;           //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，

        nextNode = nodeSta;                     //重新赋值让它指向首节点
        System.out.println(nextNode);                      //打印输出

    }
}
