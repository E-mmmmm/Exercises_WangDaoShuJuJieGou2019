package chapter4_3_3;

import chapter2_3_7.Pointer;
import chapter4_2_3.PublicAncestor;

//�ݹ�ʵ�ֶ�������ǰ�����
public class TreeTest {
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

		// TreePointer T = new TreePointer(s1);
		// ��������ʽ1
		// ������1
		TreeNodeTool.ladd(s2, s1);
		TreeNodeTool.radd(s3, s1);
		TreeNodeTool.radd(s4, s2);
		TreeNodeTool.radd(s5, s3);
		TreeNodeTool.ladd(s6, s4);
		// ������2
		// TreeNodeTool.ladd(s8, s7);
		// TreeNodeTool.radd(s9, s7);
		// TreeNodeTool.radd(s10, s8);
		// TreeNodeTool.radd(s11, s9);
		// TreeNodeTool.ladd(s12, s10);
		// ��������ʽ2
		// ������1
		// TreeNodeTool.ladd(s2, s1);
		// TreeNodeTool.radd(s3, s1);
		// TreeNodeTool.ladd(s4, s2);
		// TreeNodeTool.radd(s5, s2);
		// TreeNodeTool.ladd(s6, s3);
		// TreeNodeTool.radd(s7, s3);
		// // ������2
		// TreeNodeTool.ladd(s9, s8);
		// TreeNodeTool.radd(s10, s8);
		// TreeNodeTool.ladd(s11, s9);
		// TreeNodeTool.radd(s12, s9);
		// TreeNodeTool.ladd(s13, s10);
		// TreeNodeTool.radd(s14, s10);

		// TreeNodeTool.preOrderRecursive(T);
		// TreeNodeTool.inOrderRecursive(s1);
		// TreeNodeTool.postOrderRecursive(s1);

		// TreeNodeTool.inOrder(T);
		// TreeNodeTool.preOrder(T);
		// TreeNodeTool.postOrder(T);

		// TreeNodeTool.levelOrder(T);

		// TreeNodeTool.inOrderThreadBiTree(s1);
		// System.out.println(TreeNodeTool.firstNode(s1).getData());
		// System.out.println(TreeNodeTool.nextNode(s1).getData());
		// TreeNodeTool.threadInOrder(s1);

		// TreeNodeTool.preOrderThreadBiTree(s1);
		// System.out.println(TreeNodeTool.nextNodePre(s4).getData());

		// TreeNodeTool.postOrderthreadBitree(s1);
		// System.out.println(TreeNodeTool.parentsNode(s1, s3).getData());
		// TreeNodeTool.showPostOrderThreadBintree(s1);

		// TreeNodeTool.preOrderThreadBiTree(s1);

		// TreeNodeTool.pathPreOrder(s1, s6);

		// ������
		// TreeNodeTool.levelOrderReverse(s1);

		// ������
		// System.out.println(TreeNodeTool.height(s1));

		// ������
		// TreeNode[] A = new TreeNode[]{s1, s2, s4, s3, s5, s7, s6};
		// TreeNode[] B = new TreeNode[]{s4, s2, s1, s5, s7, s3, s6};
		// TreeNode root = TreeNodeTool.creatLinkBiTreeByPreIn(A, B, 0, 0, 6);

		// System.out.println(TreeNodeTool.isFullBiTree(s1));

		// ������
		// System.out.println(TreeNodeTool.isCompleteBiTree(s1));

		// �ڰ���
		// System.out.println(TreeNodeTool.countDouble(s1));
		// System.out.println(TreeNodeTool.countDouble2(s1));

		// �ھ���
		// System.out.println("����");
		// TreeNodeTool.preOrder(T);
		// System.out.println("����");
		// TreeNodeTool.inOrder(T);
		// System.out.println("----------------");
		//
		// TreeNodeTool.changeChildren(s1);
		//
		// System.out.println("����");
		// TreeNodeTool.preOrder(T);
		// System.out.println("����");
		// TreeNodeTool.inOrder(T);

		// ��ʮ��
		// TreeNodeTool.whichPreOrder(s1, 4);

