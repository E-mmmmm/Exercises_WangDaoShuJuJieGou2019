package chapter2_3_7;

/**
 * ��ͷ����ѭ��˫����Ĳ�����
 * 
 * @author һ��
 *
 */
public class CyclicDoubleLinkedListTest {
	public static void main(String[] args) {
		//�����ڵ�
		Node s1 = new Node(5);
		Node s2 = new Node(4);
		Node s3 = new Node(1);
		Node s4 = new Node(3);
		Node s5 = new Node(5);
		
		//����ͷָ��
		Pointer head = new Pointer();
		Pointer rear = new Pointer();
		//ͷ�巨����ڵ�
//		CyclicDoubleLinkedListTool.headAdd(s1, head, rear);
//		CyclicDoubleLinkedListTool.headAdd(s2, head, rear);
//		//CyclicDoubleLinkedListTool.headAdd(s3, head, rear);
//		CyclicDoubleLinkedListTool.headAdd(s4, head, rear);
//		CyclicDoubleLinkedListTool.headAdd(s5, head, rear);
//		CyclicDoubleLinkedListTool.headAdd(h, head, rear);
		
//		CyclicDoubleLinkedListTool.headAddWithHeadPoint(head, s1);
//		CyclicDoubleLinkedListTool.headAddWithHeadPoint(head, s2);
//		CyclicDoubleLinkedListTool.headAddWithHeadPoint(head, s3);
//		CyclicDoubleLinkedListTool.headAddWithHeadPoint(head, s4);
//		CyclicDoubleLinkedListTool.headAddWithHeadPoint(head, s5);
		
//		CyclicDoubleLinkedListTool.headAddWithoutHeadPoint(head, s1);
//		CyclicDoubleLinkedListTool.headAddWithoutHeadPoint(head, s2);
//		CyclicDoubleLinkedListTool.headAddWithoutHeadPoint(head, s3);
//		CyclicDoubleLinkedListTool.headAddWithoutHeadPoint(head, s4);
//		CyclicDoubleLinkedListTool.headAddWithoutHeadPoint(head, s5);		
		
		CyclicDoubleLinkedListTool.rearAddWithHeadPoint(head, s1);
		CyclicDoubleLinkedListTool.rearAddWithHeadPoint(head, s2);
		CyclicDoubleLinkedListTool.rearAddWithHeadPoint(head, s3);
		CyclicDoubleLinkedListTool.rearAddWithHeadPoint(head, s4);
		CyclicDoubleLinkedListTool.rearAddWithHeadPoint(head, s5);
		
//		CyclicDoubleLinkedListTool.rearAddWithoutHeadPoint(head, s1);
//		CyclicDoubleLinkedListTool.rearAddWithoutHeadPoint(head, s2);
//		CyclicDoubleLinkedListTool.rearAddWithoutHeadPoint(head, s3);
//		CyclicDoubleLinkedListTool.rearAddWithoutHeadPoint(head, s4);
//		CyclicDoubleLinkedListTool.rearAddWithoutHeadPoint(head, s5);
		
		CyclicDoubleLinkedListTool.show(head);
		System.out.println("---------------------------");
		
		//��ʮ����
		//boolean flag = CyclicDoubleLinkedListTool.issymmetry(head, rear);
		//System.out.println(flag);
	}
}
