package chapter2_3_7;

/**
 * ������Ļ���������
 * 
 * @author һ��
 * 
 */
public class SingleLinkedListTool<T> {

	/**
	 * ͷ�巨���Ԫ��
	 * �÷������ɵĵ�����ڵ��˳�������˳���෴
	 * 
	 * @param node
	 *            ��ӵĽڵ�
	 * @param hp
	 *            ͷָ��
	 */
	public static <T> void frontAdd(Node<T> node, Pointer<T> frontPointer) {
		node.setNext(frontPointer.getNode());
		frontPointer.setNode(node);
	}

	/**
	 * ������β�巨���Ԫ��
	 * 
	 * @param node
	 *            ��ӵĽڵ�
	 * @param tp
	 *            βָ��
	 */
	public static <T> void rearAdd(Node<T> node, Pointer<T> rearPointer) {
		if (rearPointer.getNode() != null) {
			rearPointer.getNode().setNext(node);
			// βָ��ָ��β�ڵ�
			rearPointer.setNode(node);
		} else {
			rearPointer.setNode(node);
		}
	}

	/**
	 * ��ʾ������
	 * 
	 * @param hp
	 *            ͷָ��
	 */
	public static <T> void show(Pointer<T> frontPointer) {
		// ������ʱָ�룬����ͷָ��
		Pointer<T> tempPointer = new Pointer<T>();
		tempPointer.setNode(frontPointer.getNode());

		while (tempPointer.getNode() != null) {
			if(tempPointer.getNode().getData() != null) {
				// ��ʾ��ǰͷָ��ָ��Ľڵ������
				System.out.println(tempPointer.getNode().toString()+":"+tempPointer.getNode().getData());
			}
			// ����ʱָ��ָ����һ���ڵ�
			tempPointer.setNode(tempPointer.getNode().getNext());
		}
	}
	
	public static Pointer finRearPointer(Pointer frontPointer) {
		while(frontPointer.getNode().getNext() != null) {
			frontPointer.setNode(frontPointer.getNode().getNext());
		}
		Pointer rearPointer = new Pointer();
		rearPointer.setNode(frontPointer.getNode());
		
		return rearPointer; 
	}
	
	public static int sizeOf(Pointer frontPointer) {
		Pointer tempPointer = new Pointer();
		tempPointer.setNode(frontPointer.getNode());
		
		int size = 0;
		while (tempPointer.getNode() != null) {
			if(tempPointer.getNode().getData() != null) {
				size++;
			}
			tempPointer.setNode(tempPointer.getNode().getNext());
		}
		
		return size;
	}
	// ��һ��
	/*
	 * ʹ������ָ�룬�ж�ָ��pָ��Ľڵ��ֱ�Ӻ��
	 * �Լ�һ����ʱָ��
	 * ͷָ��ʼ��ָ���һ���ڵ㣬���ͷָ����Ҫһ�������Ĳ������и�ֵ
	 * 
	 * �÷���ʹ������ָ�룺
	 * ָ��currentPointer������ָ��ǰ�Ľڵ㣬�жϵ�ǰ�ڵ��Ƿ���Ҫɾ��
	 * ָ��tempPointer�����ڸ�������
	 * ָ��frontPointer����Ϊͷָ��ʼ��ָ���һ���ڵ㣬���ڱ����������Լ�֮������Ĵ�ӡ
	 * 
	 * �ݹ���ֹ������currentPointerָ��null
	 * A.��ǰ�ڵ�Ϊ��һ���ڵ�ʱ
	 * 	a.Ҫɾ��
	 * 	 1.tempPointerָ����һ���ڵ�
	 *   2.ʹ��һ���ڵ����
	 *   3.currentPointerָ��tempPointerָ��Ľڵ�
	 *   4.frontPointerָ��tempPointerָ��Ľڵ�
	 *   5.���õݹ�
	 *  b.��ɾ��
	 *   1.currentPointerָ����һ���ڵ�
	 *   2.���õݹ�
	 * B.��ǰ�ڵ㲻Ϊ��һ���ڵ�
	 *  a.Ҫɾ��
	 *   1.����������tempPointerָ��ǰ�ڵ��ǰ�����
	 *   2.currentPointerָ����һ���ڵ�
	 *   3.�ı䵱ǰ�ڵ��ǰ������ָ����
	 *   4.���õݹ�
	 *  b.��ɾ��
	 *   1.currentPointerָ����һ���ڵ�
	 *   2.���õݹ�
	 */
	
	/**
	 * ʹ�õݹ飬ɾ��������������ֵΪelement��Ԫ��
	 * 
	 * @param element 
	 * 				��ɾ����Ԫ��
	 * @param frontPointer 
	 * 				                 �����ĵ������ͷָ��
	 * @param currentPointer 
	 * 					          ����ɾ������ʱʹ�õĵ�ǰָ�룬���ݲ����ĵ������ͷָ��ĸ���
	 */
	
	public static <T> void deleteAllX(T element, Pointer frontPointer, Pointer currentPointer) {
		//��ʱָ��
		Pointer tempPointer = new Pointer();
		
		//��ֹ����
		if(currentPointer.getNode() == null) {
			return;
		}


		//ɾ���˽ڵ�
		if(currentPointer.getNode().getData().equals(element)) {
			//��ǰ�ڵ�Ϊ��һ���ڵ�
			if(currentPointer.getNode().equals(frontPointer.getNode())) {
				//ɾ����һ���ڵ�
				tempPointer.setNode(currentPointer.getNode().getNext());
				currentPointer.getNode().setNext(null);
				currentPointer.setNode(tempPointer.getNode());
				frontPointer.setNode(tempPointer.getNode());
						
				deleteAllX(element, frontPointer, currentPointer);
			} else {
				//��ǰ�ڵ㲻Ϊ��һ���ڵ�
				//���������ҵ��˽ڵ��ǰ�����
				tempPointer.setNode(frontPointer.getNode());
				while(!tempPointer.getNode().getNext().equals(currentPointer.getNode())) {
					tempPointer.setNode(tempPointer.getNode().getNext());
				}
						
				currentPointer.setNode(currentPointer.getNode().getNext());
				tempPointer.getNode().setNext(currentPointer.getNode());
						
				deleteAllX(element, frontPointer, currentPointer);
			}
		} else {
			//��ɾ���˽ڵ�
			currentPointer.setNode(currentPointer.getNode().getNext());
			deleteAllX(element, frontPointer, currentPointer);
		}
	}
	
