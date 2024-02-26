package cn.wfy.year2022;

/**
 * @Description TODO
 * @auther wfy
 * @since 2022/7/2
 */
public class Node<T> {
    private Node<T> head;
    private Node<T> last;
    private T t;
    private int size;

    public int getSize() {
        return size;
    }

    public Node() {
        head = new Node<>();
        last = head;
    }



    //增删改查
    public void add(T t) {

    }
}
