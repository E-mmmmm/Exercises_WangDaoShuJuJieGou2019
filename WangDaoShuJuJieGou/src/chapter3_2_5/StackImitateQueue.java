package chapter3_2_5;

import chapter3_1_4.SequenceStack;

//��3��
public class StackImitateQueue {
	public static void main(String[] args) {
		//ss1Ϊ��ջ
		//ss2Ϊ��ջ
		SequenceStack<Integer> ss1 = new SequenceStack<>();
		SequenceStack<Integer> ss2 = new SequenceStack<>();
		
		
	}
//	public static <T> void enQueue(SequenceStack ss1, T element) {
//		//if(!ss1.stackOverflow) �ж�ջ�Ƿ�������Ŀ��������if���ɡ����ҵ�push()�Դ����ݹ��ܣ������ж�
//		ss1.Push(element);
//	}
//	
//	public static <T> T deQueue(SequenceStack ss1, SequenceStack ss2) {
//		while(!ss1.StackEmpty()) {
//			ss2.Push(ss1.Pop());
//		}
//		
//		T temp = (T)ss2.Pop();
//		
//		while(!ss2.StackEmpty()) {
//			ss1.Push(ss2.Pop());
//		}
//		
//		return temp;
//	}
//	
//	public static boolean queueEmpty(SequenceStack ss1) {
//		return ss1.StackEmpty();
//	}
	/* ���ϵķ������ҵ���
	 * ����������������ջ�Ŀռ���д洢���������������ջ
	 */
	public static <T> void enQueue(SequenceStack ss1, SequenceStack ss2, T element) {
		//if(!ss1.stackOverflow) �ж�ջ�Ƿ�������Ŀ��������if���ɡ����ҵ�push()�Դ����ݹ��ܣ������ж�
		if(!ss1.stackOverflow()) {
			ss1.Push(element);
		} else if (ss1.stackOverflow() && ss2.StackEmpty()) {
			while(!ss1.StackEmpty()) {
				ss2.Push(ss1.Pop());
			}
			ss1.Push(element);
		} else if(ss1.stackOverflow() && !ss2.StackEmpty()) {
			System.out.println("����������");
		}
	}
	
	public static <T> T deQueue(SequenceStack ss1, SequenceStack ss2) {
		if(!ss2.StackEmpty()) {
			return (T)ss2.Pop();
		} else if(!ss1.StackEmpty() && ss2.StackEmpty()) {
			while(!ss1.StackEmpty()) {
				ss2.Push(ss1.Pop());
			}
			
			return (T)ss2.Pop();
		} else if(ss1.StackEmpty() && ss2.StackEmpty()) {
			System.out.println("����Ϊ�գ�");
		}
		
		return null;
	}
	
	public static boolean queueEmpty(SequenceStack ss1, SequenceStack ss2) {
		return ss1.StackEmpty() && ss2.StackEmpty();
	}
}
