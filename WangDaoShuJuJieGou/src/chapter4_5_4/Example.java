package chapter4_5_4;

import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//�����ܽ��е�����
public class Example {
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
		
		TreeNodeTool.ladd(s2, s1);
		TreeNodeTool.radd(s3, s1);
		TreeNodeTool.radd(s4, s2);
		TreeNodeTool.radd(s5, s3);
		TreeNodeTool.ladd(s6, s4);
		
//		TreeNodeTool.ladd(s2, s1);
//		TreeNodeTool.radd(s3, s1);
//		TreeNodeTool.ladd(s4, s2);
//		TreeNodeTool.radd(s5, s2);
//		TreeNodeTool.ladd(s6, s3);
//		TreeNodeTool.radd(s7, s3);
		
		//��1��
//		System.out.println(du1(s1));
		
		//��2��
//		System.out.println(du2(s1));
		
		//��3��
//		System.out.println(du0(s1));
		
		//��4��
		System.out.println(deep(s1));
	}
	
	//��1��
	static int count = 0;
	public static int du1(TreeNode root) {
		if(root != null) {
			if((root.getLchild() == null && root.getRchild() != null) || 
					(root.getLchild()!= null && root.getRchild() == null)) {
				count++;
			}
			
			du1(root.getLchild());
			du1(root.getRchild());
		}
		
		return count;
	}
	
	//��2��
	public static int du2(TreeNode root) {
		if(root != null) {
			if(root.getLchild() != null && root.getRchild() != null) {
				count++;
			}
			
			du2(root.getLchild());
			du2(root.getRchild());
		}
		
		return count;
	}
	
	//��3��
	public static int du0(TreeNode root) {
		if(root != null) {
			if(root.getLchild() == null && root.getRchild() == null) {
				count++;
			}
			
			du0(root.getLchild());
			du0(root.getRchild());
		}
		
		return count;
	}
	
	//��4��
	//��¼ÿ��Ҷ������ȣ�����������Ǹ����������ĸ߶�
	static int max = 0;
	static int deep = 0;
	public static int deep(TreeNode root) {
		if(root != null) {
			deep++;
			if(root.getLchild() == null && root.getRchild() == null) {
				if(deep > max) {
					max = deep;
				}
				deep = 0;
			}
			
			deep(root.getLchild());
			deep(root.getRchild());
		}
		
		return max;
	}
	
	//��5��
	/*
	 * ˼·
	 * 	��deep��¼�������
	 * 	��һ�������¼���ΪX�Ľ��ĸ���
	 * 	���ļ�Ϊ���
	 * 
	 * 	���⣺���Ѱ�����ģ��������飿����ڵݹ��㷨�б������飿
	 */
}
