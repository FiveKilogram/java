package TenXun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String nums[] = new String[num];
        int nums2[] = new int[num];

        int i = 0;
//        while (scanner.hasNextInt()) {
//            int a = scanner.nextInt();
//            nums2[i] = a;
//            String b = scanner.next();
//            nums[i] = b;
//            i++;
//        }
        while (i<num){
            int a = scanner.nextInt();
            nums2[i] = a;
            String b = scanner.next();
            nums[i] = b;
            i++;
        }

        for (int j = 0; j < num; j++) {
            if((nums[j]+"").length()<11){
                System.out.println("NO");

            }else if((nums[j]+"").charAt((nums[j]+"").length()-11)!='8'){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }

    }
}
