package chapter4_5_4;

import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//第九题
public class BiggestAndSmallestInBST {
	public static void main(String[] args) {
		TreeNode s52 = new TreeNode("52");
		TreeNode s26 = new TreeNode("26");
		TreeNode s71 = new TreeNode("71");
		TreeNode s14 = new TreeNode("14");
		TreeNode s32 = new TreeNode("32");
		TreeNode s60 = new TreeNode("60");
		TreeNode s93 = new TreeNode("93");
		TreeNode s24 = new TreeNode("24");
		TreeNode s41 = new TreeNode("41");
		TreeNode s58 = new TreeNode("58");
		
		TreeNodeTool.ladd(s26, s52);
		TreeNodeTool.radd(s71, s52);
		TreeNodeTool.ladd(s14, s26);
		TreeNodeTool.radd(s32, s26);
		TreeNodeTool.ladd(s60, s71);
		TreeNodeTool.radd(s93, s71);
		TreeNodeTool.radd(s24, s14);
		TreeNodeTool.radd(s41, s32);
		TreeNodeTool.ladd(s58, s60);
		
		System.out.println(extremeValueBST(s52));
	}
	/*
	 * 思路
	 * 	二叉排序树中，最小的关键字在最左下
	 * 				   最大的关键字在最右下
	 */
	public static String extremeValueBST(TreeNode root) {
		int min = 0;
		int max = 0;
		
		TreeNode temp = new TreeNode();
		temp = root;
		//最小值
		while(temp.getLchild() != null) {
			temp = temp.getLchild();
		}
		min = Integer.parseInt(temp.getData());
		
		//最大值
		while(root.getRchild() != null) {
			root = root.getRchild();
		}
		max = Integer.parseInt(root.getData());
		
		return "min:" + min + "---max:" + max; 
	}
}
