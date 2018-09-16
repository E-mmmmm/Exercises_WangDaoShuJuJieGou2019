package chapter4_5_4;

import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//������
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
	 * ˼·
	 * 	�жϵ�ǰ�����ָ�����Ĵ�С��ϵ
	 * 		���ڣ�����ǰ����������Ϊ��ǰ��㣬deep+1
	 * 		С�ڣ�����ǰ�����Һ�����Ϊ��ǰ��㣬deep+1
	 * 		���ڣ�����deep
	 */
	/*
	 * ע�⣺�����Ҳ�û��if(root!=null)
	 * 	         ��Ϊ�����ϣ��ᵼ�²��Ҳ����ڵĽ��ʱ�����ش���Ĳ���
	 * 	        �����ӣ�����׳���ָ���쳣����try...catch...���쳣������ʾ�������ҵĽ�㲻���ڡ�����
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
