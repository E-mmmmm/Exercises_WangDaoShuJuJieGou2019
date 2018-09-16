package chapter3_3_6;

import chapter3_1_4.SequenceStack;
//�ڶ���
/*
 * ˼·
 * 	������ջ��ʾ������졢�Ҳ�����͵���վ
 * 	�Ҳ൯ջ
 * 		��ΪӲ�ԣ��������վ
 * 		��Ϊ���ԣ�������ջ
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
