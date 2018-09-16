package chapter3_3_6;

import chapter3_1_4.SequenceStack;

//��һ��
/*
 * ˼��
 * 	ɨ���������ʽ
 * 		��ɨ�赽����ʱ
 * 			����������������
 * 				��ջ
 * 			����������������
 * 				����������ջ������ƥ�䣬������Ų���ջ����ջ�����ų�ջ
 * 					���������ʽɨ����ɣ���ջ��Ϊ��\0����������ƥ��
 * 				����������ջ�����Ų�ƥ�䣬�����Ų�ƥ��
 */

//����switch�Ľ�
public class Bracket {
	public static void main(String[] args) {
		String expression = "{[1+2*(4-1)]/3+5*7\0";
		char[] chr = expression.toCharArray();
		
		System.out.println(isBracket(chr));
	}
	
	public static boolean isBracket(char[] chr) {
		SequenceStack<Character> ss = new SequenceStack<>();
		ss.InitStack();
		
		int count = 0;
		while(chr[count] != '\0') {
			if(chr[count] == '(' || chr[count] == '[' || chr[count] == '{') {
				ss.Push(chr[count++]);
			} else if(chr[count] == ')') {
				if((char)ss.GetTop() == '(') {
					ss.Pop();
					count++;
				} else {
					return false;
				}
			} else if(chr[count] == ']') {
				if((char)ss.GetTop() == '[') {
					ss.Pop();
					count++;
				} else {
					return false;
				}
			} else if(chr[count] == '}') {
				if((char)ss.GetTop() == '{') {
					ss.Pop();
					count++;
				} else {
					return false;
				}
			} else {
				count++;
			}
		}
		
		if(!ss.StackEmpty()) {
			return false;
		}
		
		return true;
	}
}
