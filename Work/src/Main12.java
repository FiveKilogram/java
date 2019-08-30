import java.util.Scanner;
import java.util.concurrent.Semaphore;


//同程艺龙
public class Main12 {

    public static Semaphore semaphore1 = new Semaphore(0);
    public static Semaphore semaphore2 = new Semaphore(0);
    static String string;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Main12.string = str;


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Main12.string = Main12.string + "_A";
                Main12.semaphore1.release();
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Main12.semaphore1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Main12.string = Main12.string + "_B";
                Main12.semaphore2.release();

            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Main12.semaphore2.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Main12.string = Main12.string + "_C";
            }
        });
        thread2.start();

        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Main12.string);
    }

}
