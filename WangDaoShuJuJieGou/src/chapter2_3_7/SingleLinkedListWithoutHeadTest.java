package chapter2_3_7;

/**
 * 无头结点的单链表的测试类
 * @author 一汪
 *
 */
public class SingleLinkedListWithoutHeadTest {
	public static void main(String[] args) {
		//创建节点
		Node<String> s1 = new Node<>("A");
		Node<String> s2 = new Node<>("B");
		Node<String> s3 = new Node<>("C");
		Node<String> s4 = new Node<>("D");
		Node<String> s5 = new Node<>("E");
		
		//创建头指针
		Pointer<String> frontPointer = new Pointer<>();
		
		//将节点插入一个不带头节点单链表L
//		SingleLinkedListTool.frontAdd(s1, frontPointer);
//		SingleLinkedListTool.frontAdd(s2, frontPointer);
//		SingleLinkedListTool.frontAdd(s3, frontPointer);
//		SingleLinkedListTool.frontAdd(s4, frontPointer);
//		SingleLinkedListTool.frontAdd(s5, frontPointer);
		
		//创建尾指针
		Pointer<String> rearPointer = new Pointer<>();
		
		SingleLinkedListTool.rearAdd(s1, rearPointer);
		SingleLinkedListTool.rearAdd(s2, rearPointer);
		SingleLinkedListTool.rearAdd(s3, rearPointer);
		SingleLinkedListTool.rearAdd(s4, rearPointer);
		SingleLinkedListTool.rearAdd(s5, rearPointer);
		
		//将头指针指向表头
		frontPointer.setNode(s1);
		SingleLinkedListTool.show(frontPointer);
		System.out.println("------------------");
		
		//第一题
		Pointer currentPointer = new Pointer();
		currentPointer.setNode(frontPointer.getNode());
		SingleLinkedListTool.deleteAllX("A", frontPointer, currentPointer);
	
		
		SingleLinkedListTool.show(frontPointer);
		
	}
	
	

}
