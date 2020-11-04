package XieChen;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/

    /**
     *
     *
     * ((ur)oi)
     *
     *
     * iour
     * @param expr
     * @return
     */
    static String resolve(String expr) {
        String string = "";
        boolean b = true;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < expr.length(); i++) {
            if(expr.charAt(i)!=')'){
                stack.push(expr.charAt(i));
            }else {
                    char a = stack.pop();
                    while (a!='('){
                        string = string + a;
                        a = stack.pop();
                    }
                    stack.pop();
            }
        }
        int a = string.indexOf("(");
        StringBuffer stringBuffer = new StringBuffer(string);
        string = stringBuffer.reverse().toString();
        if(a!=-1)
            return string;
        else return "";
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
