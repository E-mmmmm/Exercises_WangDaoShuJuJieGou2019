package chapter3_1_4;

import java.util.Arrays;

//������
public class ShareStack<T> {
	//ջ������
	int capacity = 10;
	//ջ��
	int top1;
	int top2;
	//˳��ջ�Ĵ洢����
	Object[] obj;
	
	//���췽��
	public ShareStack() {}
	public ShareStack(int capacity) {
		super();
		this.capacity = capacity;
	}
	
	/**
	 * ��ʼ��һ����ջ
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
