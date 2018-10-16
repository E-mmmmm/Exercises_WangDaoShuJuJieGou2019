package chapter5_3_4;

public class VNode {
	private String data = null;
	private ArcNode first = null;
	
	public VNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VNode(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ArcNode getFirst() {
		return first;
	}
	public void setFirst(ArcNode first) {
		this.first = first;
	}
	public void setFirst(String data, ArcNode first) {
		this.data = data;
		this.first = first;
	}
	
}
