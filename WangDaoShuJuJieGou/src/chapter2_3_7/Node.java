package chapter2_3_7;

public class Node<T> {
	/*
	 * ������ڵ����ɣ�
	 * 	A.����
	 * 	B.ָ��
	 * 		ָ��ֱ�Ӻ��
	 * 
	 */
	//����
	private T data;
	
	//���ָ��
	private Node<T> next;
	
	//ǰ��ָ��
	private Node<T> prior;
	
	//Ƶ��
	private int freq = 0;
	
	//���췽��
	public Node() {
		super();
	}

	public Node(T data) {
		super();
		this.data = data;
	}
	
	//��ȡ�븳ֵ
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
