import java.util.Scanner;

public class Main2 {
    int num = 0;
    public static void main(String[] args) {

        Main2 main2 = new Main2();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();

        main2.Print1ToMaxOfNDigits(n, s);

        System.out.println(main2.num%1000000007);



    }


    public void Print1ToMaxOfNDigits(int n, int s) {
        if (n <= 0)
            return;

        int result[] = new int[n];
        Print1ToMaxOfNDigitsCore(result, n, 0, s);

    }

    public void Print1ToMaxOfNDigitsCore(int result[], int length, int index, int s) {
        if(index == length) {
            if(check(result,s))
                num++;
            return;
        }
        for(int i=0;i<10;i++) {
            result[index] = i;
            Print1ToMaxOfNDigitsCore(result, length, index+1,s);
        }
    }

    public boolean check(int result[],int s){
        boolean b = true;
        for (int i = 0; i < result.length-1; i++) {
            if(result[i]>result[i+1]||sumOfArray(result)!=s){
                b = false;
                break;
            }

        }
        return b;
    }

    public int  sumOfArray(int result[]){
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        return num;
    }

}
