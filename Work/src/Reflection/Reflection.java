package Reflection;

public class Reflection {

	public static void main(String[] args) throws ClassNotFoundException {
		Class c = Class.forName("Reflection.T");
	}
}

class T {
	static {
		System.out.println("class load");
	}
}