	// �ڶ���
		/*
		 * ʹ������ָ�룬�ж�ָ��pָ��Ľڵ��ֱ�Ӻ��
		 * �Լ�һ����ʱָ��
		 * ͷָ��ʼ��ָ��ͷ�ڵ㣬���ͷָ����Ҫһ�������Ĳ������и�ֵ
		 * 
		 * �÷���ʹ������ָ�룺
		 * ָ��currentPointer������ָ��ǰ�Ľڵ㣬�жϵ�ǰ�ڵ��Ƿ���Ҫɾ��
		 * ָ��tempPointer�����ڸ�������
		 * ָ��frontPointer����Ϊͷָ��ʼ��ָ��ͷ�ڵ�ڵ㣬���ڱ����������Լ�֮������Ĵ�ӡ
		 * 
		 * �ݹ���ֹ������currentPointerָ��null
		 * A.��ǰ�ڵ�Ϊͷ�ڵ�ʱ
		 *   1.currentPointerָ����һ���ڵ�
		 *   2.���õݹ�
		 * B.��ǰ�ڵ㲻Ϊͷ�ڵ�
		 *  a.Ҫɾ��
		 *   1.����������tempPointerָ��ǰ�ڵ��ǰ�����
		 *   2.currentPointerָ����һ���ڵ�
		 *   3.�ı䵱ǰ�ڵ��ǰ������ָ����
		 *   4.���õݹ�
		 *  b.��ɾ��
		 *   1.currentPointerָ����һ���ڵ�
		 *   2.���õݹ�
		 */
	
	//�жϽڵ�������Ϊ��Ҫ�á�=����������equals()��������ָ���쳣
		
	/**
	 * ʹ�õݹ飬ɾ��������������ֵΪelement��Ԫ��
	 * 
	 * @param element 
	 * 				��ɾ����Ԫ��
	 * @param frontPointer 
	 * 				                 �����ĵ������ͷָ��
	 * @param currentPointer 
	 * 					          ����ɾ������ʱʹ�õĵ�ǰָ�룬���ݲ����ĵ������ͷָ��ĸ���
	 */
		
	public static <T> void deleteAllXWithHead(T element, Pointer frontPointer, Pointer currentPointer) {
		//��ʱָ��
		Pointer tempPointer = new Pointer();
		
		//��ֹ����
		if(currentPointer.getNode() == null) {
			return;
		}

		//ɾ���˽ڵ�
		if(currentPointer.getNode().getData() != null && currentPointer.getNode().getData().equals(element)) {
			//��ǰ�ڵ�Ϊ��һ���ڵ�
				if(!currentPointer.getNode().equals(frontPointer.getNode())) {
				//��ǰ�ڵ㲻Ϊ��һ���ڵ�
				//���������ҵ��˽ڵ��ǰ�����
				tempPointer.setNode(frontPointer.getNode());
				while(!tempPointer.getNode().getNext().equals(currentPointer.getNode())) {
					tempPointer.setNode(tempPointer.getNode().getNext());
				}
							
				currentPointer.setNode(currentPointer.getNode().getNext());
				tempPointer.getNode().setNext(currentPointer.getNode());
						
				deleteAllX(element, frontPointer, currentPointer);
			}
		} else {
			//��ɾ����ǰ�ڵ��ǰ�ڵ�Ϊͷ���
			currentPointer.setNode(currentPointer.getNode().getNext());
			deleteAllX(element, frontPointer, currentPointer);
		}
	}
	
	//������
	/*
	 * ����󣬾������õݹ�
	 * ��ֹ������currentPoint.next = null
	 * �ݹ����壺currentPointָ����һ���ڵ�
	 */
	
	public static void reverse(Pointer currentPoint) {
		Pointer tempPointer = new Pointer();
		//tempPointer.setNode(currentPoint.getNode());
		tempPointer.setNode(currentPoint.getNode().getNext());
		
		if(currentPoint.getNode().getNext() == null) {
			System.out.println(currentPoint.getNode().getData());
			return;
		}
		
		//tempPointer.setNode(tempPointer.getNode().getNext());
		reverse(tempPointer);
		
		if(currentPoint.getNode().getData() != null) {
			System.out.println(currentPoint.getNode().getData());
		}
	}
	
	//������
	/*
	 * ����ָ��minPointer��prePointer���ֱ�ָ��ڶ����ڵ�͵�һ���ڵ�
	 * ����һ����ʱָ��tempPointer��ָ����Сֵ�ڵ��ǰ����㣬��ʼΪͷ���
	 * �ӵڶ����ڵ㿪ʼ��������
	 * 		����ǰ�ڵ�����ݱ�tempPointer��С����tempPointerָ��ǰ�ڵ��ǰ�����
	 * minPointer��prePointer�ֱ�ָ����һ���ڵ�
	 * ֱ��prePointer = nullΪֹ
	 * ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
	 */
	public static void minimum(Pointer frontPointer) {
		//����ָ��minPointer��prePointer���ֱ�ָ��ڶ����ڵ�͵�һ���ڵ�
		Pointer minPointer = new Pointer();
		Pointer prePointer = new Pointer();
		minPointer.setNode(frontPointer.getNode().getNext());
		prePointer.setNode(frontPointer.getNode());
		
		//����һ����ʱָ��tempPointer
		Pointer tempPointer = new Pointer();
		tempPointer.setNode(frontPointer.getNode());
		//����һ����ʱ����temp����ֵΪ�ڶ����ڵ������
		//int temp = (int)frontPointer.getNode().getNext().getData();
		
		/*
		 *  �ӵڶ����ڵ㿪ʼ��������
		 * 		����ǰ�ڵ�����ݱ�temp��С�����丳ֵ��temp
		 * 		��tempPointerָ��ǰ�ڵ��ǰ�����
		 * 	minPointer��prePointer�ֱ�ָ����һ���ڵ�
		 *  ֱ��minPointer = nullΪֹ
		 */
		while(minPointer.getNode() != null) {
			if((int)minPointer.getNode().getData() < (int)tempPointer.getNode().getNext().getData()) {
				tempPointer.setNode(prePointer.getNode());
			}
			minPointer.setNode(minPointer.getNode().getNext());
			prePointer.setNode(prePointer.getNode().getNext());
		}
		
		//ɾ���ڵ�
		tempPointer.getNode().setNext(tempPointer.getNode().getNext().getNext());
	}
	
