package chapter2_3_7;

public class Node<T> {
	/*
	 * 单链表节点的组成：
	 * 	A.数据
	 * 	B.指针
	 * 		指向直接后继
	 * 
	 */
	//数据
	private T data;
	
	//后继指针
	private Node<T> next;
	
	//前趋指针
	private Node<T> prior;
	
	//频度
	private int freq = 0;
	
	//构造方法
	public Node() {
		super();
	}

	public Node(T data) {
		super();
		this.data = data;
	}
	
	//获取与赋值
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrior() {
		return prior;
	}

	public void setPrior(Node<T> prior) {
		this.prior = prior;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}
