package chapter2_3_7;

/**
 * ��ͷ���ĵ�����Ĳ�����
 * @author һ��
 *
 */
public class SingleLinkedListWithoutHeadTest {
	public static void main(String[] args) {
		//�����ڵ�
		Node<String> s1 = new Node<>("A");
		Node<String> s2 = new Node<>("B");
		Node<String> s3 = new Node<>("C");
		Node<String> s4 = new Node<>("D");
		Node<String> s5 = new Node<>("E");
		
		//����ͷָ��
		Pointer<String> frontPointer = new Pointer<>();
		
		//���ڵ����һ������ͷ�ڵ㵥����L
//		SingleLinkedListTool.frontAdd(s1, frontPointer);
//		SingleLinkedListTool.frontAdd(s2, frontPointer);
//		SingleLinkedListTool.frontAdd(s3, frontPointer);
//		SingleLinkedListTool.frontAdd(s4, frontPointer);
//		SingleLinkedListTool.frontAdd(s5, frontPointer);
		
		//����βָ��
		Pointer<String> rearPointer = new Pointer<>();
		
		SingleLinkedListTool.rearAdd(s1, rearPointer);
		SingleLinkedListTool.rearAdd(s2, rearPointer);
		SingleLinkedListTool.rearAdd(s3, rearPointer);
		SingleLinkedListTool.rearAdd(s4, rearPointer);
		SingleLinkedListTool.rearAdd(s5, rearPointer);
		
		//��ͷָ��ָ���ͷ
		frontPointer.setNode(s1);
		SingleLinkedListTool.show(frontPointer);
		System.out.println("------------------");
		
		//��һ��
		Pointer currentPointer = new Pointer();
		currentPointer.setNode(frontPointer.getNode());
		SingleLinkedListTool.deleteAllX("A", frontPointer, currentPointer);
	
		
		SingleLinkedListTool.show(frontPointer);
		
	}
	
	

}