	//������
	//��ͷ����⣬����ڵ�����ԵĽڵ㻥������(�ڶ����͵�����һ�����������͵����ڶ������Դ����ƣ�
	//ʱ�临�Ӷ�O(n^2) �ռ临�Ӷ�O(n)
	public static void localReverse(Pointer frontPointer) {
		//ָ��ǰһ���ڵ�
		Pointer pre = new Pointer();
		Pointer rear = new Pointer();
		//��ʼ��ָ��
		pre.setNode(frontPointer.getNode());
		//��ʱ�ڵ㣬�����ݴ���Ҫ���������ݴ洢
		Node temp = new Node();
		
		int i = SingleLinkedListTool.sizeOf(frontPointer);
		for(int x = 0, z = i; x < i/2; x++,z--) {
			//��ָ��ָ��������Ľڵ�
			//ǰһ��ָ��
			pre.setNode(pre.getNode().getNext());
			//��һ��ָ��
			rear.setNode(frontPointer.getNode());
			
			for(int y = 0; y < z; y++) {
				rear.setNode(rear.getNode().getNext());
			}
			
			temp.setData(pre.getNode().getData());
			pre.getNode().setData(rear.getNode().getData());
			rear.getNode().setData(temp.getData());
		}
	}
	//���������ϵ����ֽⷨ�����Ӽ�
	//�ⷨһ
	//A.��ͷ���ժ��
	//B.�����Ľڵ���ͷ�巨���뵽ͷ���ĺ���
	//ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
	public static void localReverse2(Pointer frontPointer) {
		//��������ָ��͸���ָ��
		Pointer currentPointer = new Pointer();
		Pointer assistantPointer = new Pointer();

		//��ʼ��ָ��λ��
		currentPointer.setNode(frontPointer.getNode().getNext());
		//��ͷ���ժ��
		frontPointer.getNode().setNext(null);
			
		while(currentPointer.getNode() != null) {
			frontPointer.getNode().setNext(currentPointer.getNode());
			currentPointer.setNode(currentPointer.getNode().getNext());
			frontPointer.getNode().getNext().setNext(assistantPointer.getNode());
			assistantPointer.setNode(frontPointer.getNode().getNext());
		}
	}
	
	//������ �ⷨ��
	/*
	 * ��һ���ڵ��nextָ��null
	 * ��������ָ��p,q,rָ�����ڵ������ڵ�
	 * ��q!=null
	 * 	q.next->p
	 * 	p->q
	 *	q->r
	 *  r->r.next
	 * ͷָ��ָ���µĵ�һ�ڵ�front->p
	 */
	public static void localReverse3(Pointer frontPointer) {
		//��������ָ��p,q,r
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer r = new Pointer();
		//��ʼ��ָ��λ��
		q.setNode(frontPointer.getNode().getNext());
		r.setNode(q.getNode().getNext());

		//��һ���ڵ��nextָ��null
		q.getNode().setNext(null);
		
		//����ڵ�
		while(r.getNode() != null) {
			p.setNode(q.getNode());
			q.setNode(r.getNode());
			r.setNode(r.getNode().getNext());
			q.getNode().setNext(p.getNode());
		}
		
		//ͷָ��ָ���µĵ�һ�ڵ�
		frontPointer.getNode().setNext(q.getNode());
	}
	
	/*
	 * ������
	 * ˼�룺�ȹ���ֻ��һ�����ݽڵ��������������֮��Ľڵ㣬�����ҵ����������е�ÿ���ڵ�
	 * A.����ָ��p,q,r
	 * 	���ܣ�
	 *   pָ�����������������еĽڵ�
	 *   q���ڱ�������
	 *   rָ��ֵ��С�Ľڵ�
	 * 	��ʼ����
	 *   p->front.next
	 *   q->p.next
	 *   r
	 *   
	 *  B.�����ڵ㣺temp,min
	 *   ���ܣ�
	 *    min���ڴ洢��С��ֵ
	 *    temp�����ڽ�������ʱ�洢���� 
	 *   ��ʼ����
	 *    temp
	 *    min.data = p.data
	 *   
	 *  ���裺
	 *     Ѱ����Сֵ
	 *   A.��q.data��min.data�Ƚ�
	 *   	��С����min.data = q.data,r->q
	 *   B.q->q,next
	 *   C.�ظ�A,Bֱ��q == null
	 *     ��������
	 *   D.temp.data = p.data
	 *   E.p.data = min.data
	 *   F.r.data = temp.data
	 *
	 *   G.p->p.next
	 *   H.�ظ�A-Fֱ��p == null
	 *   
	 */
	public static void increase(Pointer frontPointer) {
		//����ָ��p,q,r
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer r = new Pointer();
		//��ʼ��ָ��
		p.setNode(frontPointer.getNode().getNext());
		
		
		//�����ڵ㣺temp,min
		Node temp = new Node();
		Node min = new Node();
		Node exchangJudge = new Node();
		
		//�ظ�A-Fֱ��p == null
		while(p.getNode() != null) {
			//��ʼ��ָ��
			q.setNode(p.getNode().getNext());
			//��ʼ���ڵ�
			min.setData(p.getNode().getData());
			exchangJudge.setData(min.getData());
			//Ѱ����Сֵ
			//�ظ�A,Bֱ��q == null
			while(q.getNode() != null) {
				//��q.data��min.data�Ƚ�
				if((int)q.getNode().getData() < (int)min.getData()) {
					min.setData(q.getNode().getData());
					r.setNode(q.getNode());
				}
				//q->q,next
				q.setNode(q.getNode().getNext());
			}
			
			if(!exchangJudge.getData().equals(min.getData())){
				//��������
				//temp.data = p.data
				temp.setData(p.getNode().getData());
				//p.data = min.data
				p.getNode().setData(min.getData());
				//r.data = temp.data
				r.getNode().setData(temp.getData());
			}
			//p->p.next
			p.setNode(p.getNode().getNext());
		}
	}
	
	// ������
	// ���ϵ��㷨˼·�����෴��������ͨ������ָ��ʵ��
	// �ң�ȷ����������Ľڵ�λ�ã�ͨ���������µĽڵ��ҵ�Ӧ���Ǹ�λ���ϵĽڵ�
	// �飺ȷ�����½ڵ��е�ĳ���ڵ㣬ͨ���������������ҵ��ýڵ������������е�λ��
	/*
	 * ָ�룺pre,p,r
	 * ���ã�
	 * 	pre:ָ��ڵ�������������Ӧ��λ�õ�ǰ�����
	 *  p��ָ�����½ڵ��ĳ���ڵ�
	 *  r��ָ��p�ĺ�̽ڵ㣬��ֹ����
	 * 
	 * ��ʼ����
	 * 	A.����һ���ڵ㿴����������,����һ���ڵ��next��ֵΪnull
	 *  B.preָ��ͷ���
	 *  C.pָ��ڶ����ڵ�
	 *  D.rָ��p
	 * ���裺
	 *  A.r->p.next
	 * 	B.ʹ��pre������������
	 * 		pre.next != null && pre.next.data < p.dataʱ
	 *      pre->pre.next,����p�ڵ����pre�ڵ�֮��
	 *  C.p->p.next
	 *    pre->ͷָ��
	 *  D.�ظ�A-C��ֱ��p == null
	*/
	public static void increase2(Pointer frontPointer) {
		//ָ�룺pre,p,r
		Pointer pre = new Pointer();
		Pointer p = new Pointer();
		Pointer r = new Pointer();
		
		//��ʼ��
		//preָ��ͷ���
		pre.setNode(frontPointer.getNode());
		//pָ��ڶ����ڵ�
		p.setNode(pre.getNode().getNext().getNext());
		//rָ��p
		r.setNode(p.getNode());
		//����һ���ڵ㿴����������,����һ���ڵ��next��ֵΪnull
		pre.getNode().getNext().setNext(null);
		
		
		//�ظ�A,B��ֱ��p == null
		while(p.getNode() != null) {
			//ָ��r���ƶ�����ָ��p֮ǰ����p==nullʱ��ָ��r�ƶ�����ָ���쳣
			r.setNode(p.getNode().getNext());
			//ʹ��pre������������
			//pre.next != null && pre.next.data < p.dataʱ
			//pre->pre.next,����p�ڵ����pre�ڵ�֮��
			while(pre.getNode().getNext() != null && (int)pre.getNode().getNext().getData() < (int)p.getNode().getData()) {
				pre.setNode(pre.getNode().getNext());
			}
			//����p�ڵ����pre�ڵ�֮��
			p.getNode().setNext(pre.getNode().getNext());
			pre.getNode().setNext(p.getNode());
			
			//p->p.next
			//r->p.next
			//pre->ͷָ��
			p.setNode(r.getNode());
			pre.setNode(frontPointer.getNode());
		}
	}
	
