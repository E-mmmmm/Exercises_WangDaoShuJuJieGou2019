package chapter3_1_4;

import java.util.Arrays;

//第五题
public class ShareStack<T> {
	//栈的容量
	int capacity = 10;
	//栈顶
	int top1;
	int top2;
	//顺序栈的存储数组
	Object[] obj;
	
	//构造方法
	public ShareStack() {}
	public ShareStack(int capacity) {
		super();
		this.capacity = capacity;
	}
	
	/**
	 * 初始化一个空栈
	 */
	public void InitStack() {
		obj = new Object[capacity];
		top1 = -1;
		top2 = capacity;
	}
	
	public <T> void push1(T element) {
		if(top2 - top1 > 1) {
			obj[++top1] = element;
		}
	}
	
	public <T> void push2(T element) {
		if(top2 - top1 > 1) {
			obj[--top2] = element;
		}
	}
	
	public <T> T Pop1() {
		if(top1 > -1) {
			return (T)obj[top1--];
		} else {
			return null;
		}
	}
	
	public <T> T Pop2() {
		if(top2 < capacity) {
			return (T)obj[top2++];
		} else {
			return null;
		}
	}
}
