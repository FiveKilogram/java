import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandle.*;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class A extends B {
    public void test() {
            System.out.print("a");
    }
    public static void main(String[] args) {
            try {
            	MethodType mt = MethodType.methodType(void.class);
    			MethodHandle mh = MethodHandles.lookup().findSpecial(C.class,"thinking", mt, A.class);
    			try {
					mh.invoke();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }
}
class B extends C {
    public void test() {
            System.out.print("b");
    }
}
class C {
    public void test() {
            System.out.print("c");
    }
}