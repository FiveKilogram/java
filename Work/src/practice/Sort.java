package practice;
import java.util.Stack;

public class Sort {
	int count = 0;
	//选择排序
	public void SelectSort(int a[]) {
		for(int i=0;i<a.length-1;i++) {
			int min_num = i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[min_num]) {
					min_num = j;
				}
			}
			Swap(a,min_num,i);
		}
	}
	
	//直接插入排序
	public void InsertSort(int a[]) {
		for(int i = 1;i<a.length;i++) {
			int temp = 0;
			if(a[i-1]>a[i]) {
				temp = a[i];
				int j = 0;
				for(j=i-1;j>=0&&a[j]>temp;j--) {//必须使用&&，用&会出现错误
					a[j+1] = a[j];
				}
				a[j+1] = temp;
			}
		}
	}


	//冒泡排序,从前往后，每次确定最小元素。
	public void BubbleSort(int a[]) {
		for(int i = 0;i<a.length-1;i++) {
			boolean flag = false;
			for(int j=a.length-1;j>i;j--) {
				if(a[j-1]>a[j]) {
					Swap(a,j,j-1);
					flag = true;
				}
			}
			if(flag == false) {
				return;
			}
		}
	}
	
	//从后往前
	public void BubbleSort2(int a[]) {
		for(int i = a.length-1;i>0;i--) {
			boolean flag = false;
			for(int j = 0;j<i;j++) {
				if(a[j+1]<a[j]) {
					Swap(a,j,j+1);
					flag = true;
				}
			}
			if(flag == false) {
				return;
			}
		}
	}
	public void Swap(int a[],int i,int j) {
		int temp = 0;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	//快速排序递归实现
	public void QuickSort(int a[],int min,int max) {
		if(min<max) {
			int mid  = Portition(a, min, max);
			QuickSort(a, min, mid-1);
			QuickSort(a, mid+1, max);
		}
	}
	
	//快速排序非递归实现
	public void QuickSort1(int a[], int min, int max) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(new Integer(min));
		st.push(new Integer(max));
		while(!st.isEmpty()) {
			int high = st.pop();
			int low = st.pop();
			int mid = Portition(a,low,high);
			if(low<mid-1) {
				st.push(new Integer(low));
				st.push(new Integer(mid-1));
			}
			if(mid+1<high) {
				st.push(new Integer(mid+1));
				st.push(new Integer(high));
			}
		}
	}
	
	
//	public int Portition(int a[], int min, int max) {
//		int i = min+1;
//		int j = max;
//
//		while(i<j) {
//			while(i<=max&&a[i]<a[min]) {
//				i = i+1;
//			}
//			while(j>=min&&a[j]>a[min]) {
//				j = j-1;
//			}
//			Swap(a, i, j);
//		}
//		Swap(a, i, j);
//		Swap(a, min, j);
//		return j;
//	}
	public int Portition(int a[], int low, int high) {
				int i = low;
				int j = high;
				int temp = low;
				while (i<j){
					while (i<j&&a[j]>=a[temp]){
						j--;
					}
					while (i<j&&a[i]<=a[temp]){
						i++;
					}
					if(i<j){
				Swap(a,i,j);
			}
		}
		Swap(a,j,low);
		return j;
	}
	
	//归并排序
	public void MergeSort(int a[], int min, int max) {
		if(min<max) {
			int mid = (min+max)/2;
			MergeSort(a,min,mid);
			MergeSort(a,mid+1,max);
			Merge(a,min,mid,max);
		}
	}
	
	public void Merge(int a[], int min, int mid,int max) {
		int b[] = new int[max+1];
		for(int i=min;i<=max;i++) {
			b[i] = a[i];
		}
		
		int i = min;
		int j = mid+1;
		int k = min;
		while(i<=mid&&j<=max) {
			if(b[i]<b[j]) {
				a[k] = b[i];
				i++;
			}else {
				a[k] = b[j];
				j++;	
			}
			k++;
		}
		while(i<=mid) {
			a[k] = b[i];
			i++;
			k++;
		}
		while(j<=max) {
			a[k] = b[j];
			j++;
			k++;
		}
	}
	
	//堆排序
	public void HeapSort(int a[], int len) {
		BuildMaxHeap(a,len);
		for(int i = len-1;i>0;i--) {
			Swap(a,0,i);
			AdjustHeap(a, i, 0);
		}
	}
	
	public void BuildMaxHeap(int a[], int len) {
		for(int i = len/2 - 1;i>=0;i--) {
			AdjustHeap(a,len,i);
		}
	}
	
	public void AdjustHeap(int a[], int len,int i) {
		int temp = a[i];
		for(int j = 2*i+1;j<=len-1;j = 2*j+1) {
			if(j<len-1&&a[j]<a[j+1])
				j++;
			if(temp<a[j]) {
				a[i] = a[j];
				i = j;
			}else {
				break;
			}
			
		}
		a[i] = temp;
	}
	
	public static void main(String[] args) {  
		// TODO Auto-generated method stub
		int a[] = {9, 7, 3, 2, 4, 1, 0, 17, 18, 20};
		Sort st = new Sort();
		//st.QuickSort1(a,0,a.length-1);
		st.HeapSort(a,a.length);
		for(int i =0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	
	

}
