package Cloud;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            String str[] = string.split(",");

            str[0] = str[0].substring(1);
            str[str.length-2] = str[str.length-2].substring(0,str[str.length-2].length()-1);

            int num[] = new int[str.length-1];

            for (int i = 0; i <num.length; i++) {
                num[i] = Integer.valueOf(str[i]);
            }

            bubbleSort(num);
            System.out.println(find(num,Integer.valueOf(str[str.length-1]),0,num.length-1));


    }

    public static int find(int num[], int k,int low,int high){
        if(k<num[low]||k>num[high]||low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if(num[mid]>k){
            return find(num,k,low,mid-1);
        }else if(num[mid]<k){
            return find(num,k,mid+1,high);
        }else {
            return mid;
        }
    }


    public static void bubbleSort(int num[]){
        for (int i = 0; i < num.length-1; i++) {
            boolean flag = true;
            for (int j = num.length-1; j > i; j--) {
                if(num[j]<num[j-1]){
                    swap(num,j,j-1);
                    flag = false;
                }
            }
            if(flag)
                return;
        }
    }

    private static void swap(int[] num, int j, int i) {
        int temp = 0;
        temp = num[j];
        num[j]  = num[i];
        num[i] = temp;
    }
}
