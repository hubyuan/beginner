package cn.wfy.chain;

/**
 * @Description TODO
 * @auther wfy
 * @since 2024/2/26
 */
class Node {
    int data;
    Node next;

    // 构造函数
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 链表类
class LinkedList {
    Node head;

    // 构造函数
    public LinkedList() {
        this.head = null;
    }

    // 在链表末尾添加节点
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // 打印链表
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// 示例用法
 class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        System.out.println("Linked List: ");
        linkedList.printList();
    }
}
