package cn.wfy.chain;

/**
 * @Description TODO
 * @auther wfy
 * @since 2024/2/26
 */


class NewChain {

    int hashcode;
    int data;
    NewChain next;


    public NewChain(int hashcode, int data) {
        this.hashcode = hashcode;
        this.data = data;
    }


}

// 链表类
class NewChainList {
    NewChain head;

    // 构造函数
    public NewChainList() {
        this.head = null;
    }

    // 在链表末尾添加节点
    public void append(int hashcode ,int data) {
        //算法判断 判断hashcode

        NewChain newNewChain = new NewChain(hashcode,data);

        if (head == null) {
            head = newNewChain;
            return;
        }

        NewChain current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNewChain;
    }

    // 打印链表
    public void printList() {
        NewChain current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// 示例用法
 class Main1 {
    public static void main(String[] args) {
        NewChainList newChainList = new NewChainList();

        newChainList.append(1,1);
        newChainList.append(1,2);
        newChainList.append(1,3);

        System.out.println("Linked List: ");
        newChainList.printList();
    }
}