	/*
	 * ������
	 * ָ��
	 *  ����:p,q
	 *  ���ã�qָ����жϵĽڵ�
	 *  	pָ��q��ǰ����㣬����ɾ������
	 *  ��ʼ����p = frontPointer
	 *  	 q = frontPointer->next
	 *  
	 *  ���裺
	 *  	A.�ж�q.data�Ƿ����
	 *  		a.����
	 *  			p->next = q->next
	 *  			q = q->next
	 *   		b.������
	 *   			p = q
	 *   			q = q->next
	 *   	B.�ظ�A��ֱ��q == null
	 */
	public static void delBetween(int min, int max, Pointer frontPointer) {
		//����ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		//��ʼ��ָ��
		p.setNode(frontPointer.getNode());
		q.setNode(frontPointer.getNode().getNext());
		
		//�ظ�A��ֱ��q == null
		while(q.getNode() != null) {
			//�ж�q.data�Ƿ����
			if((int)q.getNode().getData() < max && (int)q.getNode().getData() > min) {
				p.getNode().setNext(q.getNode().getNext());
				q.setNode(q.getNode().getNext());
			} else {
				p.setNode(q.getNode());
				q.setNode(q.getNode().getNext());
			}
		}
	}
	
	// �ڰ���
	// ˼·
	// 	��һ�������ÿ���ڵ�ȥ����һ����������нڵ���бȽϣ�ʱ�临�Ӷ�O(n^2)���ռ临�Ӷ�O(1)
	// 	�����б���Ƚϣ�n1��m1֮��Ƚϣ�m1��n2֮��Ƚϣ�n2��m2֮��Ƚϣ��Դ����ƣ�ʵ�������һ�ַ���һģһ��
	// ʵ��
	//  ָ�룺p,q
	//  ���ã��ֱ�ָ������������ĵ�һ�����
	//  ��ʼ����p = frontPointer1->next
	//       q = frontPointer2->next
	//	���飺Node[]
	//  ���ã����湲ͬ�Ľڵ�
	//  ��ʼ��:����������ĳ���
	//  ���裺
	//   A.p->data��q->data�Ƚ�
	//   	a.��ͬ
	//			���ýڵ����Node[]��
	//      b.��ͬ
	//	���²�����
	/*
	 * ˼·��
	 *  ���ϣ�
	 *  ��������Ľṹ�����ԣ�������������ڹ����ڵ㣬�򹫹��ڵ�֮��Ľڵ㶼Ϊ�����ڵ�
	 *  Ҳ����˵�����ǵ��ز��ṹΪ��Y����������Ϊ��X��
	 *  ����ζ��ֻ��Ҫ�ҵ���һ�������ڵ㼴�ɣ����๫���ڵ����������Ҫʱ�ҳ������������������β�ڵ��ǹ����ڵ�
	 *  ��Ҫע����ǣ�����������ĳ��Ȳ�һ����ͬ���������ͬʱ��ͷ�����������������ҵ������ڵ�
	 *  �����Ҫ�Ƚ�������������߳���֮����ڵ㣬��ͬʱ�����������ҳ������ڵ�
	 * ʵ��
	 *  ������
	 *   ָ�룺longP��shortP
	 *   ���ã��ֱ�ָ������Ͷ������ͷ���
	 *   ��ʼ����������
	 *  ����:
	 *   A.ʹ��sizeOf()����������������֮��
	 *   B.������������߳���֮����ڵ�
	 * 	 C.������ͬʱ�������ȽϽڵ��Ƿ���ͬ
	 * 		a.��ͬ
	 * 			return �ڵ�
	 * 		b.��ͬ
	 * 			���������Ƚ�
	 */
	public static Node publicNode(Pointer frontPointer1, Pointer frontPointer2) {
		//����ָ��
		Pointer longP = new Pointer();
		Pointer shortP = new Pointer();
		//��ʼ��ָ��
		//�����жϵ�������
		int size1 = sizeOf(frontPointer1);
		int size2 = sizeOf(frontPointer2);
		int difference = 0;
		if (size1 > size2) {
			longP.setNode(frontPointer1.getNode());
			shortP.setNode(frontPointer2.getNode());
			difference = size1 - size2;
		} else {
			longP.setNode(frontPointer2.getNode());
			shortP.setNode(frontPointer1.getNode());
			difference = size2 - size1;
		}
		
		//������������߳���֮����ڵ�
		for(int x = 0; x < difference; x++) {
			longP.setNode(longP.getNode().getNext());
		}
		
		//������ͬʱ�������ȽϽڵ��Ƿ���ͬ
		//��Ϊ��Ȼ���ڹ����ڵ㣬����ѭ������Ϊtrue
		while(true) {
			if (longP.getNode() == shortP.getNode()) {
				return longP.getNode();
			} else {
				longP.setNode(longP.getNode().getNext());
				shortP.setNode(shortP.getNode().getNext());
			}
		}
	}
	
	/*
	 * �ھ���
	 * ˼·
	 *  �Ƚ������������У������ο�������
	 *  Ȼ�����������ɾ���ڵ�
	 *  ʱ�临�Ӷ�O(n^2),�ռ临�Ӷ�O(1)
	 *  
	 * ʵ��
	 *  ����
	 *   ָ�룺p
	 *   ���ܣ������������ɾ���Ľڵ�
	 *   ��ʼ����pָ����������ĵ�һ���ڵ�
	 *  ����
	 *   A.ʹ��increase2()��������������
	 *   B.�����ɾ������
	 *   	a.���p->data
	 *      b.head->next = p->next
	 *      c.p = p->next
	 *   C.�ظ�A,B��ֱ��p == null
	 */
	public static void increaseShow(Pointer head) {
		//����ָ��
		Pointer p = new Pointer();
		
		//��������������
		increase2(head);
		
		//��ʼ��ָ��
		p.setNode(head.getNode().getNext());
		
		//�����ɾ������
		//�ظ�A,B��ֱ��p == null
		while(p.getNode() != null) {
			System.out.println(p.getNode().getData());
			head.getNode().setNext(p.getNode().getNext());
			p.setNode(p.getNode().getNext());
		}
	}
	
