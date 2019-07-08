package practice;
import java.util.*;


//华为机试，参数解析
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String sca = scan.nextLine();
		//使用空格分开
        String str[] = sca.split(" ");
        int i = 0;
        int length = 0;
        ArrayList<String> array = new ArrayList<String>();
        
        while(i<str.length) {
        	//有双引号的情况，且参数中间有空格的情况
        	if(str[i].contains("“")&&i<str.length-1) {
            	array.add(str[i].substring(1, str[i].length()-1)+" "+ str[i+1].substring(0, str[i+1].length()-2));
            	i = i + 2;
            	length++;
            }
        	//有双引号的情况但参数中间没有空格的情况
        	if(str[i].contains("“")&&str[i].contains("”")) {
        		array.add(str[i].substring(1, str[i].length()-1));
            	i = i + 1;
            	length++;
            }
        	else {
        		array.add(str[i]);
            	i = i + 1;
            	length++;
            }
        }
        
        System.out.println(array.size());
        for(String str1 : array) {
        	System.out.println(str1);
        }
	}

}
