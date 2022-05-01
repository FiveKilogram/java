/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 有效的数独满足以下三个条件：
 *  同一个数字在每一行只能出现一次；
 *  同一个数字在每一列只能出现一次；
 *  同一个数字在每一个小九宫格只能出现一次。
 *
 * 时间复杂度：O(1)
 * 空间复杂度: O(1)
 * 时间复杂度：在固定 9*9 的问题里，计算量不随数据变化而变化。复杂度为 O(1)
 * 空间复杂度：在固定 9*9 的问题里，存储空间不随数据变化而变化。复杂度为 O(1)
 * https://leetcode-cn.com/problems/valid-sudoku/solution/you-xiao-de-shu-du-by-leetcode-solution-50m6/
 * @author luweiliang
 * @created 2020/5/22
 */
public class Lc_37_解数独 {

    public static void solveSudoku(char[][] board) {
        //定义数字行内出现的次数
        //定义数字列内出现的次数
        //定义数字九宫格内出现的次数最大为9次
        boolean[][] rowArr = new boolean[9][9], colArr = new boolean[9][9], boxArr = new boolean[9][9];
        //初始化，该赋值的赋值
        init(board, rowArr, colArr, boxArr);

        //深度优先搜索遍历
        dfs(board, 0, 0, rowArr, colArr, boxArr);
    }

    private static void init(char[][] board, boolean[][] rowArr, boolean[][] colArr, boolean[][] boxArr){
        //遍历数组
        for (int row = 0; row < 9; row ++) {
            for (int col = 0; col < 9; col ++) {
                char c = board[row][col];
                //只要存在数字，如果有'.'退出循环
                if (c == '.') {
                    continue;
                }
                //数字
                int digit = c - '0' - 1;
                //计算小方块的索引
                int boxIdx = row / 3 * 3 + col / 3;
                rowArr[row][digit] = true;  colArr[col][digit] = true; boxArr[boxIdx][digit] = true;
            }
        }
    }

    private static boolean dfs(char[][] board, int row, int col, boolean[][] rowArr, boolean[][] colArr, boolean[][] boxArr){
        while (board[row][col] != '.') {
            col += 1;
            if (col == 9) {
                row += 1;
                col = 0;
            }
            if (row == 9) return true;
        }
        for (char c = '1'; c <= '9'; c ++) {
            //数字
            int digit = c - '0' - 1;
            //计算小方块的索引
            int boxIdx = row / 3 * 3 + col / 3;

            //尝试下一个
            if (rowArr[row][digit] || colArr[col][digit] || boxArr[boxIdx][digit]) continue;

            //进行赋值
            board[row][col] = c;
            rowArr[row][digit] = true;  colArr[col][digit] = true; boxArr[boxIdx][digit] = true;

            //没有冲突，则使用当前的这个字符, dfs遍历操作
            if (dfs(board, row, col, rowArr, colArr, boxArr)) return true;

            //如果行、列、小方格不满足则回溯，撤回操作，还原回来
            board[row][col] = '.';
            rowArr[row][digit] = false;  colArr[col][digit] = false; boxArr[boxIdx][digit] = false;

        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);

        //打印结果到控制台
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j == 8) {
                    System.out.print("\n");
                }
            }
        }
    }
}
