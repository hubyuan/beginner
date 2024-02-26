package cn.wfy.node;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/9/14
 */
public class DoubleList {
    private Node first;
    private Node last;
    private int size;

    boolean isEmpty() {
        return size == 0;
    }

    //构造方法
    //search
    public Node find(String key) {
        return null;
    }

    public Node add(Object value) {
        return add(size, value);
    }

    //获取节点
    public Node getNode(int index){
        Node n;
        if(index>=size/2){
            n=last;
            for(int i=size;i>index;i--){
                n=n.pre;
            }
            return n;
        }
        else{
            n=first;
            for(int i=0;i<=index;i++){
                n=n.next;
            }
            return n;
        }
    }

    //insert
    public Node add(int index, Object value) {
        if (index < 0 || index > size) {
            return null;
        }
        Node node = new Node(value,getNode(size-1),last);
        if (isEmpty()) {
            first = node;
            last = node;
            first.next = last;
            last.pre = first;
        } else if (index == 0) {
//            node.pre
        }

        return null;
    }

    //delete
    public Node delete(String key) {
        return null;
    }

    class Node {
        private Object data;
        private Node next;
        private Node pre;

        public Node(Object data, Node next, Node pre) {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }
//xxx

    }
}
