package chapter3_2_5;

import chapter3_1_4.SequenceStack;

//第3题
public class StackImitateQueue {
	public static void main(String[] args) {
		//ss1为主栈
		//ss2为辅栈
		SequenceStack<Integer> ss1 = new SequenceStack<>();
		SequenceStack<Integer> ss2 = new SequenceStack<>();
		
		
	}
//	public static <T> void enQueue(SequenceStack ss1, T element) {
//		//if(!ss1.stackOverflow) 判断栈是否满由题目给出，加if即可。而我的push()自带扩容功能，不用判断
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
	/* 书上的方法比我的妙
	 * 妙在它能利用两个栈的空间进行存储，充分利用了两个栈
	 */
	public static <T> void enQueue(SequenceStack ss1, SequenceStack ss2, T element) {
		//if(!ss1.stackOverflow) 判断栈是否满由题目给出，加if即可。而我的push()自带扩容功能，不用判断
		if(!ss1.stackOverflow()) {
			ss1.Push(element);
		} else if (ss1.stackOverflow() && ss2.StackEmpty()) {
			while(!ss1.StackEmpty()) {
				ss2.Push(ss1.Pop());
			}
			ss1.Push(element);
		} else if(ss1.stackOverflow() && !ss2.StackEmpty()) {
			System.out.println("队列已满！");
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
			System.out.println("队列为空！");
		}
		
		return null;
	}
	
	public static boolean queueEmpty(SequenceStack ss1, SequenceStack ss2) {
		return ss1.StackEmpty() && ss2.StackEmpty();
	}
}
