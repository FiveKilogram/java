public class Sort {


    public void swap(int nums[], int a, int b){
        int temp =0;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    //选择排序
    public void selectSort(int nums[]){
        for (int i = 1; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[min])
                    min = j;
            }
            swap(nums,min,i);
        }
    }


    //直接插入排序
    public void insertSort(int nums[]){
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            if(nums[i]<nums[i-1]) {
                int j = 0;
                for (j = i - 1; j >= 0 && nums[j] > temp; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[j+1] = temp;
            }

        }
    }



    fdsgfdhgrjhki;

    //冒泡排序
    public void bubbleSort(int nums[]){

    }


    public static void main(String[] args) {
        int num[] = {2,46,3,76,3,7,3,76};
        Sort sort = new Sort();
        sort.insertSort(num);
        printArray(num);
    }

    public static void printArray(int nums[]){
        for (int a:nums) {
            System.out.println(a);
        }
    }

}
