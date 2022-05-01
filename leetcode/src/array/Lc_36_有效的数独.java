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
public class Lc_36_有效的数独 {

    public static boolean isValidSudoku(char[][] board) {
        //定义数字行内出现的次数
        //定义数字列内出现的次数
        //定义数字九宫格内出现的次数最大为9次
        boolean[][] rowArr = new boolean[9][9], colArr = new boolean[9][9], boxArr = new boolean[9][9];

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
                //行、列、小方块的次数存在就不成立一个数独
                if (rowArr[row][digit] || colArr[col][digit] || boxArr[boxIdx][digit]) return false;
                //否则设置为true
                rowArr[row][digit] = true;  colArr[col][digit] = true; boxArr[boxIdx][digit] = true;
            }
        }
        //代码能够执行到这里的，就是满足条件的，返回true
        return true;
    }



    public static void main(String[] args) {
       char[][] board = {{'5','3','.','.','7','.','.','.','.'},
               {'6','.','.','1','9','5','.','.','.'},
               {'.','9','8','.','.','.','.','6','.'},
               {'8','.','.','.','6','.','.','.','3'},
               {'4','.','.','8','.','3','.','.','1'},
               {'7','.','.','.','2','.','.','.','6'},
               {'.','6','.','.','.','.','2','8','.'},
               {'.','.','.','4','1','9','.','.','5'},
               {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }

}
