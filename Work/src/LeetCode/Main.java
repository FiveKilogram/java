package LeetCode;

import LeetCode.Tree.TreeNode;

import java.util.*;

public class Main {

	
	
	//链表
	//第二题,两数相加
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumListHead = new ListNode(0);
        ListNode sumList  = sumListHead;
        ListNode p = l1, q = l2;
        
        int carry = 0;//获得进位
        
        while(p!=null&&q!=null) {
        	int x = (p!=null)?p.val:0;
        	int y = (q!=null)?q.val:0;
        	
        	int sum = carry + x + y;
        	carry = sum/10;
        	
        	sumList.next = new ListNode(sum%10);
        	sumList = sumList.next;
        	
        	if(p!=null)
        		p = p.next;
        	
        	if(q!=null)
        		q = q.next;
        	
        }
        
        //记得把最后一个进位加上例如80+80,答案会是三位数
        if(carry>0) {
        	sumList.next = new ListNode(carry);
        }
        
        return sumListHead.next;
    }
	
	
	//第十九题,删除链表的倒数第n节点
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lt1 = dummy;
        ListNode lt2 = dummy;//从第一个节点开始
        
        int num = 0;
        while(num<=n) {
        	lt1 = lt1.next;
        	num++;
        }
        while(lt1!=null) {
        	lt1 = lt1.next;
        	lt2 = lt2.next;
        }
        lt2.next = lt2.next.next;
        
        return dummy.next;
    }
	
	//两两交换链表中的节点
	public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
        	return head;
        
        ListNode temp = new ListNode(0);
        temp.next = head;
        
        
        ListNode p = temp;
        ListNode l1 = temp.next;
        ListNode l2 = temp.next.next;
        
        
        while(l1!=null&&l2!=null) {
        	//保存下一个节点
        	ListNode next = l2.next;
        	//交换节点
        	l2.next = l1;
        	p.next = l2;
        	l1.next = next;
        	//异常神用
        	try {
				p = l1;
				l1 = p.next;
				l2 = p.next.next;
			} catch (Exception e) {
				return temp.next;
			}
        }
        
        
        return temp.next;
    }
	
	public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int subLen = 0;
        int i = 0 ,j =0;
        Set set = new HashSet();
        
        while(j<len) {
        	if(!set.contains(s.charAt(j))) {
        		set.add(s.charAt(j));
        		j++;
        		subLen = Math.max(subLen, j-i);
        	}else {
        		set.remove(s.charAt(i));
        		i++;
        	}
        }
        
        return subLen;
    }
	
	public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        int subLen = 0;
        int i = 0 ,j =0;
        Map<Character,Integer> map = new HashMap();
        
        while(j<len) {
        	if(!map.containsKey(s.charAt(j))) {
        		map.put(s.charAt(j), j+1);
        		j++;
        		subLen = Math.max(subLen, j-i);
        	}else {
        		i = Math.max(map.get(s.charAt(j)), i);
        	}
        }
        
        return subLen;
    }


	public TreeNode invertTree(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList();

		queue.offer(root);
		while (!queue.isEmpty()){
			TreeNode node = queue.poll();
			TreeNode leftNode =node.left;
			TreeNode rightNode =node.right;
			if(leftNode!=null){
				queue.offer(leftNode);
			}
			if(rightNode!=null){
				queue.offer(rightNode);
			}
			node.left = rightNode;
			node.right = leftNode;
		}

		return root;




//		if(root==null){
//			return root;
//		}
//		TreeNode left = invertTree(root.left);
//		TreeNode right = invertTree(root.right);
//		root.left = right;
//		root.right = left;
//		return root;
	}

	public int singleNumber(int[] nums) {
		int result = nums[1];
		for (int i = 0; i < nums.length; i++) {
			if(nums[i-1]!=nums[i]){
				result = nums[i];
			}
		}
		for (int num:nums) {

		}
		return result;
	}


    //给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的，使用动态规划
	public boolean isInterleave(String s1, String s2, String s3) {

		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();


		if(len1+len2!=len3){
			return false;
		}
		boolean dp[][] = new boolean[len1+1][len2+1];

		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if(i==0&&j==0){
					dp[i][j] = true;
				}else if(i==0){
					dp[i][j] = dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1));
				}else if(j==0){
					dp[i][j] = dp[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1));
				}else {
					dp[i][j] = (dp[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)))||(dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)));
				}
			}
		}
		return dp[len1][len2];
	}



	//123. 买卖股票的最佳时机 III, 结合买卖股票的最佳时机 I进行解题(求只进行一次买卖最大值)，进行分割，分别求出两段的最大值，进行相加。

	public int halfMaxProfit(int prices[], int start, int end){//求出一段中的最大值
		int minPrice = Integer.MAX_VALUE;
		int maxProfit  = 0;

		for (int i = start; i < end; i++) {
			if(prices[i]<minPrice)
				minPrice = prices[i];
			else if(maxProfit<(prices[i] - minPrice))
				maxProfit = prices[i] - minPrice;
		}
		return maxProfit;
	}
	public void test(){
		int a[] = {3,3,5,0,0,3,1,4};
		System.out.println(halfMaxProfit(a,1,a.length));
	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int tempProfit = 0;

		//不断寻找分割点
		for (int i = 1; i < prices.length; i++) {

			//分别求出两段的最大值的和，注意边界的取值，这个和单独求一段的函数有关
			tempProfit = halfMaxProfit(prices, 0, i+1) + halfMaxProfit(prices, i,prices.length);
			if(tempProfit>maxProfit)
				maxProfit = tempProfit;
		}


		return maxProfit;
	}



	//53. 最大子序和,动态规划基础题
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = nums[0];
        for (int i = 1, length = nums.length; i < length; i++) {
            // 我们不需要记录sum数组，只要算出当前的sum，然后和result比较就行了
            sum = Math.max(sum + nums[i], nums[i]);
            result = Math.max(result, sum);
        }
        return result;
    }

    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = Integer.MIN_VALUE;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }


	public int longestPalindromeSubseq(String s) {
		int len = s.length();
		boolean pd[][] = new boolean[len][len];
		int start = 0;
		int maxLen = 1;
		for (int j = 0; j < len; j++) {
			for (int i = 0; i <= j; i++) {
				if(i==j){
					pd[i][j] = true;
				}
				else if((j-i)==1){
					pd[i][j] = s.charAt(i)==s.charAt(j);
				}else {
					pd[i][j] = (s.charAt(i)==s.charAt(j))&&pd[i+1][j-1];
				}

				if(pd[i][j]&&(j-i+1)>maxLen){
					start = i;
					maxLen = j - i + 1;
				}
			}
		}
		return maxLen;
	}


	public static void main(String[] args) {

		Main main = new Main();

		System.out.println(main.longestPalindromeSubseq("babb"));

	}

	public ListNode FindKthToTail(ListNode head,int k) {
		ListNode node = head;
		int i = 0;
		while(head!=null&&i<k){
			i++;
			head = head.next;
		}
		if(head==null){
			return null;
		}

		while(head!=null){
			head = head.next;
			node = node.next;
		}
		return node;
	}


}
