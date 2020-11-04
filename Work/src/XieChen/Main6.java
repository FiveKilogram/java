package XieChen;

public class Main6 {
    /**
     *
     *
     *
     *
     * 在m个节点的分布式计算系统中，有一批任务需要执行，每个任务需要的时间是array[i]，每个节点同一时间只能执行一个任务，
     * 每个节点只能执行连续的任务，例如i,i+1,i+2,但是不能执行i,i+2。请问任务完成的最短时间
     * 3 5
     * 1 5 3 4 2
     *
     *6
     *
     * 第一个节点执行：任务1和任务2，耗时=1+5=6
     * 第二个节点执行：任务3，耗时=3
     * 第三个节点执行：任务4和任务5，耗时=4+2=6
     * 所以，总最短耗时=6
     */
    public static void main(String[] args) {
        int a[]  = new int[5];;
        System.out.println(a[0]);
    }
}



