package chapter2_3_7;
/**
 * ѭ��˫����Ĺ�����
 * 
 * @author һ��
 *
 */
public class CyclicSingleLinkedListTool {
	//��ͷ�ڵ��ͷ�巨
	/*
	 * ˼·
	 * 	�ɷ��������ṩͷ��㣬�������û��ṩ
	 * �ṩ
	 * 	ָ��
	 * 		ͷָ��
	 * 	�ڵ�
	 * 		������
	 * 
	 * 	����
	 * 		A.�жϸ������Ƿ���ͷ���
	 * 			û��
	 * 				�ṩͷ��㣬����ӽڵ�,������ѭ��
	 * 			��
	 * 				��ӽڵ�
	 */
	/**
	 * �ṩͷ�ڵ��ͷ�巨
	 * 
	 * @param head 
	 * 			ѭ���������ͷָ��
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
			headNode.setNext(node);
		} else {
			node.setNext(head.getNode().getNext());
			head.getNode().setNext(node);
		}
	}
	
	
	/**
	 * ����ͷ����ͷ�巨
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
			return;
		} else {
			Pointer rear = findRearPointer(head);
			rear.getNode().setNext(node);
			node.setNext(head.getNode());
			head.setNode(node);
		}
	}
	/**
	 * ����ͷ����ͷ�巨��Ч�ʱȲ��ṩβָ���headAddWithoutHeadPoint��
	 * @param head 
	 * 			ִ�в�������������ͷָ��
	 * @param rear
	 * 			ִ�в�������������βָ��
	 * @param node
	 * 			������Ľڵ�
	 */
	public static void headAddWithoutHeadPoint(Pointer head,Pointer rear, Node node) {
		if(head.getNode() == null) {
			head.setNode(node);
			node.setNext(node);
		} else {
			rear.getNode().setNext(node);
			node.setNext(head.getNode());
			head.setNode(node);
		}
	}
	
	/**
	 * ��ͷ����β�巨
	 * 
	 * @param head
	 * 			ִ�в�������������ͷָ��
	 * @param node
	 * 			������Ľڵ�
	 */
	public static void rearAddWithHeadPoint(Pointer head, Node node) {
		if(head.getNode() == null) {
			Node headNode = new Node();
			headNode.setNext(node);
			node.setNext(headNode);
			head.setNode(headNode);
		} else {
			Pointer rear = findRearPointer(head);
			node.setNext(head.getNode());
			rear.getNode().setNext(node);
		}
	}
	/**
	 * ��ͷ����β�巨��Ч�ʱ�rearAddWithHeadPoint(Pointer head, Node node)��
	 * @param head
	 * 			ִ�в�������������ͷָ��
	 * @param rear
	 * 			ִ�в�������������βָ��
	 * @param node
	 * 			������Ľڵ�
	 */
	public static void rearAddWithHeadPoint(Pointer head, Pointer rear, Node node) {
		if(head.getNode() == null) {
			Node headNode = new Node();
			headNode.setNext(node);
			node.setNext(headNode);
			head.setNode(headNode);
		} else {
			node.setNext(rear.getNode().getNext());
			rear.getNode().setNext(node);
		}
	}
	
	/**
	 * ����ͷ����β�巨
	 * 
	 * @param head
	 * 			ִ�иò����������ͷ���
	 * @param node
	 * 			������Ľڵ�
	 */
	public static void rearAddWithoutHeadPoint(Pointer head, Node node) {
		if(head.getNode() == null) {
			head.setNode(node);
			node.setNext(node);
		} else {
			Pointer rear = findRearPointer(head);
			node.setNext(rear.getNode().getNext());
			rear.getNode().setNext(node);
		}
	}

	
	
	/**
	 * Ѱ��β�ڵ�
	 * @param head
	 * 			ִ�иò����������ͷָ��
	 * @return	ִ�иò����������βָ��
	 */
	public static Pointer findRearPointer(Pointer head) {
		//ָ��
		//Pointer p = head;������������Ϊ����pʵ���ϲ�������head���ᵼ��֮���while��ѭ��
		Pointer p = new Pointer();
		p.setNode(head.getNode());
		
		while(p.getNode().getNext() != head.getNode()) {
			p.setNode(p.getNode().getNext());
		}
		
		return p;
	}
	
	/**
	 * ��ӡѭ��������
	 * @param head
	 * 			����ӡ�������ͷָ��
	 */
	public static void show(Pointer head) {
		//����ָ��
		Pointer p = new Pointer();
		//��ʼ��ָ��
		p.setNode(head.getNode());
		
		while(true)  {
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
	 * 	�ֱ��ҵ�h1,h2��β�ڵ�
	 * 	��h1��β�ڵ��h2��ͷ�ڵ�����
	 *  ��h2��β�ڵ��h1��ͷ�ڵ�����
	 *  
	 * ʵ��
	 * 	����
	 * 		ָ��
	 * 			rear1��ָ��h1��β�ڵ�
	 * 			rear2��ָ��h2��β�ڵ�
	 * 	��ʼ��
	 * 		ָ��
	 * 			ͨ��findRearPoint(head)
	 * 	����
	 * 		A.h1->next = h2
	 * 		B.rear2->next = h1
	 * ʱ�临�Ӷ�O(m+n)
	 */
	public static void mergeH1H2(Pointer h1, Pointer h2) {
		Pointer rear1 = findRearPointer(h1);
		Pointer rear2 = findRearPointer(h2);
		
		rear1.getNode().setNext(h2.getNode());
		rear2.getNode().setNext(h1.getNode());
	}
	
	//��ʮ����
	/*
	 * ˼·
	 * 	�ܼ򵥣�����ȡ��һ���ڵ㣬Ȼ�����αȽϺ����ֵ���������ֵС�������ͺ���ıȣ�ֱ���ҵ���С�ģ������ɾ��
	 * ʵ��
	 * 	����
	 * 		ָ��
	 * 			p��ָ����бȽϵĽڵ��ǰ���ڵ�
	 * 			q��ָ��ǰ��С�Ľڵ��ǰ���ڵ�
	 * 		����
	 * 			temp���洢��ǰ����Сֵ
	 *  ��ʼ��
	 *  	ָ��
	 *  		p = head->next
	 *		����
	 *			temp = p->data
	 *  ����
	 *  	head
	 *  ʵ��
	 *  	A.temp��p->next->data�Ƚ�
	 *  		������
	 *  			temp = p->next->data
	 *  			q = p
	 *  			p = p->next
	 *  		����
	 *  			p = p->next
	 *  	B.�ظ�A��ֱ��p->next == head
	 *  	C.���temp
	 *  	D.ɾ����Сֵ�ڵ�
	 *  		q->next = q->next->next
	 *  	E.�ظ����ϲ�����ֱ��head->next == head
	 */
	public static void findMinimum(Pointer head) {
		//ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		//��ʼ��ָ��
		p.setNode(head.getNode());
		
		while(head.getNode().getNext() != head.getNode()) {
			//��ʼ��ָ��
			p.setNode(head.getNode());
			q.setNode(p.getNode());
			//����
			int temp = (int)p.getNode().getNext().getData();
			
			while(p.getNode().getNext().getNext() != head.getNode()) {
				p.setNode(p.getNode().getNext());
				
				if(temp > (int)p.getNode().getNext().getData()) {
					temp = (int)p.getNode().getNext().getData();
					q.setNode(p.getNode());
				}
			}
			
			q.getNode().setNext(q.getNode().getNext().getNext());
			
			System.out.println(temp);
		}
	}
}
