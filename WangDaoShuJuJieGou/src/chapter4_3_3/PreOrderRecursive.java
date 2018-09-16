package chapter4_3_3;

import chapter2_3_7.Pointer;

//递归实现二叉树的前序遍历
public class PreOrderRecursive {
	public static void main(String[] args) {
		TreeNode s1 = new TreeNode("1");
		TreeNode s2 = new TreeNode("2");
		TreeNode s3 = new TreeNode("3");
		TreeNode s4 = new TreeNode("4");
		TreeNode s5 = new TreeNode("5");
		TreeNode s6 = new TreeNode("6");
		TreeNode s7 = new TreeNode("7");
		
		TreePointer T = new TreePointer(s1);
		
//		TreeNodeTool.ladd(s2, s1);
//		TreeNodeTool.radd(s3, s1);
//		TreeNodeTool.radd(s4, s2);
//		TreeNodeTool.radd(s5, s3);
//		TreeNodeTool.ladd(s6, s4);
		
		TreeNodeTool.ladd(s2, s1);
		TreeNodeTool.radd(s3, s1);
		TreeNodeTool.ladd(s4, s2);
		TreeNodeTool.radd(s5, s2);
		TreeNodeTool.ladd(s6, s3);
		TreeNodeTool.radd(s7, s3);
		
		
		
		//TreeNodeTool.preOrderRecursive(T);
		//TreeNodeTool.inOrderRecursive(T);
		//TreeNodeTool.postOrderRecursive(T);
		
		//TreeNodeTool.inOrder(T);
		//TreeNodeTool.preOrder(T);
		//TreeNodeTool.postOrder(T);
		
		//TreeNodeTool.levelOrder(T);
		
		//TreeNodeTool.inOrderThreadBiTree(s1);
//		System.out.println(TreeNodeTool.firstNode(s1).getData());
//		System.out.println(TreeNodeTool.nextNode(s1).getData());
		//TreeNodeTool.threadInOrder(s1);
		
		TreeNodeTool.preOrderThreadBiTree(s1);
		System.out.println(TreeNodeTool.nextNodePre(s4).getData());
	}
}

