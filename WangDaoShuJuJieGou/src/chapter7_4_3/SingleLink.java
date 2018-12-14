package chapter7_4_3;

public class SingleLink {
	//结点的值
	private int value;
	//后继指针
	private SingleLink next;

	public SingleLink(int value) {
		super();
		this.value = value;
	}

	public SingleLink() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SingleLink getNext() {
		return next;
	}

	public void setNext(SingleLink next) {
		this.next = next;
	}
	
	public void rearAdd(SingleLink node) {
		this.next = node;
	}
}
