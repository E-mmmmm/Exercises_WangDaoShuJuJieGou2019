package chapter4_5_4;

import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//第七题
public class FindInBST {
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
		
		System.out.println(findInBST(s5, 10));
	}
	
	/*
	 * 思路
	 * 	判断当前结点与指定结点的大小关系
	 * 		大于：将当前结点的左孩子作为当前结点，deep+1
	 * 		小于：将当前结点的右孩子作为当前结点，deep+1
	 * 		等于：返回deep
	 */
	/*
	 * 注意：这里我并没有if(root!=null)
	 * 	         因为若加上，会导致查找不存在的结点时，返回错误的层数
	 * 	        若不加，则会抛出空指针异常，用try...catch...将异常捕获并显示“您查找的结点不存在”即可
	 */
	static int deep = 1;
	public static int findInBST(TreeNode root, int element) {
		if(Integer.parseInt(root.getData()) > element) {
			deep++;
			findInBST(root.getLchild(), element);
		} else if(Integer.parseInt(root.getData()) < element) {
			deep++;
			findInBST(root.getRchild(), element);
		} 

		return deep;
	}
}
