package DuXiaoMan;

import java.util.Scanner;

/**
 *西西有N张卡片，卡片上分别写有数字1到N。由于西西太过无聊，他决定从N张卡片中抽取两张，若
 * 两张卡片上的数字互质，则西西认为自己的得分为两个数字的乘积，
 * 否则他认为自己的得分为0。那么，西西的期望得分是多少？
 *
 * 样例输入
 * 2
 * 2
 * 4
 * 样例输出
 * 2
 * 9/2
 *
 * 样例解释
 * 对于第1组数据，西西抽取的两个数字必定为1和 2。
 * 对于第2组数据，西西抽取的两个数字可以为1和2 、 1和3、1和4、 2和3、 2和4、 3和4， 他 的 期 望 得 分 为
 * （2+3+4+6+0+12）/6=27/6=9/2。
 *
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int nums[] = new int[num];
        int i = 0;
        while (i < num) {

            nums[i] = scanner.nextInt();
            i++;
        }

        for (int j = 0; j < nums.length; j++) {
            System.out.println(count(nums[j]));
        }
    }

    public static String count(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = i + 1; j <= num; j++) {
                if (check(i, j)) {
                    result = result + i * j;
                }
            }
        }
        int e = num*(num-1)/2;
        int f = getGCD(e,result);


        int e2 = e/f;
        int result2 = result/f;
        if(e2==1){
            return result2 +"";
        }else {
            return result2 + "" + "/" + e2;
        }

    }


    public static boolean check(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int c;
        while ((c = a % b) != 0) {
            a = b;
            b = c;
        }
        return b == 1;//b == 1 表示互质
    }

    public static int getGCD(int x, int y) {// x接受第一个整数，y接受第二个整数
        int num = 1;// 定义一个变量num,来保存最大公约数

        for (int i = 1; i <= x; i++) {// 遍历1到x的所有整数 
            if (x % i == 0 && y % i == 0) {//  如果有一个数同时满足被x,y整除
                num = i;//  将这个数保存到num变量
            }
        }
        return num;
    }
}
