package chapter3_1_4;

import java.util.Arrays;

public class SequenceStack<T> {
	//栈的容量
	int capacity = 10;
	//栈顶
	int top;
	//顺序栈的存储数组
	Object[] obj;
	
	//构造方法
	public SequenceStack() {}
	public SequenceStack(int capacity) {
		super();
		this.capacity = capacity;
	}

	/**
	 * 初始化一个空栈
	 */
	public void InitStack() {
		obj = new Object[capacity];
		top = -1;
	}
	
	/**
	 * 判断一个栈是否为空
	 * @return 
	 * 		栈为空，返回true
	 */
	public boolean StackEmpty() {
		if(top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 进栈，若栈未满，将element加入使之成为新栈顶
	 * @param element
	 * 				添加的元素
	 */
	public void Push(T element) {
//		if(top < obj.length - 1) {
//			obj[++top] = element; 
//		} else {
//			System.out.println("栈顶溢出");
//		}
		
		if(top == obj.length - 1) {
			ensureCapacity(capacity + 10);
		}
		
		obj[++top] = element;
	}
	
	/**
	 * 出栈，若栈非空，弹出栈顶元素
	 * @return
	 * 		弹出的栈顶元素
	 */
	public <T> T Pop() {
		if(StackEmpty() == false) {
			return (T)obj[top--];
		} else {
			return null;
		}
	}
	
	/**
	 * 若栈非空，读栈顶元素
	 * @return
	 * 		栈顶元素
	 */
	public <T> T GetTop() {
		if(StackEmpty() == false) {
			return (T)obj[top];
		} else {
			return null;
		}
	}
	
	/**
	 * 销毁栈
	 * @throws Throwable 
	 * 		栈的空间无法被正常回收
	 */
	public void ClearStack() throws Throwable {
		top = -1;
	}
	
	/**
	 * 
	 * @return
	 * 		栈顶指针
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
