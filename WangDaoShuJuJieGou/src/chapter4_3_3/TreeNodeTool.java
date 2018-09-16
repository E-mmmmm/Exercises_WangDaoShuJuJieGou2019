package chapter4_3_3;

import chapter3_1_4.SequenceStack;
import chapter3_2_5.CyclicQueue;

//用于操作二叉树的链结点的工具类
public class TreeNodeTool {
	/**
	 * 将节点添加为左孩子
	 * 
	 * @param lchild 
	 * 				左孩子结点
	 * @param parent 
	 * 				双亲节点
	 */
	public static void ladd(TreeNode lchild, TreeNode parent) {
		if (parent.getLchild() == null) {
			parent.setLchild(lchild);
		} else {
			System.out.println("该双亲结点已有左孩子结点");
		}
	}
	
	/**
	 * 将节点添加为右孩子
	 * 
	 * @param rchild
	 * 				右孩子节点
	 * @param parent
	 * 				双亲节点
	 */
	public static void radd(TreeNode rchild, TreeNode parent) {
		if (parent.getRchild() == null) {
			parent.setRchild(rchild);
		} else {
			System.out.println("该双亲结点已有右孩子结点");
		}
	}
	
	/**
	 * 前序遍历二叉树（递归）
	 * 
	 * @param T 
	 * 			二叉树根结点的指针
	 */
	public static void preOrderRecursive(TreeNode root) {
		TreeNode temp = new TreeNode();
		temp = root;
				
		if(temp != null) {
			System.out.println(temp.getData());
			preOrderRecursive(temp.getLchild());
			preOrderRecursive(temp.getRchild());
		}
	}
	
	/**
	 * 中序遍历二叉树（递归）
	 * @param T
	 * 			二叉树根结点的指针
	 */
	public static void inOrderRecursive(TreeNode root) {
		TreeNode temp = new TreeNode();
		temp = root;
		
		if(temp != null) {
			inOrderRecursive(temp.getLchild());
			System.out.println(temp.getData());
			inOrderRecursive(temp.getRchild());
		}
	}
	
	/**
	 * 后序遍历二叉树（递归）
	 * @param T
	 * 			二叉树根结点的指针
	 */
	public static void postOrderRecursive(TreeNode root) {
		TreeNode temp = new TreeNode();
		temp = root;
		
		if(temp != null) {
			postOrderRecursive(temp.getLchild());
			postOrderRecursive(temp.getRchild());
			System.out.println(temp.getData());
		}
	}

	/*
	 * 	前序遍历二叉树（非迭代）
	 * 	思路
	 * 		A.令指针temp指向根结点
	 *  	B.判断指针temp指向的结点是否为空
	 *  		a.非空
	 *  			1.将此结点压栈
	 *  			2.输出此节点的data
	 *  			3.将temp指向它的左孩子结点
	 *  			3.回到B
	 *  		b.空
	 *  			1.弹栈
	 *  			2.将temp指向栈顶元素的右孩子结点
	 *  			3.回到B
	 *  	C.重复B，直到temp和栈都为空
	 */
	/**
	 * 前序遍历二叉树（非递归）
	 * @param T
	 * 			二叉树根结点的指针
	 */
	public static void preOrder(TreePointer T) {
		//令指针temp指向根结点
		TreePointer temp = new TreePointer();
		temp.setNode(T.getNode());
			
		//创建栈
		SequenceStack<TreeNode> ss = new SequenceStack<>();
		ss.InitStack();
				
		while(temp.getNode() != null || !ss.StackEmpty()) {
			if (temp.getNode() != null) {
				ss.Push(temp.getNode());
				System.out.println(temp.getNode().getData());
				temp.setNode(temp.getNode().getLchild());
			} else {
				TreeNode tempNode = (TreeNode)ss.Pop();
				temp.setNode(tempNode.getRchild());
			}
		}
	}
	
	/*
	 *  中序遍历二叉树（非迭代）
	 *  思路
	 *  	A.令指针temp指向根结点
	 *  	B.判断指针temp指向的结点是否为空
	 *  		a.非空
	 *  			1.将此结点压栈
	 *  			2.将temp指向它的左孩子结点
	 *  			3.回到B
	 *  		b.空
	 *  			1.将栈顶元素弹栈并保存在tempNode中，并输出其data
	 *  			2.将temp指向其右孩子结点
	 *  			3.回到B
	 *  	C.重复B，直到temp和栈都为空
	 */
	/**
	 * 中序遍历二叉树（非递归）
	 * @param T
	 * 			二叉树的根结点指针
	 */
	public static void inOrder(TreePointer T) {
		//令指针temp指向根结点
		TreePointer temp = new TreePointer();
		temp.setNode(T.getNode());
		
		//创建栈
		SequenceStack<TreeNode> ss = new SequenceStack<>();
		ss.InitStack();
		
		while(temp.getNode() != null || !ss.StackEmpty()) {
			if (temp.getNode() != null) {
				ss.Push(temp.getNode());
				temp.setNode(temp.getNode().getLchild());
			} else {
				TreeNode tempNode = (TreeNode)ss.Pop();
				System.out.println(tempNode.getData());
				temp.setNode(tempNode.getRchild());
			}
		}
	}
	
	/*
	 * 利用visit统计结点被访问的次数
	 * 若栈不为空
	 * 	p != null  
	 * 		p.node.visit == 0
	 * 			p.node入栈
	 * 			p.node.visit++
	 * 			p = p->lchild
	 * 		p.node.visit != 0
	 * 			syso(ss.pop.data)
	 * 			ss不为空
	 *  			p = ss.getTop->rchild
	 *  			ss.getTop.visit++
	 *  p == null
	 *  	if(ss.getTop.visit == 1) {
	 *  		p = ss.getTop->rchild
	 *  		ss.getTop.visit++
	 *  	} else if(ss.getTop.visit == 2) {
	 *  		syso(ss.pop.data)
	 *  		p = ss.getTop->rchild
	 *  		ss.getTop.visit++
	 *  	}
	 * 	
	 * 	
	 */
	