		// ��ʮһ��
		// System.out.println("����");
		// TreeNodeTool.preOrder(T);
		// System.out.println("����");
		// TreeNodeTool.inOrder(T);
		// System.out.println("----------------");
		//
		// TreeNodeTool.deleteValueTree(s1, "4");
		//
		// System.out.println("����");
		// TreeNodeTool.preOrder(T);
		// System.out.println("����");
		// TreeNodeTool.inOrder(T);
		//
		// System.out.println("--------------------------------");
		//
		// System.out.println("����");
		// TreeNodeTool.preOrder(T);
		// System.out.println("����");
		// TreeNodeTool.inOrder(T);
		// System.out.println("----------------");
		//
		// TreeNodeTool.deleteValueTree2(s1, "4");
		//
		// System.out.println("����");
		// TreeNodeTool.preOrder(T);
		// System.out.println("����");
		// TreeNodeTool.inOrder(T);

		// ��ʮ����
		// TreeNodeTool.showAncestor(s1, "7");

		// ��ʮ����
		// TreePointer p = new TreePointer();
		// p.setNode(s2);
		// TreePointer q = new TreePointer();
		// q.setNode(s4);
		// TreeNode pubAncestor = TreeNodeTool.ancestor(s1, p, q);
		// System.out.println(pubAncestor.getData());

		// ��ʮ����
		// System.out.println(TreeNodeTool.width(s1));

		// ��ʮ����
		// TreeNode[] pre = {s1, s2, s4, s8, s9, s5, s10, s11, s3, s6, s12, s13,
		// s7, s14, s15};
		// TreeNode[] pre = {s1, s2, s4, s5, s3, s6 ,s7};
		// TreeNode[] post = new TreeNode[pre.length];
		// TreeNodeTool.findPostByPre3(pre, 0, pre.length-1,post, 0,
		// pre.length-1);
		// for(int x = 0; x < post.length; x++) {
		// TreeNode temp = new TreeNode();
		// temp = post[x];
		// System.out.println(temp.getData());
		// }

		// ��ʮ����
		// TreePointer head = TreeNodeTool.leafSingleLinked(s1);
		// TreePointer head = TreeNodeTool.leafSingleLinked2(s1);
		// TreePointer operator = new TreePointer();
		// operator.setNode(head.getNode());
		// while(operator.getNode() != null) {
		// System.out.println(operator.getNode().getData());
		// operator.setNode(operator.getNode().getRchild());
		// }

		// ��ʮ����
		// System.out.println(TreeNodeTool.similar(s2, s9));

		// ��ʮ����
		// TreeNodeTool.inOrderThreadBiTree(s1);
		// TreeNode pre = TreeNodeTool.predecessorOfPostByIn(s7);
		// if(pre != null) {
		// System.out.println(pre.getData());
		// } else {
		// System.out.println("null");
		// }

		// ��ʮ����
		// int weight = TreeNodeTool.wpl(s1);
		// System.out.println(weight);
		// System.out.println("--------------");
		// int weight2 = TreeNodeTool.wplByPreRecursive(s1, 1);
		// System.out.println(weight2);

		// �ڶ�ʮ��
		TreeNode s16 = new TreeNode("*");
		TreeNode s17 = new TreeNode("+");
		TreeNode s18 = new TreeNode("*");
		TreeNode s19 = new TreeNode("a");
		TreeNode s20 = new TreeNode("b");
		TreeNode s21 = new TreeNode("c");
		TreeNode s22 = new TreeNode("-");
		TreeNode s23 = new TreeNode("d");
		
		TreeNodeTool.ladd(s17, s16);
		TreeNodeTool.radd(s18, s16);
		TreeNodeTool.ladd(s19, s17);
		TreeNodeTool.radd(s20, s17);
		TreeNodeTool.ladd(s21, s18);
		TreeNodeTool.radd(s22, s18);
		TreeNodeTool.radd(s23, s22);
		
		TreeNodeTool.expressionTreeToNifix(s16);
		TreeNodeTool.expressionTreeToNifex2(s16);
	}
}
