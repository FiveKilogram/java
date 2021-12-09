import sun.applet.Main;

import java.sql.Array;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        int num = in.nextInt();

        String str[] = s1.split(" ");
        int weight[] = new int [str.length];

        for (int i = 0; i < str.length; i++) {
            weight[i] = Integer.parseInt(str[i]);

        }

        System.out.println(Main4.numForPeople(weight,num));

    }




    public static int numForPeople(int weight[],int limit){
        Arrays.sort(weight);
        int i = 0;
        int j = weight.length-1;
        int num = 0;
        while (i<=j){
            num++;
            if((weight[i] + weight[j])<=limit){
                i++;
            }
            j--;
        }
        return num;
    }



}