	//第三题
	/**
	 * 二叉树的后序遍历（非递归）
	 * @param T
	 * 			二叉树的根结点指针
	 */
	public static void postOrder(TreePointer T) {
		TreePointer p = new TreePointer();
		p.setNode(T.getNode());
		
		TreeNode temp = new TreeNode();
		
		//创建栈
		SequenceStack<TreeNode> ss = new SequenceStack<>();
		ss.InitStack();
		
		int count = 0;
		
		while(!ss.StackEmpty() || count == 0) {
			if(p.getNode() != null) {
				//只有当结点未被访问时才需要入栈
				if(p.getNode().getVisit() == 0) {
					ss.Push(p.getNode());
					p.getNode().visit++;
					p.setNode(p.getNode().getLchild());
					
					//用来表示栈已被操作，第二次空栈时即为结束
					count++;
				} else {
					//该节点通过双亲结点访问，可该节点已被访问过，则代表双亲结点的左右结点均被访问，输出双亲结点
					temp = ss.Pop();
					System.out.println(temp.getData());
					if(!ss.StackEmpty()) {
						temp = ss.GetTop();
						p.setNode(temp.getRchild());
						temp.visit++;
					}
				}
			} else {
				temp = ss.GetTop();
				if(temp.visit == 1) {
					p.setNode(temp.getRchild());
					temp.visit++;
				}else if(temp.visit == 2) {
					ss.Pop();
					System.out.println(temp.getData());
					temp = ss.GetTop();
					p.setNode(temp.getRchild());
					temp.visit++;
				}
			}
		}
	}
	
	/**
	 * 层次遍历二叉树
	 * @param T
	 * 			二叉树的根结点的指针
	 */
	public static void levelOrder(TreePointer T) {
		//创建队列
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		//操作指针
		TreePointer p = new TreePointer();
		p.setNode(T.getNode());
		
		TreeNode tNode = new TreeNode();
		
		cq.enQueue(p.getNode());
		
		while(!cq.queueEmpty()) {
			tNode = cq.deQueue();
			System.out.println(tNode.getData());
			
			if(tNode.getLchild() != null) {
				cq.enQueue(tNode.getLchild());
			}
			
			if(tNode.getRchild() != null) {
				cq.enQueue(tNode.getRchild());
			}
		} 
	}
	//指向前一次访问的结点,前
		static TreeNode pre = null;
	//二叉树的线索化（前序）
	/*
	 * 	思路【不一定准确】
	 * 		依次判断结点的左右孩子结点
	 * 		
	 * 		中序遍历则是先判断所有所有结点的左孩子结点再判断结点的右孩子几点
	 * 		
	 */
		/**
		 * 二叉树的线索化（先序）
		 * @param p
		 * 			二叉树的根结点
		 */
		public static void preOrderThreadBiTree(TreeNode p) {
			preOrderThread(p);
			if(pre.getRchild() == null) {
				pre.rtag = 1;
			}
			
			pre = null;
		}
		
		/**
		 * 二叉树的线索化（先序）的主要操作
		 * @param p
		 * 			二叉树的根结点
		 */
		private static void preOrderThread(TreeNode p) {
			if(p != null) {
				if(p.getLchild() == null) {
					p.setLchild(pre);
					p.ltag = 1;
				}
				
				if(pre != null && pre.getRchild() == null) {
					pre.setRchild(p);
					pre.rtag = 1;
				}
				
				pre = p;
				
				if(p.ltag == 0) {
					preOrderThread(p.getLchild());
				}
				
				if(p.rtag == 0) {
					preOrderThread(p.getRchild());
				}
			}
		}
		
		/**
		 * 返回先序线索二叉树中结点p在先序序列下的后继结点
		 * @param p
		 * 			返回结点的前驱结点
		 * @return
		 * 			结点p的后继结点
		 */
		public static TreeNode nextNodePre(TreeNode p) {
			if(p.ltag == 0) {
				return p.getLchild();
			} else {
				return p.getRchild();
			}
		}
	
		public static void showPreOrderThreadBiTree(TreeNode root) {
			TreeNode temp = new TreeNode();
			temp = root;
			while(temp != null) {
				System.out.println(temp.getData());
				temp = nextNodePre(temp);
			}
		}
	//二叉树的线索化（中序）
	/*
	 * 思想核心：一次更改一组结点，因此使用递归
	 */
	
	/**
	 * 二叉树的线索化（中序）
	 * @param p
	 * 			二叉树的根结点
	 */
	public static void inOrderThreadBiTree(TreeNode p) {
		inOrderThread(p);
		if(pre.getRchild() == null) {
			pre.rtag = 1;
		}
		
		pre = null;
	}
	
	/**
	 * 二叉树的线索化（中序）的主要操作
	 * @param p
	 * 			二叉树的根结点
	 */
	private static void inOrderThread(TreeNode p) {
		if(p != null) {
			inOrderThread(p.getLchild());
			if(p.getLchild() == null) {
				p.setLchild(pre);
				p.ltag = 1;
			}
			
			if(pre != null && pre.getRchild() == null) {
				pre.setRchild(p);
				pre.rtag = 1;
			}
			
			pre = p;
			inOrderThread(p.getRchild());
		}
	}
	
	/**
	 * 返回中序线索二叉树中中序序列下的第一个结点
	 * @param root
	 * 			中序线索二叉树的根结点
	 * @return
	 * 			中序线索二叉树中中序序列下的第一个结点
	 */
	public static TreeNode firstNodeIn(TreeNode root) {
		TreeNode tNode = root;
		while(tNode.ltag == 0) {
			tNode = tNode.getLchild();
		}
		
		return tNode;
	}
	
	/**
	 * 返回中序线索二叉树中结点p在中序序列下的后继结点
	 * @param p
	 * 			返回结点的前驱结点
	 * @return
	 * 			结点p的后继节点
	 */
	public static TreeNode nextNodeIn(TreeNode p) {
		if(p.rtag == 1) {
			return p.getRchild();
		} else {
			return firstNodeIn(p.getRchild());
		}
	}
	
	/**
	 * 遍历中序线索化的二叉树
	 * @param root
	 * 				二叉树的根结点
	 */
	public static void showInOrderThreadBiTree(TreeNode root) {
		TreeNode tNode = firstNodeIn(root);
		while(tNode != null) {
			System.out.println(tNode.getData());
			tNode = nextNodeIn(tNode);
		}
	}
	
