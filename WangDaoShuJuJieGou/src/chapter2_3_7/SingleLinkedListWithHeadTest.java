package chapter2_3_7;

/**
 * ��ͷ���ĵ�����Ĳ�����
 * 
 * @author һ��
 * 
 */
public class SingleLinkedListWithHeadTest {
	public static void main(String[] args) {
		// �����ڵ�
		Node<Integer> s1 = new Node<>(21);
		Node<Integer> s2 = new Node<>(-7);
		Node<Integer> s3 = new Node<>(-15);
		Node<Integer> s4 = new Node<>(-15);
		Node<Integer> s5 = new Node<>(15);
		Node<Integer> head = new Node<>();

		// ����ͷָ��
		Pointer frontPointer = new Pointer();
		// ����������
		SingleLinkedListTool.frontAdd(s1, frontPointer);
		SingleLinkedListTool.frontAdd(s2, frontPointer);
		SingleLinkedListTool.frontAdd(s3, frontPointer);
		SingleLinkedListTool.frontAdd(s4, frontPointer);
		SingleLinkedListTool.frontAdd(s5, frontPointer);
		SingleLinkedListTool.frontAdd(head, frontPointer);

		SingleLinkedListTool.show(frontPointer);
		System.out.println("---------------------");
		
		// �����ڶ������������һ���������й����ڵ�
		Node<Integer> s10 = new Node<>(9);
		Node<Integer> s9 = new Node<>(8);
		Node<Integer> s6 = new Node<>(4);
		Node<Integer> s7 = new Node<>(7);
		Node<Integer> s8 = new Node<>(9);
		Node<Integer> head2 = new Node<>();
		
		// ����ͷָ��
		Pointer frontPointer2 = new Pointer();
	
		// ����������
		SingleLinkedListTool.frontAdd(s1, frontPointer2);
		SingleLinkedListTool.frontAdd(s2, frontPointer2);
//		SingleLinkedListTool.frontAdd(s3, frontPointer2);
//		SingleLinkedListTool.frontAdd(s4, frontPointer2);
//		SingleLinkedListTool.frontAdd(s5, frontPointer2);
		//SingleLinkedListTool.frontAdd(s10, frontPointer2);
//		SingleLinkedListTool.frontAdd(s9, frontPointer2);
//		SingleLinkedListTool.frontAdd(s6, frontPointer2);
//		SingleLinkedListTool.frontAdd(s7, frontPointer2);
		SingleLinkedListTool.frontAdd(s8, frontPointer2);
		SingleLinkedListTool.frontAdd(head2, frontPointer2);
		
		//SingleLinkedListTool.show(frontPointer2);
		System.out.println("---------------------");
		
		// //�ڶ���
		// Pointer currentPointer = new Pointer();
		// currentPointer.setNode(frontPointer.getNode());
		// SingleLinkedListTool.deleteAllXWithHead("A", frontPointer,
		// currentPointer);
		// SingleLinkedListTool.show(frontPointer);

		// ������
		// SingleLinkedListTool.reverse(frontPointer);

		// ������
		// SingleLinkedListTool.minimum(frontPointer);
		// SingleLinkedListTool.show(frontPointer);

		// ������
		// �ҵķ���
		// SingleLinkedListTool.localReverse(frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		// ���Ϸ���һ
		// SingleLinkedListTool.localReverse2(frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		// ���Ϸ�����
		// SingleLinkedListTool.localReverse3(frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		
		// ������
		// SingleLinkedListTool.increase(frontPointer);
		// SingleLinkedListTool.increase2(frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		
		// ������
		// SingleLinkedListTool.delBetween(0, 8, frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		
		//�ڰ���
		//System.out.println(SingleLinkedListTool.publicNode(frontPointer, frontPointer2));
		
		//�ھ���
		//SingleLinkedListTool.increaseShow(frontPointer);
		//System.out.println("-----------------");
		//SingleLinkedListTool.show(frontPointer);
		
		//��ʮ��
		//Pointer headB = SingleLinkedListTool.mkDouble(frontPointer);
		//System.out.println("A:");
		//SingleLinkedListTool.show(frontPointer);
		//System.out.println("B:");
		//SingleLinkedListTool.show(headB);
		
		//��ʮ����
		// SingleLinkedListTool.deleteRepeat(frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		
		//��ʮ����
		//Pointer headA = SingleLinkedListTool.dualIncreaseToSingleDecrease(frontPointer, frontPointer2);
		//SingleLinkedListTool.show(headA);
		
		//��ʮ����
		//Pointer headC = SingleLinkedListTool.publicNodeWithNewList(frontPointer, frontPointer2);
		//Pointer headC = SingleLinkedListTool.publicNodeWithNewList2(frontPointer, frontPointer2);
		//SingleLinkedListTool.show(headC);
		
		//��ʮ����
		//Pointer headA = SingleLinkedListTool.intersection(frontPointer, frontPointer2);
		//SingleLinkedListTool.show(headA);
		
		//��ʮ���� 
		/*-----------------------------------------------
		 * ������ף�����ǵ�һ������һ��ͨ�����⣡����
		 * 2018/8/4 15:40
		 *-----------------------------------------------
		 */
		//boolean flag = SingleLinkedListTool.isContinuousSequence(frontPointer, frontPointer2);
		//System.out.println(flag);
		
		//�ڶ�ʮһ��
		//System.out.println(SingleLinkedListTool.lastK(frontPointer, 3));
		
		//�ڶ�ʮ����
		//Pointer r = SingleLinkedListTool.findPublic(frontPointer, frontPointer2);
		//Pointer r = SingleLinkedListTool.findPublic2(frontPointer, frontPointer2);
		//System.out.println(r.getNode());
		
		//�ڶ�ʮ����
//		SingleLinkedListTool.differAbsoluteValue(frontPointer);
		SingleLinkedListTool.differAbsoluteValue2(frontPointer, 21);
		SingleLinkedListTool.show(frontPointer);
	}
}
