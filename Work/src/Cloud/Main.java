package Cloud;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string  = scanner.nextLine();

        String str[] = string.split(",");

        int num[] = new int[str.length];
        for (int i = 0; i <num.length ; i++) {
            num[i] = Integer.valueOf(str[i]);
        }

        bubbleSort(num);

        for (int i = 0; i < num.length; i++) {
            if(i!=num.length-1)
                System.out.print(num[i] + ",");
            else
                System.out.print(num[i]);
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
