package LeetCode;

import java.util.ArrayList;

public class Sort {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> al = new ArrayList();
        selectSort(input,k);
        for (int i = 0; i < k; i++) {
            al.add(input[i]);
        }
        return al;
    }


    public void selectSort(int nums[],int k){
        for (int i = 0; i < k; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[min]){
                    min = j;
                }
            }

            swap(nums,i,min);
        }
    }


    public void swap(int nums[], int a, int b){
        int temp =0;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
