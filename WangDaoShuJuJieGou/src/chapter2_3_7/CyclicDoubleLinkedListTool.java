package chapter2_3_7;

/**
 * ѭ��˫����Ĺ�����
 * 
 * @author һ��
 *
 */
public class CyclicDoubleLinkedListTool {
	//����ԭ��˼·�ı䣬�����ͷ���Ӧ�ɷ����������������û�����
//	//ͷ�巨����ָ��
//	/* 
//	 * ����
//	 * 	ָ��
//	 *		rear:βָ��
//	 *		p:ָ��ǰ���в���Ľڵ�
//	 *	��ʼ��
//	 *		p = node	
//	 * ����
//	 * 	A.���������β�ڵ㣬������˳���ϵĵ�һ���ڵ�,head == null
//	 * 		head = node
//	 * 		rear = node
//	 *  B.��������ǵڶ������Ժ󣨲���˳���ϣ��Ľڵ�,head != null 
//	 *  	˫���������ڵ�֮�������
//	 *  	p->next = head
//	 *  	head->perior = node
//	 *  	head = node
//	 *  	ѭ��˫����ͷβ�ڵ�֮�������
//	 *  	head->prior = rear
//	 *      rear->next = head      
//	 */
//	/**
//	 * ͷ�巨����ڵ㣬�����Ƿ���ͷ���
//	 * ����˳����ʵ��˳���෴
//	 * @param node
//	 * 			  ������Ľڵ�
//	 * @param head
//	 * 			 ��ǰ�����ͷָ��
//	 */
//	public static void headAdd(Node node, Pointer head, Pointer rear) {
//		//����ָ��
//		Pointer p = new Pointer();
//		//��ʼ��ָ��
//		p.setNode(node);
//		
//		//���������β�ڵ㣬������˳���ϵĵ�һ���ڵ�
//		if(head.getNode() == null) {
//			head.setNode(node);
//			rear.setNode(node);
//		} else if(head.getNode() != null) {
//			//��������ǵڶ������Ժ󣨲���˳���ϣ��Ľڵ�
//			//˫���������ڵ�֮�������
//			p.getNode().setNext(head.getNode());
//			head.getNode().setPrior(node);
//			head.setNode(node);
//			//ѭ��˫����ͷβ�ڵ�֮�������
//			head.getNode().setPrior(rear.getNode());
//			rear.getNode().setNext(head.getNode());
//		}
//	}
//	
	/**
	 * ��ͷ����ͷ�巨
	 * 
	 * @param head
	 * 			ִ�в�������������ͷָ��
	 * @param node
	 * 			������Ľڵ�
	 */
	public static void headAddWithHeadPoint(Pointer head, Node node) {
		//�ñ�û��ͷ���
		if(head.getNode() == null) {
			//�ṩͷ���
			Node headNode = new Node();
			head.setNode(headNode);
			node.setNext(headNode);
			node.setPrior(headNode);
			headNode.setNext(node);
			headNode.setPrior(node);
		} else {
			node.setNext(head.getNode().getNext());
			node.setPrior(head.getNode());
			head.getNode().getNext().setPrior(node);
			head.getNode().setNext(node);
		}
	}
	
	/**
	 * û��ͷ����ͷ�巨
	 * 
	 * @param head
	 * 			ִ�в�������������ͷָ��
	 * @param node
	 * 			������Ľڵ�
	 */
	public static void headAddWithoutHeadPoint(Pointer head, Node node) {
		if(head.getNode() == null) {
			head.setNode(node);
			node.setNext(node);
		} else {
			Pointer rear = findRearPoint(head);
			node.setNext(head.getNode());
			head.getNode().setPrior(node);
			node.setPrior(rear.getNode());
			rear.getNode().setNext(node);
			head.setNode(node);
		}
	}
	
	/**
	 * ��ͷ�ڵ��β�巨
	 * 
	 * @param head
	 * 			������������ͷָ��
	 * @param node
	 * 			������Ľڵ�
	 */
	public static void rearAddWithHeadPoint(Pointer head, Node node) {
		if(head.getNode() == null) {
			Node headNode = new Node();
			head.setNode(headNode);
			headNode.setNext(node);
			headNode.setPrior(node);
			node.setNext(headNode);
			node.setPrior(headNode);
		} else {
			Pointer rear = findRearPoint(head);
			node.setNext(head.getNode());
			node.setPrior(rear.getNode());
			head.getNode().setPrior(node);
			rear.getNode().setNext(node);
		}
	}
	
