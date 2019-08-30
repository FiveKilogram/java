package testExtends;

public class Son extends Parent{
    int a = 8;

    @Override
    public int add() {
        return 10;
    }

    public static int add2(){
        return 15;
    }

    public static void main(String[] args) {
        Parent p = new Son();
        System.out.println(p.a);
        System.out.println(p.add());
        System.out.println(Son.add2());
        System.out.println(Son.p);
    }

}
