package practice;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sca  = new Scanner(System.in);
		int num = sca.nextInt();
		
		int count = 0;
		int a = 1;
		while(num!=0) {
			if((num&a)!=0) {
				count++;
			}
			num  = num >> 1;
		}
		System.out.println(count);
	}

}
