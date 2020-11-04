package aiqiyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int nums[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        Main m = new Main();


        int n[] = new int[num];
        for (int i = 0; i < n.length; i++) {
            n[i] = i+1;
        }

        int i = 0;
        nums = new int[num - 1];
        while (i <= nums.length-1) {
            nums[i] = scanner.nextInt();
            i++;
        }



        List<List<Integer>> list = m.permute(n);



        int result = 0;
        for (int j = 0; j < list.size(); j++) {
            if (Main.isOk(list.get(j), nums)) {
                result++;
            }
        }

        long l = (long)Math.pow(10.0,9) + 7;

        System.out.println(result%l);

    }


    public static boolean isOk(List<Integer> list, int nums[]) {


        for (int j = 0; j < nums.length; j++) {
            if ((nums[j] == 0) && list.get(j) < list.get(j + 1)) {
                return false;
            }
            if ((nums[j] == 1) && list.get(j) > list.get(j + 1)) {
                return false;
            }
        }

        return true;
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            if(Main.isOk(tmp,nums))
                res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

}