package chapter3_2_5;

import chapter3_1_4.SequenceStack;

//第一题
public class CyclicQueue<T> {
	//顺序存储
	private Object[] obj;
	//容量
	private int capacity = 10;
	//队首指针,指向队首元素
	private int front;
	//队尾指针，指向队尾元素的下一个元素
	private int rear;
	//辅助判断空满的记号
	/*
	 * 在执行入队操作时，使其变为1
	 * 在执行出队操作时，使其变为0
	 * 这样，当front == rear时
	 * 就能通过tag判断是由哪一个操作导致的
	 * 因为，这个结果必然是上一次出队或入队操作导致
	 */
	private int tag;
	
	//构造方法
	public CyclicQueue() {	}
	public CyclicQueue(int capacity) {
		super();
		this.capacity = capacity;
	}

	/**
	 * 初始化队列
	 */
	public void initQueue() {
		obj = new Object[capacity];
		front = 0;
		rear = 0;
		tag = 0;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 * 		若为空，返回true
	 */
	public boolean queueEmpty() {
		if(front == rear && tag == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 入队，若队列未满，将element加入，使之成为新的队尾
	 * @param element
	 * 				插入的元素
	 */
	public <T> void enQueue(T element) {
		if(!(front == rear && tag == 1)) {
			obj[rear] = element;
			rear = (rear + 1) % capacity;
			tag = 1;
		} else {
			System.out.println("队列已满！");
		}
	}
	
	/**
	 * 出队，若队列非空，返回对头元素
	 * @return
	 */
	public <T> T deQueue() {
		if(front == rear && tag == 0) {
			System.out.println("队列为空!");
			return null;
		} else {
			T temp = (T)obj[front];
			
			front = (front + 1) % capacity;
			tag = 0;
			
			return temp;
		}
	}
	
	public <T> T getHead() {
		if(front == rear && tag == 0) {
			System.out.println("队列为空!");
			return null;
		} else {
			return (T)obj[front];
		}
	}
	
	public <T> void reverse() {
		SequenceStack<T> ss = new SequenceStack<>(capacity);
		ss.InitStack();
		
		while(!(front == rear && tag == 0)) {
			ss.Push((T)deQueue());
		}
		
		while(ss.getTop() > -1) {
			enQueue(ss.Pop());
		}
	}
	
	public int length() {
		return rear - front;
	}
	
	/**
	 * 返回顺序表的最后一个元素的索引
	 * @return
	 * 		顺序表的最后一个元素的索引
	 */
	public int getRear() {
		return rear;
	}
}
