package chapter2_3_7;

/**
 * 循环双链表的工具类
 * 
 * @author 一汪
 *
 */
public class CyclicDoubleLinkedListTool {
	//废弃原因：思路改变，链表的头结点应由方法创建，而不是用户创建
//	//头插法插入指针
//	/* 
//	 * 创建
//	 * 	指针
//	 *		rear:尾指针
//	 *		p:指向当前进行插入的节点
//	 *	初始化
//	 *		p = node	
//	 * 步骤
//	 * 	A.若插入的是尾节点，即插入顺序上的第一个节点,head == null
//	 * 		head = node
//	 * 		rear = node
//	 *  B.若插入的是第二个及以后（插入顺序上）的节点,head != null 
//	 *  	双链表两个节点之间的链接
//	 *  	p->next = head
//	 *  	head->perior = node
//	 *  	head = node
//	 *  	循环双链表头尾节点之间的链接
//	 *  	head->prior = rear
//	 *      rear->next = head      
//	 */
//	/**
//	 * 头插法插入节点，无论是否有头结点
//	 * 插入顺序与实际顺序相反
//	 * @param node
//	 * 			  待插入的节点
//	 * @param head
//	 * 			 当前链表的头指针
//	 */
//	public static void headAdd(Node node, Pointer head, Pointer rear) {
//		//创建指针
//		Pointer p = new Pointer();
//		//初始化指针
//		p.setNode(node);
//		
//		//若插入的是尾节点，即插入顺序上的第一个节点
//		if(head.getNode() == null) {
//			head.setNode(node);
//			rear.setNode(node);
//		} else if(head.getNode() != null) {
//			//若插入的是第二个及以后（插入顺序上）的节点
//			//双链表两个节点之间的链接
//			p.getNode().setNext(head.getNode());
//			head.getNode().setPrior(node);
//			head.setNode(node);
//			//循环双链表头尾节点之间的链接
//			head.getNode().setPrior(rear.getNode());
//			rear.getNode().setNext(head.getNode());
//		}
//	}
//	
	/**
	 * 带头结点的头插法
	 * 
	 * @param head
	 * 			执行插入操作的链表的头指针
	 * @param node
	 * 			待插入的节点
	 */
	public static void headAddWithHeadPoint(Pointer head, Node node) {
		//该表没有头结点
		if(head.getNode() == null) {
			//提供头结点
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
	 * 没有头结点的头插法
	 * 
	 * @param head
	 * 			执行插入操作的链表的头指针
	 * @param node
	 * 			待插入的节点
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
	 * 带头节点的尾插法
	 * 
	 * @param head
	 * 			待插入的链表的头指针
	 * @param node
	 * 			待插入的节点
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
	 * 不带头节点的尾插法
	 * 
	 * @param head
	 * 			待插入的链表的头指针
	 * @param node
	 * 			待插入的节点
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
	 * 寻找尾节点
	 * @param head
	 * 			待寻找尾节点的链表的头指针
	 * @return
	 * 			此链表的尾指针
	 */
	public static Pointer findRearPoint(Pointer head) {
		//Pointer p = head;不能这样，因为这里p实际上操作的是head，会导致之后的while死循环
		Pointer p = new Pointer();
		p.setNode(head.getNode());
		
		while(p.getNode().getNext() != head.getNode()) {
			p.setNode(p.getNode().getNext());
		}
		
		return p;
	}
	
	//显示循环双链表的节点元素
	/*
	 * 思路
	 * 	从头结点开始遍历，直到尾节点
	 * 实现
	 * 	创建
	 * 		指针
	 * 			p：指向当前遍历的节点
	 * 	初始化
	 * 		指针
	 * 			p = head
	 * 	步骤
	 * 		A.若当前节点为头结点
	 * 			p = p->next
	 * 		B.当p != head
	 * 			输出p->data
	 * 			p = p->next
	 */
	/**
	 * 显示循环双链表的节点元素
	 * 头结点的元素不显示
	 * 
	 * @param head
	 * 			  循环双链表的头结点
	 */
	public static void show(Pointer head) {
		//创建指针
		Pointer p = new Pointer();
		//初始化指针
		p.setNode(head.getNode());
		
		//若当前节点为头结点
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
	
	//第十七题
	/*
	 * 思路
	 * 	利用头指针和尾指针，分别获取对应位置的节点的元素并比较
	 * 实现
	 * 	创建
	 * 		指针
	 * 			p：指向待比较的节点1
	 * 			q：指向待比较的节点2
	 * 		标记
	 * 			flag
	 * 	初始化
	 * 		指针
	 * 			p = head
	 * 			q = head
	 * 		标记
	 * 			flag = true
	 * 	步骤
	 * 		A.若 p->next != q->prior && p->next != q
	 * 			a.p = p->next;q = q->prior
	 * 			b.比较p->data与q->data
	 * 				相等，重复A
	 * 				不相等，return false
	 */
	public static boolean issymmetry(Pointer head, Pointer rear) {
		//创建指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		//初始化指针
		p.setNode(head.getNode());
		q.setNode(head.getNode());
		
		//创建标记
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
