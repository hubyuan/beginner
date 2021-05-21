package cn.wfy;

public class LinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    transient int size;


    @Override
    public void add(T t) {
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    class Node<E> {
        E item;
        Node next;
        Node prev;

        public Node(E item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
