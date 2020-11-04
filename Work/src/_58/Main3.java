package _58;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num[] = new int[200];
        int i =0;
        while (i<200){
            num[i] = scanner.nextInt();
            i++;
        }

        Arrays.sort(num);

        System.out.println(num[197]);
    }
}
