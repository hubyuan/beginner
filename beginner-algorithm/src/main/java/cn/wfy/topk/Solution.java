package cn.wfy.topk;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        TopK pq = new TopK(4);
        for (int n : array) {
            pq.add(n);
        }
        System.out.println(pq.sortedList());
    }


}

class TopK<E extends Comparable> {

    private int maxSize;
    private PriorityQueue<E> queue;

    public TopK(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalStateException();
        }
        this.maxSize = maxSize;
        this.queue = new PriorityQueue<>(maxSize, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                // 最大堆用o2 - o1，最小堆用o1 - o2
                return (o1.compareTo(o2));
            }
        });
    }

    public void add(E e) {
        if (queue.size() < maxSize) {
            queue.add(e);
        } else {
            E peek = queue.peek();
            if (e.compareTo(peek) > 0) {
                queue.poll();
                queue.add(e);
            }
        }
    }

    public List<E> sortedList() {
        List<E> list = new ArrayList<>(queue);
        Collections.sort(list);
        return list;
    }
}
