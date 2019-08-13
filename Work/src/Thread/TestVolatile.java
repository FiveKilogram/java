package Thread;

public class TestVolatile {
    public static volatile int a= 0;

    public static void main(String[] args) throws InterruptedException {
        TestVolatile testVolatile = new TestVolatile();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testVolatile.test();
                }
            }).start();
        }


        Thread.currentThread().join();
        System.out.println(TestVolatile.a);
    }

    public void test(){
        a++;
    }

}
