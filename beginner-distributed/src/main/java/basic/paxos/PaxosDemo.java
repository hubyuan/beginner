package basic.paxos;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author : wangfangyuan
 * @date : 2023/1/17 15:48
 */
public class PaxosDemo {

    public static void main(String[] args) {
//        PaxosDemo paxosDemo = new PaxosDemo();
        PaxosNode paxosNode = new PaxosNode();
//        paxosDemo.proposal()
        for (int i = 0; i < nodeSize; i++) {
            paxosNode.learner(paxosNode.acceptor());
        }
        int acceptor = paxosNode.acceptor();
        System.out.println(acceptor);
    }

    public PaxosDemo() {
    }


    /***
     * 提案节点
     */
    private  PaxosNode proposal;
    /***
     * 决策节点
     */
    private  PaxosNode acceptor;
    /***
     * 记录节点
     */
    private  PaxosNode learner;

    private static int nodeSize;

    private static List<Integer> nodeNumber;

    static {
        if (nodeSize == 0) {
            nodeSize = PaxosNode.getSize();
        }


    }



    final static class PaxosNode {

        /***
         * 提案
         */
        public int proposal() {
            Random random = new Random(nodeSize);
            return random.nextInt();
        }

        public void learner(int num) {
            if (nodeNumber == null) {
                nodeNumber = new ArrayList<>();
            }
            nodeNumber.add(num);
        }

        public int acceptor() {
            //使用topk
            int k = 2;
            k = nodeNumber.size() - k + 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 大顶堆
            for (int val : nodeNumber) {
                pq.add(val);
                if (pq.size() > k)  // 维护堆的大小为 K
                    pq.poll();
            }
            return pq.peek();

        }

        public static int getSize() {
            return 10;
        }
    }

}
