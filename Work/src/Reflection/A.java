package Reflection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import static java.lang.invoke.MethodHandles.lookup;


//�����游��ķ���
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
//        //�ҵ��游��Ĺ��캯��
//            MethodHandle inithandle = MethodHandles.lookup().findConstructor(C.class, methodType);
//            //��ȡ�游��ʵ������
//            Object o = inithandle.invoke();
//            //�ҵ��游���ﱻ��д�ķ������Ѹ÷����󶨵��游��ʵ����
//            MethodHandle handle = MethodHandles.lookup().findVirtual(C.class, "test", methodType);
//          //�����游���ﱻ���าд�ķ���
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