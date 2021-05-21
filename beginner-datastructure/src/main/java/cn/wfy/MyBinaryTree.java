package cn.wfy;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/23
 */
public class MyBinaryTree {
    private Object data;
    private MyBinaryTree left;
    private MyBinaryTree right;
    private MyBinaryTree parent;

    public MyBinaryTree() {
    }

    public MyBinaryTree(Object data) {
        if (this.parent == null) {
            this.data = data;
        }
    }

    public void addLeft(Object val) {
        MyBinaryTree tree = new MyBinaryTree(val);
        if (parent == null) {
            parent = tree;
            return;
        }
        MyBinaryTree temp = parent;
        while (temp.left != null) {
            temp = temp.left;
        }
        temp.left = tree;
    }

    public void addRight(Object val) {
        MyBinaryTree tree = new MyBinaryTree(val);

        if (parent == null) {
            parent = tree;
            return;
        }
        MyBinaryTree temp = parent;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = tree;
    }

    public void viewTree(MyBinaryTree tree) {
        System.out.print(tree.data + "\t");
    }

    public void viewTreeBefore(MyBinaryTree tree) {
        if (tree == null) {
            return;
        }
        viewTree(tree);
        viewTreeBefore(tree.left);
        viewTreeBefore(tree.right);
    }

    public void viewTreeAfter(MyBinaryTree tree) {
        if (tree == null) {
            return;
        }
        viewTreeAfter(tree.left);
        viewTreeAfter(tree.right);
        viewTree(tree);
    }

    public void viewTreeMidlle(MyBinaryTree tree) {
        if (tree == null) {
            return;
        }
        viewTreeMidlle(tree.left);
        viewTree(tree);
        viewTreeMidlle(tree.right);

    }

    public int getLeafNum(MyBinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 1;
        }
        int rightNum = getLeafNum(tree.right);
        int leftNum = getLeafNum(tree.left);
        return rightNum + leftNum;
    }


    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.addLeft("1");
        tree.addLeft("2");
        tree.addRight("3");
        tree.addLeft("4");
        tree.addRight("5");
        tree.addLeft("6");
        tree.addRight("7");

        tree.viewTreeBefore(tree.parent);
        System.out.println();
        tree.viewTreeAfter(tree.parent);
        System.out.println();
        tree.viewTreeMidlle(tree.parent);
        System.out.println();
        System.out.println(tree.getLeafNum(tree.parent));
    }
}
