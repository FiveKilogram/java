package practice;
import java.util.*;


//��Ϊ���ԣ���������
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String sca = scan.nextLine();
		//ʹ�ÿո�ֿ�
        String str[] = sca.split(" ");
        int i = 0;
        int length = 0;
        ArrayList<String> array = new ArrayList<String>();
        
        while(i<str.length) {
        	//��˫���ŵ�������Ҳ����м��пո�����
        	if(str[i].contains("��")&&i<str.length-1) {
            	array.add(str[i].substring(1, str[i].length()-1)+" "+ str[i+1].substring(0, str[i+1].length()-2));
            	i = i + 2;
            	length++;
            }
        	//��˫���ŵ�����������м�û�пո�����
        	if(str[i].contains("��")&&str[i].contains("��")) {
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
