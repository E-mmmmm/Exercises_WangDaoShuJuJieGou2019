package chapter2_3_7;
/**
 * ���ڴ������޸�ָ��
 * @author һ��
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