	/*
	 * �ھ���
	 * ����˼·
	 *  ����ָ��pre��p��pΪ����ָ�룬preΪ��Сֵ�ڵ��ǰ��ָ��
	 *  ����������p->data < pre->next->data����pre = p,p = p->next
	 *         ����p = p->next
	 *  ������������ɾ��pre->next
	 *  Ȼ���ٴδ�ͷ����
	 *  
	 * �о��ҵ�˼·����һ��
	 * 
	 * ʵ�ּ�������
	 */
	
	/*
	 * ��ʮ��
	 * ˼·��
	 * 	A.��������B��ͷ���
	 * 	B.��������A��ÿ�����Ϊż���Ľڵ㣬�����A�۵�B��
	 * 
	 * ʵ�֣�
	 *  ָ�룺
	 * 		������
	 * 			ָ��p,q,headB
	 *  	���ã�
	 *  		p:ָ������ڵ��ǰ�����
	 *  		q��ָ������ڵ�
	 *  		headB������B��ͷ���
	 *      	r:ָ������B�����һ���ڵ�
	 *  	��ʼ����
	 *  		p = frontPointer
	 *      	q = p->next
	 *      	headB=listHeadB
	 *      	r = headB
	 *	�ڵ㣺
	 *		������
	 *			����B��ͷ���
	 * ���裺
	 * 	A.��������A
	 * 		a.��ǰ�ڵ����Ϊż��
	 * 			p->next = q->next
	 * 			r->next = q
	 * 			r = q
	 * 			r->next = null
	 * 			q = p->next
	 * 			
	 *  	b.��ǰ�ڵ����Ϊ����
	 *  		p = q
	 *        	q = q->next
	 */
	public static Pointer mkDouble(Pointer frontPointer) {
		//����ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer headB = new Pointer();
		Pointer r = new Pointer();
		
		//����B��ͷ���
		Node listHeadB = new Node();
		
		//��ʼ��ָ��
		p.setNode(frontPointer.getNode());
		q.setNode(p.getNode().getNext());
		headB.setNode(listHeadB);
		r.setNode(headB.getNode());
		
		
		int i = 0;
		while(q.getNode() != null) {
			if(++i % 2 == 0 ) {
				p.getNode().setNext(q.getNode().getNext());
				r.getNode().setNext(q.getNode());
				r.setNode(q.getNode());
				r.getNode().setNext(null);
				q.setNode(p.getNode().getNext());
			} else {
				p.setNode(q.getNode());
				q.setNode(q.getNode().getNext());
			}
		}
		
		return headB;
	}
	
	//��ʮһ��
	/*
	 * �����͵�ʮ��һ��
	 */
	
	//��ʮ����
	/*
	 * ˼·��
	 * 	�ҵ������ظ���ֵ�����һ��ֵ������ĺ�̽ڵ����һ���ظ�ֵ��ǰ���������
	 * 		����˼·��
	 * 			1���ҵ�һ���ظ�ֵ��ɾ��һ���ظ�ֵ
	 * 			2����ͷ���ժ�£���ʣ��ڵ���Ϊ�½ڵ���뵽ͷ���֮������ֵ��ǰ���ڵ��ֵ�ظ��򲻲���
	 * ʵ��
	 * 	ָ��
	 * 		����
	 * 			p��ָ������ڵ��ǰ�����
	 * 			q��ָ������ڵ�
	 * 		��ʼ��
	 * 			p = frontPointer
	 * 			q = p
	 * 	����
	 * 		��q->next != null
	 * 			q = p->next
	 * 				A.��q->next == null
	 *  				return
	 * 				B.��q->next->data = q->data
	 * 					q -> q.next ֱ��q->next->data ��= q->data
	 * 					p->next = q->next
	 * 				c.��q->next->data ��= q->data
	 * 					p = q
	 */
	public static void deleteRepeat(Pointer frontPointer) {
		//����ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		
		//��ʼ��ָ��
		p.setNode(frontPointer.getNode()); 
		q.setNode(p.getNode());
		
		while (q.getNode().getNext() != null) {
			q.setNode(p.getNode().getNext());
			
			//��q�ƶ�������ĩβ�����
			if(q.getNode().getNext() == null) {
				return;
			}
			
			if(q.getNode().getNext().getData() == q.getNode().getData()) {
				//while�ĵ�һ�������Ƿ�ֹ��������󼸸��ڵ��ֵ���ظ�ʱ��ָ��������������һ���ڵ�ʱ�Ŀ�ָ���쳣
				while(q.getNode().getNext() != null && q.getNode().getNext().getData() == q.getNode().getData()) {
					q.setNode(q.getNode().getNext());
				}
				p.getNode().setNext(q.getNode().getNext());
			} else {
				p.setNode(q.getNode());
			}
		}
	}
	
