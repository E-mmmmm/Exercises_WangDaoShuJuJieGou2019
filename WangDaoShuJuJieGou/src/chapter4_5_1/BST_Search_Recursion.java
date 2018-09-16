package chapter4_5_1;

import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

public class BST_Search_Recursion {
	public static void main(String[] args) {
		TreeNode s1 = new TreeNode("1");
		TreeNode s2 = new TreeNode("2");
		TreeNode s3 = new TreeNode("3");
		TreeNode s4 = new TreeNode("4");
		TreeNode s5 = new TreeNode("6");
		TreeNode s6 = new TreeNode("8");
		
		TreeNodeTool.ladd(s2, s5);
		TreeNodeTool.radd(s6, s5);
		TreeNodeTool.ladd(s1, s2);
		TreeNodeTool.radd(s4, s2);
		TreeNodeTool.ladd(s3, s4);
		
		System.out.println(BST_Search_Recursion(8, s5).getData());
	}
	
	static TreeNode result = null;
	public static TreeNode BST_Search_Recursion(int key, TreeNode root) {
		if(key == Integer.parseInt(root.getData())) {
			result = root;
		} else if(key > Integer.parseInt(root.getData())) {
			BST_Search_Recursion(key, root.getRchild());
		} else {
			BST_Search_Recursion(key, root.getLchild());
		}
		
		return result;
	}
}
