package chapter2_3_7;
/**
 * 循环单链表的测试类
 * 
 * @author 一汪
 *
 */
public class CyclicSingleLinkedListTest {
	public static void main(String[] args) {
		//创建节点
		Node s1 = new Node(2);
		Node s2 = new Node(4);
		Node s3 = new Node(1);
		Node s4 = new Node(3);
		Node s5 = new Node(5);
		
		Node s6 = new Node(9);
		Node s7 = new Node(7);
		Node s8 = new Node(8);
		//创建头指针
		Pointer head = new Pointer();
		
//		CyclicSingleLinkedListTool.headAddWithHeadPoint(head, s1);
//		CyclicSingleLinkedListTool.headAddWithHeadPoint(head, s2);
//		CyclicSingleLinkedListTool.headAddWithHeadPoint(head, s3);
//		CyclicSingleLinkedListTool.headAddWithHeadPoint(head, s4);
//		CyclicSingleLinkedListTool.headAddWithHeadPoint(head, s5);
		
//		CyclicSingleLinkedListTool.headAddWithoutHeadPoint(head, s1);
//		CyclicSingleLinkedListTool.headAddWithoutHeadPoint(head, s2);
//		CyclicSingleLinkedListTool.headAddWithoutHeadPoint(head, s3);
//		CyclicSingleLinkedListTool.headAddWithoutHeadPoint(head, s4);
//		CyclicSingleLinkedListTool.headAddWithoutHeadPoint(head, s5);
		
//		CyclicSingleLinkedListTool.rearAddWithHeadPoint(head, s1);
//		CyclicSingleLinkedListTool.rearAddWithHeadPoint(head, s2);
//		CyclicSingleLinkedListTool.rearAddWithHeadPoint(head, s3);
//		CyclicSingleLinkedListTool.rearAddWithHeadPoint(head, s4);
//		CyclicSingleLinkedListTool.rearAddWithHeadPoint(head, s5);
		
		CyclicSingleLinkedListTool.rearAddWithHeadPoint(head, s1);
		CyclicSingleLinkedListTool.rearAddWithHeadPoint(head, s2);
		CyclicSingleLinkedListTool.rearAddWithHeadPoint(head, s3);
		CyclicSingleLinkedListTool.rearAddWithHeadPoint(head, s4);
		CyclicSingleLinkedListTool.rearAddWithHeadPoint(head, s5);
		
//		Pointer rear = new Pointer();
//		rear.setNode(s5);
		
//		Pointer head2 = new Pointer();
//		CyclicSingleLinkedListTool.headAddWithoutHeadPoint(head2, s6);
//		CyclicSingleLinkedListTool.headAddWithoutHeadPoint(head2, s7);
//		CyclicSingleLinkedListTool.headAddWithoutHeadPoint(head2, s8);
		
		CyclicSingleLinkedListTool.show(head);
		System.out.println("------------------");
//		CyclicSingleLinkedListTool.show(head2);
//		System.out.println("---------------------");
//		
		//第十八题
		//CyclicSingleLinkedListTool.mergeH1H2(head, head2);
		//CyclicSingleLinkedListTool.show(head);
		
		//第十九题
		CyclicSingleLinkedListTool.findMinimum(head);
	}
}
