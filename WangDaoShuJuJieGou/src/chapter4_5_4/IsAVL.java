package chapter4_5_4;

import chapter2_2_3.SequenceList;
import chapter3_1_4.SequenceStack;
import chapter3_2_5.CyclicQueue;
import chapter3_2_5.CyclicQueueTest;
import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//�ڰ���
public class IsAVL {
	public static void main(String[] args) {
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
		
		System.out.println(isAVL(s1));
	}
	
	/*
	 * ˼·
	 * 	���ú�������ķǵݹ��㷨
	 * 	ÿ��������nullʱ����ջ�еĽ�������¼������A��
	 * 	��󣬶���A��Ԫ�����γ���
	 *  ����һ��Ԫ�ؼ�Ϊa����һ����ͬ��a��Ԫ�ؼ�Ϊb
	 *  ��ʣ�µ�Ԫ�ز���a����b����˶�����Ϊƽ�������
	 *  ������ƽ�������
	 */
	public static boolean isAVL(TreeNode root) {
		//�����ж����
		CyclicQueue<Integer> cq = new CyclicQueue<>(1000);
		cq.initQueue();
		int a = 0;
		int b = 0;
		
		//���ڷǵݹ�ĺ������
		SequenceStack<TreeNode> ss = new SequenceStack<>();
		ss.InitStack();
		ss.Push(root);
		TreeNode temp = new TreeNode();

		while(!ss.StackEmpty()) {
			temp = ss.GetTop();
			if(temp != null) {
				if(temp.visit == 0) {
					ss.Push(temp.getLchild());
					temp.visit++;
				} else if(temp.visit == 1) {
					ss.Push(temp.getRchild());
					temp.visit++;
				} else if(temp.visit == 2) {
					ss.Pop();
				}
			} else {
				cq.enQueue(ss.getTop());
				ss.Pop();
				temp = ss.GetTop();
				if(temp.visit == 1) {
					ss.Push(temp.getRchild());
					temp.visit++;
				} else if(temp.visit == 2) {
					ss.Pop();
				}
			}
		}
		
//		while(!cq.queueEmpty()) {
//			System.out.println(cq.deQueue());
//		}
		//�ж�ÿ��Ҷ�ڵ������Ƿ�����1
		int flag = 0;
		for(int x = 0; x < cq.getRear(); x++) {
			if(x == 0) {
				//����һ��Ԫ�ؼ�Ϊa
				a = cq.deQueue();
			} else if((int)cq.getHead() != a && flag == 0) {
				//��һ����ͬ��a��Ԫ�ؼ�Ϊb
				b = cq.deQueue();
				flag = 1;
			} else if((int)cq.getHead() == a || (int)cq.getHead() == b) {
				//��ʣ�µ�Ԫ�ز���a����b����˶�����Ϊƽ�������,������ƽ�������
				cq.deQueue();
			} else {
				return false;
			}
		}
		
		return true;
	}
}
