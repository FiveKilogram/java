package XiaoMi;

import java.util.Scanner;

public class Main3 {

    static String string = "";

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static void solution(String input) {
        if(input==null){
            return ;
        }
        String str = input.substring(0,0);

        String str1 = input.substring(1);
        int  i;
        for (i = 0; i < str1.length(); i++) {
            if(str1.charAt(i)==')'&&str1.charAt(i+1)==','){
                break;
            }
        }
        String str2 = null;
        String str3 = null;
        try {
             input.substring(2,i);

             input.substring(i+1,input.length()-1);
        }catch (Exception e){
            return;
        }

        solution(str2);
        System.out.println(str);
        solution(str3);

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        solution(_input);
        //System.out.println(res);
    }
}
