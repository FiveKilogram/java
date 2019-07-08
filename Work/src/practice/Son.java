package practice;

public class Son extends Parent{
    int a = 8;

    @Override
    public int add() {
        return 10;
    }

    public static void main(String[] args) {
        Parent p = new Son();
        System.out.println(p.a);
        System.out.println(p.add());
    }
}
