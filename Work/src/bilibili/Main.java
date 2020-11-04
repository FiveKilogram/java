package bilibili;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s11 = "abc";
        String s22 = "abc";
        System.out.println(s11.equals(s22));

        StringBuffer s1 = new StringBuffer("abc");
        StringBuffer s2 = new StringBuffer("abc");
        System.out.println(s1.equals(s2));
        System.out.println('A' + 3);
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        System.out.println(findNum(num)+1);
    }

    public static int findNum(int num){
        int result = 0;

        int first = 1;
        int last = 2;
        int curSum = 3;
        while (first<=num/2&&last<num){
            if(curSum>num){
                curSum -= first;
                first++;
            }else if(curSum<num){
                last++;
                curSum+=last;
            }else {
                result++;
                curSum -=first;
                first++;
                last++;
                curSum+=last;
            }
        }

        return result;
    }

}
