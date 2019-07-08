package Reflection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import static java.lang.invoke.MethodHandles.lookup;


//调用祖父类的方法
public class A extends B {
	public void test() {
////		try{
////			MethodType mt = MethodType.methodType(void.class);
////			MethodHandle mh = lookup().findSpecial(C.class,"test", mt, getClass());
////			mh.invoke(this);
////		}catch(Throwable e){
////			
////		}
//		MethodType methodType = MethodType.methodType(void.class);
//        try {
//        //找到祖父类的构造函数
//            MethodHandle inithandle = MethodHandles.lookup().findConstructor(C.class, methodType);
//            //获取祖父类实例对象
//            Object o = inithandle.invoke();
//            //找到祖父类里被覆写的方法并把该方法绑定到祖父类实例上
//            MethodHandle handle = MethodHandles.lookup().findVirtual(C.class, "test", methodType);
//          //调用祖父类里被父类覆写的方法
//            handle.invoke(o);
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
		(new C()).test();;
	}

	public static void main(String[] args) {
		(new A()).test();
	}
}

class B extends C {
	public void test() {
		System.out.print("bbbb");
	}
}

class C {
	public void test() {
		System.out.print("c");
	}
}