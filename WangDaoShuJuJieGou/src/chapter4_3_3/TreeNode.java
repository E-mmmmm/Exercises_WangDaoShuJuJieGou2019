package chapter4_3_3;
//树的链式存储的结点
public class TreeNode {
	private String data = null;
	private TreeNode lchild = null;
	private TreeNode rchild = null;
	public int visit = 0;
	public int ltag = 0;
	public int rtag = 0;
	
	public TreeNode() {
	}

	public TreeNode(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TreeNode getLchild() {
		return lchild;
	}

	public void setLchild(TreeNode lchild) {
		this.lchild = lchild;
	}

	public TreeNode getRchild() {
		return rchild;
	}

	public void setRchild(TreeNode rchild) {
		this.rchild = rchild;
	}

	public int getVisit() {
		return visit;
	}

	public void setVisit(int visit) {
		this.visit = visit;
	}
	
}
