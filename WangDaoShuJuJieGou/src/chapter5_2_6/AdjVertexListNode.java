package chapter5_2_6;
//邻接表的顶点表结点
public class AdjVertexListNode {
	private String data = null;
	private AdjSideListNode firstarc = null;
	
	public AdjVertexListNode() {
	}
	
	public AdjVertexListNode(String data, AdjSideListNode firstarc) {
		super();
		this.data = data;
		this.firstarc = firstarc;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public AdjSideListNode getFirstarc() {
		return firstarc;
	}
	public void setFirstarc(AdjSideListNode firstarc) {
		this.firstarc = firstarc;
	}
	public void set(String data, AdjSideListNode firstarc) {
		setData(data);
		setFirstarc(firstarc);
	}
}
