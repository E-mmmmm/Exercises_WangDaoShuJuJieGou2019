package chapter4_4_5;

import chapter3_2_5.CyclicQueue;
import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;
//第六题
/*
 * 先序遍历二叉树，
 */
public class Deep_6 {
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
		TreeNode N = new TreeNode("N");
		
		TreeNodeTool.ladd(B, A);
		TreeNodeTool.ladd(E, B);
		TreeNodeTool.radd(C, B);
		TreeNodeTool.ladd(K, E);
		TreeNodeTool.ladd(F, C);
		TreeNodeTool.radd(D, C);
		TreeNodeTool.radd(L, K);
		TreeNodeTool.radd(G, F);
		TreeNodeTool.ladd(H, D);
		TreeNodeTool.radd(I, H);
		TreeNodeTool.ladd(M, I);
		TreeNodeTool.radd(J, I);
		TreeNodeTool.radd(N, M);
		
		System.out.println(deep(A));
	}
	

	public static int deep(TreeNode root) {
		return deepOperater(root, 1);
	}
	
	static int deep = 0;
	private static int deepOperater(TreeNode root, int tempDeep) {
		if(root != null) {
			if(root.getLchild() != null) {
				deepOperater(root.getLchild(), tempDeep+1);
			}
			deepOperater(root.getRchild(), tempDeep);
		}
		
		if(tempDeep > deep) {
			deep = tempDeep;
		}
		
		return deep;
	}
}
