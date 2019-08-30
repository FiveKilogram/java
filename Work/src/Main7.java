import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        String str = sc.next();
        System.out.println(str);

        int i;
        for (i = 0; i < str.length()/2; i++) {
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                break;
            }
        }

        String result = str;
        String mid = str.substring(i-1);

        for (int j = 0; j < k-1; j++) {
            result = result + mid;
        }

        System.out.println(result);

    }
}
