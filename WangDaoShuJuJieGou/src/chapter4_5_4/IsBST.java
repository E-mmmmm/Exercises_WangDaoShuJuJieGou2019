package chapter4_5_4;

import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//������
public class IsBST {
	public static void main(String[] args) {
		//true
//		TreeNode s1 = new TreeNode("1");
//		TreeNode s2 = new TreeNode("2");
//		TreeNode s3 = new TreeNode("3");
//		TreeNode s4 = new TreeNode("4");
//		TreeNode s5 = new TreeNode("6");
//		TreeNode s6 = new TreeNode("8");
//		
//		TreeNodeTool.ladd(s2, s5);
//		TreeNodeTool.radd(s6, s5);
//		TreeNodeTool.ladd(s1, s2);
//		TreeNodeTool.radd(s4, s2);
//		TreeNodeTool.ladd(s3, s4);

		//flase
		TreeNode s1 = new TreeNode("1");
		TreeNode s2 = new TreeNode("2");
		TreeNode s3 = new TreeNode("3");
		TreeNode s4 = new TreeNode("4");
		TreeNode s5 = new TreeNode("5");
		TreeNode s6 = new TreeNode("6");
		TreeNode s7 = new TreeNode("7");
		
		TreeNodeTool.ladd(s2, s1);
		TreeNodeTool.radd(s3, s1);
		TreeNodeTool.ladd(s4, s2);
		TreeNodeTool.radd(s5, s2);
		TreeNodeTool.ladd(s6, s3);
		TreeNodeTool.radd(s7, s3);
		System.out.println(isBST(s1));
	}
	/*
	 * ˼·
	 * 	ʹ�õݹ飬�жϸ������亢�ӽ���Ƿ����������������Ҫ��
	 * 	�ݹ�߽�
	 * 		���Ϊ��
	 * 	�ݹ���
	 * 		�жϵ�ǰ����ֵ�������ӵ�ֵ�Ĺ�ϵ
	 * 			���ڣ�������Ϊ��ǰ���
	 * 			С�ڣ�����false
	 * 		�жϵ�ǰ����ֵ�����Һ��ӵ�ֵ�Ĺ�ϵ
	 * 			���ڣ�����false
	 * 			С�ڣ��Һ�����Ϊ��ǰ���
	 */
	static boolean result = true;
	public static boolean isBST(TreeNode root) {
		if(root != null) {
			//�жϵ�ǰ����ֵ�������ӵ�ֵ�Ĺ�ϵ
			if(root.getLchild() != null) {
				if(Integer.parseInt(root.getData()) > 
					Integer.parseInt(root.getLchild().getData())) {
					isBST(root.getLchild());
				} else {
					result = false;
				}
			}
			
			//�жϵ�ǰ����ֵ�����Һ��ӵ�ֵ�Ĺ�ϵ
			if(root.getRchild() != null) {
				if(Integer.parseInt(root.getData()) > 
					Integer.parseInt(root.getRchild().getData())) {
					result = false;
				} else {
					isBST(root.getRchild());
				}	
			}	
		}
		
		return result;
	}
}
