package SmallRedBook;

import java.util.Scanner;
import java.util.Stack;

/**
 * 薯队长写了一篇笔记草稿，请你帮忙输出最后内容。
 *
 * 1.输入字符包括英文字符，"(" , ")" 和 "<"。
 *
 * 2.英文字符表示笔记内容。
 *
 * 3. (  ) 之间表示注释内容，任何字符都无效。 括号保证成对出现。
 *
 * 4. "<" 表示退格, 删去前面一个笔记内容字符。 括号不受 "<" 影响 。
 *
 */


public class Main50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i)==')'){
                char a = stack.pop();
                while (a!='('){
                    a = stack.pop();
                }
            }else if(string.charAt(i)=='<'&&(!stack.empty())&&stack.peek()!='('&&stack.peek()!=')'){
                stack.pop();
            }else {
                if(string.charAt(i)!='<')
                    stack.push(string.charAt(i));
            }
        }

        while (!stack.empty()){
            result = result + stack.pop();
        }

        StringBuffer stringBuffer = new StringBuffer(result);
        System.out.println(stringBuffer.reverse());

    }
}
