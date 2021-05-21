package cn.wfy.N皇后;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/5
 */
public class Solution {
    static List<LinkedList<String>> res = new LinkedList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
        res.forEach(System.out::println);
        System.out.println(res.size());
    }

    /* 输入棋盘边长 n，返回所有合法的放置 */
    public List<LinkedList<String>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        LinkedList<String> board = new LinkedList<>();

        backtrack1(board, n);
        return res;
    }

    private void backtrack(LinkedList<String> board, int num) {
        if (board.size() == num) {
            res.add(new LinkedList<>(board));
            return;
        }

        for (int i = 0; i < num; i++) {
            boolean flag = false;
            if (board.contains(String.valueOf(i))) {
                if (!res.contains(board)) {
                    res.add(new LinkedList<>(board));
                }
                continue;
            }
            for (int j = 0; j < board.size(); j++) {
                if (board.size() == (Integer.valueOf(board.get(j)) + i)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                if (!res.contains(board)) {
                    res.add(new LinkedList<>(board));
                }
                continue;
            }


            board.add(String.valueOf(i));
            backtrack(board, num);
            board.removeLast();
        }

    }


    private void backtrack1(LinkedList<String> board, int num) {
        if (board.size() == num) {
            res.add(new LinkedList<>(board));
            return;
        }

        for (int i = 0; i < num; i++) {
            if (board.contains(String.valueOf(i))) {
                continue;
            }
    /*        if (board.contains(String.valueOf(i - 1)) && (Math.abs(board.size() - Integer.valueOf(board.get(board.size() - 1))) == i)) {
                continue;
            }
            if (board.contains(String.valueOf(i + 1)) && (Math.abs(board.size() - Integer.valueOf(board.get(board.size() - 1))) == i)) {
                continue;
            }*/

            if (board.contains(String.valueOf(i - 1)) && ((board.size() + 1) == i || board.size() - 1 == i)) {
                continue;
            }
            if (board.contains(String.valueOf(i + 1)) && ((board.size() + 1) == i || board.size() - 1 == i)) {
                continue;
            }
            board.add(String.valueOf(i));
            backtrack1(board, num);
            board.removeLast();
        }
    }
}


