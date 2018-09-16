package chapter2_3_7;
/**
 * 循环双链表的工具类
 * 
 * @author 一汪
 *
 */
public class CyclicSingleLinkedListTool {
	//带头节点的头插法
	/*
	 * 思路
	 * 	由方法本身提供头结点，而不用用户提供
	 * 提供
	 * 	指针
	 * 		头指针
	 * 	节点
	 * 		待插入
	 * 
	 * 	步骤
	 * 		A.判断该链表是否有头结点
	 * 			没有
	 * 				提供头结点，并添加节点,并建立循环
	 * 			有
	 * 				添加节点
	 */
	/**
	 * 提供头节点的头插法
	 * 
	 * @param head 
	 * 			循环单链表的头指针
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
			headNode.setNext(node);
		} else {
			node.setNext(head.getNode().getNext());
			head.getNode().setNext(node);
		}
	}
	
	
	/**
	 * 不带头结点的头插法
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
			return;
		} else {
			Pointer rear = findRearPointer(head);
			rear.getNode().setNext(node);
			node.setNext(head.getNode());
			head.setNode(node);
		}
	}
	/**
	 * 不带头结点的头插法，效率比不提供尾指针的headAddWithoutHeadPoint高
	 * @param head 
	 * 			执行插入操作的链表的头指针
	 * @param rear
	 * 			执行插入操作的链表的尾指针
	 * @param node
	 * 			待插入的节点
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
	 * 带头结点的尾插法
	 * 
	 * @param head
	 * 			执行插入操作的链表的头指针
	 * @param node
	 * 			待插入的节点
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
	 * 带头结点的尾插法，效率比rearAddWithHeadPoint(Pointer head, Node node)高
	 * @param head
	 * 			执行插入操作的链表的头指针
	 * @param rear
	 * 			执行插入操作的链表的尾指针
	 * @param node
	 * 			待插入的节点
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
	 * 不带头结点的尾插法
	 * 
	 * @param head
	 * 			执行该操作的链表的头结点
	 * @param node
	 * 			待插入的节点
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
	 * 寻找尾节点
	 * @param head
	 * 			执行该操作的链表的头指针
	 * @return	执行该操作的链表的尾指针
	 */
	public static Pointer findRearPointer(Pointer head) {
		//指针
		//Pointer p = head;不能这样，因为这里p实际上操作的是head，会导致之后的while死循环
		Pointer p = new Pointer();
		p.setNode(head.getNode());
		
		while(p.getNode().getNext() != head.getNode()) {
			p.setNode(p.getNode().getNext());
		}
		
		return p;
	}
	
	/**
	 * 打印循环单链表
	 * @param head
	 * 			待打印的链表的头指针
	 */
	public static void show(Pointer head) {
		//创建指针
		Pointer p = new Pointer();
		//初始化指针
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
	
	//第十八题
	/*
	 * 思路
	 * 	分别找到h1,h2的尾节点
	 * 	将h1的尾节点和h2的头节点相连
	 *  将h2的尾节点和h1的头节点相连
	 *  
	 * 实现
	 * 	创建
	 * 		指针
	 * 			rear1：指向h1的尾节点
	 * 			rear2：指向h2的尾节点
	 * 	初始化
	 * 		指针
	 * 			通过findRearPoint(head)
	 * 	步骤
	 * 		A.h1->next = h2
	 * 		B.rear2->next = h1
	 * 时间复杂度O(m+n)
	 */
	public static void mergeH1H2(Pointer h1, Pointer h2) {
		Pointer rear1 = findRearPointer(h1);
		Pointer rear2 = findRearPointer(h2);
		
		rear1.getNode().setNext(h2.getNode());
		rear2.getNode().setNext(h1.getNode());
	}
	
	//第十九题
	/*
	 * 思路
	 * 	很简单，首先取第一个节点，然后依次比较后面的值，若后面的值小，则换它和后面的比，直到找到最小的，输出，删除
	 * 实现
	 * 	创建
	 * 		指针
	 * 			p：指向进行比较的节点的前驱节点
	 * 			q：指向当前最小的节点的前驱节点
	 * 		变量
	 * 			temp：存储当前的最小值
	 *  初始化
	 *  	指针
	 *  		p = head->next
	 *		变量
	 *			temp = p->data
	 *  参数
	 *  	head
	 *  实现
	 *  	A.temp与p->next->data比较
	 *  		若大于
	 *  			temp = p->next->data
	 *  			q = p
	 *  			p = p->next
	 *  		否则
	 *  			p = p->next
	 *  	B.重复A，直到p->next == head
	 *  	C.输出temp
	 *  	D.删除最小值节点
	 *  		q->next = q->next->next
	 *  	E.重复以上操作，直到head->next == head
	 */
	public static void findMinimum(Pointer head) {
		//指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		//初始化指针
		p.setNode(head.getNode());
		
		while(head.getNode().getNext() != head.getNode()) {
			//初始化指针
			p.setNode(head.getNode());
			q.setNode(p.getNode());
			//变量
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
