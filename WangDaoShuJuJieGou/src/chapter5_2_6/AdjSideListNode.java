package chapter5_2_6;
//邻接表的边表结点
public class AdjSideListNode {
	private AdjVertexListNode adjvex = null;
	private AdjSideListNode nextarc = null;
	private String mark = null;
	
	public AdjSideListNode() {
		// TODO Auto-generated constructor stub
	}
	
	public AdjSideListNode(AdjVertexListNode adjvex, AdjSideListNode nextarc) {
		super();
		this.adjvex = adjvex;
		this.nextarc = nextarc;
	}
	
	public AdjVertexListNode getAdjvex() {
		return adjvex;
	}
	public void setAdjvex(AdjVertexListNode adjvex) {
		this.adjvex = adjvex;
	}
	public AdjSideListNode getNextarc() {
		return nextarc;
	}
	public void setNextarc(AdjSideListNode nextarc) {
		this.nextarc = nextarc;
	}
	
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public void set(AdjVertexListNode adjvex, AdjSideListNode nextarc) {
		setAdjvex(adjvex);
		setNextarc(nextarc);
	}
}
