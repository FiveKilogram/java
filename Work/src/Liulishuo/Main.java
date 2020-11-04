package Liulishuo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int a_num  = scanner.nextInt();
        int b_num  = scanner.nextInt();

        int costA[] = new int[num];
        int costB[] = new int[num];

        int i = 0;
        while(i<num){
            costA[i] = scanner.nextInt();
            costB[i] = scanner.nextInt();
            i++;
        }

        int cost[] = new int[num];
        for (int j = 0; j < num; j++) {
            cost[j] = costA[j]-costB[j];
        }

        int result = 0;
        List<Integer> list = new LinkedList<>();

        for (int j = 0; j < num; j++) {
            int o = findMax(cost);
            if(a_num==0){
                break;
            }else {
                result = result + costA[o];
                a_num--;
                cost[o] = 900000000;
                list.add(o);
            }

        }

        for (int j = 0; j < num; j++) {
            if(list.contains(j)){
                result = result + costB[j];
            }
        }

        System.out.println(result);

    }

    public static int findMax(int num[]){
        int max= 0;
        for (int i = 0; i < num.length; i++) {
            if(num[i]>num[max]){
                max = i;
            }
        }
        return max;
    }


}
