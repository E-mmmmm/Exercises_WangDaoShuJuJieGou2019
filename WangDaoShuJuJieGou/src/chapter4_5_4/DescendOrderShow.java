package chapter4_5_4;

import chapter3_1_4.SequenceStack;
import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//第十题
public class DescendOrderShow {
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
		
		descendOrderShow(s52, 100);
		descendOrderShowRecursive(s52, 100);
	}
	
	/*
	 * 思路
	 * 	反向使用中序遍历的非递归算法
	 */
	public static void descendOrderShow(TreeNode root, int k) {
		SequenceStack<TreeNode> ss = new SequenceStack<>();
		ss.InitStack();
		
		TreeNode temp = new TreeNode();
		
		while(root != null || !ss.StackEmpty()) {
			if(root != null) {
				ss.Push(root);
				root = root.getRchild();
			} else {
				temp = ss.Pop();
				//判断是否不小于k
				if(Integer.parseInt(temp.getData()) >= k) {
					System.out.print(temp.getData() + "; ");
				} else {
					return;
				}
				root = temp.getLchild();
			}
		}
	}
	
	//递归实现
	//访问顺序：右子树、根结点、左子树
	public static void descendOrderShowRecursive(TreeNode root, int k) {
		if(root == null) {
			return;
		}
		
		if(root.getRchild() != null) {
			descendOrderShowRecursive(root.getRchild(), k);
		}
		
		if(Integer.parseInt(root.getData()) >= k) {
			System.out.print(root.getData() + "; ");
		}
		
		if(root.getLchild() != null) {
			descendOrderShowRecursive(root.getLchild(), k);
		}
	}
}
