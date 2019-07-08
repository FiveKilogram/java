package Reflection;

public class TestClassLoder {

	public static void main(String[] args) {
		System.out.println(TestClassLoder.class.getClassLoader().getParent().getClass().getName());

	}
}




//class A {
//
//}
//
//class B {
//
//}
//
//class C {
//	static {
//		System.out.println("wwwwwwwww");
//	}
//}
//
//class D {
//	{
//		System.out.println("rrrrrrrrrr");
//	}
//}