	/**
	 * ����ͷ�ڵ��β�巨
	 * 
	 * @param head
	 * 			������������ͷָ��
	 * @param node
	 * 			������Ľڵ�
	 */
	public static void rearAddWithoutHeadPoint(Pointer head, Node node) {
		if(head.getNode() == null) {
			head.setNode(node);
			node.setNext(node);
		} else {
			Pointer rear = findRearPoint(head);
			node.setNext(head.getNode());
			node.setPrior(rear.getNode());
			head.getNode().setPrior(node);
			rear.getNode().setNext(node);
		}
	}
	
	/**
	 * Ѱ��β�ڵ�
	 * @param head
	 * 			��Ѱ��β�ڵ�������ͷָ��
	 * @return
	 * 			�������βָ��
	 */
	public static Pointer findRearPoint(Pointer head) {
		//Pointer p = head;������������Ϊ����pʵ���ϲ�������head���ᵼ��֮���while��ѭ��
		Pointer p = new Pointer();
		p.setNode(head.getNode());
		
		while(p.getNode().getNext() != head.getNode()) {
			p.setNode(p.getNode().getNext());
		}
		
		return p;
	}
	
	//��ʾѭ��˫����Ľڵ�Ԫ��
	/*
	 * ˼·
	 * 	��ͷ��㿪ʼ������ֱ��β�ڵ�
	 * ʵ��
	 * 	����
	 * 		ָ��
	 * 			p��ָ��ǰ�����Ľڵ�
	 * 	��ʼ��
	 * 		ָ��
	 * 			p = head
	 * 	����
	 * 		A.����ǰ�ڵ�Ϊͷ���
	 * 			p = p->next
	 * 		B.��p != head
	 * 			���p->data
	 * 			p = p->next
	 */
	/**
	 * ��ʾѭ��˫����Ľڵ�Ԫ��
	 * ͷ����Ԫ�ز���ʾ
	 * 
	 * @param head
	 * 			  ѭ��˫�����ͷ���
	 */
	public static void show(Pointer head) {
		//����ָ��
		Pointer p = new Pointer();
		//��ʼ��ָ��
		p.setNode(head.getNode());
		
		//����ǰ�ڵ�Ϊͷ���
		while(true) {
			if(p.getNode().getData() != null) {
				System.out.println(p.getNode().getData());
			}
			if(p.getNode().getNext() == head.getNode()) {
				return;
			}
			
			p.setNode(p.getNode().getNext());
		}
	}
	
	//��ʮ����
	/*
	 * ˼·
	 * 	����ͷָ���βָ�룬�ֱ��ȡ��Ӧλ�õĽڵ��Ԫ�ز��Ƚ�
	 * ʵ��
	 * 	����
	 * 		ָ��
	 * 			p��ָ����ȽϵĽڵ�1
	 * 			q��ָ����ȽϵĽڵ�2
	 * 		���
	 * 			flag
	 * 	��ʼ��
	 * 		ָ��
	 * 			p = head
	 * 			q = head
	 * 		���
	 * 			flag = true
	 * 	����
	 * 		A.�� p->next != q->prior && p->next != q
	 * 			a.p = p->next;q = q->prior
	 * 			b.�Ƚ�p->data��q->data
	 * 				��ȣ��ظ�A
	 * 				����ȣ�return false
	 */
	public static boolean issymmetry(Pointer head, Pointer rear) {
		//����ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		//��ʼ��ָ��
		p.setNode(head.getNode());
		q.setNode(head.getNode());
		
		//�������
		boolean flag = true;
		
		while(p.getNode().getNext() != q.getNode().getPrior() && p.getNode().getNext() != q.getNode()) {
			p.setNode(p.getNode().getNext());
			q.setNode(q.getNode().getPrior());
			if(!p.getNode().getData().equals(q.getNode().getData())) {
				flag = false;
			}
		}
		
		return flag;
	}
}
