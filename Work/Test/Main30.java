import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(Main30.convert(num));
    }

    public static String convert(double d) {
        String[] numTables = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] unitTables = new String[]{"分", "角"};
        String[] levelTables = new String[]{"万", "亿"};
        String[] mulTables = new String[]{"", "拾", "佰", "仟"};
        StringBuffer result = new StringBuffer();
        int index = -1;
// 将数字格式化为xxxx.xx
        DecimalFormat df = new DecimalFormat();
        df.setGroupingSize(4);
        df.setMinimumFractionDigits(2);
        String strFormat = df.format(d);
// 拆分整数部分和小数部分
        StringBuffer intPart = new StringBuffer(strFormat.substring(0, strFormat.length()-3));
        StringBuffer decimalPart = new StringBuffer(strFormat.substring(intPart.length()+1, strFormat.length()));
// 处理小数部分
        decimalPart.reverse();
        for(int i=0; i<decimalPart.length(); i++) {
            result.append(unitTables[i%2]);
            result.append(numTables[Character.getNumericValue(decimalPart.charAt(i))]);
        }
// 处理整数部分
        result.append("元");
        intPart.reverse();
        int level = 0;
        for(int i=0; i<intPart.length(); i++) {
            if(intPart.charAt(i) != ',') {
                result.append(mulTables[i%5]);
                result.append(numTables[Character.getNumericValue(intPart.charAt(i))]);
            } else {
                result.append(levelTables[level]);
                level = ++level % 2;
            }
        }
        result.reverse();
// 处理多余的零
        while((index = result.indexOf("零分")) != -1){ result.deleteCharAt(index+1); };
        while((index = result.indexOf("零角")) != -1){ result.deleteCharAt(index+1); };
        while((index = result.indexOf("零拾")) != -1){ result.deleteCharAt(index+1); };
        while((index = result.indexOf("零佰")) != -1){ result.deleteCharAt(index+1); };
        while((index = result.indexOf("零仟")) != -1){ result.deleteCharAt(index+1); };
// 没有小数部分
        while((index = result.indexOf("元零零")) != -1) {
            result.delete(index+1, index+3);
            result.append("整");
        };
        while((index = result.indexOf("零零")) != -1){ result.deleteCharAt(index); };
        while((index = result.indexOf("零元")) != -1) {result.deleteCharAt(index);};
        while((index = result.indexOf("零万")) != -1) {result.deleteCharAt(index);};
        while((index = result.indexOf("零亿")) != -1) {result.deleteCharAt(index);};
        while((index = result.indexOf("亿万")) != -1) {result.deleteCharAt(index+1);};
// 没有分位
        while((index = result.indexOf("角零")) != -1){ result.deleteCharAt(index+1); };
// 只有分位
        while((index = result.indexOf("元零")) != -1 && index == 0){ result.delete(index, index+2); };
// 只有小数位
        while((index = result.indexOf("元")) != -1 && index == 0){ result.deleteCharAt(index); };
// 零元
        while((index = result.indexOf("整")) != -1 && index == 0){ result.replace(index, index+2, "零元"); };
        return result.toString();
    }

}