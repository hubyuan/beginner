package cn.wfy.二叉树的最小高度;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/6
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] values =  new Integer[]{1,3,4,null,null,34,21};

        TreeNode root = new DefaultMutableTreeNode(values);

        solution.minDepth(root);
    }

    private int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
//       q.offer()
        return 0;
    }
}
