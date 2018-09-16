package chapter2_3_7;
/**
 * ��ѭ��˫������Ĺ�����
 * 
 * @author һ��
 *
 */
public class DoubleLinkedListTool {
	public static void headAddWithHeadNode(Pointer head, Node node) {
		if(head.getNode() == null) {
			Node headNode = new Node();
			headNode.setNext(node);
			node.setPrior(headNode);
			head.setNode(headNode);
		} else {
			node.setNext(head.getNode().getNext());
			node.setPrior(head.getNode());
			head.getNode().getNext().setPrior(node);
			head.getNode().setNext(node);
		}
	}
	
	public static void show(Pointer head) {
		Pointer p = new Pointer();
		p.setNode(head.getNode());
		
		while(true) {
			if(p.getNode().getData() != null) {
				System.out.println(p.getNode().getData());
			}
			
			if(p.getNode().getNext() == null) {
				return;
			}
			
			p.setNode(p.getNode().getNext());
		}
	}
	
	/**
	 * ��ʾ�ڵ��data��freq
	 * @param head
	 */
	public static void showFreq(Pointer head) {
		Pointer p = new Pointer();
		p.setNode(head.getNode());
		
		while(true) {
			if(p.getNode().getData() != null) {
				System.out.println("Data:" + p.getNode().getData() + "---Freq:" + p.getNode().getFreq());
			}
			
			if(p.getNode().getNext() == null) {
				return;
			}
			
			p.setNode(p.getNode().getNext());
		}
	}
	
	//�ڶ�ʮ��
	/*
	 * Ԫ�ز��ظ�
	 * ˼·
	 * 	�ȱ��������ҵ�Ԫ����x��ͬ�Ľڵ�a
	 * 	�ڵ�a��freq++
	 * 	Ȼ����������ҵ�freqС�ڵ��ڽڵ�a�Ľڵ�b
	 * 	��a�ŵ�b֮ǰ
	 * ʵ��
	 * 	����
	 * 		ָ��
	 * 			p:ָ��Ԫ��ֵ��x��ͬ�Ľڵ�a��ǰ���ڵ�
	 * 			q��ָ��freqС�ڵ��ڽڵ�a�Ľڵ��ǰ���ڵ�
	 * 			r:ָ��ڵ�a
	 * 	��ʼ��
	 * 		p = head
	 * 		q = head
	 * 	����
	 * 		head
	 * 		x:ֵ
	 * 	����
	 * 		���������Ƚ�p->next->data��x
	 * 			����
	 * 				r = p->next
	 * 				r->freq = r->freq + 1
	 * 				���������Ƚ�q->next->freq��r->freq
	 * 					С�ڵ���
	 * 						��q->next != r 
	 * 							p->next = r->next
	 * 							r->next->prior = p
	 * 							r->next = q->next
	 * 							r->prior = q
	 * 							q->next->prior = r
	 * 							q->next = r
	 * 						��q->next == r
	 * 							return;
	 * 					����
	 * 						q = q->next
	 * 			������
	 * 				p = p->next��ֱ��p->next->next == null
	 */		
	public static void Locate(Pointer head, int x) {
		//ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer r = new Pointer();
		p.setNode(head.getNode());
		q.setNode(head.getNode());
		
		//�ȱ��������ҵ�Ԫ����x��ͬ�Ľڵ�a
		while(p.getNode().getNext() != null) {
			if(p.getNode().getNext().getData().equals(x)) {
				r.setNode(p.getNode().getNext());
				r.getNode().setFreq(r.getNode().getFreq()+1);
				
				//����freq
				while(true) {
					if(q.getNode().getNext().getFreq() <= r.getNode().getFreq()) {
						if(q.getNode().getNext() != r.getNode() && r.getNode().getNext() != null) {
							p.getNode().setNext(r.getNode().getNext());
							r.getNode().getNext().setPrior(p.getNode());
							r.getNode().setNext(q.getNode().getNext());
							r.getNode().setPrior(q.getNode());
							q.getNode().getNext().setPrior(r.getNode());
							q.getNode().setNext(r.getNode());
						} else if(q.getNode().getNext() != r.getNode() && r.getNode().getNext() == null) {
							p.getNode().setNext(null);
							r.getNode().setNext(q.getNode().getNext());
							r.getNode().setPrior(q.getNode());
							q.getNode().getNext().setPrior(r.getNode());
							q.getNode().setNext(r.getNode());
						} else if(q.getNode().getNext() == r.getNode()){
							return;
						}
					} else {
						q.setNode(q.getNode().getNext());
					}
				}
			} else {
				p.setNode(p.getNode().getNext());
			}
		}
	}
}
