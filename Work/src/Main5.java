import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int graph [][] = new int [6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                graph[i][j]  = sc.nextInt();
            }
        }


        for (int i = 1; i < 6; i++) {
            if(graph[0][1]==0){
                System.out.println(graph[0][1]);
            }else {
                System.out.println(Integer.MAX_VALUE);
            }
        }

    }
}
