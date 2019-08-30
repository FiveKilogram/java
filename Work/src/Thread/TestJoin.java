package Thread;

public class TestJoin implements Runnable {

    int a;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a = 400;
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        thread.join();

        System.out.println(testJoin.a);
    }

}
