import java.util.ArrayList;
import java.util.Scanner;

public class Main8 {
    static class VW{
        int v,w;
        public VW(int v,int w){
            this.v=v;
            this.w=w;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int V=sc.nextInt();


        ArrayList<VW> vw=new ArrayList<>();
        for(int i=0;i<N;i++){

            int s=sc.nextInt();
            int v=sc.nextInt();
            int w= N-i;
            int tmp=0;
            while (s>=Math.pow(2,tmp)){
                vw.add(new VW((int) Math.pow(2,tmp)*v,(int)Math.pow(2,tmp)*w));
                s-=Math.pow(2,tmp);
                tmp+=1;
            }
            if(s>0) vw.add(new VW(v*s,w*s));
        }


        int[][] res=new int[vw.size()+1][V+1];
        for(int i=1;i<=vw.size();i++){
            for(int j=V;j>0;j--){
                if(vw.get(i-1).v>j) res[i][j]=res[i-1][j];
                else res[i][j]=Math.max(res[i-1][j],res[i-1][j-vw.get(i-1).v]+vw.get(i-1).w);
            }
        }
        System.out.println(res[vw.size()][V]);
    }
}
