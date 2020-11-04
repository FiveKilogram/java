package ShunFen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int result[] = new int[num];
        result[0] = 0;
        result[1] = 0;
        for (int i = 2; i < num; i++) {
            if(i%2==0){
                result[i] = i/4*2 + result[i-2];
            }else {
                result[i] = (i+1)/4 + result[i-1] +1;
            }
        }


        //int nums[] = new int[num];
        int j;
        while (num--!=0){
            int x = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                if(result[i]>=x){
                    System.out.println(i);
                    break;
                }
            }
        }

//        int result1[] = new int[num];//斜边
//        int result2[] = new int[num];//正边
//
//        result1[0] = 0;result1[1] = 4;result1[2] = 2;
//        result2[0] = 4;result2[1] = 0;result2[2] = 4;
//
//        for (int i = 3; i < num; i++) {
//            if(i%2==0){
//                result1[i] = 2;
//                result2[i] = result1[i-1];
//            }else {
//                result1[i] = result2[i-1]+result1[i-1];
//                result2[i] = 0;
//            }
//        }


//        for (int i = 0; i < num; i++) {
//            System.out.println(result[i]);
//        }

    }
}
