import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String string[] = new String[3];
        int i = 0;
        while (i<3) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            string[i] = in.next();
            i++;
        }

        boolean flag = false;

        int j = 0;

        int a = 0;
        int b = 0;

        if((string[0].length()+string[1].length())!=string[2].length()){
            System.out.println("FALSE");
        }else {
            while (j<string[2].length()){
                if(a<string[0].length()&&string[0].charAt(a)==(string[2].charAt(j))){
                    a++;
                    j++;
                    flag = true;
                } else if(b<string[1].length()&&string[1].charAt(a)==(string[2].charAt(j))){
                    b++;
                    j++;
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("TRUE");
            }else {
                System.out.println("FALSE");
            }
        }

    }

}