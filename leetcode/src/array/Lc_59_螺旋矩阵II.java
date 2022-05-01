/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * 时间复杂度: O(N)
 * 空间复杂度: O(N)
 * @author luweiliang
 * @created 2020/5/23
 */
public class Lc_59_螺旋矩阵II {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowBigen = 0;
        int rowEnd = n - 1;
        int colBigen = 0;
        int colEnd = n -1;
        int num = 0;

        while (rowBigen <= rowEnd && colBigen <= colEnd){
            // 从左到右遍历“上边”，第一行的所有列遍历放到开始行，然后添加到list
            for (int i = colBigen; i <= colEnd; i ++) {
                matrix[rowBigen][i] = num++;
            }
            rowBigen ++;

            // 从上到下遍历“右边”， 最后一列的所有元素遍历放到对应的行中，然后添加到list
            for (int i = rowBigen; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num++;
            }
            colEnd --;

            // 从右到左遍历“下边”
            for (int i = colEnd; i >= colBigen; i--) {
                matrix[rowEnd][i] = num++;
            }
            rowEnd --;

            // 从下到上遍历“左边”
            for (int i = rowEnd; i >= rowBigen; i --) {
               matrix[i][colBigen] = num ++;
            }
            colBigen ++;
        }
        return matrix;
    }

    public static void main(String[] args){
        int[][] sums = generateMatrix(3);
        for (int i[] : sums) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
