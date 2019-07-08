package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRex {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("[a-z]{3}");
		Matcher m  = p.matcher("fgh");
		System.out.println(m.matches());
		System.out.println(" \n\t\r".matches("\\s{4}"));
		System.out.println("\\".matches("\\\\"));
	}

}