	//��ʮ����
	/*
	 * ˼·
	 * 	������A��ͷ���ժ��
	 * 	�������������ȡ��һ���ڵ㣬��Ϊ�ڵ�a������A�����ڵ�1������B��
	 * 	�ȽϽڵ�a�ͽڵ�1��ֵ
	 * 	���ڵ�a<=�ڵ�1���򽫽ڵ�a����ͷ���A��
	 * 	�ظ����ϲ���
	 * 
	 * ʵ��
	 * 	ָ��
	 * 		����
	 * 			p:ָ������A�Ĳ����ڵ�
	 * 			q��ָ��p�ĺ�̽ڵ㣬���ڽ�p�û�����A
	 * 			e��ָ������B�Ĳ����ڵ�
	 * 			r��ָ��e�ĺ�̽ڵ㣬���ڽ�e�û�����B
	 * 		��ʼ��
	 * 			p = headA->next
	 * 			q = p->next
	 * 			e = headB->next
	 * 			r = e->next
	 * ����
	 * 	A.������A��ͷ���ժ��
	 * 	B.�Ƚ�p->data��e->data
	 * 		��p->data < e->data
	 * 			p->next = headA->next
	 * 			headA->next = p
	 * 			p = q
	 * 			q = p->next
	 * 		����
	 * 			e->next = headA->next
	 * 			headA->next = e
	 * 			e = r
	 * 			r = e->next
	 * 	C.��p != null && e != null�ظ�A
	 * 	D.һ�����������Ϻ�����һ��������ʣ��ڵ㣬��ȫ�����뵽headA����
	 * 		��q != null
	 * 			p->next = headA->next
	 * 			headA->next = p
	 * 			p = q
	 * 			q = p->next
	 * 			�ظ���ֱ��q == null
	 *    	��r != null
	 *	    	e->next = headA->next
	 * 			headA->next = e
	 * 			e = r
	 *	 		r = e->next
	 * 			�ظ���ֱ��r == null
	 */
	public static Pointer dualIncreaseToSingleDecrease(Pointer headA, Pointer headB) {
		//����ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer e = new Pointer();
		Pointer r = new Pointer();
		
		//��ʼ��ָ��
		p.setNode(headA.getNode().getNext());
		q.setNode(p.getNode().getNext());
		e.setNode(headB.getNode().getNext());
		r.setNode(e.getNode().getNext());
		
		//ժ������A��ͷ���
		headA.getNode().setNext(null);
		
		//��q != null && r != null�ظ�A
		while(p.getNode() != null && e.getNode() != null) {
			//�Ƚ�p->data��e->data
			if((int)p.getNode().getData() < (int)e.getNode().getData()) {
				p.getNode().setNext(headA.getNode().getNext());
				headA.getNode().setNext(p.getNode());
				p.setNode(q.getNode());
				
				//������ĩβ�ڵ�󣬺���ָ�벻��ҪҲ�����ٺ�����
				if(p.getNode() != null) {
					q.setNode(p.getNode().getNext());
				}
			} else {
				e.getNode().setNext(headA.getNode().getNext());
				headA.getNode().setNext(e.getNode());
				e.setNode(r.getNode());
				
				//������ĩβ�ڵ�󣬺���ָ�벻��ҪҲ�����ٺ�����
				if(e.getNode() != null) {
					r.setNode(e.getNode().getNext());
				}
			}
		}
		
		//һ�����������Ϻ�����һ��������ʣ��ڵ㣬��ȫ�����뵽headA����
		if(p.getNode() != null) {
			p.getNode().setNext(headA.getNode().getNext());
			headA.getNode().setNext(p.getNode());
			p.setNode(q.getNode());
			
			//������ĩβ�ڵ�󣬺���ָ�벻��ҪҲ�����ٺ�����
			if(p.getNode() != null) {
				q.setNode(p.getNode().getNext());
			}
		}
		
		if(e.getNode() != null) {
			e.getNode().setNext(headA.getNode().getNext());
			headA.getNode().setNext(e.getNode());
			e.setNode(r.getNode());
			
			//������ĩβ�ڵ�󣬺���ָ�벻��ҪҲ�����ٺ�����
			if(e.getNode() != null) {
				r.setNode(e.getNode().getNext());
			}
		}
		
		return headA;
 	}
	
	//��ʮ����
	/*
	 * ˼·����������������ʹ�ö��ֲ���ʱ�����ֵ�Ľڵ���Ҫ��ͷ���������ǻ�����ֱ�ӱ������Ƚϣ�
	 * 	����������A��ʹ�ö��ֲ����ڵ�����B�в��ҵ�����A�е����нڵ��ֵ
	 * 	��������B������ֵͬ�Ľڵ㣬���½��ڵ㣬������ͬ��ֵ�������뵽������C��ĩβ
	 * 
	 * ˼·
	 * 	����������A����ȡÿ���ڵ�
	 * 	��ÿ���ڵ�ֵ������B�еĽڵ��ֵ�Ƚ�
	 * 	������ͬ�ģ�����ֵ����һ���µĽڵ㲢���뵽������C��ĩβ
	 *  ����ǰ�������ĵ�����B�еĽڵ��ֵ���ڵ�����ڵ�A��ֵ����ֹͣ����������B
	 * ʵ��
	 * 	����
	 * 		�ڵ�
	 * 			headNodeC��������C��ͷ���
	 * 		ָ��
	 * 			p:ָ������A�Ĵ��ȽϽڵ�
	 * 			q:ָ������B�Ĵ��ȽϽڵ�
	 * 			e:ָ��q��ǰ����㣬�����Ϳ��Դӱ�ǰһ��p->data���ֵ��ʼ�Ƚϣ�ʡȥ��ͷ�Ƚϵ�ʱ��
	 * 			r:ָ������C��β�ڵ�
	 * 			headC��ָ������C��ͷ���
	 *  ��ʼ��
	 *  	�ڵ�
	 *  		headNodeC
	 *  	ָ��
	 *  		p = headA
	 *  		q = headB
	 *  		headC = headNodeC
	 *  		r = headC
	 *  
	 *  ���裺
	 *  	A.�Ƚϵ�����A�͵�����B�нڵ��ֵ
	 *  		a.��p->data == q->data
	 *   			new Node temp
	 *   			temp->data = p->data
	 *   			r->next = temp
	 *   			r = r->next
	 *   			break
	 *   
	 *   		b.��p->data < q->data
	 *    			break
	 *    
	 *   	B.��q->next != nullʱ��q = q->next,�ظ�A
	 *   	C.��p->next != nullʱ��p = p->next,q = headB,�ظ�A��B
	 *  	
	 */
	public static Pointer publicNodeWithNewList(Pointer headA, Pointer headB) {
		//�����ڵ�
		Node headNodeC = new Node();
		//����ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer e = new Pointer();
		Pointer r = new Pointer();
		Pointer headC = new Pointer();
		
		//��ʼ��ָ��
		p.setNode(headA.getNode());
		q.setNode(headB.getNode());
		headC.setNode(headNodeC);
		r.setNode(headC.getNode());
		
		while(p.getNode().getNext() != null) {
			p.setNode(p.getNode().getNext());
			
			while(q.getNode().getNext() != null) {
				e.setNode(q.getNode());
				q.setNode(q.getNode().getNext());
				
				if((int)p.getNode().getData() == (int)q.getNode().getData()) {
					Node temp = new Node((int)p.getNode().getData());
					r.getNode().setNext(temp);
					r.setNode(r.getNode().getNext());
					break;
				}
				
				if((int)p.getNode().getData() < (int)q.getNode().getData()) {
					q.setNode(e.getNode());
					break;
				}
			}
		}
		
		return headC;
	}
	
