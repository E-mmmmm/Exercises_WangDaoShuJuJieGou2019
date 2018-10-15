package chapter3_1_4;

import java.util.Arrays;

public class SequenceStack<T> {
	//ջ������
	int capacity = 10;
	//ջ��
	int top;
	//˳��ջ�Ĵ洢����
	Object[] obj;
	
	//���췽��
	public SequenceStack() {}
	public SequenceStack(int capacity) {
		super();
		this.capacity = capacity;
	}

	/**
	 * ��ʼ��һ����ջ
	 */
	public void InitStack() {
		obj = new Object[capacity];
		top = -1;
	}
	
	/**
	 * �ж�һ��ջ�Ƿ�Ϊ��
	 * @return 
	 * 		ջΪ�գ�����true
	 */
	public boolean StackEmpty() {
		if(top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ��ջ����ջδ������element����ʹ֮��Ϊ��ջ��
	 * @param element
	 * 				��ӵ�Ԫ��
	 */
	public void Push(T element) {
//		if(top < obj.length - 1) {
//			obj[++top] = element; 
//		} else {
//			System.out.println("ջ�����");
//		}
		
		if(top == obj.length - 1) {
			ensureCapacity(capacity + 10);
		}
		
		obj[++top] = element;
	}
	
	/**
	 * ��ջ����ջ�ǿգ�����ջ��Ԫ��
	 * @return
	 * 		������ջ��Ԫ��
	 */
	public <T> T Pop() {
		if(StackEmpty() == false) {
			return (T)obj[top--];
		} else {
			return null;
		}
	}
	
	/**
	 * ��ջ�ǿգ���ջ��Ԫ��
	 * @return
	 * 		ջ��Ԫ��
	 */
	public <T> T GetTop() {
		if(StackEmpty() == false) {
			return (T)obj[top];
		} else {
			return null;
		}
	}
	
	/**
	 * ����ջ
	 * @throws Throwable 
	 * 		ջ�Ŀռ��޷�����������
	 */
	public void ClearStack() throws Throwable {
		top = -1;
	}
	
	/**
	 * 
	 * @return
	 * 		ջ��ָ��
	 */
	public int getTop() {
		return top;
	}
	
	public <T> void ensureCapacity(int minCapacity) {
		T[] temp = (T[])Arrays.copyOf(obj, minCapacity);
		
		obj = temp;
	}
	
	public boolean stackOverflow() {
		if(top == capacity - 1) {
			return true;
		}
		
		return false;
	}
}
