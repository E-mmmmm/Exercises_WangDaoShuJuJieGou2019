package chapter4_5_4;

import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//归纳总结中的例题
public class Example {
	public static void main(String[] args) {
		TreeNode s1 = new TreeNode("1");
		TreeNode s2 = new TreeNode("2");
		TreeNode s3 = new TreeNode("3");
		TreeNode s4 = new TreeNode("4");
		TreeNode s5 = new TreeNode("5");
		TreeNode s6 = new TreeNode("6");
		TreeNode s7 = new TreeNode("7");
		TreeNode s8 = new TreeNode("H");
		TreeNode s9 = new TreeNode("I");
		TreeNode s10 = new TreeNode("J");
		TreeNode s11 = new TreeNode("K");
		TreeNode s12 = new TreeNode("L");
		TreeNode s13 = new TreeNode("M");
		TreeNode s14 = new TreeNode("N");
		TreeNode s15 = new TreeNode("O");
		
		TreeNodeTool.ladd(s2, s1);
		TreeNodeTool.radd(s3, s1);
		TreeNodeTool.radd(s4, s2);
		TreeNodeTool.radd(s5, s3);
		TreeNodeTool.ladd(s6, s4);
		
//		TreeNodeTool.ladd(s2, s1);
//		TreeNodeTool.radd(s3, s1);
//		TreeNodeTool.ladd(s4, s2);
//		TreeNodeTool.radd(s5, s2);
//		TreeNodeTool.ladd(s6, s3);
//		TreeNodeTool.radd(s7, s3);
		
		//第1题
//		System.out.println(du1(s1));
		
		//第2题
//		System.out.println(du2(s1));
		
		//第3题
//		System.out.println(du0(s1));
		
		//第4题
		System.out.println(deep(s1));
	}
	
	//第1题
	static int count = 0;
	public static int du1(TreeNode root) {
		if(root != null) {
			if((root.getLchild() == null && root.getRchild() != null) || 
					(root.getLchild()!= null && root.getRchild() == null)) {
				count++;
			}
			
			du1(root.getLchild());
			du1(root.getRchild());
		}
		
		return count;
	}
	
	//第2题
	public static int du2(TreeNode root) {
		if(root != null) {
			if(root.getLchild() != null && root.getRchild() != null) {
				count++;
			}
			
			du2(root.getLchild());
			du2(root.getRchild());
		}
		
		return count;
	}
	
	//第3题
	public static int du0(TreeNode root) {
		if(root != null) {
			if(root.getLchild() == null && root.getRchild() == null) {
				count++;
			}
			
			du0(root.getLchild());
			du0(root.getRchild());
		}
		
		return count;
	}
	
	//第4题
	//记录每个叶结点的深度，返回最深的那个，便是树的高度
	static int max = 0;
	static int deep = 0;
	public static int deep(TreeNode root) {
		if(root != null) {
			deep++;
			if(root.getLchild() == null && root.getRchild() == null) {
				if(deep > max) {
					max = deep;
				}
				deep = 0;
			}
			
			deep(root.getLchild());
			deep(root.getRchild());
		}
		
		return max;
	}
	
	//第5题
	/*
	 * 思路
	 * 	用deep记录结点的深度
	 * 	用一个数组记录深度为X的结点的个数
	 * 	最大的即为宽度
	 * 
	 * 	问题：如何寻找最大的？遍历数组？如何在递归算法中遍历数组？
	 */
}