	//��ʮ���� ���Ϸ���
	/*
	 * ˼·��
	 * 	ͬʱ����������������ȡһ���ڵ�
	 * 	�Ƚ������ڵ��ֵ
	 * 	������ȣ���ָ���Сֵ�Ľڵ��ָ�����һ��
	 * 	����ȣ��򴴽�һ���½ڵ㣬����ֵ��ֵ���½ڵ㲢������뵽����Cĩβ
	 * 
	 * ʵ��
	 * 	����
	 * 		�ڵ�
	 * 			nodeHeadC��������C��ͷ���
	 * 		ָ��
	 * 			p:ָ������A���ȽϵĽڵ�
	 * 			q:ָ������B���ȽϵĽڵ�
	 * 			headC:ָ������C��ͷ���
	 * 			r:ָ������C��β�ڵ�
	 * 	��ʼ��
	 * 		p = headA->next
	 * 		q = headB->next
	 * 		headC = nodeHeadC
	 * 		r = nodeHeadC
	 * 		
	 *  ����
	 *  	A.�Ƚ�p->data��q->data
	 *  		��p->data == q->data
	 *  			new Node(p->data) temp
	 *  			r->next = temp
	 *  			r = r->next
	 *  			p = p->next
	 *  			q = q->next
	 *  		��p->data < q->data
	 *  			p = p->next
	 *  		��p->data > q->data
	 *  			q = q->next
	 *  	B.��p != null && q != null,�ظ�A
	 */
	public static Pointer publicNodeWithNewList2(Pointer headA, Pointer headB) {
		//�����ڵ�
		Node nodeHeadC = new Node();
		//����ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer headC = new Pointer();
		Pointer r = new Pointer();
		
		//��ʼ��ָ��
		p.setNode(headA.getNode().getNext());
		q.setNode(headB.getNode().getNext());
		headC.setNode(nodeHeadC);
		r.setNode(nodeHeadC);
		
		//��p != null && q != null,�ظ�A
		while(p.getNode() != null && q.getNode() != null) {
			//�Ƚ�p->data��q->data
			if((int)p.getNode().getData() == (int)q.getNode().getData()) {
				Node temp = new Node(p.getNode().getData());
				r.getNode().setNext(temp);
				r.setNode(r.getNode().getNext());
				p.setNode(p.getNode().getNext());
				q.setNode(q.getNode().getNext());
			} else if((int)p.getNode().getData() < (int)q.getNode().getData()) {
				p.setNode(p.getNode().getNext());
			} else if((int)p.getNode().getData() > (int)q.getNode().getData()) {
				q.setNode(q.getNode().getNext());
			}
		}
		
		return headC;
	}
	
	//��ʮ����
	/*
	 * ˼·
	 * 	ժ������A��ͷ���
	 * 	ͬʱ����������������ȡһ���ڵ�
	 * 	�Ƚ������ڵ��ֵ
	 * 	������ȣ���ָ���Сֵ�Ľڵ��ָ�����һ��
	 * 	����ȣ�������һ���ڵ���뵽ͷ���A�ı�β
	 * ʵ��
	 * 	�ο���ʮ����
	 */
	public static Pointer intersection(Pointer headA, Pointer headB) {
		//����ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer r = new Pointer();
				
		//��ʼ��ָ��
		p.setNode(headA.getNode().getNext());
		q.setNode(headB.getNode().getNext());
		r.setNode(headA.getNode());
		
		//��headA��ͷ���ժ��
		headA.getNode().setNext(null);
		
		//��p != null && q != null,�ظ�A
		while(p.getNode() != null && q.getNode() != null) {
			//�Ƚ�p->data��q->data
			if((int)p.getNode().getData() == (int)q.getNode().getData()) {
				r.getNode().setNext(p.getNode());
				r.setNode(r.getNode().getNext());
				p.setNode(p.getNode().getNext());
				q.setNode(q.getNode().getNext());
			} else if((int)p.getNode().getData() < (int)q.getNode().getData()) {
				p.setNode(p.getNode().getNext());
			} else if((int)p.getNode().getData() > (int)q.getNode().getData()) {
				q.setNode(q.getNode().getNext());
			}
		}
				
		//�����������A��β�ڵ������̽ڵ�Ͽ�
		r.getNode().setNext(null);
		
		return headA;
	}
	
	//��ʮ����
	/*
	 * ˼��
	 * 	����������A
	 * 	����ڵ��ֵ�뵥����B�ĵ�һ���ڵ��ֵ�Ƚ�
	 * 		����ͬ����������������A��������β������false
	 * 		����ͬ��������B�ӵ�һ���ڵ㿪ʼͬʱ�뵥����A����
	 * 			�������ڵ���ͬ�����������������������B�ı�β������true
	 * 			�������ڵ㲻ͬ������false
	 * ʵ��
	 * 	����
	 * 		ָ��
	 * 			p:ָ������A�Ĵ��жϽڵ�
	 * 			q��ָ������B�Ĵ��жϽڵ�
	 * 	��ʼ��
	 * 		ָ��
	 * 			p = headA->next
	 * 			q = headB->next
	 * ����
	 * 	A.�Ƚ�p->data��q->data
	 * 		a.p->data == q->data
	 * 			1.p = p->next
	 * 			2.q = q->next
	 * 		b.p->data != q->data
	 * 			p = p->next
	 * 		
	 *  B.�ظ�A��ֱ��p == null || q == null
	 * 			
	 *	 		3.��q == null
	 * 				return true
	 * 			��p == null && q != null	
	 * 				return false
	 * 	B.return
	 */
	public static boolean isContinuousSequence(Pointer headA, Pointer headB) {
		//����ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		//��ʼ��ָ��
		p.setNode(headA.getNode().getNext());
		q.setNode(headB.getNode().getNext());
		
		//���
		boolean flag = false;
		
		//Ѱ��������������A�еĵ�һ���ڵ�
		while(p.getNode().getData() != q.getNode().getData() && p.getNode() != null) {
			p.setNode(p.getNode().getNext());
		}
		
		//�ж�����B�ǲ�������A������������
		while(p.getNode() != null && q.getNode() != null) {
			if((int)p.getNode().getData() == (int)q.getNode().getData()) {
				p.setNode(p.getNode().getNext());
				q.setNode(q.getNode().getNext());
			} else {
				break;
			}
		}
		
		if(q.getNode() == null) {
			flag = true;
		} else if(p.getNode() == null && q.getNode() != null) {
			flag = false;
		}
		
		return flag;
	}
	
	//�ڶ�ʮһ��
	/*
	 * 1���������˼��
	 * 	��������ָ�����p,q��
	 * ��qָ��ָ��ͷ��㣬Ȼ��qָ�����k���ڵ㡣
	 * ��pָ��ָ������ĵ�һ���ڵ㡣
	 * ����ָ��ͬ�����ƣ�ֱ��qָ���ƶ������һ���ڵ㣬pָ��ָ��ļ��ǵ�����k���ڵ㡣
	 * 2����ϸʵ�ֲ���
	 * 	A.��������ָ��p,q
	 * 	B.qָ�����ȴӱ�ͷ����
	 * 	C.��qָ��Ľڵ�ĺ�̽ڵ�Ϊnull����˵��q������β�����ƶ�����k�Σ���˵���õ�����û�е�����k���ڵ㣬����0����������G
	 *  D.��pָ���һ���ڵ�
	 *  E.p��qͬʱ���ƣ�ֱ��qָ��β�ڵ㣬���ҳɹ�
	 *  F.���pָ��Ľڵ��data���ֵ��������1
	 *  G.�㷨����
	 */
	public static int lastK(Pointer head, int k) {
		//��������ʼ��ָ��
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		
		q.setNode(head.getNode());
		
		//qָ�����ȴӱ�ͷ����k��
		for(int x = 0; x < k; x++) {
			if(q.getNode().getNext() == null) {
				return 0;
			}
			q.setNode(q.getNode().getNext());
			
		}
		
		//��qָ����ڵĽڵ㣬����pָ���һ���ڵ�
		p.setNode(head.getNode().getNext());
		
		//p��qͬʱ���ƣ�ֱ��qָ��β�ڵ�
		while(q.getNode().getNext() != null) {
			q.setNode(q.getNode().getNext());
			p.setNode(p.getNode().getNext());
		}
		
		//���pָ��Ľڵ��data���ֵ��������1
		System.out.println(p.getNode().getData());
		return 1;
	}
	