	//后序线索化二叉树
	/*
	 * 递归到左子树的叶子结点
	 * 先左后右，然后pre=p
	 */
	/**
	 * 后序线索化二叉树
	 * @param root
	 * 				二叉树的根结点
	 */
	public static void postOrderthreadBitree(TreeNode root) {
		postOrderThread(root);
		pre = null;
	}
	/**
	 * 后序线索化二叉树的主要操作
	 * @param root
	 * 				二叉树的根结点
	 */		
	private static void postOrderThread(TreeNode root) {
		TreeNode p = new TreeNode();
		p = root;
		
		if(p != null) {
			//递归到左子树的叶子结点
			if(p.ltag == 0) {
				p.visit++;
				postOrderThread(p.getLchild());
			} 
			if(p.rtag == 0 && p.getRchild() != null && p.getRchild().visit == 0) {
				p.visit++;
				postOrderThread(p.getRchild());
			}
		
			//先左后右，然后pre=p
			if(p.getLchild() == null) {
				p.setLchild(pre);
				p.ltag = 1;
			} 
			
			if(pre != null && pre.getRchild() == null && pre.rtag == 0) {
				pre.setRchild(p);
				pre.rtag = 1;
			}
			
			pre = p;
		}
	}
	
	/**
	 * 返回后序线索化的二叉树的起始结点
	 * @param root
	 * 				二叉树的根结点
	 * @return
	 * 				二叉树的起始结点
	 */
	public static TreeNode firstNodePost(TreeNode root) {
		TreeNode first = new TreeNode();
		first = root;
		//寻找遍历的起点
		while(first.getLchild() != null) {
			 first = first.getLchild();
		}
		
		return first;
	}
	
	/**
	 * 返回后序线索化二叉树中结点的后继节点
	 * @param root
	 * @param p
	 * @return
	 */
	//用于存储结果，方法中的temp在每次迭代时值仅在当时有效，会导致返回值异常
	static TreeNode result = new TreeNode();
	public static TreeNode nextNodePost(TreeNode root, TreeNode p) {
		TreeNode temp = new TreeNode();
		temp = root;
		
		if(temp != null) {
			//在结点的左子树寻找
			if(temp.getLchild() != null && temp.ltag == 0) {
				if(temp.getLchild() == p) {
					//判断是否有后继结点的线索
					if(temp.getLchild().rtag == 1) {
						result = temp.getLchild().getRchild();
					} else {
					//寻找结点p的右兄弟的最靠左靠下的结点
						if(temp.getRchild() != null && temp.rtag == 0) {
							temp = temp.getRchild();
							while(temp.getLchild() != null && temp.ltag == 0) {
								temp = temp.getLchild();
							}
							
							if(temp.getRchild() != null && temp.rtag == 0) {
								result = temp.getRchild();
							}else {
								result = temp;
							} 
						}
					}
				} else {
					nextNodePost(temp.getLchild(), p);
				}
			}
			
			if(result != null) {
				//在结点的右子树寻找
				if(temp.getRchild() != null && temp.rtag == 0) {
					if(temp.getRchild() == p) {
						result = temp;
					} else {
						nextNodePost(temp.getRchild(), p);
					}
				}
			}
		}
		
		//返回结果
		return result;
	}
	
	/**
	 * 遍历后序线索化的二叉树
	 * @param root
	 * 				二叉树的根结点
	 */
	public static void showPostOrderThreadBintree(TreeNode root) {
		TreeNode first = new TreeNode();
		first = firstNodePost(root);
		
		while(first.visit != 5) {
			first.visit = 5;
			System.out.println(first.getData());
			first = nextNodePost(root, first);
		}
	}
	
	//第四题
	/**
	 * 自下至上、自右至左层次遍历
	 * @param root
	 * 				二叉树的根结点
	 */
	public static void levelOrderReverse(TreeNode root) {
		//队列用于正序进行层次遍历
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		//栈用来存储出队的结点，最后依次出栈便为逆序
		SequenceStack<TreeNode> ss = new SequenceStack<>();
		ss.InitStack();
		
		cq.enQueue(root);
		
		while(!cq.queueEmpty()) {
			TreeNode temp = cq.deQueue();
			ss.Push(temp);
			
			if(temp.getLchild() != null) {
				cq.enQueue(temp.getLchild());
			}
			
			if(temp.getRchild() != null) {
				cq.enQueue(temp.getRchild());
			}
		}
		
		while(!ss.StackEmpty()) {
			TreeNode sstemp = new TreeNode();
			sstemp = ss.Pop();
			System.out.println(sstemp.getData());
		}
	}
	
	//第五题
	/*
	 * 思路
	 * 	利用层次遍历
	 * 	每次读取一层的结点时，记录一层有n个结点
	 * 	当出队n个结点后，高度＋1
	 * 	直到队列为空
	 */
	/**
	 * 求二叉树的高度
	 * @param root
	 * 				二叉树的根结点
	 * @return
	 * 				二叉树的高度
	 */
	public static int height(TreeNode root) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		//记录一层的节点数
		int count = 1;
		//高度
		int height = 0;
		
		cq.enQueue(root);
		while(!cq.queueEmpty()) {
			//用于暂时记录下一层的结点数
			int countNext = 0;
			for(int x = 0; x < count; x++) {
				TreeNode temp = new TreeNode();
				temp = cq.deQueue();
				
				if(temp.getLchild() != null) {
					cq.enQueue(temp.getLchild());
					countNext++;
				}
				
				if(temp.getRchild() != null) {
					cq.enQueue(temp.getRchild());
					countNext++;
				}
			}
			
			count = countNext;
			
			height++;
		}
		
