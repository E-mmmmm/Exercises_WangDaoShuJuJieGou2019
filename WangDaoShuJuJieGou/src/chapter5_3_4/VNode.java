package chapter5_3_4;

public class VNode {
	private String data = null;
	private ArcNode first = null;
	/**
	 * 记录该顶点是否被访问
	 */
	private boolean mark = false;
	
	public VNode() {
		super();
		// TODO Auto-generated constructor stub
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
	public boolean isMark() {
		return mark;
	}
	public void setMark(boolean mark) {
		this.mark = mark;
	}
	public void setFirst(String data, ArcNode first) {
		this.data = data;
		this.first = first;
	}
	
}
