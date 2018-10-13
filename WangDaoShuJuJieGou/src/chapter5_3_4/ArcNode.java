package chapter5_3_4;

public class ArcNode {
	private int adjvex = 0;
	private ArcNode next = null;
	/**
	 * 记录是否被访问
	 */
	private boolean mark = false;
	public ArcNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getAdjvex() {
		return adjvex;
	}
	public void setAdjvex(int adjvex) {
		this.adjvex = adjvex;
	}
	public ArcNode getNext() {
		return next;
	}
	public void setNext(ArcNode next) {
		this.next = next;
	}
	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public void set(int adjvex, ArcNode next) {
		this.adjvex = adjvex;
		this.next = next;
	}
}
