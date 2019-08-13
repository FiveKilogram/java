
public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a1 = "rr";
		String a2 = "rr";

		String s3 = new String("rrt");
		String s4 = new String("rrt");

		String s5 = new String("rr");

		TestString.pt(a1==a2);
		TestString.pt(s3==s4);
		TestString.pt(s5==s4);

	}
	
	public static void pt(Object o) {
		System.out.println(o);
//		Integer c = 127;
//		Integer d = 127;
//		System.out.println(c == d);
	}
	 
}
