package _58;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String str[] = string.split("@");

        char[] c = {'M','A','S','K'};
        String result = "";
        int j = 0;
        for (int i = 0; i < str[0].length(); i++) {

            result = result + str[0].charAt(i) + c[j];
            j++;
            if(j==4){
                j = 0;
            }
        }

        result = result.substring(0,result.length()-1) + "@"+ str[1];
        System.out.println(result);
    }
}
