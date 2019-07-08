package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

import org.omg.Messaging.SyncScopeHelper;

public class Test {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	private static final String HashTable = null;

	public static Node generateTree(int[] sortArr) {
		if (sortArr == null) {
			return null;
		}
		return generate(sortArr, 0, sortArr.length - 1);
	}

	public static Node generate(int[] sortArr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node head = new Node(sortArr[mid]);
		head.left = generate(sortArr, start, mid - 1);
		head.right = generate(sortArr, mid + 1, end);
		return head; // ��ʼ��Ȼ���м��head��������ˣ�����û�е�return
						// head�ϣ�Ȼ���ٽ�ȥ�Ǹ��ݹ��ʱ���Ǹ��ݹ������ֻὫhead���������Ȼ���ֻ���һ��return
						// head������ֱ�������еĶ�ִ�������֮������м��head�Ż�ִ�г�ȥ��
	}

	// for test -- print tree ,���������
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 10);
		System.out.println();
	}

	// ���Ҳ����������ṹ����
	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = (len - lenM) / 2;// len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					result[0] = nums[i];
					result[1] = nums[j];
				}
			}
		}
		return result;
	}

	// 14�������ǰ׺
	public String longestCommonPrefix(String[] strs) {

		if (strs.length == 0 || strs == null) {
			return "";
		}

		// int minLength = strs[0].length();
		//
		// for(int i =0;i<strs.length;i++) {
		// if(strs[i].length()<minLength) {
		// minLength = strs[i].length();
		// }
		// }

		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				try {
					if (strs[0].charAt(i) != strs[j].charAt(i)) {
						return strs[0].substring(0, i);
					}
				} catch (Exception e) {
					return strs[0].substring(0, i);
				}

			}
		}

		return strs[0];

	}

	// 13. ��������ת����
	// ���ҵ���ֱ����ӣ�������ұߵ�����С���ȥ�������֪ʶ�㣺Map
	public int romanToInt(String s) {

		int num = 0;
		int len = s.length();

		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		num = romanMap.get(s.charAt(len - 1));
		for (int i = len - 2; i >= 0; i--) {
			int num1 = romanMap.get(s.charAt(i));
			int num2 = romanMap.get(s.charAt(i + 1));
			if (num1 < num2) {
				num = num - num1;
			} else {
				num = num + num1;
			}
		}

		return num;
	}

	// 20. ��Ч������
	// ʹ��ջ���ݽṹ����ƥ�䡣
	public boolean isValid(String s) {

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
				st.push(s.charAt(i));
			}
			try {// �쳣����ʹ�ã������ֳ�ջ��ֵΪ��ʱ������false.
				if (s.charAt(i) == '}') {
					if (st.pop() != '{') {
						return false;
					}
				}
				if (s.charAt(i) == ']') {
					if (st.pop() != '[') {
						return false;
					}
				}
				if (s.charAt(i) == ')') {
					if (st.pop() != '(') {
						return false;
					}
				}
			} catch (Exception e) {
				return false;
			}

		}
		if (st.isEmpty()) {
			return true;
		}
		return false;
	}

	// 21. �ϲ�������������
	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode current = new ListNode(0);
		if (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				current = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				current = l2;
				l2 = l2.next;
			}
		}
		if (l1 == null) {
			current.next = l2;
		} else {
			current.next = l1;
		}
		return current.next;
	}

	// ��ָoffer������
	// ֪ʶ�㣺��ϣ�������ϣ����û�����Ԫ�ؼӽ���ϣ������еĻ�������ظ���
	public boolean dupliacate(int a[]) {
		boolean b = false;

		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			if (table.containsValue(new Integer(a[i]))) {
				b = true;
				return b;
			} else {
				table.put(new Integer(i), new Integer(a[i]));
			}
		}

		return b;
	}

	// ����������ظ���ÿ�������Էŵ�������λ���ϡ�
	public boolean dupliacate2(int a[]) {
		boolean b = false;

		for (int i = 0; i < a.length; i++) {
			while (i != a[i]) {
				if (a[i] == a[a[i]])
					return true;
				else {
					int temp = 0;
					temp = a[a[i]];
					a[a[i]] = a[i];
					a[i] = temp;
				}
			}
		}

		return b;

	}

	// ��ָoffer�����⣬�õ��ո����Ŀ������֪���滻���ַ����ĳ��ȡ���Ӧ�Ľ��ַ����ƣ�ע���滻��Ķ�Ӧ��ϵ��
	public String replaceSpace(StringBuffer str) {
		String a = str.toString();
		int str_len = a.length();
		int b = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == ' ') {
				b++;
			}
		}

		char c[] = new char[str_len + b * 2];
		System.out.println(c.length);
		int index = 0;//�����ԭ�ַ���ƫ����
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == ' ') {
				c[i + index] = '%';
				c[i + index + 1] = '2';
				c[i + index + 2] = '0';
				index = index + 2;
			} else {
				c[i + index] = a.charAt(i);//����ƫ����
			}
		}
