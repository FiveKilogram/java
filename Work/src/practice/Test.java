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
		return head; // 开始虽然将中间的head计算出来了，但是没有到return
						// head上，然后再进去那个递归的时候那个递归里面又会将head计算出来，然后又会有一个return
						// head。。。直到把所有的都执行完出来之后，这个中间的head才会执行出去。
	}

	// for test -- print tree ,这个不懂，
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 10);
		System.out.println();
	}

	// 这个也不懂，这个结构不懂
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

	// 14、最长公共前缀
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

	// 13. 罗马数字转整数
	// 从右到左直接相加，如果比右边的数字小则减去这个数。知识点：Map
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

	// 20. 有效的括号
	// 使用栈数据结构进行匹配。
	public boolean isValid(String s) {

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
				st.push(s.charAt(i));
			}
			try {// 异常的神使用，当出现出栈的值为空时，返回false.
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

	// 21. 合并两个有序链表
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

	// 剑指offer第三题
	// 知识点：哈希表。如果哈希表中没有则把元素加进哈希表。如果有的话则存在重复。
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

	// 如果不存在重复则每个数可以放到所属的位置上。
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

	// 剑指offer第五题，得到空格的数目，可以知道替换后字符串的长度。对应的将字符复制，注意替换后的对应关系。
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
		int index = 0;//相对于原字符串偏移量
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == ' ') {
				c[i + index] = '%';
				c[i + index + 1] = '2';
				c[i + index + 2] = '0';
				index = index + 2;
			} else {
				c[i + index] = a.charAt(i);//加上偏移量
			}
		}
//		for (int i = 0; i < c.length; i++) {
//			result = result + c[i];
//		}
		String result = new String(c);//直接用String构造方法

		return result;
	}

	// 剑指offer第六题，顺序遍历链表，将其压入栈中，然后出栈，此解法空间复杂度为n。
	// 空间复杂度为1的解法会改变链表的结构。
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

	// 空间复杂度为n的解法
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

	// leetcode83. 删除排序链表中的重复元素,重复的元素保留一个。
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
	//剑指offer面试题第十八题，删除链表中重复的节点，重复的节点不保留。
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

	// leetcode141:环形链表。leetcode网页上有两种解法的详细解释。

	// 知识点：集合。每遍历一个节点，将其加入到集合中。如果集合中已经存在则有环形链表。
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

	// leetcode160:相交链表
	// 思路：比较两个链表的长度，获得两个链表的长度差，遍历链表时先从较长链表的开始直到较短链表的起始位置，接着开始同时开始便利并比较链表节点元素是否相同。
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
		// 先遍历较长链表，长度为链表长度差。
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

	// leetcode203移除链表元素,使用链表常规操作。
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

	// leetcode203:移除链表元素，使用ArrayList数据结构，将新链表的值存进ArrayList中，然后依次取出，构造成新链表。
	public ListNode removeElements2(ListNode head, int val) {
		ArrayList<Integer> hs = new ArrayList<Integer>();
		while (head != null) {
			if (head.val != val) {// 如果不等于给定值，则把元素加进ArrayList
				hs.add((Integer) head.val);
			}
			head = head.next;
		}
		ListNode index = new ListNode(-1);
		ListNode current = index;
		int len = hs.size();

		for (int i = 0; i < len; i++) {
			current.next = new ListNode(hs.get(i).intValue());// 把元素添加到新链表。
			current = current.next;
		}
		return index.next;
	}

	// 剑指offer第七题，树
	// leetcode105题，从树中序和前序或者后序遍历重构树。
	// 根据各种遍历方式的特点确定节点左右子树,然后递归实现。
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

	// leet106题,中序比遍历和后序遍历。做法和前一道一致
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

	// 剑指offer第八题
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}

		if (pNode.right != null) {// 如果有右子树,那么最左边的节点是下一个
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}

		while (pNode.next != null) {// 如果没有,那么一直向上遍历父节点直到当前节点是父节点左节点,返回父节点。
			if (pNode.next.left == pNode)
				return pNode.next;
			pNode = pNode.next;
		}
		return null;
	}

	// 剑指offer第九题,用两个堆栈模拟队列。
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

	// 剑指offer第十一题,使用二分法进行查找，注意特例。
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

	// 剑指offer第十二题,知识点：回溯法。回溯法一般和递归相结合。
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

		boolean visited[] = new boolean[rows * cols];// 和原始矩阵相同大小的矩阵用来判断是否走过

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

		int path = 0;// 判断走到哪个地方

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {// 从每个点开始走
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
		} // 如果路径长度和字符长度一样,那么有路径,返回true.
		boolean hasPath = false;
		if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLen]
				&& visited[row * cols + col] == false) {
			// 点在矩阵内,并且字符匹配,路径没有走过,则往点四周走下一步。

			pathLen = pathLen + 1;// 路径同步
			visited[row * cols + col] = true;// 标记为走过。

			hasPath = findPath(matrix, rows, cols, row - 1, col, str, pathLen, visited)
					|| findPath(matrix, rows, cols, row + 1, col, str, pathLen, visited)
					|| findPath(matrix, rows, cols, row, col - 1, str, pathLen, visited)
					|| findPath(matrix, rows, cols, row, col + 1, str, pathLen, visited);// 往四周走

			// 如果这个点四周走不通的话,返回到上一个上一点,并且更新路径和状态。
			if (hasPath == false) {
				pathLen = pathLen - 1;
				visited[row * cols + col] = false;
			}
		}

		return hasPath;

	}

	// 动态规,剪绳子问题.这个解法默认长度大于4的绳子本身的长度小于剪掉以后的各个长度的乘积？
	// 当做子问题时的最优解和不当做子问题时候最优解不太一样？
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

	// 剑指offer第十五题，知识点：位移运算.
	// 重要知识点：把一个整数减一之后再和原来的整数做位与运算,相当于把整数二进制表示中最右边的1变成0.
	// 用只有一个数字为一的二进制数和数做与运算,可以判断数字对应位置上是否为1
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

	// 重要知识点：把一个整数减一之后再和原来的整数做位与运算,相当于把整数二进制表示中最右边的1变成0.很多位运算的题都可以用这个来解答。
	// 利用这个知识点做这道题能将降低复杂度。
	public int NumberOf12(int num) {
		int count = 0;

		while (num != 0) {
			count++;
			num = num & (num - 1);
		}
		return count;
	}

	//打印从1到最大的n位数。使用递归方法实现。把问题转换为数字排列问题。
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

	

	//反转链表，剑指offer第24题
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