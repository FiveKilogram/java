/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 在这里编写类的功能描述
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 时间复杂度: O(N * M) N * M = 总元素个数
 * 空间复杂度: O(N * M)
 * 
 * @author luweiliang
 * @created 2020/5/23
 */
public class Lc_54_螺旋矩阵 {

    /**
     * 顺时针螺旋
     *
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     * 输入:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     * 时间复杂度: O(N * M) N * M = 总元素个数
     * 空间复杂度: O(N * M)
     * 
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return list;

        int rowStart = 0;
        // 矩阵的行数
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        // 是矩阵的列数
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 第一行的所有列遍历放到开始行，然后添加到list
            for (int i = colStart; i <= colEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            rowStart ++;

            // 最后一列的所有元素遍历放到对应的行中，然后添加到list
            for (int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd --;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd --;

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
            }
            colStart ++;
//            rowStart ++;
//            colEnd --;
//            rowEnd --;
//            colStart ++;
        }
        return list;
    }

    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        // 当二维数组是空或任何一个维度是0，直接返回
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        // m是矩阵的行数
        int m = matrix.length;
        // n是矩阵的列数
        int n = matrix[0].length;
        // 大循环，从外向内逐层遍历矩阵
        for (int i = 0; i < (Math.min(m, n) + 1) / 2; i++) {
            // 从左到右遍历“上边”
            for (int j = i; j < n - i; j++) {
                list.add(matrix[i][j]);
            }
            // 从上到下遍历“右边”
            for (int j = i + 1; j < m - i; j++) {
                list.add(matrix[j][(n - 1) - i]);
            }
            // 从右到左遍历“下边”
            for (int j = i + 1; j < n - i; j++) {
                list.add(matrix[(m - 1) - i][(n - 1) - j]);
            }
            // 从下到上遍历“左边”
            for (int j = i + 1; j < m - 1 - i; j++) {
                list.add(matrix[(m - 1) - j][i]);
            }
        }
        return list;
    }

    /**
     * 逆时针螺旋
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1、4、7、8、9、6、3、2、5]
     * 时间复杂度: O(N * M) N * M = 总元素个数
     * 空间复杂度: O(N * M)
     * @param matrix
     * @return
     */
    public static List<Integer> anticlockwiseSpiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return list;

        int rowStart = 0;
        // 矩阵的行数
        int rowEnd = matrix.length - 1;

        // 矩阵的列数
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 从上到下遍历“左边”
            if (colStart <= colEnd) {
                for (int i = colStart; i <= colEnd; i++) {
                    list.add(matrix[i][rowStart]);
                }
            }
            // 从左到右遍历“下边”（左---->右）
            if (rowStart < rowEnd) {
                for (int i = rowStart + 1; i <= rowEnd; i++) {
                    list.add(matrix[colEnd][i]);
                }
            }
            // 从下到上遍历“右边”（下---->上）
            if (rowStart < rowEnd && colStart < colEnd) {
                for (int i = colEnd - 1; i >= colStart; i--) {
                    list.add(matrix[i][rowEnd]);
                }
            }
            // 从右到左遍历“上边”（右---->左）
            if (rowStart < rowEnd - 1 && colStart < colEnd) {
                for (int i = rowEnd - 1; i >= rowStart + 1; i--) {
                    list.add( matrix[colStart][i]);
                }
            }
            rowStart ++;
            colStart ++;
            rowEnd --;
            colEnd --;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("============顺时针打印=================");
        List<Integer> list1 = spiralOrder(matrix);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        System.out.println("=============逆时针打印================");

        List<Integer> list = anticlockwiseSpiralOrder(matrix);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
