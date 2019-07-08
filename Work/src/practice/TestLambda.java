package practice;

public class TestLambda {
    public static void main(String[] args) {

        new Thread(()->{
            System.out.println("Ïß³Ì");
        }).start();

        new TestLambda().getName(()->{
            System.out.println("lambda");
        });

    }

    public void getName(Person p){
        p.name();
    }

    public void add(int... a){
        for (int i = 0; i < a.length; i++) {

        }
    }
}

@FunctionalInterface
interface Person{
     public abstract void name();

}