//		for (int i = 0; i < c.length; i++) {
//			result = result + c[i];
//		}
		String result = new String(c);//ֱ����String���췽��

		return result;
	}

	// ��ָoffer�����⣬˳�������������ѹ��ջ�У�Ȼ���ջ���˽ⷨ�ռ临�Ӷ�Ϊn��
	// �ռ临�Ӷ�Ϊ1�Ľⷨ��ı�����Ľṹ��
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		ArrayList<Integer> ar = new ArrayList<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		if (listNode == null) {
			return ar;
		}
		while (listNode != null) {
			st.push((Integer) listNode.val);
			listNode = listNode.next;
		}

		while (!st.isEmpty()) {
			ar.add((Integer) st.pop());
		}

		return ar;
	}

	// �ռ临�Ӷ�Ϊn�Ľⷨ
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode cur = head;
		ListNode pre = null;
		ListNode next = null;

		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		return pre;
	}

	// leetcode83. ɾ�����������е��ظ�Ԫ��,�ظ���Ԫ�ر���һ����
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode index = head;
		while (head != null) {
			if (head.next == null) {
				return index;
			}
			if (head.val == head.next.val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return index;
	}
	//��ָoffer�������ʮ���⣬ɾ���������ظ��Ľڵ㣬�ظ��Ľڵ㲻������
	public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null) {
        	return null;
        }
        if(pHead.next==null) {
        	return pHead;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        
        while(pHead!=null&&pHead.next!=null) {
        	if(pHead.val!=pHead.next.val) {
        		pre = pHead;
        		pHead = pHead.next;
        	}else {
        		int temp = pHead.val;
        		while(pHead!=null&&pHead.val==temp) {
        			pHead = pHead.next;
        		}
        		pre.next = pHead;        		
        	}
        }
        return head.next;
	}

	// leetcode141:��������leetcode��ҳ�������ֽⷨ����ϸ���͡�

	// ֪ʶ�㣺���ϡ�ÿ����һ���ڵ㣬������뵽�����С�����������Ѿ��������л�������
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> node = new HashSet<>();
		while (head != null) {
			if (node.contains(head))
				return true;
			else
				node.add(head);
			head = head.next;
		}
		return false;
	}

	// leetcode160:�ཻ����
	// ˼·���Ƚ���������ĳ��ȣ������������ĳ��Ȳ��������ʱ�ȴӽϳ�����Ŀ�ʼֱ���϶��������ʼλ�ã����ſ�ʼͬʱ��ʼ�������Ƚ�����ڵ�Ԫ���Ƿ���ͬ��
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lenthA = 0;
		int lenthB = 0;

		ListNode indexA = headA;
		ListNode indexB = headB;

		while (headA != null) {
			headA = headA.next;
			lenthA++;
		}

		while (headB != null) {
			headB = headB.next;
			lenthB++;
		}

		int len = Math.abs(lenthB - lenthA);
		// �ȱ����ϳ���������Ϊ�����Ȳ
		if (lenthA > lenthB) {
			while (len > 0) {
				indexA = indexA.next;
				len--;
			}
		} else {
			while (len > 0) {
				indexB = indexB.next;
				len--;
			}

		}
		while (indexB != null) {
			if (indexB.equals(indexA)) {
				return indexB;
			}
			indexA = indexA.next;
			indexB = indexB.next;
		}
		return null;
	}

	// leetcode203�Ƴ�����Ԫ��,ʹ�������������
	public ListNode removeElements(ListNode head, int val) {
		ListNode header = new ListNode(-1);
		header.next = head;
		ListNode cur = header;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return header.next;
	}

	// leetcode203:�Ƴ�����Ԫ�أ�ʹ��ArrayList���ݽṹ�����������ֵ���ArrayList�У�Ȼ������ȡ���������������
	public ListNode removeElements2(ListNode head, int val) {
		ArrayList<Integer> hs = new ArrayList<Integer>();
		while (head != null) {
			if (head.val != val) {// ��������ڸ���ֵ�����Ԫ�ؼӽ�ArrayList
				hs.add((Integer) head.val);
			}
			head = head.next;
		}
		ListNode index = new ListNode(-1);
		ListNode current = index;
		int len = hs.size();

		for (int i = 0; i < len; i++) {
			current.next = new ListNode(hs.get(i).intValue());// ��Ԫ����ӵ�������
			current = current.next;
		}
		return index.next;
	}

	// ��ָoffer�����⣬��
	// leetcode105�⣬���������ǰ����ߺ�������ع�����
	// ���ݸ��ֱ�����ʽ���ص�ȷ���ڵ���������,Ȼ��ݹ�ʵ�֡�
	public TreeNode buildTree(int[] pre, int[] in) {

		if (pre == null || in == null) {
			return null;
		}
		return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	private TreeNode construct(int[] pre, int[] in, int ps, int pe, int is, int ie) {
		if (ps > pe || is > ie) {
			return null;
		}

		TreeNode root = new TreeNode(pre[ps]);

		int position = 0;
		for (int i = is; i <= ie; i++) {
			if (in[i] == pre[ps]) {
				position = i;
			}
		}
		root.left = construct(pre, in, ps + 1, ps + position - is, is, position - 1);
		root.right = construct(pre, in, ps + position - is + 1, pe, position + 1, ie);

		return root;
	}

	// leet106��,����ȱ����ͺ��������������ǰһ��һ��
	public TreeNode buildTree2(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}
		return construct(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	private TreeNode construct2(int[] in, int[] post, int is, int ie, int ps, int pe) {
		if (is > ie || ps > pe) {
			return null;
		}

		TreeNode root = new TreeNode(post[pe]);
		int position = 0;

		for (int i = is; i <= ie; i++) {
			if (in[i] == post[pe]) {
				position = i;
			}
		}
		root.left = construct2(in, post, is, position - 1, ps, ps + position - is - 1);
		root.right = construct2(in, post, position + 1, ie, ps + position - is, pe - 1);

		return root;
	}

	// ��ָoffer�ڰ���
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}

		if (pNode.right != null) {// �����������,��ô����ߵĽڵ�����һ��
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}

		while (pNode.next != null) {// ���û��,��ôһֱ���ϱ������ڵ�ֱ����ǰ�ڵ��Ǹ��ڵ���ڵ�,���ظ��ڵ㡣
			if (pNode.next.left == pNode)
				return pNode.next;
			pNode = pNode.next;
		}
		return null;
	}

	// ��ָoffer�ھ���,��������ջģ����С�
	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.pop().intValue();
	}

	// ��ָoffer��ʮһ��,ʹ�ö��ַ����в��ң�ע��������
	public int minNumberInRotateArray(int[] array) {

		if (array.length == 1) {
			return array[0];
		}

		int min = 0;
		int pre = 0;
		int end = array.length - 1;

		if (array[pre] < array[end]) {
			min = array[pre];
		}

		int mid = 0;
		while (array[pre] >= array[end]) {
			if (end - pre == 1) {
				return array[end];
			}

			mid = (pre + end) / 2;

			if (array[pre] == array[end] && array[pre] == array[mid]) {
				return min(array, pre, end);
			}
			if (array[pre] <= array[mid]) {
				pre = mid;
			} else {
				end = mid;
			}
		}
		min = array[mid];

		return min;
	}

	public int min(int[] array, int pre, int end) {
		int min_num = array[pre];
		for (int i = pre + 1; i <= end; i++) {
			if (array[i] < min_num) {
				min_num = array[i];
			}
		}
		return min_num;
	}

	// ��ָoffer��ʮ����,֪ʶ�㣺���ݷ������ݷ�һ��͵ݹ����ϡ�
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

		boolean visited[] = new boolean[rows * cols];// ��ԭʼ������ͬ��С�ľ��������ж��Ƿ��߹�

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

		int path = 0;// �ж��ߵ��ĸ��ط�

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {// ��ÿ���㿪ʼ��
				if (findPath(matrix, rows, cols, i, j, str, path, visited)) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean findPath(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLen,
			boolean visited[]) {
		if (pathLen == str.length) {
			return true;
		} // ���·�����Ⱥ��ַ�����һ��,��ô��·��,����true.
		boolean hasPath = false;
		if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLen]
				&& visited[row * cols + col] == false) {
			// ���ھ�����,�����ַ�ƥ��,·��û���߹�,��������������һ����

			pathLen = pathLen + 1;// ·��ͬ��
			visited[row * cols + col] = true;// ���Ϊ�߹���

			hasPath = findPath(matrix, rows, cols, row - 1, col, str, pathLen, visited)
					|| findPath(matrix, rows, cols, row + 1, col, str, pathLen, visited)
					|| findPath(matrix, rows, cols, row, col - 1, str, pathLen, visited)
					|| findPath(matrix, rows, cols, row, col + 1, str, pathLen, visited);// ��������

			// �������������߲�ͨ�Ļ�,���ص���һ����һ��,���Ҹ���·����״̬��
			if (hasPath == false) {
				pathLen = pathLen - 1;
				visited[row * cols + col] = false;
			}
		}

		return hasPath;

	}

	// ��̬��,����������.����ⷨĬ�ϳ��ȴ���4�����ӱ���ĳ���С�ڼ����Ժ�ĸ������ȵĳ˻���
	// ����������ʱ�����Ž�Ͳ�����������ʱ�����Žⲻ̫һ����
	public int maxCuting(int length) {

		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}

		int result[] = new int[length + 1];

		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;

		int max = 0;
		for (int i = 4; i <= length; i++) {
			max = 0;
			for (int j = 1; j <= i / 2; j++) {
				int tempLength = result[j] * result[i - j];
				if (max < tempLength) {
					max = tempLength;
				}
				result[i] = max;
			}
		}
		return result[length];
	}

	// ��ָoffer��ʮ���⣬֪ʶ�㣺λ������.
	// ��Ҫ֪ʶ�㣺��һ��������һ֮���ٺ�ԭ����������λ������,�൱�ڰ����������Ʊ�ʾ�����ұߵ�1���0.
	// ��ֻ��һ������Ϊһ�Ķ�������������������,�����ж����ֶ�Ӧλ�����Ƿ�Ϊ1
	public int NumberOf1(int num) {
		int count = 0;
		int flag = 1;

		while (flag != 0) {
			if ((num & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	// ��Ҫ֪ʶ�㣺��һ��������һ֮���ٺ�ԭ����������λ������,�൱�ڰ����������Ʊ�ʾ�����ұߵ�1���0.�ܶ�λ������ⶼ��������������
	// �������֪ʶ����������ܽ����͸��Ӷȡ�
	public int NumberOf12(int num) {
		int count = 0;

		while (num != 0) {
			count++;
			num = num & (num - 1);
		}
		return count;
	}

	//��ӡ��1������nλ����ʹ�õݹ鷽��ʵ�֡�������ת��Ϊ�����������⡣
	public void Print1ToMaxOfNDigits(int n) {
		if (n <= 0)
			return;

		int result[] = new int[n];
		Print1ToMaxOfNDigitsCore(result, n, 0);

	}

	public void Print1ToMaxOfNDigitsCore(int result[], int length, int index) {
		if(index == length) {
			PrintNum(result);
			return;
		}
		for(int i=0;i<10;i++) {
			result[index] = i;
			Print1ToMaxOfNDigitsCore(result, length, index+1);
		}
	}

	public void PrintNum(int result[]) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println("");
	}

	

	//��ת������ָoffer��24��
	public ListNode ReverseList(ListNode head) {
		
		ListNode cur = head;
		ListNode pre = null;
		ListNode ReverseHead = null;
		
		if(cur==null||cur.next==null)
			return head;
		
		while(cur!=null) {
			
			ListNode NextNode = cur.next;
			
			if(NextNode==null)
				ReverseHead = cur;
			
			cur.next = pre;
			cur = pre;
			NextNode = cur;
			
		}
		
		return ReverseHead;
	}
	
	
	
	
	public static void main(String[] args) {
		Test t = new Test();
		//t.Print1ToMaxOfNDigits(4);
		// trans t1 = new trans();
		// int a = 0;
		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// printTree(generateTree(arr));
		// String str[] = new String[3];//["flower","flow","flight"]
		// str[0] = "flower";
		// str[1] = "flow";
		// str[2] = "flight";
		// System.out.println(t.longestCommonPrefix(str));
		// System.out.println(t.isValid("]"));
		// int a[] = {0,2,4,3,3};
		// System.out.println(t.dupliacate2(a));
		// String str = "as dzxcas d";
		// String str4 = str.replaceAll(" ","%20");
		// System.out.println(str4);
		
		int a = 11;
		a= a/10;
		int b= a;
		System.out.println(b);
	}

}