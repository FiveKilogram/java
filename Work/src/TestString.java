
public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a1 = "rr";
		String a2 = "rr";
		TestString.pt(a1==a2);
	}
	
	public static void pt(Object o) {
		System.out.println(o);
		Integer c = 127;
	     Integer d = 127;
	     System.out.println(c == d);
	}
	 
}
