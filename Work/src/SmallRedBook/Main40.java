package SmallRedBook;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main40 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int path[][] = new int[n][m];
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                path[i][j] = 1;
            }
        }

        int l = 0;
        while (l<k){
            path[scanner.nextInt()][scanner.nextInt()] = 0;
            l++;
        }

        System.out.println(m+n);
    }


    public void ii(){
        //static int i = 5;
    }
}
