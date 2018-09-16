package chapter3_3_6;

import chapter3_1_4.SequenceStack;
//第二题
/*
 * 思路
 * 	由三个栈表示左侧铁轨、右侧铁轨和调度站
 * 	右侧弹栈
 * 		若为硬卧，则入调度站
 * 		若为软卧，则进左侧栈
 */
public class TrainSchedule {
	public static void main(String[] args) {
		SequenceStack<Character> right = new SequenceStack<>();
		right.InitStack();
		
		right.Push('S');
		right.Push('S');
		right.Push('H');
		right.Push('S');
		right.Push('H');
		right.Push('H');
		right.Push('H');
		right.Push('H');
		right.Push('S');
		right.Push('S');
		right.Push('H');
		right.Push('H');
		right.Push('H');
		right.Push('H');
		
		SequenceStack<Character> left = trainSchedule(right);
		
		while(!left.StackEmpty()) {
			System.out.println(left.Pop());
		}
	}
	
	public static SequenceStack<Character> trainSchedule(SequenceStack<Character> right) {
		SequenceStack<Character> schedule = new SequenceStack<>();
		schedule.InitStack();
		SequenceStack<Character> left = new SequenceStack<>();
		left.InitStack();
		
		while(!right.StackEmpty()) {
			switch ((Character)right.GetTop()) {
			case 'H':
				schedule.Push((Character)right.Pop());
				break;
			case 'S':
				left.Push((Character)right.Pop());
				break;
			}
		}
		
		while(!schedule.StackEmpty()) {
			left.Push((Character)schedule.Pop());
		}
		
		return left;
	}
}
