package chapter4_5_4;

import chapter4_3_3.TreeNode;

public class BSTNode {
	private String data = null;
	private BSTNode lchild = null;
	private BSTNode rchild = null;
	//以该结点为根的子树上的结点个数
	private int count = 0;
	public BSTNode() {
	}

	public BSTNode(String data, int count) {
		super();
		this.data = data;
		this.count = count;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BSTNode getLchild() {
		return lchild;
	}

	public void setLchild(BSTNode lchild) {
		this.lchild = lchild;
	}

	public BSTNode getRchild() {
		return rchild;
	}

	public void setRchild(BSTNode rchild) {
		this.rchild = rchild;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
