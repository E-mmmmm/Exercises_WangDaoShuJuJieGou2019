package chapter3_2_5;

import chapter3_1_4.SequenceStack;

//��һ��
public class CyclicQueue<T> {
	//˳��洢
	private Object[] obj;
	//����
	private int capacity = 10;
	//����ָ��,ָ�����Ԫ��
	private int front;
	//��βָ�룬ָ���βԪ�ص���һ��Ԫ��
	private int rear;
	//�����жϿ����ļǺ�
	/*
	 * ��ִ����Ӳ���ʱ��ʹ���Ϊ1
	 * ��ִ�г��Ӳ���ʱ��ʹ���Ϊ0
	 * ��������front == rearʱ
	 * ����ͨ��tag�ж�������һ���������µ�
	 * ��Ϊ����������Ȼ����һ�γ��ӻ���Ӳ�������
	 */
	private int tag;
	
	//���췽��
	public CyclicQueue() {	}
	public CyclicQueue(int capacity) {
		super();
		this.capacity = capacity;
	}

	/**
	 * ��ʼ������
	 */
	public void initQueue() {
		obj = new Object[capacity];
		front = 0;
		rear = 0;
		tag = 0;
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 * 		��Ϊ�գ�����true
	 */
	public boolean queueEmpty() {
		if(front == rear && tag == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ��ӣ�������δ������element���룬ʹ֮��Ϊ�µĶ�β
	 * @param element
	 * 				�����Ԫ��
	 */
	public <T> void enQueue(T element) {
		if(!(front == rear && tag == 1)) {
			obj[rear] = element;
			rear = (rear + 1) % capacity;
			tag = 1;
		} else {
			System.out.println("����������");
		}
	}
	
	/**
	 * ���ӣ������зǿգ����ض�ͷԪ��
	 * @return
	 */
	public <T> T deQueue() {
		if(front == rear && tag == 0) {
			System.out.println("����Ϊ��!");
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
			System.out.println("����Ϊ��!");
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
	 * ����˳�������һ��Ԫ�ص�����
	 * @return
	 * 		˳�������һ��Ԫ�ص�����
	 */
	public int getRear() {
		return rear;
	}
}
