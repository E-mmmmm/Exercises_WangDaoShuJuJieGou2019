package chapter2_3_7;

/**
 * 单链表的基本操作类
 * 
 * @author 一汪
 * 
 */
public class SingleLinkedListTool<T> {

	/**
	 * 头插法添加元素
	 * 该方法生成的单链表节点的顺序与添加顺序相反
	 * 
	 * @param node
	 *            添加的节点
	 * @param hp
	 *            头指针
	 */
	public static <T> void frontAdd(Node<T> node, Pointer<T> frontPointer) {
		node.setNext(frontPointer.getNode());
		frontPointer.setNode(node);
	}

	/**
	 * 单链表尾插法添加元素
	 * 
	 * @param node
	 *            添加的节点
	 * @param tp
	 *            尾指针
	 */
	public static <T> void rearAdd(Node<T> node, Pointer<T> rearPointer) {
		if (rearPointer.getNode() != null) {
			rearPointer.getNode().setNext(node);
			// 尾指针指向尾节点
			rearPointer.setNode(node);
		} else {
			rearPointer.setNode(node);
		}
	}

	/**
	 * 显示单链表
	 * 
	 * @param hp
	 *            头指针
	 */
	public static <T> void show(Pointer<T> frontPointer) {
		// 创建临时指针，代替头指针
		Pointer<T> tempPointer = new Pointer<T>();
		tempPointer.setNode(frontPointer.getNode());

		while (tempPointer.getNode() != null) {
			if(tempPointer.getNode().getData() != null) {
				// 显示当前头指针指向的节点的数据
				System.out.println(tempPointer.getNode().toString()+":"+tempPointer.getNode().getData());
			}
			// 将临时指针指向下一个节点
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
	// 第一题
	/*
	 * 使用两个指针，判断指针p指向的节点的直接后继
	 * 以及一个临时指针
	 * 头指针始终指向第一个节点，因此头指针需要一个独立的参数进行赋值
	 * 
	 * 该方法使用三个指针：
	 * 指针currentPointer：用于指向当前的节点，判断当前节点是否需要删除
	 * 指针tempPointer：用于辅助操作
	 * 指针frontPointer：作为头指针始终指向第一个节点，用于遍历单链表以及之后单链表的打印
	 * 
	 * 递归终止条件：currentPointer指向null
	 * A.当前节点为第一个节点时
	 * 	a.要删除
	 * 	 1.tempPointer指向下一个节点
	 *   2.使第一个节点断链
	 *   3.currentPointer指向tempPointer指向的节点
	 *   4.frontPointer指向tempPointer指向的节点
	 *   5.调用递归
	 *  b.不删除
	 *   1.currentPointer指向下一个节点
	 *   2.调用递归
	 * B.当前节点不为第一个节点
	 *  a.要删除
	 *   1.遍历单链表，tempPointer指向当前节点的前驱结点
	 *   2.currentPointer指向下一个节点
	 *   3.改变当前节点的前驱结点的指针域
	 *   4.调用递归
	 *  b.不删除
	 *   1.currentPointer指向下一个节点
	 *   2.调用递归
	 */
	
	/**
	 * 使用递归，删除单链表中所有值为element的元素
	 * 
	 * @param element 
	 * 				待删除的元素
	 * @param frontPointer 
	 * 				                 操作的单链表的头指针
	 * @param currentPointer 
	 * 					          进行删除操作时使用的当前指针，传递操作的单链表的头指针的副本
	 */
	
	public static <T> void deleteAllX(T element, Pointer frontPointer, Pointer currentPointer) {
		//临时指针
		Pointer tempPointer = new Pointer();
		
		//终止条件
		if(currentPointer.getNode() == null) {
			return;
		}


		//删除此节点
		if(currentPointer.getNode().getData().equals(element)) {
			//当前节点为第一个节点
			if(currentPointer.getNode().equals(frontPointer.getNode())) {
				//删除第一个节点
				tempPointer.setNode(currentPointer.getNode().getNext());
				currentPointer.getNode().setNext(null);
				currentPointer.setNode(tempPointer.getNode());
				frontPointer.setNode(tempPointer.getNode());
						
				deleteAllX(element, frontPointer, currentPointer);
			} else {
				//当前节点不为第一个节点
				//遍历链表，找到此节点的前驱结点
				tempPointer.setNode(frontPointer.getNode());
				while(!tempPointer.getNode().getNext().equals(currentPointer.getNode())) {
					tempPointer.setNode(tempPointer.getNode().getNext());
				}
						
				currentPointer.setNode(currentPointer.getNode().getNext());
				tempPointer.getNode().setNext(currentPointer.getNode());
						
				deleteAllX(element, frontPointer, currentPointer);
			}
		} else {
			//不删除此节点
			currentPointer.setNode(currentPointer.getNode().getNext());
			deleteAllX(element, frontPointer, currentPointer);
		}
	}
	
	// 第二题
		/*
		 * 使用两个指针，判断指针p指向的节点的直接后继
		 * 以及一个临时指针
		 * 头指针始终指向头节点，因此头指针需要一个独立的参数进行赋值
		 * 
		 * 该方法使用三个指针：
		 * 指针currentPointer：用于指向当前的节点，判断当前节点是否需要删除
		 * 指针tempPointer：用于辅助操作
		 * 指针frontPointer：作为头指针始终指向头节点节点，用于遍历单链表以及之后单链表的打印
		 * 
		 * 递归终止条件：currentPointer指向null
		 * A.当前节点为头节点时
		 *   1.currentPointer指向下一个节点
		 *   2.调用递归
		 * B.当前节点不为头节点
		 *  a.要删除
		 *   1.遍历单链表，tempPointer指向当前节点的前驱结点
		 *   2.currentPointer指向下一个节点
		 *   3.改变当前节点的前驱结点的指针域
		 *   4.调用递归
		 *  b.不删除
		 *   1.currentPointer指向下一个节点
		 *   2.调用递归
		 */
	
	//判断节点数据域为空要用“=”而不能用equals()，否则会空指针异常
		
	/**
	 * 使用递归，删除单链表中所有值为element的元素
	 * 
	 * @param element 
	 * 				待删除的元素
	 * @param frontPointer 
	 * 				                 操作的单链表的头指针
	 * @param currentPointer 
	 * 					          进行删除操作时使用的当前指针，传递操作的单链表的头指针的副本
	 */
		
	public static <T> void deleteAllXWithHead(T element, Pointer frontPointer, Pointer currentPointer) {
		//临时指针
		Pointer tempPointer = new Pointer();
		
		//终止条件
		if(currentPointer.getNode() == null) {
			return;
		}

		//删除此节点
		if(currentPointer.getNode().getData() != null && currentPointer.getNode().getData().equals(element)) {
			//当前节点为第一个节点
				if(!currentPointer.getNode().equals(frontPointer.getNode())) {
				//当前节点不为第一个节点
				//遍历链表，找到此节点的前驱结点
				tempPointer.setNode(frontPointer.getNode());
				while(!tempPointer.getNode().getNext().equals(currentPointer.getNode())) {
					tempPointer.setNode(tempPointer.getNode().getNext());
				}
							
				currentPointer.setNode(currentPointer.getNode().getNext());
				tempPointer.getNode().setNext(currentPointer.getNode());
						
				deleteAllX(element, frontPointer, currentPointer);
			}
		} else {
			//不删除当前节点或当前节点为头结点
			currentPointer.setNode(currentPointer.getNode().getNext());
			deleteAllX(element, frontPointer, currentPointer);
		}
	}
	
	//第三题
	/*
	 * 看书后，决定采用递归
	 * 终止条件：currentPoint.next = null
	 * 递归主体：currentPoint指向下一个节点
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
	
	//第四题
	/*
	 * 设置指针minPointer和prePointer，分别指向第二个节点和第一个节点
	 * 设置一个临时指针tempPointer，指向最小值节点的前驱结点，初始为头结点
	 * 从第二个节点开始遍历链表
	 * 		若当前节点的数据比tempPointer的小，则将tempPointer指向当前节点的前驱结点
	 * minPointer和prePointer分别指向下一个节点
	 * 直到prePointer = null为止
	 * 时间复杂度O(n) 空间复杂度O(1)
	 */
	public static void minimum(Pointer frontPointer) {
		//设置指针minPointer和prePointer，分别指向第二个节点和第一个节点
		Pointer minPointer = new Pointer();
		Pointer prePointer = new Pointer();
		minPointer.setNode(frontPointer.getNode().getNext());
		prePointer.setNode(frontPointer.getNode());
		
		//设置一个临时指针tempPointer
		Pointer tempPointer = new Pointer();
		tempPointer.setNode(frontPointer.getNode());
		//设置一个临时变量temp，其值为第二个节点的数据
		//int temp = (int)frontPointer.getNode().getNext().getData();
		
		/*
		 *  从第二个节点开始遍历链表
		 * 		若当前节点的数据比temp的小，则将其赋值给temp
		 * 		将tempPointer指向当前节点的前驱结点
		 * 	minPointer和prePointer分别指向下一个节点
		 *  直到minPointer = null为止
		 */
		while(minPointer.getNode() != null) {
			if((int)minPointer.getNode().getData() < (int)tempPointer.getNode().getNext().getData()) {
				tempPointer.setNode(prePointer.getNode());
			}
			minPointer.setNode(minPointer.getNode().getNext());
			prePointer.setNode(prePointer.getNode().getNext());
		}
		
		//删除节点
		tempPointer.getNode().setNext(tempPointer.getNode().getNext().getNext());
	}
	
	//第五题
	//除头结点外，其余节点与相对的节点互换数据(第二个和倒数第一个，第三个和倒数第二个，以此类推）
	//时间复杂度O(n^2) 空间复杂度O(n)
	public static void localReverse(Pointer frontPointer) {
		//指向前一个节点
		Pointer pre = new Pointer();
		Pointer rear = new Pointer();
		//初始化指针
		pre.setNode(frontPointer.getNode());
		//临时节点，用于暂存需要交换的数据存储
		Node temp = new Node();
		
		int i = SingleLinkedListTool.sizeOf(frontPointer);
		for(int x = 0, z = i; x < i/2; x++,z--) {
			//将指针指向待交换的节点
			//前一个指针
			pre.setNode(pre.getNode().getNext());
			//后一个指针
			rear.setNode(frontPointer.getNode());
			
			for(int y = 0; y < z; y++) {
				rear.setNode(rear.getNode().getNext());
			}
			
			temp.setData(pre.getNode().getData());
			pre.getNode().setData(rear.getNode().getData());
			rear.getNode().setData(temp.getData());
		}
	}
	//第五题书上的两种解法，更加简单
	//解法一
	//A.将头结点摘下
	//B.将其后的节点用头插法插入到头结点的后面
	//时间复杂度O(n) 空间复杂度O(1)
	public static void localReverse2(Pointer frontPointer) {
		//创建工作指针和辅助指针
		Pointer currentPointer = new Pointer();
		Pointer assistantPointer = new Pointer();

		//初始化指针位置
		currentPointer.setNode(frontPointer.getNode().getNext());
		//将头结点摘下
		frontPointer.getNode().setNext(null);
			
		while(currentPointer.getNode() != null) {
			frontPointer.getNode().setNext(currentPointer.getNode());
			currentPointer.setNode(currentPointer.getNode().getNext());
			frontPointer.getNode().getNext().setNext(assistantPointer.getNode());
			assistantPointer.setNode(frontPointer.getNode().getNext());
		}
	}
	
	//第五题 解法二
	/*
	 * 第一个节点的next指向null
	 * 创建三个指针p,q,r指向相邻的三个节点
	 * 当q!=null
	 * 	q.next->p
	 * 	p->q
	 *	q->r
	 *  r->r.next
	 * 头指针指向新的第一节点front->p
	 */
	public static void localReverse3(Pointer frontPointer) {
		//创建三个指针p,q,r
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer r = new Pointer();
		//初始化指针位置
		q.setNode(frontPointer.getNode().getNext());
		r.setNode(q.getNode().getNext());

		//第一个节点的next指向null
		q.getNode().setNext(null);
		
		//其余节点
		while(r.getNode() != null) {
			p.setNode(q.getNode());
			q.setNode(r.getNode());
			r.setNode(r.getNode().getNext());
			q.getNode().setNext(p.getNode());
		}
		
		//头指针指向新的第一节点
		frontPointer.getNode().setNext(q.getNode());
	}
	
	/*
	 * 第六题
	 * 思想：先构成只有一个数据节点的有序单链表，遍历之后的节点，依次找到升序链表中的每个节点
	 * A.创建指针p,q,r
	 * 	功能：
	 *   p指向数据在增序链表中的节点
	 *   q用于遍历链表
	 *   r指向值最小的节点
	 * 	初始化：
	 *   p->front.next
	 *   q->p.next
	 *   r
	 *   
	 *  B.创建节点：temp,min
	 *   功能：
	 *    min用于存储最小的值
	 *    temp用于在交换数据时存储数据 
	 *   初始化：
	 *    temp
	 *    min.data = p.data
	 *   
	 *  步骤：
	 *     寻找最小值
	 *   A.将q.data与min.data比较
	 *   	若小，则min.data = q.data,r->q
	 *   B.q->q,next
	 *   C.重复A,B直到q == null
	 *     交换数据
	 *   D.temp.data = p.data
	 *   E.p.data = min.data
	 *   F.r.data = temp.data
	 *
	 *   G.p->p.next
	 *   H.重复A-F直到p == null
	 *   
	 */
	public static void increase(Pointer frontPointer) {
		//创建指针p,q,r
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer r = new Pointer();
		//初始化指针
		p.setNode(frontPointer.getNode().getNext());
		
		
		//创建节点：temp,min
		Node temp = new Node();
		Node min = new Node();
		Node exchangJudge = new Node();
		
		//重复A-F直到p == null
		while(p.getNode() != null) {
			//初始化指针
			q.setNode(p.getNode().getNext());
			//初始化节点
			min.setData(p.getNode().getData());
			exchangJudge.setData(min.getData());
			//寻找最小值
			//重复A,B直到q == null
			while(q.getNode() != null) {
				//将q.data与min.data比较
				if((int)q.getNode().getData() < (int)min.getData()) {
					min.setData(q.getNode().getData());
					r.setNode(q.getNode());
				}
				//q->q,next
				q.setNode(q.getNode().getNext());
			}
			
			if(!exchangJudge.getData().equals(min.getData())){
				//交换数据
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
	
	// 第六题
	// 书上的算法思路和我相反，并且其通过调整指针实现
	// 我：确定有序链表的节点位置，通过遍历余下的节点找到应在那个位置上的节点
	// 书：确定余下节点中的某个节点，通过遍历有序链表，找到该节点在有序链表中的位置
	/*
	 * 指针：pre,p,r
	 * 作用：
	 * 	pre:指向节点在有序链表中应有位置的前驱结点
	 *  p：指向余下节点的某个节点
	 *  r：指向p的后继节点，防止断链
	 * 
	 * 初始化：
	 * 	A.将第一个节点看做有序链表,将第一个节点的next赋值为null
	 *  B.pre指向头结点
	 *  C.p指向第二个节点
	 *  D.r指向p
	 * 步骤：
	 *  A.r->p.next
	 * 	B.使用pre遍历有序链表
	 * 		pre.next != null && pre.next.data < p.data时
	 *      pre->pre.next,否则将p节点插入pre节点之后
	 *  C.p->p.next
	 *    pre->头指针
	 *  D.重复A-C，直到p == null
	*/
	public static void increase2(Pointer frontPointer) {
		//指针：pre,p,r
		Pointer pre = new Pointer();
		Pointer p = new Pointer();
		Pointer r = new Pointer();
		
		//初始化
		//pre指向头结点
		pre.setNode(frontPointer.getNode());
		//p指向第二个节点
		p.setNode(pre.getNode().getNext().getNext());
		//r指向p
		r.setNode(p.getNode());
		//将第一个节点看做有序链表,将第一个节点的next赋值为null
		pre.getNode().getNext().setNext(null);
		
		
		//重复A,B，直到p == null
		while(p.getNode() != null) {
			//指针r的移动放在指针p之前，当p==null时，指针r移动则会空指针异常
			r.setNode(p.getNode().getNext());
			//使用pre遍历有序链表
			//pre.next != null && pre.next.data < p.data时
			//pre->pre.next,否则将p节点插入pre节点之后
			while(pre.getNode().getNext() != null && (int)pre.getNode().getNext().getData() < (int)p.getNode().getData()) {
				pre.setNode(pre.getNode().getNext());
			}
			//否则将p节点插入pre节点之后
			p.getNode().setNext(pre.getNode().getNext());
			pre.getNode().setNext(p.getNode());
			
			//p->p.next
			//r->p.next
			//pre->头指针
			p.setNode(r.getNode());
			pre.setNode(frontPointer.getNode());
		}
	}
	
	/*
	 * 第七题
	 * 指针
	 *  创建:p,q
	 *  作用：q指向待判断的节点
	 *  	p指向q的前驱结点，用于删除操作
	 *  初始化：p = frontPointer
	 *  	 q = frontPointer->next
	 *  
	 *  步骤：
	 *  	A.判断q.data是否符合
	 *  		a.符合
	 *  			p->next = q->next
	 *  			q = q->next
	 *   		b.不符合
	 *   			p = q
	 *   			q = q->next
	 *   	B.重复A，直到q == null
	 */
	public static void delBetween(int min, int max, Pointer frontPointer) {
		//创建指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		//初始化指针
		p.setNode(frontPointer.getNode());
		q.setNode(frontPointer.getNode().getNext());
		
		//重复A，直到q == null
		while(q.getNode() != null) {
			//判断q.data是否符合
			if((int)q.getNode().getData() < max && (int)q.getNode().getData() > min) {
				p.getNode().setNext(q.getNode().getNext());
				q.setNode(q.getNode().getNext());
			} else {
				p.setNode(q.getNode());
				q.setNode(q.getNode().getNext());
			}
		}
	}
	
	// 第八题
	// 思路
	// 	用一个链表的每个节点去与另一个链表的所有节点进行比较，时间复杂度O(n^2)，空间复杂度O(1)
	// 	两个列表交替比较（n1和m1之后比较，m1和n2之后比较，n2和m2之后比较，以此类推）实质上与第一种方法一模一样
	// 实现
	//  指针：p,q
	//  作用：分别指向两个单链表的第一个结点
	//  初始化：p = frontPointer1->next
	//       q = frontPointer2->next
	//	数组：Node[]
	//  作用：保存共同的节点
	//  初始化:单链表中最长的长度
	//  步骤：
	//   A.p->data与q->data比较
	//   	a.相同
	//			将该节点存入Node[]中
	//      b.不同
	//	以下步骤略
	/*
	 * 思路：
	 *  书上：
	 *  由于链表的结构特殊性，若两个链表存在公共节点，则公共节点之后的节点都为公共节点
	 *  也就是说，它们的拓补结构为“Y”，而不会为“X”
	 *  这意味着只需要找到第一个公共节点即可，其余公共节点可由其在需要时找出，且至少两个链表的尾节点是公共节点
	 *  需要注意的是，两个单链表的长度不一定相同，如果两者同时从头遍历，几乎不可能找到公共节点
	 *  因此需要先将长链表遍历两者长度之差个节点，再同时遍历，即可找出公共节点
	 * 实现
	 *  创建：
	 *   指针：longP，shortP
	 *   作用：分别指向长链表和短链表的头结点
	 *   初始化：见作用
	 *  步骤:
	 *   A.使用sizeOf()计算两个单链表长度之差
	 *   B.长链表遍历两者长度之差个节点
	 * 	 C.两链表同时遍历并比较节点是否相同
	 * 		a.相同
	 * 			return 节点
	 * 		b.不同
	 * 			继续遍历比较
	 */
	public static Node publicNode(Pointer frontPointer1, Pointer frontPointer2) {
		//创建指针
		Pointer longP = new Pointer();
		Pointer shortP = new Pointer();
		//初始化指针
		//首先判断单链表长度
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
		
		//长链表遍历两者长度之差个节点
		for(int x = 0; x < difference; x++) {
			longP.setNode(longP.getNode().getNext());
		}
		
		//两链表同时遍历并比较节点是否相同
		//因为必然存在公共节点，所以循环条件为true
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
	 * 第九题
	 * 思路
	 *  先将链表升序排列，方法参考第六题
	 *  然后依次输出并删除节点
	 *  时间复杂度O(n^2),空间复杂度O(1)
	 *  
	 * 实现
	 *  创建
	 *   指针：p
	 *   功能：操作待输出和删除的节点
	 *   初始化：p指向升序链表的第一个节点
	 *  步骤
	 *   A.使用increase2()将链表升序排列
	 *   B.输出并删除链表
	 *   	a.输出p->data
	 *      b.head->next = p->next
	 *      c.p = p->next
	 *   C.重复A,B，直至p == null
	 */
	public static void increaseShow(Pointer head) {
		//创建指针
		Pointer p = new Pointer();
		
		//将链表升序排列
		increase2(head);
		
		//初始化指针
		p.setNode(head.getNode().getNext());
		
		//输出并删除链表
		//重复A,B，直至p == null
		while(p.getNode() != null) {
			System.out.println(p.getNode().getData());
			head.getNode().setNext(p.getNode().getNext());
			p.setNode(p.getNode().getNext());
		}
	}
	
	/*
	 * 第九题
	 * 书上思路
	 *  创建指针pre、p，p为工作指针，pre为最小值节点的前驱指针
	 *  遍历链表，若p->data < pre->next->data，则pre = p,p = p->next
	 *         否则p = p->next
	 *  遍历完后，输出并删除pre->next
	 *  然后再次从头遍历
	 *  
	 * 感觉我的思路更好一点
	 * 
	 * 实现及代码略
	 */
	
	/*
	 * 第十题
	 * 思路：
	 * 	A.创建链表B的头结点
	 * 	B.遍历链表A，每到序号为偶数的节点，将其从A价到B中
	 * 
	 * 实现：
	 *  指针：
	 * 		创建：
	 * 			指针p,q,headB
	 *  	作用：
	 *  		p:指向操作节点的前驱结点
	 *  		q：指向操作节点
	 *  		headB：链表B的头结点
	 *      	r:指向链表B的最后一个节点
	 *  	初始化：
	 *  		p = frontPointer
	 *      	q = p->next
	 *      	headB=listHeadB
	 *      	r = headB
	 *	节点：
	 *		创建：
	 *			链表B的头结点
	 * 步骤：
	 * 	A.遍历链表A
	 * 		a.当前节点序号为偶数
	 * 			p->next = q->next
	 * 			r->next = q
	 * 			r = q
	 * 			r->next = null
	 * 			q = p->next
	 * 			
	 *  	b.当前节点序号为奇数
	 *  		p = q
	 *        	q = q->next
	 */
	public static Pointer mkDouble(Pointer frontPointer) {
		//创建指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer headB = new Pointer();
		Pointer r = new Pointer();
		
		//链表B的头结点
		Node listHeadB = new Node();
		
		//初始化指针
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
	
	//第十一题
	/*
	 * 做法和第十题一样
	 */
	
	//第十二题
	/*
	 * 思路：
	 * 	找到所有重复的值的最后一个值，将其的后继节点与第一个重复值的前驱结点相连
	 * 		书上思路：
	 * 			1、找到一个重复值则删除一个重复值
	 * 			2、将头结点摘下，将剩余节点作为新节点插入到头结点之后，若其值与前趋节点的值重复则不插入
	 * 实现
	 * 	指针
	 * 		创建
	 * 			p：指向操作节点的前驱结点
	 * 			q：指向操作节点
	 * 		初始化
	 * 			p = frontPointer
	 * 			q = p
	 * 	步骤
	 * 		若q->next != null
	 * 			q = p->next
	 * 				A.若q->next == null
	 *  				return
	 * 				B.若q->next->data = q->data
	 * 					q -> q.next 直到q->next->data ！= q->data
	 * 					p->next = q->next
	 * 				c.若q->next->data ！= q->data
	 * 					p = q
	 */
	public static void deleteRepeat(Pointer frontPointer) {
		//创建指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		
		//初始化指针
		p.setNode(frontPointer.getNode()); 
		q.setNode(p.getNode());
		
		while (q.getNode().getNext() != null) {
			q.setNode(p.getNode().getNext());
			
			//若q移动到链表末尾则结束
			if(q.getNode().getNext() == null) {
				return;
			}
			
			if(q.getNode().getNext().getData() == q.getNode().getData()) {
				//while的第一个条件是防止当链表最后几个节点的值都重复时，指针往后遍历到最后一个节点时的空指针异常
				while(q.getNode().getNext() != null && q.getNode().getNext().getData() == q.getNode().getData()) {
					q.setNode(q.getNode().getNext());
				}
				p.getNode().setNext(q.getNode().getNext());
			} else {
				p.setNode(q.getNode());
			}
		}
	}
	
	//第十三题
	/*
	 * 思路
	 * 	将链表A的头结点摘下
	 * 	从两个链表里各取第一个节点，设为节点a（链表A），节点1（链表B）
	 * 	比较节点a和节点1的值
	 * 	若节点a<=节点1，则将节点a插入头结点A后
	 * 	重复以上步骤
	 * 
	 * 实现
	 * 	指针
	 * 		创建
	 * 			p:指向链表A的操作节点
	 * 			q：指向p的后继节点，用于将p置回链表A
	 * 			e：指向链表B的操作节点
	 * 			r：指向e的后继节点，用于将e置回链表B
	 * 		初始化
	 * 			p = headA->next
	 * 			q = p->next
	 * 			e = headB->next
	 * 			r = e->next
	 * 步骤
	 * 	A.将链表A的头结点摘下
	 * 	B.比较p->data和e->data
	 * 		若p->data < e->data
	 * 			p->next = headA->next
	 * 			headA->next = p
	 * 			p = q
	 * 			q = p->next
	 * 		否则
	 * 			e->next = headA->next
	 * 			headA->next = e
	 * 			e = r
	 * 			r = e->next
	 * 	C.若p != null && e != null重复A
	 * 	D.一个链表插入完毕后，若另一个链表还有剩余节点，则全部插入到headA后面
	 * 		若q != null
	 * 			p->next = headA->next
	 * 			headA->next = p
	 * 			p = q
	 * 			q = p->next
	 * 			重复，直到q == null
	 *    	若r != null
	 *	    	e->next = headA->next
	 * 			headA->next = e
	 * 			e = r
	 *	 		r = e->next
	 * 			重复，直到r == null
	 */
	public static Pointer dualIncreaseToSingleDecrease(Pointer headA, Pointer headB) {
		//创建指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer e = new Pointer();
		Pointer r = new Pointer();
		
		//初始化指针
		p.setNode(headA.getNode().getNext());
		q.setNode(p.getNode().getNext());
		e.setNode(headB.getNode().getNext());
		r.setNode(e.getNode().getNext());
		
		//摘下链表A的头结点
		headA.getNode().setNext(null);
		
		//若q != null && r != null重复A
		while(p.getNode() != null && e.getNode() != null) {
			//比较p->data和e->data
			if((int)p.getNode().getData() < (int)e.getNode().getData()) {
				p.getNode().setNext(headA.getNode().getNext());
				headA.getNode().setNext(p.getNode());
				p.setNode(q.getNode());
				
				//操作完末尾节点后，后驱指针不需要也不能再后移了
				if(p.getNode() != null) {
					q.setNode(p.getNode().getNext());
				}
			} else {
				e.getNode().setNext(headA.getNode().getNext());
				headA.getNode().setNext(e.getNode());
				e.setNode(r.getNode());
				
				//操作完末尾节点后，后驱指针不需要也不能再后移了
				if(e.getNode() != null) {
					r.setNode(e.getNode().getNext());
				}
			}
		}
		
		//一个链表插入完毕后，若另一个链表还有剩余节点，则全部插入到headA后面
		if(p.getNode() != null) {
			p.getNode().setNext(headA.getNode().getNext());
			headA.getNode().setNext(p.getNode());
			p.setNode(q.getNode());
			
			//操作完末尾节点后，后驱指针不需要也不能再后移了
			if(p.getNode() != null) {
				q.setNode(p.getNode().getNext());
			}
		}
		
		if(e.getNode() != null) {
			e.getNode().setNext(headA.getNode().getNext());
			headA.getNode().setNext(e.getNode());
			e.setNode(r.getNode());
			
			//操作完末尾节点后，后驱指针不需要也不能再后移了
			if(e.getNode() != null) {
				r.setNode(e.getNode().getNext());
			}
		}
		
		return headA;
 	}
	
	//第十四题
	/*
	 * 思路（放弃，单链表在使用二分查找时，最大值的节点需要从头遍历链表，那还不如直接遍历并比较）
	 * 	遍历单链表A，使用二分查找在单链表B中查找单链表A中的所有节点的值
	 * 	若单链表B中有相同值的节点，则新建节点，赋予相同的值，并插入到单链表C的末尾
	 * 
	 * 思路
	 * 	遍历单链表A，获取每个节点
	 * 	将每个节点值与链表B中的节点的值比较
	 * 	若有相同的，则将其值赋予一个新的节点并插入到单链表C的末尾
	 *  若当前遍历到的单链表B中的节点的值大于单链表节点A的值，则停止遍历单链表B
	 * 实现
	 * 	创建
	 * 		节点
	 * 			headNodeC：单链表C的头结点
	 * 		指针
	 * 			p:指向链表A的待比较节点
	 * 			q:指向链表B的待比较节点
	 * 			e:指向q的前驱结点，这样就可以从比前一个p->data大的值开始比较，省去从头比较的时间
	 * 			r:指向单链表C的尾节点
	 * 			headC：指向单链表C的头结点
	 *  初始化
	 *  	节点
	 *  		headNodeC
	 *  	指针
	 *  		p = headA
	 *  		q = headB
	 *  		headC = headNodeC
	 *  		r = headC
	 *  
	 *  步骤：
	 *  	A.比较单链表A和单链表B中节点的值
	 *  		a.若p->data == q->data
	 *   			new Node temp
	 *   			temp->data = p->data
	 *   			r->next = temp
	 *   			r = r->next
	 *   			break
	 *   
	 *   		b.若p->data < q->data
	 *    			break
	 *    
	 *   	B.当q->next != null时，q = q->next,重复A
	 *   	C.当p->next != null时，p = p->next,q = headB,重复A、B
	 *  	
	 */
	public static Pointer publicNodeWithNewList(Pointer headA, Pointer headB) {
		//创建节点
		Node headNodeC = new Node();
		//创建指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer e = new Pointer();
		Pointer r = new Pointer();
		Pointer headC = new Pointer();
		
		//初始化指针
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
	
	//第十四题 书上方法
	/*
	 * 思路：
	 * 	同时遍历两个单链表，各取一个节点
	 * 	比较两个节点的值
	 * 	若不相等，则指向较小值的节点的指针后移一个
	 * 	若相等，则创建一个新节点，将该值赋值给新节点并将其插入到链表C末尾
	 * 
	 * 实现
	 * 	创建
	 * 		节点
	 * 			nodeHeadC：单链表C的头结点
	 * 		指针
	 * 			p:指向单链表A待比较的节点
	 * 			q:指向单链表B待比较的节点
	 * 			headC:指向单链表C的头结点
	 * 			r:指向单链表C的尾节点
	 * 	初始化
	 * 		p = headA->next
	 * 		q = headB->next
	 * 		headC = nodeHeadC
	 * 		r = nodeHeadC
	 * 		
	 *  步骤
	 *  	A.比较p->data和q->data
	 *  		若p->data == q->data
	 *  			new Node(p->data) temp
	 *  			r->next = temp
	 *  			r = r->next
	 *  			p = p->next
	 *  			q = q->next
	 *  		若p->data < q->data
	 *  			p = p->next
	 *  		若p->data > q->data
	 *  			q = q->next
	 *  	B.若p != null && q != null,重复A
	 */
	public static Pointer publicNodeWithNewList2(Pointer headA, Pointer headB) {
		//创建节点
		Node nodeHeadC = new Node();
		//创建指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer headC = new Pointer();
		Pointer r = new Pointer();
		
		//初始化指针
		p.setNode(headA.getNode().getNext());
		q.setNode(headB.getNode().getNext());
		headC.setNode(nodeHeadC);
		r.setNode(nodeHeadC);
		
		//若p != null && q != null,重复A
		while(p.getNode() != null && q.getNode() != null) {
			//比较p->data和q->data
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
	
	//第十五题
	/*
	 * 思路
	 * 	摘下链表A的头结点
	 * 	同时遍历两个单链表，各取一个节点
	 * 	比较两个节点的值
	 * 	若不相等，则指向较小值的节点的指针后移一个
	 * 	若相等，则将其中一个节点插入到头结点A的表尾
	 * 实现
	 * 	参考第十四题
	 */
	public static Pointer intersection(Pointer headA, Pointer headB) {
		//创建指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		Pointer r = new Pointer();
				
		//初始化指针
		p.setNode(headA.getNode().getNext());
		q.setNode(headB.getNode().getNext());
		r.setNode(headA.getNode());
		
		//将headA的头结点摘下
		headA.getNode().setNext(null);
		
		//若p != null && q != null,重复A
		while(p.getNode() != null && q.getNode() != null) {
			//比较p->data和q->data
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
				
		//将结果单链表A的尾节点与其后继节点断开
		r.getNode().setNext(null);
		
		return headA;
	}
	
	//第十六题
	/*
	 * 思想
	 * 	遍历单链表A
	 * 	将其节点的值与单链表B的第一个节点的值比较
	 * 		若不同，继续遍历单链表A，若到表尾，返回false
	 * 		若相同，单链表B从第一个节点开始同时与单链表A遍历
	 * 			若两个节点相同，则继续遍历，若到单链表B的表尾，返回true
	 * 			若两个节点不同，返回false
	 * 实现
	 * 	创建
	 * 		指针
	 * 			p:指向单链表A的待判断节点
	 * 			q：指向单链表B的待判断节点
	 * 	初始化
	 * 		指针
	 * 			p = headA->next
	 * 			q = headB->next
	 * 步骤
	 * 	A.比较p->data与q->data
	 * 		a.p->data == q->data
	 * 			1.p = p->next
	 * 			2.q = q->next
	 * 		b.p->data != q->data
	 * 			p = p->next
	 * 		
	 *  B.重复A，直到p == null || q == null
	 * 			
	 *	 		3.若q == null
	 * 				return true
	 * 			若p == null && q != null	
	 * 				return false
	 * 	B.return
	 */
	public static boolean isContinuousSequence(Pointer headA, Pointer headB) {
		//创建指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		//初始化指针
		p.setNode(headA.getNode().getNext());
		q.setNode(headB.getNode().getNext());
		
		//标记
		boolean flag = false;
		
		//寻找子序列在链表A中的第一个节点
		while(p.getNode().getData() != q.getNode().getData() && p.getNode() != null) {
			p.setNode(p.getNode().getNext());
		}
		
		//判断链表B是不是链表A的连续子序列
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
	
	//第二十一题
	/*
	 * 1、基本设计思想
	 * 	定义两个指针对象p,q。
	 * 让q指针指向头结点，然后q指针后移k个节点。
	 * 让p指针指向链表的第一个节点。
	 * 两个指针同步后移，直到q指针移动到最后一个节点，p指针指向的既是倒数第k个节点。
	 * 2、详细实现步骤
	 * 	A.创建两个指针p,q
	 * 	B.q指针首先从表头后移
	 * 	C.若q指向的节点的后继节点为null，则说明q已至表尾，若移动不到k次，则说明该单链表没有倒数第k个节点，返回0，跳至步骤G
	 *  D.令p指向第一个节点
	 *  E.p和q同时后移，直到q指向尾节点，查找成功
	 *  F.输出p指向的节点的data域的值，并返回1
	 *  G.算法结束
	 */
	public static int lastK(Pointer head, int k) {
		//创建并初始化指针
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		
		q.setNode(head.getNode());
		
		//q指针首先从表头后移k次
		for(int x = 0; x < k; x++) {
			if(q.getNode().getNext() == null) {
				return 0;
			}
			q.setNode(q.getNode().getNext());
			
		}
		
		//若q指向存在的节点，则令p指向第一个节点
		p.setNode(head.getNode().getNext());
		
		//p和q同时后移，直到q指向尾节点
		while(q.getNode().getNext() != null) {
			q.setNode(q.getNode().getNext());
			p.setNode(p.getNode().getNext());
		}
		
		//输出p指向的节点的data域的值，并返回1
		System.out.println(p.getNode().getData());
		return 1;
	}
	
	//第二十一题
	/*
	 * 1、设计思想
	 * 	创建两个指针对象p,q，分别指向单链表str1和单链表str2的第一个节点。
	 * 	遍历单链表str2，将p指向的节点和q指向的节点进行比较。
	 * 	若相同，则返回指针p
	 * 	若不同，则将指针q移动到下一个节点，直到q指向尾指针
	 * 	移动指针p到下一个节点，重复上述步骤，直到p指向尾指针
	 * 3、时间复杂度 O(mn)
	 */
	public static Pointer findPublic(Pointer head1, Pointer head2) {
		//创建并初始化指针对象
		Pointer p = new Pointer();
		Pointer q = new Pointer();
		p.setNode(head1.getNode().getNext());
		q.setNode(head2.getNode().getNext());
		
		//返回值
		Pointer r = null;
		
		while(p.getNode() != null) {
			//str2遍历完一趟后，将指针q初始化
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
	
	//第二十二题
	/*
	 * 书上方法
	 *  1、基本思想
	 *  	A.分别算出两个链表的长度len1,len2
	 *  	B.将两个单链表以表尾对齐：令指针p,q分别指向str1和str2的头节点，
	 *  	       若len1≥len2，将指针p指向第len1-len2+1个节点
	 *  	       若len1<len2，将指针q指向第len1-len2+1个节点
	 *  	C.两个节点同步后移，直到q=p，即为共同后缀的起始位置，算法结束
	 *  2、时间复杂度 O(m+n)
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
		//分别算出两个链表的长度m,n
		int len1 = length(head1);
		int len2 = length(head2);
		
		//将两个单链表以表尾对齐
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
		
		//寻找共同后缀的起始位置
		while(q.getNode() != p.getNode()) {
			q.setNode(q.getNode().getNext());
			p.setNode(p.getNode().getNext());
		}
		
		return p;
	}
	
	//第23题
	/*
	 * 1、基本思想
	 * 	A.将头结点和第一个有元素的节点摘下，视作单链表B
	 * 	B.依次取下剩余节点并与单链表B中的所有节点比较两者的data的绝对值
	 * 		a.若都不相等，则将取下的节点插入到单链表B的表尾
	 * 		b.若有相等，则不插入
	 * 4、时间复杂度 O(n^2) 空间复杂度O(1)
	 */
	public static void differAbsoluteValue(Pointer head) {
		//创建指针p，指向原链表中待比较的节点
		Pointer p = new Pointer();
		p.setNode(head.getNode().getNext().getNext());
		//创建指针r，指向p的后继节点
		Pointer r = new Pointer();
		//创建指针q，指向链表B中待比较的节点
		Pointer q = new Pointer();
		q.setNode(head.getNode().getNext());
				
		//将头结点和第一个有元素的节点摘下，视作单链表B
		head.getNode().getNext().setNext(null);
		
		while(p.getNode().getNext() != null) {
			//比较p->data和q->data的绝对值，若相等则继续向后遍历原链表
			if(Math.abs((int)p.getNode().getData()) != Math.abs((int)q.getNode().getData())) {
				//若q->data与p->data不等，判断q是不是链表B的最后一个节点，是则将p插入到q之后，否则继续遍历链表B
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
	//第23题
	/*
	 * 书上做法，用空间换时间：利用数组记录链表中已经出现的数值！
	 */
	public static void differAbsoluteValue2(Pointer head, int n) {
		//因为|data|<=n，所以数组长度为n+1。由于这个n由题目提供，所以可作为参数即已知数
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