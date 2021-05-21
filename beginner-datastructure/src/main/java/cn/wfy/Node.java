package cn.wfy;

public class Node {
    private Object value;
    private Node next;
    private Node head;

    public Node() {
    }

    public Node(Object value) {
        if (next == null) {
            this.value = value;
        }
    }
/*
    //头插法
    public void add(Object val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        node.next=head;
        head=node;
    }*/


    //尾插法
    public void add(Object val) {
        Node node = new Node(val);

        if (head == null) {
            head=node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public Object get(int index) {
        Node temp = this;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public void set(int index, Object val) {
        Node temp = this;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = val;
    }

    public void remove(int index) {
        Node temp = this;
        Node temp1 = this;
        if (index == 0) {
            head = temp.next;
            return;
        }

        //prev
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        for (int i = 0; i < index + 1; i++) {
            temp1 = temp1.next;
        }
        temp.next = temp1;
        head=temp;

    }


}
