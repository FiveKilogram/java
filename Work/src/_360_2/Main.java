package _360_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        speedObject speedObject[] = new speedObject[num];

        int i =0;
        while (i<num){
            speedObject[i].speed = scanner.nextInt();
            speedObject[i].time = scanner.nextInt();
            i++;
        }


        Arrays.sort(speedObject);


        double dis = 0;
        int preSpeed = 0;

        for (int j = num; j >=0; j--) {
            dis = preSpeed*speedObject[j].time + 0.5*speedObject[j].speed*speedObject[j].time*speedObject[j].time;
            preSpeed = preSpeed + speedObject[j].time*speedObject[j].speed;
        }


        System.out.println(dis);




    }

    private class speedObject implements Comparator<speedObject> {
        int speed;
        int time;

        @Override
        public int compare(speedObject o1, speedObject o2) {
            if((o1.speed*o1.time-o2.speed*o2.time)>0){
                return 1;
            }
            if((o1.speed*o1.time-o2.speed*o2.time)<0){
                return -1;
            }
            if((o1.speed*o1.time-o2.speed*o2.time)==0){
                return 0;
            }
            return 0;
        }
    }
}