	//�ڶ�ʮһ��
	/*
	 * 1�����˼��
	 * 	��������ָ�����p,q���ֱ�ָ������str1�͵�����str2�ĵ�һ���ڵ㡣
	 * 	����������str2����pָ��Ľڵ��qָ��Ľڵ���бȽϡ�
	 * 	����ͬ���򷵻�ָ��p
	 * 	����ͬ����ָ��q�ƶ�����һ���ڵ㣬ֱ��qָ��βָ��
	 * 	�ƶ�ָ��p����һ���ڵ㣬�ظ��������裬ֱ��pָ��βָ��
	 * 3��ʱ�临�Ӷ� O(mn)
	 */
	public static Pointer findPublic(Pointer head1, Pointer head2) {
		//��������ʼ��ָ�����
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		p.setNode(head1.getNode().getNext());
		q.setNode(head2.getNode().getNext());
		
		//����ֵ
		Pointer r = null;
		
		while(p.getNode() != null) {
			//str2������һ�˺󣬽�ָ��q��ʼ��
			q.setNode(head2.getNode().getNext());
			
			while(q.getNode() != null) {
				if(p.getNode() == q.getNode()) {
					r = p;
					return r;
				} else {
					q.setNode(q.getNode().getNext());
				}
			}
			
			p.setNode(p.getNode().getNext());
		}
		
		return r;
	}
	
	//�ڶ�ʮ����
	/*
	 * ���Ϸ���
	 *  1������˼��
	 *  	A.�ֱ������������ĳ���len1,len2
	 *  	B.�������������Ա�β���룺��ָ��p,q�ֱ�ָ��str1��str2��ͷ�ڵ㣬
	 *  	       ��len1��len2����ָ��pָ���len1-len2+1���ڵ�
	 *  	       ��len1<len2����ָ��qָ���len1-len2+1���ڵ�
	 *  	C.�����ڵ�ͬ�����ƣ�ֱ��q=p����Ϊ��ͬ��׺����ʼλ�ã��㷨����
	 *  2��ʱ�临�Ӷ� O(m+n)
	 */
	public static int length(Pointer head) {
		int x = 0;
		Pointer p = new Pointer();
		p.setNode(head.getNode());
		
		while(p.getNode().getNext() != null) {
			p.setNode(p.getNode().getNext());
			x++;
		}
		
		return x;
	}
	public static Pointer findPublic2(Pointer head1, Pointer head2) {
		//�ֱ������������ĳ���m,n
		int len1 = length(head1);
		int len2 = length(head2);
		
		//�������������Ա�β����
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		p.setNode(head1.getNode());
		q.setNode(head2.getNode());
		
		if(len1 >= len2) {
			for(int x = 0; x < (len1 - len2); x++) {
				p.setNode(p.getNode().getNext());
			}
		} else {
			for(int x = 0; x < (len2 - len1); x++) {
				q.setNode(q.getNode().getNext());
			}
		}
		
		//Ѱ�ҹ�ͬ��׺����ʼλ��
		while(q.getNode() != p.getNode()) {
			q.setNode(q.getNode().getNext());
			p.setNode(p.getNode().getNext());
		}
		
		return p;
	}
	
	//��23��
	/*
	 * 1������˼��
	 * 	A.��ͷ���͵�һ����Ԫ�صĽڵ�ժ�£�����������B
	 * 	B.����ȡ��ʣ��ڵ㲢�뵥����B�е����нڵ�Ƚ����ߵ�data�ľ���ֵ
	 * 		a.��������ȣ���ȡ�µĽڵ���뵽������B�ı�β
	 * 		b.������ȣ��򲻲���
	 * 4��ʱ�临�Ӷ� O(n^2) �ռ临�Ӷ�O(1)
	 */
	public static void differAbsoluteValue(Pointer head) {
		//����ָ��p��ָ��ԭ�����д��ȽϵĽڵ�
		Pointer p = new Pointer();
		p.setNode(head.getNode().getNext().getNext());
		//����ָ��r��ָ��p�ĺ�̽ڵ�
		Pointer r = new Pointer();
		//����ָ��q��ָ������B�д��ȽϵĽڵ�
		Pointer q = new Pointer();
		q.setNode(head.getNode().getNext());
				
		//��ͷ���͵�һ����Ԫ�صĽڵ�ժ�£�����������B
		head.getNode().getNext().setNext(null);
		
		while(p.getNode().getNext() != null) {
			//�Ƚ�p->data��q->data�ľ���ֵ������������������ԭ����
			if(Math.abs((int)p.getNode().getData()) != Math.abs((int)q.getNode().getData())) {
				//��q->data��p->data���ȣ��ж�q�ǲ�������B�����һ���ڵ㣬����p���뵽q֮�󣬷��������������B
				if(q.getNode().getNext() != null) {
					q.setNode(q.getNode().getNext());
				} else {
					q.getNode().setNext(p.getNode());
					r.setNode(p.getNode().getNext());
					p.getNode().setNext(null);
					p.setNode(r.getNode());
					q.setNode(head.getNode().getNext());
				}
			} else {
				q.setNode(head.getNode().getNext());
				p.setNode(p.getNode().getNext());
			}
		}
	}
	//��23��
	/*
	 * �����������ÿռ任ʱ�䣺���������¼�������Ѿ����ֵ���ֵ��
	 */
	public static void differAbsoluteValue2(Pointer head, int n) {
		//��Ϊ|data|<=n���������鳤��Ϊn+1���������n����Ŀ�ṩ�����Կ���Ϊ��������֪��
		int[] arr = new int[n+1];
		
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		p.setNode(head.getNode());
		q.setNode(head.getNode().getNext());
		
		while(q.getNode() != null) {
			if(arr[Math.abs((int)q.getNode().getData())] == 0) {
				arr[Math.abs((int)q.getNode().getData())] = 1;
				q.setNode(q.getNode().getNext());
				p.setNode(p.getNode().getNext());
			} else {
				p.getNode().setNext(q.getNode().getNext());
				q.setNode(q.getNode().getNext());
				
			}
		}
	}
}