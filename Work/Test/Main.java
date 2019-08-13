import org.junit.Test;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(n);
        int nums[] = new int[n];

        int i = 0;
        while (i<4) {
            nums[i] = Math.abs(in.nextInt());
            i++;
        }

        Main m = new Main();
        m.SelectSort(nums);

//        for (int j = 0; j < nums.length; j++) {
//            System.out.println(nums[j]);
//        }

        double b = Double.MAX_VALUE;
        double o;

        for (int j = 0; j < n-2; j++) {
            o = m.fangcha(nums[j],nums[j+1],nums[j+2]);
            if(b-o>0){
                b = o;
            }

        }
        System.out.println(String.format("%.2f",b));
    }



    public double fangcha(int a, int b, int c){

        double avg = (a + b + c)/3.0;
        double dVar  = (a-avg)*(a-avg) + (b-avg)*(b-avg) + (c-avg)*(c-avg);

        return dVar/3;
    }


    @Test
    public void test(){
        Main m = new Main();
        System.out.println(m.fangcha(10,17,17));
    }


    public void SelectSort(int a[]) {
        for(int i=0;i<a.length-1;i++) {
            int min_num = i;
            for(int j=i+1;j<a.length;j++) {
                if(a[j]<a[min_num]) {
                    min_num = j;
                }
            }
            Swap(a,min_num,i);
        }
    }

    public void Swap(int a[],int i,int j) {
        int temp = 0;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