		return height;
	}
	
	//第六题
	/*
	 * 思路
	 * 	通过先序遍历序列获取根结点
	 * 	通过中序遍历序列判断该结点有无左子树
	 * 		有：将先序遍历序列中此根结点的下一个结点作为此根结点的左孩子结点
	 * 			将此左子树作为新的树并递归
	 * 		无：无操作
	 * 	通过中序遍历序列判断该结点有无右子树
	 * 		有：将先序遍历序列中此根结点的下一个结点作为此根结点的右孩子结点
	 * 			将此右子树作为新的树并递归
	 * 		无：无操作
	 */
	
	//记录递归过程中已做过根结点的结点在数组A中的索引
	static int has = 0;
	/**
	 * 通过先序遍历序列和中序遍历序列建立该二叉树的二叉链表
	 * @param A
	 * 			先序遍历序列
	 * @param B
	 * 			中序遍历序列
	 * @param rNum
	 * 			根结点在先序遍历序列中的索引
	 * @param lStart
	 * 			树在中序遍历序列中的起始索引
	 * @param rEnd
	 * 			树在中序遍历序列中的结束索引
	 * @return
	 * 			二叉链表的根结点
	 */
	public static TreeNode creatLinkBiTreeByPreIn(TreeNode[] A, TreeNode[] B, int rNum, int lStart, int rEnd) {
		//寻找根结点在数组B中的索引
		TreeNode root = new TreeNode();
		root = A[rNum];
		//记录根结点在数组B中的索引
		int rNumB = lStart;
		for(int x = lStart; B[x].getData() != root.getData(); x++) {
			rNumB++;
		}
		//拆分左右子树
		//左子树
		if((rNumB - lStart) > 0) {
			//连接左孩子
			root.setLchild(A[++has]);
			
			creatLinkBiTreeByPreIn(A, B, has, lStart, (rNumB - 1));
		}
		
		//右子树
		if((rEnd - rNumB) > 0) {
			//连接右孩子
			root.setRchild(A[++has]);
			
			creatLinkBiTreeByPreIn(A, B, has, ++rNumB, rEnd);
		}
		
		return root;
	}
	
	//判断一个按照二叉链表形式存储的二叉树是否是满二叉树
	/*
	 * 思路
	 * 	类似层次遍历
	 * 	tag：用于记录当前层的结点是否有孩子
	 * 	使用level记录当前结点的个数
	 * 	出队一个判断其是否拥有左孩子和右孩子 
	 * 		均有：若tag = 1，则将其孩子入队；
	 * 			    若tag = 0，返回false
	 * 		只有一个：返回false
	 * 		均无:若tag = 1，返回true
	 * 			  若tag = 0
	 */
	/**
	 * 判断一个按照二叉链表形式存储的二叉树是否是满二叉树
	 * @param root
	 * 				二叉树的根结点
	 * @return
	 * 				是否是满二叉树
	 */
	public static boolean isFullBiTree(TreeNode root) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		TreeNode temp = new TreeNode();
		
		//记录当前层的节点数
		int level = 1;
		//记录下一层的节点数
		int nextLevel = 0;
		//记录该层的一个结点是否是叶子结点
		int tag = 0;
		
		cq.enQueue(root);
		while(!cq.queueEmpty()) {
			for(int x = 0; x < level; x++) {
				temp = cq.deQueue();
				
				if(temp.getLchild() != null && temp.getRchild() != null) {
					//记录该层第一个结点的情况
					if(x == 0) {
						tag = 1;
					}
					if(tag == 1) {
						cq.enQueue(temp.getLchild());
						cq.enQueue(temp.getRchild());
						nextLevel++;
						nextLevel++;
					} else {
						return false;
					}
				} else if(temp.getLchild() == null && temp.getRchild() == null) {
					if(x == 0) {
						tag = 0;
					}
					
					if(tag == 1) {
						return false;
					}
				} else {
					return false;
				}
			}
			
			level = nextLevel;
			nextLevel = 0;
		}
		
		return true;
	}
	
	//第七题
	/*
	 * 思路
	 * 	和判断满二叉树类似
	 * 	只要判断tag在一层中的变化次数是否小于2
	 * 		是：下一层为叶子结点，tag应始终为0
	 * 		否：不是完全二叉树
	 */
	/*------------------------------
	 * 问题：书上的代码简洁很多 
	 */
	public static boolean isCompleteBiTree(TreeNode root) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		TreeNode temp = new TreeNode();
		
		//记录当前层的节点数
		int level = 1;
		//记录下一层的节点数
		int nextLevel = 0;
		//记录该层的一个结点是否是倒数第二层的叶子结点或单孩子结点
		int tag = 0;
		//记录上一层是否为倒数第二层，tags=1说明上一层为倒数第二层
		int tags = 0;
		
		cq.enQueue(root);
		while(!cq.queueEmpty()) {
			for(int x = 0; x < level; x++) {
				temp = cq.deQueue();
				
				if(temp.getLchild() != null && temp.getRchild() != null) {
					//若上一层为倒数第二层，则此层的结点不能有孩子结点
					if(tags == 1) {
						return false;
					}
					//记录该层第一个结点的情况
					if(x == 0) {
						tag = 1;
					}
					if(tag == 1) {
						cq.enQueue(temp.getLchild());
						cq.enQueue(temp.getRchild());
						nextLevel++;
						nextLevel++;
					} else {
						return false;
					}
				} else if(temp.getLchild() == null && temp.getRchild() == null) {
					if(x == 0) {
						tag = 0;
					}
					
					if(tag == 1) {
						tag = 0;
						tags = 1;
					}
				} else if(temp.getLchild() != null && temp.getRchild() ==null){
					if(tag == 1) {
						cq.enQueue(temp.getLchild());
						nextLevel++;
					} else {
						return false;
					}
					
					tag = 0;
					tags = 1;
				} else {
					return false;
				}
			}
			
			level = nextLevel;
			nextLevel = 0;
		}
		
		return true;
	}
	
	//第八题
	/*
	 * 思路
	 * 	用层次遍历的方法
	 * 	依次判断每个结点的分支个数
	 * 		两个：计数+1
	 */
	/**
	 * 计算一棵给定二叉树的所有双分支结点个数
	 * @param root
	 * 			二叉树的根结点
	 * @return
	 * 			二叉树的所有分支节点个数	
	 */
	public static int countDouble(TreeNode root) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
	
		TreeNode temp = new TreeNode();
		int count = 0;
		
		cq.enQueue(root);
		
		while(!cq.queueEmpty()) {
			temp = cq.deQueue();
			if(temp.getLchild() != null && temp.getRchild() != null) {
				count++;
				cq.enQueue(temp.getLchild());
				cq.enQueue(temp.getRchild());
			} else if(temp.getLchild() != null && temp.getRchild() == null) {
				cq.enQueue(temp.getLchild());
			} else if(temp.getLchild() == null && temp.getRchild() != null) {
				cq.enQueue(temp.getRchild());
			}
		}
		
		return count;
	}
	
	/*
	 * 书上思路
	 * 	使用递归
	 */
	/**
	 * 使用递归计算一棵给定二叉树的所有双分支结点个数
	 * @param root
	 * 			二叉树的根结点
	 * @return
	 * 			二叉树的所有双分支结点的个数
	 */
	public static int countDouble2(TreeNode root) {
		if(root == null) {
			return 0;
		} else if(root.getLchild() != null && root.getRchild() != null) {
			return countDouble2(root.getLchild()) + countDouble2(root.getRchild()) + 1;
		} else {
			return countDouble2(root.getLchild()) + countDouble2(root.getRchild());
		}
	}
	
	//第九题
	/*
	 * 思路
	 * 	使用递归
	 * 		边界条件
	 * 			当前结点为空
	 * 		递归前进段
	 * 			（有左孩子则）将左孩子作为当前结点
	 * 			（有右孩子则）将右孩子作为当前结点
	 * 		递归返回段
	 * 			将当前结点的左孩子和右孩子互换
	 */
	public static void changeChildren(TreeNode root) {
		//建立用于帮助交换的临时存储结点
		TreeNode temp = new TreeNode();
		
		//边界条件
		if(root != null) {
			//递归前进段
			//这两个条件的判断实则就是边界条件，因此可以省略
			//if(root.getLchild() != null) {
				changeChildren(root.getLchild());
			//}
			//if(root.getRchild() != null) {
				changeChildren(root.getRchild());
			//}
			
			//递归返回段，交换孩子结点
			temp = root.getLchild();
			root.setLchild(root.getRchild());
			root.setRchild(temp);
		}
	}

	//第十题
	/*
	 * 思路
	 * 	在先序遍历时，添加一个参数，用于记录已遍历了多少结点
	 * 	最初是k，当遍历到1时，输出该结点的值
	 */
	static int count = 0;
	/**
	 * 求以二叉链存储结构存储的二叉树，其先序遍历中第k个结点的值
	 * @param root
	 * 			二叉树的根结点
	 * @param k
	 * 			第k个结点
	 */
	public static void whichPreOrder(TreeNode root, int k){
		count = k;
		if(root != null && count > 0) {
			if(count == 1){
				System.out.println(root.getData());
			} else {
				if(root.getLchild() != null)
					whichPreOrder(root.getLchild(), count-1);
				if(root.getRchild() != null)
					whichPreOrder(root.getRchild(), count-1);
			}
		}
	}
	
	//第十一题
	/*
	 * 思路
	 * 	使用先序遍历
	 * 	用一个结点pre记录当前结点的前驱结点
	 * 	树的根结点需要特殊处理
	 */
	/**
	 * 对于树中每一个元素值为value的结点，删去以它为根的子树（找孩子，删双亲）
	 * @param root
	 * 			二叉树的根结点
	 * @param value
	 * 			指定的元素值
	 */
	public static void deleteValueTree(TreeNode root, String value) {
		if(root != null) {
			if(root.getData().equals(value)) {
				if(pre != null) {
					if(pre.getLchild() == root) {
						pre.setLchild(null);
					} else {
						pre.setRchild(null);
					}
				} else {
					System.out.println("整棵树被删除");
				}
			} else {
				if(root.getLchild() != null) { 
					pre = root;
					deleteValueTree(root.getLchild(), value);
				}
				if(root.getRchild() != null) {
					pre = root;
					deleteValueTree(root.getRchild(), value);
				}
			}
		}
	}
	/*
	 * 思路2
	 * 	我想到的：可以通过判断结点的孩子结点去删除孩子的子树
	 * 	用层次遍历一层层来找应该会好一些
	 */
	/**
	 * 对于树中每一个元素值为value的结点，删去以它为根的子树（找双亲，删孩子）
	 * @param root
	 * 			二叉树的根结点
	 * @param value
	 * 			指定的元素值
	 */
	public static void deleteValueTree2(TreeNode root, String value) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		cq.enQueue(root);
		
		TreeNode temp = new TreeNode();
		
		if(root.getData().equals(value)) {
			//删除根结点意味着整棵树被删除，因其没有双亲结点，所以只能这样了
			System.out.println("整棵树被删除");
		} else {
			while(!cq.queueEmpty()) {
				temp = cq.deQueue();
				
				if(temp.getLchild() != null) {
					if(temp.getLchild().getData().equals(value)) {
						temp.setLchild(null);
					} else {
						cq.enQueue(temp.getLchild());
					}
				}
				
				if(temp.getRchild() != null) {
					if(temp.getRchild().getData().equals(value)) {
						temp.setRchild(null);
				} else {
						cq.enQueue(temp.getRchild());
					}
				}
			}
		}
	}
	
	//第十二题
	/*
	 * 使用非递归的后序遍历
	 * 当遍历到指定结点时，依次输出栈中结点的值即可
	 */
	/**
	 * 打印值为value的结点的所有祖先
	 * @param root
	 * 			二叉树的根结点
	 * @param value
	 * 			指定的值
	 */
	public static void showAncestor(TreeNode root, String value) {
		SequenceStack<TreeNode> ss = new SequenceStack<>();
		ss.InitStack();
		ss.Push(root);
		root.visit++;
		
		TreeNode top = new TreeNode();
		
		while(!ss.StackEmpty()) {
			top = ss.GetTop();
			
			if(top.getData().equals(value)) {
				ss.Pop();
				//打印祖先结点
				while(!ss.StackEmpty()) {
					TreeNode temp = new TreeNode();
					temp = ss.Pop();
					System.out.println(temp.getData());
				}
			} else if(top.getLchild() != null && top.getLchild().visit == 0) {
				//沿左支向下
				ss.Push(top.getLchild());
				top.getLchild().visit++;
			} else if(top.getRchild() != null && top.getRchild().visit == 0) {
				//沿右支向下
				ss.Push(top.getRchild());
				top.getRchild().visit++;
			} else {
				//将不符合要求的结点退栈
				ss.Pop();
			}
		}
	}
	
	//第十三题
	/*
	 * 思路
	 * 	用非递归的后序遍历，找到结点p
	 * 	然后依次出栈其祖先结点，后序遍历寻找结点q
	 * 		找到：其为公共结点
	 */
	public static TreeNode ancestor(TreeNode root, TreePointer p, 
			TreePointer q) {
		SequenceStack<TreeNode> ss = new SequenceStack<>();
		ss.InitStack();
		ss.Push(root);
		root.visit++;
		
		TreeNode top = new TreeNode();
		TreeNode r = new TreeNode();
		
		while(!ss.StackEmpty()) {
			top = ss.GetTop();
			
			if(top == p.getNode()) {
				//依次出栈其祖先结点，后序遍历寻找结点q
				ss.Pop();
				while(!ss.StackEmpty()) {
					SequenceStack<TreeNode> ss2 = new SequenceStack<>();
					ss2.InitStack();
					
					TreeNode sonRoot = ss.Pop();
					ss2.Push(sonRoot);

					while(!ss2.StackEmpty()) {
						TreeNode top2 = new TreeNode();
						top2 = ss2.GetTop();
						
						if(top2 == q.getNode() && top2.visit == 2) {
							/*
							 * top2.visit == 2的意义
							 * 若p是q的子节点，会发生将q当做公共节点的情况
							 * 此时q.visit == 1
							 * 我们将q不做为公共节点
							 * 当q的双亲节点遍历到q时，q.visit == 2
							 * 此时q的双亲结点则为p和q的最近公共祖先结点
							 */
							r = sonRoot;
							return r;
						}else if(top2.getLchild() != null && top2.getLchild().visit < 2) {
							//沿左支向下
							ss2.Push(top2.getLchild());
							top2.getLchild().visit++;
						} else if(top2.getRchild() != null && top2.getRchild().visit < 2) {
							//沿右支向下
							ss2.Push(top2.getRchild());
							top2.getRchild().visit++;
						} else {
							//将不符合要求的结点退栈
							ss2.Pop();
						}
					}
				}
			} else if(top.getLchild() != null && top.getLchild().visit == 0) {
				//沿左支向下
				ss.Push(top.getLchild());
				top.getLchild().visit++;
			} else if(top.getRchild() != null && top.getRchild().visit == 0) {
				//沿右支向下
				ss.Push(top.getRchild());
				top.getRchild().visit++;
			} else {
				//将不符合要求的结点退栈
				ss.Pop();
			}
		}
		
		return null;
	}
	
	//第十四题
	/*
	 * 思路
	 * 		使用层次遍历
	 * 		记录每一层的结点数count
	 * 		将最大的赋值给width
	 */
	public static int width(TreeNode root) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		int width = 1;
		int count = 1;
		int nextCount = 0;
		
		cq.enQueue(root);
		
		TreeNode temp = new TreeNode();
		
		while(!cq.queueEmpty()) {
			for(int x = 0; x < count; x++) {
				//重置层节点计数
				if(x == 0) {
					nextCount = 0;
				}
				
				temp = cq.deQueue();
				if(temp.getLchild() != null) {
					cq.enQueue(temp.getLchild());
					nextCount++;
				}
				if(temp.getRchild() != null) {
					cq.enQueue(temp.getRchild());
					nextCount++;
				}
			}
			count = nextCount;
			if(nextCount > width) {
				width = nextCount;
			}
		}
		return width;
	}
	
	//第十五层
	/*
	 * 思路1：
	 * 	通过递归求阶乘的算法，算出该满二叉树有几层
	 * 	然后创建链式二叉树
	 * 	在求其后序序列
	 * 
	 * 思路2：
	 * 	直接对先序序列进行操作
	 * 	将先序通过链表存储
	 * 	每个字母插入到其子节点个数个结点之后
	 * 
	 * -------------------------------------
	 * 思路1和思路2执行起来不算很简单
	 * 代码有待补全
	 */
	//思路1
	/**
	 * 幂
	 */
	static int power = 0;
	/**
	 * 通过序列的结点个数，算出满二叉树的层数
	 * @param quantity
	 * 			序列的结点个数
	 * @return
	 * 			满二叉树的层数
	 */
	private static int levelOfFullBiTree(int quantity) {
		if((Math.pow(2,power) - 1) != quantity) {
			power++;
			levelOfFullBiTree(quantity);
		}
		
		return power;
	}
