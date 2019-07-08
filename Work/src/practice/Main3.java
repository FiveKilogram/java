package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan  = new Scanner(System.in);
		int num = scan.nextInt();
		int time = scan.nextInt();
		
		
		LinkedList<record> al = new LinkedList();
		int count = 0;
		while(count<num) {
			record r = new record();
			r.id = scan.nextInt();
			r.inTime = scan.nextInt();
			r.outTime = scan.nextInt();
			al.add(r);
			count++;
		}
		
		count = 0;
		for(record re: al) {
			if(re.inTime<=time && time<=re.outTime) {
				count++;
				System.out.println(re.id);
			}
		}
		
		if(count==0) {
			System.out.println("null");
		}
	}
	
}

class record{
	int id;
	int inTime;
	int outTime;
}
