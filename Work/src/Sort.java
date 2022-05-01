import java.util.*;

public class Sort {


    public void swap(int nums[], int a, int b){
        int temp =0;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    //选择排序
    public void selectSort(int nums[]){
        for (int i = 0; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[min])
                    min = j;
            }
            swap(nums,min,i);
        }
    }

    public void selectSort2(int nums[]){
        Deque arrayList = new LinkedList();

        for (int i = 0; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[min]){
                    min=j;
                }
            }
            swap(nums,i,min);
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



    public void insertSort2(int nums[]){
        for (int i =1;i<nums.length;i++){
            int temp = nums[i];
            if(nums[i]<nums[i-1]){
                int j = 0;
                for (j = i-1; j > 0; j--) {
                    if(nums[j]>temp){
                        nums[j+1] = nums[j];
                    }
                }
                nums[j+1] = temp;
            }
        }
    }


    public void bubbleSort5(int nums[]){
        for (int i = 0; i < nums.length-1; i++) {
            boolean change = false;
            for (int j = nums.length-1; j >i ; j--) {
                if(nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                    change = true;
                }
            }
            if(!change){
                return;
            }
        }

//        for (int i = nums.length-1; i >0 ; i--) {
//            boolean change = false;
//            for (int j = 0; j < i; j++) {
//                if(nums[j]>nums[j+1]){
//                    swap(nums,j,j-1);
//                    change = true;
//                }
//            }
//            if(!change){
//                return;
//            }
//        }


    }


    //冒泡排序, 从小到大排序
    public void bubbleSort(int nums[]){
        for (int i = 0; i < nums.length-1; i++) {
            boolean flag = false;
            for (int j = nums.length-1; j > i; j--) {
                if(nums[j]<nums[j-1]){
                    swap(nums, j,j-1);
                    flag = true;
                }
            }
            if(flag==false)
                return;
        }
    }

    public void bubbleSort2(int nums[]){
        for (int i = 0; i < nums.length-1; i++) {
            boolean flag = false;
            for (int j = nums.length-1; j > i; j--) {
                if(nums[j]>nums[j-1]){
                    swap(nums, j,j-1);
                    flag = true;
                }
            }
            if(flag==false)
                return;
        }
    }


    public void bubbleSort3(int nums[]){
        for (int i = nums.length-1; i > 0 ; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if(nums[j+1]<nums[j]){
                    swap(nums, j,j+1);
                    flag = true;
                }
            }
            if(flag==false)
                return;
        }
    }


    public void bubbleSort4(int nums[]){
        for (int i = nums.length-1; i > 0 ; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if(nums[j+1]>nums[j]){
                    swap(nums, j,j+1);
                    flag = true;
                }
            }
            if(flag==false)
                return;
        }
    }

    public void QuickSort(int nums[], int low, int high){
        if(low<high){
            int mid  = Portition(nums, low, high);
            QuickSort(nums, low,mid-1);
            QuickSort(nums,mid+1,high);
        }
    }

    public void QuickSort2(int nums[], int low, int high){
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()){
            int max = stack.pop();
            int min = stack.pop();
            int mid = Portition(nums,min,max);
            if(min<mid-1){
                stack.push(min);
                stack.push(mid-1);
            }
            if(max>mid+1){
                stack.push(mid+1);
                stack.push(max);
            }
        }
    }


    public int Portition(int a[], int low, int high) {
        int i = low;
        int j = high;
        int temp = low;
        while (i<j){
            while (i<j&&a[j]>=a[temp]){
                j--;
            }
            while (i<j&&a[i]<=a[temp]){
                i++;
            }
            if(i<j){
                swap(a,i,j);
            }
        }
        swap(a,j,low);
        return j;
    }


    public int Portition2(int a[], int low, int high) {
        int temp = low;
        while (low<high){
            while (low<high&&a[high]>=a[temp]){
                high--;
            }
            a[low] = a[high];
            while (low<high&&a[low]<=a[temp]){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }


    public void heapSort(int nums[]){
        buildHeap(nums);
        for (int i = nums.length-1; i >0; i--) {
            swap(nums,0,i);
            adjustHeap(nums,i,0);
        }
    }

    public void buildHeap(int nums[]){
        for (int i = nums.length/2 -1; i >=0; i--) {
            adjustHeap(nums,nums.length,i);
        }
    }

    public void adjustHeap(int nums[], int len, int i){
            int temp = nums[i];
            for (int j = 2*i + 1; j <= len-1; j = j*2 + 1) {
                if(j<len-1&&nums[j+1]>nums[j]){
                    j++;
                }
                if(nums[j]>temp){
                    nums[i] = nums[j];
                    i = j;
                }else{
                    break;
                }
                nums[i] = temp;
            }
    }

    public static void main(String[] args) {
//        int num[] = {4,0,5,2,-1,66,9,17};
        int num[] = {2, 3, 6, 7};

        Sort sort = new Sort();
        sort.bubbleSort5(num);
        //sort.heapSort(num);
        printArray(num);
        List<Integer> integers = Arrays.asList(2, 3, 6, 7);
        List<List<Integer>> lists = sort.combinationSum(num, 7);
        System.out.println(lists);
    }

    public static void printArray(int nums[]){
        for (int a:nums) {
            System.out.println(a);
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        find(result,candidates,target,0, path);
        return result;
    }

    private void find(List<List<Integer>> result, int[] candidates, int target, int position,List<Integer> path){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = position; i < candidates.length; i++) {
            if(i>position&&candidates[i]==candidates[i-1])
                break;
            path.add(candidates[i]);
            find(result,candidates,target-candidates[i],i, path);
            path.remove(path.size()-1);
        }

    }




}
