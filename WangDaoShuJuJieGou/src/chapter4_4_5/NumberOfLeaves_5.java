package chapter4_4_5;

import chapter3_2_5.CyclicQueue;
import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//������
/*
 * ˼·��
 * Ҷ�ӽ��Ϊû�к��ӽ��Ľ��
 * ɭ��ת��Ϊ�������󣬼�Ϊһ��������Һ��ӽ��
 * ��ˣ����ò�α����ķ�ʽ������ÿһ�����
 * �ж��������Һ��ӣ�����count++��
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
	 * ���Ժ����ֵܱ�ʾ���洢��ɭ�ֵ�Ҷ�ӽڵ���
	 * @param root
	 * 			�������Ľ��
	 * @return
	 * 			Ҷ�ӽڵ���
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
