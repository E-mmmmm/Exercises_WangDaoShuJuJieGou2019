package chapter2_3_7;
/**
 * 非循环双向链表的测试类
 * 
 * @author 一汪
 *
 */
public class DoubleLinkedListTest {
	public static void main(String[] args) {
		//创建节点
		Node s1 = new Node(2);
		Node s2 = new Node(4);
		Node s3 = new Node(1);
		Node s4 = new Node(3);
		Node s5 = new Node(5);

		//创建头指针
		Pointer head = new Pointer();
		
		DoubleLinkedListTool.headAddWithHeadNode(head, s1);
		DoubleLinkedListTool.headAddWithHeadNode(head, s2);
		DoubleLinkedListTool.headAddWithHeadNode(head, s3);
		DoubleLinkedListTool.headAddWithHeadNode(head, s4);
		DoubleLinkedListTool.headAddWithHeadNode(head, s5);
		
		DoubleLinkedListTool.showFreq(head);
		System.out.println("-------------------");
		
		DoubleLinkedListTool.Locate(head, 5);
		DoubleLinkedListTool.Locate(head, 4);
		DoubleLinkedListTool.Locate(head, 4);
		DoubleLinkedListTool.Locate(head, 4);
		DoubleLinkedListTool.Locate(head, 1);
		DoubleLinkedListTool.Locate(head, 5);
		DoubleLinkedListTool.Locate(head, 7);
		DoubleLinkedListTool.Locate(head, 2);
		DoubleLinkedListTool.Locate(head, 2);
		DoubleLinkedListTool.Locate(head, 1);
		DoubleLinkedListTool.Locate(head, 3);
		DoubleLinkedListTool.showFreq(head);
	}
}
