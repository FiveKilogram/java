package SmallRedBook;

import java.util.Scanner;

/**
 *
 * 薯队长最近在玩一个迷宫探索类游戏，迷宫是一个N*N的矩阵形状，其中会有一些障碍物禁止通过。
 * 这个迷宫还有一个特殊的设计，它的左右边界以及上下边界是连通的，比如在(2,n)的位置继续往右走一格可以到(2,1)，
 * 在(1,2)的位置继续往上走一格可以到(n,2)。请问薯队长从起点位置S，最少走多少格才能到达迷宫的出口位置E。
 *  *
 */

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        String string[] = new String[num];

        int i = 0;
        while (i<num){
        }

        int len = string[0].length();
        char c[][] = new char[num][len];

        int start_x =0;
        string[i] = scanner.nextLine();
        i++;
        int start_y =0;
        int end_x =0;
        int end_y=0;


        for (int j = 0; j < num; j++) {
            for (int k = 0; k < len; k++) {
                c[j][k] = string[j].charAt(k);
                if(c[j][k]=='S'){
                    start_x = j;
                    start_y = k;
                }
                if(c[j][k]=='E'){
                    end_x = j;
                    end_y = k;
                }
            }
        }

        int m = Math.min(Math.abs(start_x - end_x),len-Math.abs(start_x - end_x));
        //int m = Math.abs(start_x - end_x);
        int n = Math.min(Math.abs(start_y - end_y),num-Math.abs(start_y - end_y));
        //int n = Math.abs(start_x - end_y);
        System.out.println(m+n-2);

    }
}
