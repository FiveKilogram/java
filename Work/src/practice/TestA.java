package practice;

public class TestA implements TestInterface2{
    public static void main(String[] args) {
        TestAbustrat a = new TestAbstract2() {
            @Override
            public void add1() {

            }
        };
        a.add();
    }

    @Override
    public void add3() {

    }
}
