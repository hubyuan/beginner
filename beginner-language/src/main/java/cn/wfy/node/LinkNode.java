package cn.wfy.node;

public class LinkNode {
    Node head = null;

    class Node {
        Node next = null;
        Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Node() {
        }

        public void add(Object data) {
            if (head == null) {
                this.data = data;
            }
            if (this.data == null) {

            }

        }
    }
}
