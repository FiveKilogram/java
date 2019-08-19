package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TestRegex {

	public static void main(String[] args) {
		String regex = "\\d{1,}\\.([1-9a-z]+|[A-Z]{3})";
		String regex2 = "\\w{3,}\\@(\\w+)(\\.[a-z]+)+";
		boolean flag = "xushijin@163.com".matches(regex2);
		System.out.println(flag);
//		System.out.println("66tt55rrttuuue55tt77".replaceAll("\\d|e|t",""));
//		Pattern pattern = Pattern.compile("\\w{3,}\\@(\\w+)(\\.[a-z]+)+");
//		Matcher matcher = pattern.matcher("xushijin@163.com");
//		System.out.println(matcher.matches());
//
//		Pattern p = Pattern.compile("\\d{3,5}");
//		String s = "123-34345-234-00";
//		Matcher m = p.matcher(s);
//		p(m.matches());
//		m.reset();
//		p(m.find());
//		p(m.start() + "-" + m.end());
//		p(m.find());
//		p(m.start() + "-" + m.end());
//		p(m.find());
//		p(m.start() + "-" + m.end());
//		p(m.find());
//		//p(m.start() + "-" + m.end());
//		p(m.lookingAt());
//		p(m.lookingAt());
//		p(m.lookingAt());
//		p(m.lookingAt());
		
	}
	
	public static void p(Object o) {
		System.out.println(o);
	}


}
