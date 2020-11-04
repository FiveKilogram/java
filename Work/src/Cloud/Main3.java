package Cloud;

import java.util.Scanner;

public class Main3 {
      public static void main(String[] args){
                 Scanner sc=new Scanner(System.in);
                 System.out.println("请输入第一个高位整数：");
                 String str1=sc.next();
                 System.out.println("请输入第二个高位整数：");
                 String str2=sc.next();
                 int[] num1=new int[str1.length()];  //num1[]存储第一个大数
                 int[] num2=new int[str2.length()];  //num2[]存储第二个大数
                 int len=1+Math.max(str1.length(),str2.length());//找到两个大数中位数更高的一个并+1，设置为求和数组的长度
                 int[] sum=new int[len];             //sum[]存储两大数之和
                 for (int a=0;a<str1.length();a++){
                         //将str1数字逐个倒序放入数组num1[]
                         num1[str1.length()-a-1]=Integer.parseInt(str1.substring(a,a+1));
                     }
                 for (int b=0;b<str2.length();b++){
                         //将str2数字逐个倒序放入数组num2[]
                         num2[str2.length()-b-1]=Integer.parseInt(str2.substring(b,b+1));
                     }
                 int overflow=0;
                 for (int i=0;i<len-1;i++){
                         //逐位相加，满10进1
                         sum[i]=num2[i]+num1[i]+overflow;
                         if (sum[i]>=10){
                                 sum[i]=sum[i]%10;
                                 overflow=1;
                            }else{
                                 overflow=0;
                             }
                     }
                 for (int j=len-1;j>=0;j--){
                         System.out.print(sum[j]);
                     }
             }
 }