package cn.wfy.node;

public class Node<T> {
    private static int index = 0;
    T item;
    private Node<T> prev;
    Node<T> next;

    private static int size = 1;


    public Node() {
    }

    public Node(T item, Node<T> prev, Node<T> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    int size() {
        return size;
    }

    void add(T val) {
        if (val == null) {
            return;
        }
        if (this.item == null) {
            this.item = val;

        } else if (this.item != null) {

            if (this.next == null) {
                this.next = new Node<>();
                this.next.index = this.index + 1;
                size++;
//                this.next.prev=this;
            }
            this.next.add(val);
        }
    }

    void remove(int index) {
        if (this.index++ == index) {
            this.next = this.next.next;

            size--;

        } else {
            this.next.remove(index);
        }
    }

    private void removeIndex() {

        this.next.index = this.next.index - 1;
        this.next.removeIndex();
//        if ()

    }

    void query(T val) {

    }

    @Override
    public String toString() {
        return "Node{" + ", item=" + item + ", next=" + next + '}';
    }
}

