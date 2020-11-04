package migu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String str1[] = string.split(" ");
        int a = Integer.valueOf(str1[0]);
        int b = Integer.valueOf(str1[1]);
        int c = Integer.valueOf(str1[2]);

        boolean bl = false;
        if(a%4==0)
            bl = true;


        int day[] = {0,31,59,90,120,151,181,212,243,273,304,334,365};

        int day2[] = {0,31,60,91,121,152,182,213,244,274,305,335,366};

        if(bl){
            System.out.println(day2[b-1]+c);
        }else {
            System.out.println(day[b-1]+c);
        }
    }
}
