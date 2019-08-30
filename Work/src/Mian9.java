import java.util.Scanner;

public class Mian9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int i = 0;

        int num[] = new int[N];
        int sum =0;

        while (i<N){
            num[i] = sc.nextInt();
            sum = sum + num[i];
        }

        int dp[] = new int[N];
        for (int j = 0; j < N; j++) {
            dp[j] = 0;
        }

        for (int j = 0; j < N; j++) {
            for (int k = sum/2; k > num[i]; k--) {
                dp[j] = Math.max(dp[k],dp[k-num[j]]+num[j]);
            }
        }
        System.out.println();

    }
}
