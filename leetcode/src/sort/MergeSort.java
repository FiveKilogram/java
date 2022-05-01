/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package sort;

/**
 * 归并排序
 * 归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。
 * java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。
 * 每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。总的平均时间复杂度为O(nlogn)。而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
 * https://www.cnblogs.com/of-fanruice/p/7678801.html
 * @author luweiliang
 * @created 2019/10/22
 */
public class MergeSort {

    public static void sort(int[] a, int low, int high) {
//        int mid = (low + high) / 2;
        int mid = (high - low) / 2 + low;
        if (low < high) {
            sort(a, low, mid);              //左边归并排序，使得左子序列有序
            sort(a, mid + 1, high);    //右边归并排序，使得右子序列有序
            merge(a, low, mid, high);       //将两个有序子数组合并操作
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;       //左序列指针
        int j = mid + 1;   //右序列指针
        int k = 0;         //临时数组指针
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 将右序列剩余元素填充进temp中
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 将temp中的元素全部拷贝到原数组中
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }

    public static void main(String[] args) {
        int array[] = {6, 2, 4, 8, 150, 1, 10, 5, 9, 7, 1, 3};
        sort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]);
        }
    }

}
