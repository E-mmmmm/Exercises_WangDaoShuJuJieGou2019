package chapter4_4_5;

import chapter3_2_5.CyclicQueue;
import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//第五题
/*
 * 思路：
 * 叶子结点为没有孩子结点的结点
 * 森林转换为二叉树后，即为一个结点无右孩子结点
 * 因此，采用层次遍历的方式，遍历每一个结点
 * 判断其有无右孩子，无则count++；
 */
public class NumberOfLeaves_5 {
	public static void main(String[] args) {
		TreeNode A = new TreeNode("A");
		TreeNode B = new TreeNode("B");
		TreeNode C = new TreeNode("C");
		TreeNode D = new TreeNode("D");
		TreeNode E = new TreeNode("E");
		TreeNode F = new TreeNode("F");
		TreeNode G = new TreeNode("G");
		TreeNode H = new TreeNode("H");
		TreeNode I = new TreeNode("I");
		TreeNode J = new TreeNode("J");
		TreeNode K = new TreeNode("K");
		TreeNode L = new TreeNode("L");
		TreeNode M = new TreeNode("M");
		
		TreeNodeTool.ladd(B, A);
		TreeNodeTool.radd(C, A);
		TreeNodeTool.ladd(D, B);
		TreeNodeTool.radd(E, B);
		TreeNodeTool.ladd(F, C);
		TreeNodeTool.radd(G, C);
		TreeNodeTool.ladd(H, E);
		TreeNodeTool.ladd(I, F);
		TreeNodeTool.radd(J, G);
		TreeNodeTool.radd(M, I);
		TreeNodeTool.ladd(K, J);
		TreeNodeTool.radd(L, K);
		
		System.out.println(numberOfLeaves(A));
	}
	/**
	 * 求以孩子兄弟表示法存储的森林的叶子节点数
	 * @param root
	 * 			二叉树的结点
	 * @return
	 * 			叶子节点数
	 */
	public static int numberOfLeaves(TreeNode root) {
		int count = 0;
		
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		cq.enQueue(root);
		
		TreeNode temp = new TreeNode();
		
		while(!cq.queueEmpty()) {
			temp = cq.deQueue();
			if(temp.getLchild() != null) {
				cq.enQueue(temp.getLchild());
			} else {
				count++;
			}
			
			if(temp.getRchild() != null) {
				cq.enQueue(temp.getRchild());
			}
		}
		return count;
	}
}
