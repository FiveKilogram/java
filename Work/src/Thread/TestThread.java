package Thread;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();

        System.out.println(Thread.currentThread().getName());
    }
}