//	public static void findPostByPre(TreeNode[] pre) {
//		//通过递归求阶乘的算法，算出该满二叉树有几层
//		int quantity = pre.length + 1;
//		levelOfFullBiTree(quantity);
//		
//		//记录操作到第几层了
//		int count = 1;
//		TreeNode root = new TreeNode();
//		for(int x = 1; x < pre.length; x++) {
//			
//		}
//	}
//	
//	//思路2
//	public static void finPostByPre2(Link)
	/*
	 * 思路三，根据书上思路改编
	 * 使用递归
	 * 		边界条件：h1 < l1
	 * 		递归体：
	 * 			post[h2] = pre[l1]
	 * 			half = (h1-l1)/2
	 * 			左子树：l1 = l1+1; h1 = l1+half-1; l2 = l2; h2 = l2+half-1
	 * 			右子树：l1 = half+1; h2 =l1+half-1; l2 = l2+half; h2 = l2+half-1
	 * 	递归完后，填补post序列的空缺
	 * 		利用递归算出二叉树有level层
	 * 		从pre的第level-1个，post的第0个同时遍历
	 * 			若当前的post[]为空，则将当前的pre[]填入post[]
	 * 			若当前的post[]非空，则跳过
	 */
	/*----------------------------------------------
	 * 弄清楚方法的本质，其究竟是怎么运作的
	 * 答：
	 * 和我的“每个字母插入到其子节点个数个结点之后”类似
	 * 
	 * 这里的子节点个数，通过half和l1,h1算出，并通过l2,h2确定其位置
	 * 因为满二叉树的子树的结点个数和其上一级子树的结点个数是1/2的关系
	 * 
	 * 但这里的插入只针对树的根结点和子树的根结点，而不是“每个字母”
	 * 叶子结点则在根结点插入完毕后，依次填入空缺
	 */
	/**
	 * 将满二叉树的先序序列中树的根结点和子树的根结点放置在后序序列中
	 * 的对应位置上
	 * @param pre
	 * 			先序序列数组
	 * @param l1
	 * 			先序序列的起始索引
	 * @param h1
	 * 			先序序列的结束索引
	 * @param post
	 * 			后序序列数组
	 * @param l2
	 * 			后序序列的起始索引
	 * @param h2
	 * 			后序序列的结束索引
	 */
	private static void changeRoot(TreeNode[] pre, int l1, int h1, 
			TreeNode[] post, int l2, int h2) {
		if(h1 >= l1) {
			post[h2] = pre[l1];
			int half = (h1-l1)/2;
			//左子树
			changeRoot(pre, l1+1, l1+half, post, l2, l2+half-1);
			//右子树
			changeRoot(pre, l1+half+1, l1+2*half, post, l2+half, l2+2*half-1);
		}
	}
	/**
	 * 将先序序列中的叶子结点放置在树的根结点和子树的根结点已经入位的
	 * 后序序列的对应位置上
	 * @param pre
	 * 			先序序列数组
	 * @param post
	 * 			后序序列数组
	 */
	private static void fillLeaf(TreeNode[] pre, TreeNode[] post) {
		int level = levelOfFullBiTree(pre.length);
		for(int x = level-1,y = 0; x < pre.length; x++,y++) {
			if(post[y] == null) {
				post[y] = pre[x];
			} else {
				continue;
			}
		}
	}
	/**
	 * 通过一棵满二叉树的先序序列，求其后序序列
	 * @param pre
	 * 			先序序列数组
	 * @param l1
	 * 			先序序列的起始索引
	 * @param h1
	 * 			先序序列的结束索引
	 * @param post
	 * 			后序序列数组
	 * @param l2
	 * 			后序序列的起始索引
	 * @param h2
	 * 			后序序列的结束索引
	 */
	public static void findPostByPre3(TreeNode[] pre, int l1, int h1, 
			TreeNode[] post, int l2, int h2) {
		changeRoot(pre, l1, h1, post, l2, h2);
		
		//最后填补post序列的空缺
		fillLeaf(pre, post);
		
	}
	
	//第十六题
	/*
	 * 思路：
	 * 	通过先序遍历，可从左至右依次访问叶子结点
	 * 		通过判断其是否无孩子结点判断是否为叶子结点
	 * 	将叶子结点存入队列
	 * 	遍历完毕后，依次出队，组成单链表
	 */
	public static TreePointer leafSingleLinked(TreeNode root) {
		//存储叶子结点的队列
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		//非递归的先序遍历
		/*
		 * 之所以不用递归的先序遍历
		 * 是因为那需要创建一个新的方法
		 *
		 *	在我的设想中，新的方法负责递归遍历
		 *	该方法负责判断
		 *	那么需要用到多线程
		 *	
		 *	而使用非递归的先序遍历，则简单的多
		 *
		 * 递归边界：递归到叶子结点
		 * 递归体：若该结点非叶子结点
		 * 			若存在左孩子，则递归到左孩子
		 * 			若存在右孩子，则递归到右孩子
		 *  
		 */
		//模拟递归的栈
		SequenceStack<TreeNode> ss = new SequenceStack<>();
		ss.InitStack();
		
		TreeNode tempNode = new TreeNode();
		TreeNode temp = new TreeNode();
		temp = root;
		while(!ss.StackEmpty() || temp != null) {
			if(temp != null) {
				if(temp.getLchild() == null && temp.getRchild() == null) {
					cq.enQueue(temp);
				}
				ss.Push(temp);
				temp = temp.getLchild();
			} else {
				tempNode = ss.Pop();
				temp = tempNode.getRchild();
			}
		}
		
		TreePointer head = new TreePointer();
		head.setNode((TreeNode)cq.deQueue());
		
		TreeNode operator = new TreeNode();
		operator = head.getNode();
		while(!cq.queueEmpty()) {
			operator.setRchild((TreeNode)cq.deQueue());
			operator = operator.getRchild();
		}
		return head;
	}
	/*
	 * 实际上，先序、中序、后序在访问叶节点时都是从左至右
	 * 而如果在遍历时就组织链表，则不需要队列，也就可以使用递归
	 * 书上采用的中序遍历的递归，我这里就采用先序遍历的递归以与之前的非递归方法对应
	 */
	/*
	 * 思路
	 * 	指针prePointer指向前驱结点，初始为null
	 * 		若该结点为叶子结点
	 * 			若prePointer = null
	 * 				prePointer指向该叶子结点
	 * 			若prePointer != null
	 *  			prePointer.getNode.setRchild = 该叶子结点
	 */
	static TreePointer prePointer = new TreePointer();
	static TreePointer head = new TreePointer();
	public static TreePointer leafSingleLinked2(TreeNode root) {
		if(root != null) {
			if(root.getLchild() == null && root.getRchild() == null) {
				if(prePointer.getNode() == null) {
					head.setNode(root);
					prePointer.setNode(root);
				} else {
					prePointer.getNode().setRchild(root);
					prePointer.setNode(prePointer.getNode().getRchild());
				}
			}
			leafSingleLinked2(root.getLchild());
			leafSingleLinked2(root.getRchild());
		}
		
		return head;
	}
	
	//第十七题
	/*
	 * 同时层次遍历T1和T2
	 *	若两树相似，则其队列长度始终相同
	 * 
	 * 书上采用的是递归的方法
	 * 同时递归遍历两棵树，判断两个结点的孩子情况
	 */
	public static boolean similar(TreeNode root1, TreeNode root2) {
		CyclicQueue<TreeNode> cq1 = new CyclicQueue<>();
		cq1.initQueue();
		CyclicQueue<TreeNode> cq2 = new CyclicQueue<>();
		cq2.initQueue();
		
		cq1.enQueue(root1);
		cq2.enQueue(root2);
		
		TreeNode temp1 = new TreeNode();
		TreeNode temp2 = new TreeNode();
		
		while(!cq1.queueEmpty() && !cq2.queueEmpty()) {
			if(cq1.length() == cq2.length()) {
				temp1 = cq1.deQueue();
				temp2 = cq2.deQueue();
			
				if(temp1.getLchild() != null) {
					cq1.enQueue(temp1.getLchild());
				}
				if(temp1.getRchild() != null) {
					cq1.enQueue(temp1.getRchild());
				}
				if(temp2.getLchild() != null) {
					cq2.enQueue(temp2.getLchild());
				}
				if(temp2.getRchild() != null) {
					cq2.enQueue(temp2.getRchild());
				}
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	//第十八题
	/*
	 * 分析
	 * 	后序线索化的后序前驱
	 * 		根结点的前驱是其右孩子结点。
	 * 			若右孩子结点为null，则是其左孩子结点
	 * 
	 * 		右结点的前驱是其左兄弟。
	 * 			若左兄弟为null，则是其第一个有左孩子结点的祖先结点
	 * 		
	 * 		左结点的前驱是其根结点的左孩子，若其是自己所在的子树，则继续追溯根结点
	 * 			若为null，则为null
	 * 
	 * 
	 * 	对应的中序线索化的后续前驱
	 * 		根结点的前驱是其右孩子结点
	 * 			若右孩子结点为null，则是其左孩子结点
	 * 
	 * 		右结点的前驱是其左孩子的左孩子
	 * 			若为null，则是其左孩子的左孩子，知道此根结点的ltag=0，返回其左孩子
	 * 		左结点同右结点
	 * ---------------------------------------
	 * 原版
	 * 		左结点的前驱是左孩子的左孩子
	 * 			若null，则为null
	 * 当画出四层的满二叉树后发现，左右结点的情况其实一样
	 * ---------------------------------------
	 */
	/**
	 * 在中序线索二叉树里查找指定结点在后序的前驱结点的算法
	 * @param node
	 * 			指定结点
	 * @return
	 * 			指定结点的后续前驱
	 */
	public static TreeNode predecessorOfPostByIn(TreeNode node) {
		if(node.rtag == 0) {
			return node.getRchild();
		} else if(node.ltag == 0) {
			return node.getLchild();
		} else {
			TreeNode temp = node;
			while(temp.ltag == 1) {
				if(temp.getLchild() != null) {
					temp = temp.getLchild();
				} else {
					return null;
				}
			}
			return temp.getLchild();
		}
	}
	//原版：左右结点分开考虑
//	public static TreeNode predecessorOfPostByIn(TreeNode root) {
//		if(root.getRchild() != null && root.rtag == 0) {
//			return root.getRchild();
//		} else if(root.rtag == 1 && root.getLchild() != null && root.ltag == 0) {
//			return root.getLchild();
//		} else if(root.getLchild() == null && root.ltag == 1) {
//			//若其不是根结点，则是中序和后序的起始结点
//			return null;
//		}else if(root.getLchild().getRchild() == root) {
//			//其为右结点
//			if(root.getLchild().ltag == 0) {
//				return root.getLchild().getLchild();
//			} else {
//				TreeNode temp = root.getLchild();
//				while(temp.ltag == 1) {
//					temp = temp.getLchild();
//				}
//				return temp.getLchild();
//			}
//		} else if(root.getRchild().getLchild() == root) {
//			//其为左结点
//			if(root.getLchild().getLchild() != null) {
//				return root.getLchild().getLchild();
//			} else {
//				return null;
//			}
//		}
//		
//		return null;
//	}
	
	//第十九题
	/*
	 * TNND！带权路径长度是深度*权值
	 * 1、基本设计思想
	 * 使用层次遍历遍历每一层结点，并记录当前遍历到的层数
	 * 若遍历到叶子结点，则计算其带权路径长度，并将其累加到wpl中
	 * 若遍历到非叶子结点，则将其孩子结点入队，继续层次遍历
	 */
	public static int wpl(TreeNode root) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		cq.enQueue(root);
		
		//带权路径长度
		int wpl = 0;
		//记录当前深度
		int deep = 1;
		//记录当前的结点个数
		int count = 1;
		//记录下一层的结点个数
		int nextCount = 0;
		//记录当前遍历到的结点数
		int nowCount = 0;
		
		TreeNode temp = new TreeNode();
		
		while(!cq.queueEmpty()) {
			temp = cq.deQueue();
			nowCount++;
			
			if(temp.getLchild() != null) {
				cq.enQueue(temp.getLchild());
				nextCount++;
			}
			if(temp.getRchild() != null) {
				cq.enQueue(temp.getRchild());
				nextCount++;
			}
			if(temp.getLchild() == null && temp.getRchild() == null) {
				wpl += Integer.parseInt(temp.getData())*deep;
			}
			if(nowCount == count) {
				deep++;
				nowCount = 0;
				count = nextCount;
				nextCount = 0;
			}
		}
		return wpl;
	}
	
	/*
	 * 思路2
	 * 	基本思路
	 * 	使用递归的先序遍历
	 * 	若当前结点为叶子结点，则累计wpl，然后继续递归的先序遍历
	 * 	若当前结点非叶子结点，则继续递归的先序遍历
	 */
	static int wpl = 0;
	public static int wplByPreRecursive(TreeNode root, int deep) {
		if(root != null) {
			if(root.getLchild() == null && root.getRchild() == null) {
				wpl += Integer.parseInt(root.getData())*deep;
			} 
			if(root.getLchild() != null) {
				wplByPreRecursive(root.getLchild(), deep+1);
			}
			if(root.getRchild() != null) {
				wplByPreRecursive(root.getRchild(), deep+1);
			}
		}
		
		return wpl;
	}
	
	//第二十题
	/*
	 * 表达式树后序遍历就是后缀表达式
	 * 表达式树中序遍历就是中缀表达式
	 * 1、基本设计思想
	 * 	中序遍历表达式树
	 * 	一个根结点或根结点的左孩子结点若无左孩子结点，则在输出它之前输出"("
	 * 	一个根结点的右孩子结点若无右孩子结点，则在输出它之前输出")"，并且当它的所处的深度
	 * 	大于3时，每多一层，额外输出一个")"
	 * 	
	 */
	/**
	 * 根据表达式树，输出中缀表达式
	 * @param root
	 * 			表达式树的根结点
	 */
	public static void expressionTreeToNifix(TreeNode root) {
		expressionTreeToNifixOperator(root, null, 1);
	}
	/**
	 * 根据表达式树，输出中缀表达式的主要操作
	 * @param root
	 * 			表达式树的根结点
	 * @param pre
	 * 			当前遍历到的结点的前驱结点，初始为null
	 * @param deep
	 * 			当前遍历到的深度，初始为1
	 */
	private static void expressionTreeToNifixOperator(TreeNode root, TreeNode pre, int deep) {
		if(root != null) {
			if(root.getLchild() != null) {
				expressionTreeToNifixOperator(root.getLchild(), root, deep+1);
			} else if(pre.getLchild() == root || root.getRchild() != null){
				System.out.print("(");
			}
			System.out.print(root.getData());
			if(root.getRchild() != null) {
				expressionTreeToNifixOperator(root.getRchild(), root,deep+1);
			} else if(pre.getRchild() == root){
				System.out.print(")");
				if(deep > 3) {
					for(int x = 0; x < deep-3; x++) {
						System.out.println(")");
					}
				}
			}
		}
	}

	/*
	 * 书上思路更加简洁，美观
	 * 	在中序遍历时，除了根结点和叶结点，
	 * 	其他结点在遍历左子树之前加上"("，在遍历右子树之后加上")"
	 * 	使用层数判断当前结点是否为根结点
	 */
	public static void expressionTreeToNifex2(TreeNode root) {
		expressionTreeToNifix2Operator(root, 1);
	}
	private static void expressionTreeToNifix2Operator(TreeNode root, int deep) {
		if(root != null) {
			//叶结点
			if(root.getLchild() == null && root.getRchild() == null) {
				System.out.print(root.getData());
			} else {
				if(deep > 1) {
					System.out.print("(");
				}
				expressionTreeToNifix2Operator(root.getLchild(), deep+1);
				System.out.print(root.getData());
				expressionTreeToNifix2Operator(root.getRchild(), deep+1);
				if(deep > 1) {
					System.out.print(")");
				}
			}
		}
	}
}