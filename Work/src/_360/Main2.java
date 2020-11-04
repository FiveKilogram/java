package _360;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int tree[] = new int[(int)Math.pow(2,4)-1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = scanner.nextInt();
        }

        int one = scanner.nextInt();
        int two = scanner.nextInt();

        //System.out.println(-1);

        System.out.println(getParent(tree,0,one,two));
    }


    public static int getParent(int root[], int rootnum, int node1,int node2) {
        if(root.length== 0 || node1 == -1 ||  node2 == -1) return -1;


        int node1_num = 0;
        int node2_num = 0;
        for (int i = 0; i < root.length; i++) {
            if(root[i]==node1){
                node1_num = i;
            }
            if(root[i]==node2){
                node2_num = i;
            }
        }

        if(root[rootnum] == node1 || root[rootnum] == node2) return rootnum;
        int left = getParent(root,rootnum/2,node1,node2);
        int right = getParent(root,rootnum/2+1,node1,node2);

        if(left != -1 && right != -1) return rootnum;

        if(left == -1) return right;

        else return left;
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
