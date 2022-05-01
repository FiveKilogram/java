/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。每列的元素从上到下升序排列。
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/tu-jie-jian-zhi-offerzhi-er-wei-shu-zu-de-cha-zhao/
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode/
 * 示例 1:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * target = 13
 * 输出: false
 *
 * @author luweiliang
 * @created 2020/9/9
 */
public class Lc_74_二维矩阵中的查找一个数 {

    /**
     * 复杂度分析如下：
     * 空间复杂度是 O(1)
     * 时间复杂度是 O(m + n)，最坏的情况是搜索了 m 行再加 n 列还没有查找到目标元素。
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target){
        //判断边界条件
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

        //获取函数矩阵的行数 m 与列数 n;
        int m = matrix.length, n = matrix[0].length;
        //初始化一开始的元素位置，设置为矩阵最右上角的元素
        int i = 0, j = n - 1;
        //循环遍历整个函数
        while(i < m && j >= 0){
            //如果目标值小于右上角的元素，则列的下标减1
            if (target < matrix[i][j]){
                j --;
            } else if (target > matrix[i][j]){      //如果目标值大于右上角的元素，则行的下标加1
                i ++;
            } else {                                //如果相等，直接返回true
                return true;
            }
        }
        //循环结束后没有找到返回false
        return false;
    }

    /**
     * 时间复杂度 : 由于是标准的二分查找，时间复杂度为O(log(m + n))。
     * 空间复杂度 : O(1)O(1)。
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        // 解法：一次二分查找
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;
        // 可以理解为二维数组转换为一个一维数组，right就是最后一个元素。
        int left = 0, right = row * col - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            // 重点：借助行数，将一维的索引值转换回二维坐标 行：mid / col, 列：mid % col。
            // 如果这一点比target小，那么mid和mid左边的值都不可能是解
            if (matrix[mid / col][mid % col] < target) {
                // 将区间转换为[mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //判断最后结束位置是不是target，如果是则true，不是则false。
        if (matrix[left / col][left % col] != target) return false;
        return true;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(searchMatrix1(matrix, 3));
//        System.out.println(searchMatrix2(matrix, 3));
    }
}
