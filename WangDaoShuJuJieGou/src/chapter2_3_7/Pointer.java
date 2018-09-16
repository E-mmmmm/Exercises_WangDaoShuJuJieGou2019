package chapter2_3_7;
/**
 * 用于创建并修改指针
 * @author 一汪
 *
 */
public class Pointer<T>{
	private Node<T> node;

	public Pointer() {
		super();
	}

	public Node<T> getNode() {
		return node;
	}

	public void setNode(Node<T> node) {
		this.node = node;
	}
}