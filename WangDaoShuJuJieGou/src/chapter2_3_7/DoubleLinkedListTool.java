package chapter2_3_7;
/**
 * 非循环双向链表的工具类
 * 
 * @author 一汪
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
	 * 显示节点的data和freq
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
	
	//第二十题
	/*
	 * 元素不重复
	 * 思路
	 * 	先遍历链表，找到元素与x相同的节点a
	 * 	节点a的freq++
	 * 	然后遍历链表，找到freq小于等于节点a的节点b
	 * 	把a放到b之前
	 * 实现
	 * 	创建
	 * 		指针
	 * 			p:指向元素值与x相同的节点a的前驱节点
	 * 			q：指向freq小于等于节点a的节点的前驱节点
	 * 			r:指向节点a
	 * 	初始化
	 * 		p = head
	 * 		q = head
	 * 	参数
	 * 		head
	 * 		x:值
	 * 	步骤
	 * 		遍历链表，比较p->next->data与x
	 * 			等于
	 * 				r = p->next
	 * 				r->freq = r->freq + 1
	 * 				便利链表，比较q->next->freq与r->freq
	 * 					小于等于
	 * 						若q->next != r 
	 * 							p->next = r->next
	 * 							r->next->prior = p
	 * 							r->next = q->next
	 * 							r->prior = q
	 * 							q->next->prior = r
	 * 							q->next = r
	 * 						若q->next == r
	 * 							return;
	 * 					大于
	 * 						q = q->next
	 * 			不等于
	 * 				p = p->next，直到p->next->next == null
	 */		
	public static void Locate(Pointer head, int x) {
		//指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer r = new Pointer();
		p.setNode(head.getNode());
		q.setNode(head.getNode());
		
		//先遍历链表，找到元素与x相同的节点a
		while(p.getNode().getNext() != null) {
			if(p.getNode().getNext().getData().equals(x)) {
				r.setNode(p.getNode().getNext());
				r.getNode().setFreq(r.getNode().getFreq()+1);
				
				//排序freq
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
