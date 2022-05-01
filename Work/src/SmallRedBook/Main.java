package SmallRedBook;

import java.util.Scanner;

/**在游戏中，击败魔物后，薯队长获得了N件宝物，接下来得把这些宝物卖给宝物回收员来赚点小钱。这个回收员有个坏毛病，每次卖给他一件宝物后，
 * 之后他就看不上比这件宝物差的宝物了。在这个世界中，衡量宝物的好坏有两个维度，稀有度X和实用度H，回收员在回收一个宝物A后，
 * 下一个宝物的稀有度和实用度都不能低于宝物A。
 * 那么薯队长如何制定售卖顺序，才能卖给回收员宝物总个数最多。
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        baowu a[] = new baowu[num];
        System.out.println(a[0]);
        int i = 0;

        while (i<num){
            baowu baowu = new baowu();
            int w = scanner.nextInt();
            int o = scanner.nextInt();
            baowu.i = w;
            baowu.j = o;
            a[i] = baowu;
            i++;
        }

        int result = 0;

        for (int j = 0; j < a.length-1; j++) {
            if((a[j].i<a[j+1].i)&&(a[j].j<a[j+1].j)){
                result++;
            }
        }

        System.out.println(result+1);

    }




    public void swap(baowu nums[], int a, int b){
        baowu temp = null;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    //选择排序
    public void selectSort(baowu nums[]){
        for (int i = 1; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if((nums[j].i<nums[min].i)&&(nums[j].j<nums[min].j))
                    min = j;
            }
            swap(nums,min,i);
        }
    }

}


class baowu{
    int i;
    int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
