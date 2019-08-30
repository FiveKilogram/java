import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int i = 0;

        int num[] = new int[n];

        while (i<n){
            num[i] = sc.nextInt();
            i++;
        }

        Arrays.sort(num);

        int count = 0;
        int total = 0;
        for (int j = 0; j < num.length; j++) {
            if((total+num[j])<s){
                total = total + num[j];
                count++;
            }
        }

        System.out.println(count);

    }
}
