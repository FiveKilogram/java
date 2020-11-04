package bilibili;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        System.out.println(moveNum(str1,str2));
    }

    public static int moveNum(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        if(m==0||n==0){
            return m+n;
        }

        int dp[][] = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }

    public static int min(int a,int b,int c){
        int min = 0;
        min = Math.min(a,Math.min(b,c));

        return min;
    }

}
