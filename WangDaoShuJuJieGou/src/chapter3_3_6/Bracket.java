package chapter3_3_6;

import chapter3_1_4.SequenceStack;

//第一题
/*
 * 思想
 * 	扫描算数表达式
 * 		当扫描到括号时
 * 			若此括号是左括号
 * 				进栈
 * 			若此括号是右括号
 * 				若此括号与栈顶括号匹配，则此括号不进栈，且栈顶括号出栈
 * 					若算数表达式扫描完成，且栈顶为“\0”，则括号匹配
 * 				若此括号与栈顶括号不匹配，则括号不匹配
 */

//可用switch改进
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
