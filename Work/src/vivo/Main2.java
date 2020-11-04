package vivo;

import java.io.*;
import java.util.Stack;

/**
 * Welcome to vivo !
 */

public class Main2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr );
        System.out.println(output);
    }

    private static int solution(String str) {

        // TODO Write your code here

        Stack<Character> stack  = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }
            if(str.charAt(i)==')'){
                stack.pop();
            }
            if(str.charAt(i)=='0'){
                break;
            }
        }
        return stack.size();
    }
}