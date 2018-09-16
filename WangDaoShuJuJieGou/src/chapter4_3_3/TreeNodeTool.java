package chapter4_3_3;

import chapter3_1_4.SequenceStack;
import chapter3_2_5.CyclicQueue;

//���ڲ����������������Ĺ�����
public class TreeNodeTool {
	/**
	 * ���ڵ����Ϊ����
	 * 
	 * @param lchild 
	 * 				���ӽ��
	 * @param parent 
	 * 				˫�׽ڵ�
	 */
	public static void ladd(TreeNode lchild, TreeNode parent) {
		if (parent.getLchild() == null) {
			parent.setLchild(lchild);
		} else {
			System.out.println("��˫�׽���������ӽ��");
		}
	}
	
	/**
	 * ���ڵ����Ϊ�Һ���
	 * 
	 * @param rchild
	 * 				�Һ��ӽڵ�
	 * @param parent
	 * 				˫�׽ڵ�
	 */
	public static void radd(TreeNode rchild, TreeNode parent) {
		if (parent.getRchild() == null) {
			parent.setRchild(rchild);
		} else {
			System.out.println("��˫�׽�������Һ��ӽ��");
		}
	}
	
	/**
	 * ǰ��������������ݹ飩
	 * 
	 * @param T 
	 * 			������������ָ��
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
	 * ����������������ݹ飩
	 * @param T
	 * 			������������ָ��
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
	 * ����������������ݹ飩
	 * @param T
	 * 			������������ָ��
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
	 * 	ǰ��������������ǵ�����
	 * 	˼·
	 * 		A.��ָ��tempָ������
	 *  	B.�ж�ָ��tempָ��Ľ���Ƿ�Ϊ��
	 *  		a.�ǿ�
	 *  			1.���˽��ѹջ
	 *  			2.����˽ڵ��data
	 *  			3.��tempָ���������ӽ��
	 *  			3.�ص�B
	 *  		b.��
	 *  			1.��ջ
	 *  			2.��tempָ��ջ��Ԫ�ص��Һ��ӽ��
	 *  			3.�ص�B
	 *  	C.�ظ�B��ֱ��temp��ջ��Ϊ��
	 */
	/**
	 * ǰ��������������ǵݹ飩
	 * @param T
	 * 			������������ָ��
	 */
	public static void preOrder(TreePointer T) {
		//��ָ��tempָ������
		TreePointer temp = new TreePointer();
		temp.setNode(T.getNode());
			
		//����ջ
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
	 *  ����������������ǵ�����
	 *  ˼·
	 *  	A.��ָ��tempָ������
	 *  	B.�ж�ָ��tempָ��Ľ���Ƿ�Ϊ��
	 *  		a.�ǿ�
	 *  			1.���˽��ѹջ
	 *  			2.��tempָ���������ӽ��
	 *  			3.�ص�B
	 *  		b.��
	 *  			1.��ջ��Ԫ�ص�ջ��������tempNode�У��������data
	 *  			2.��tempָ�����Һ��ӽ��
	 *  			3.�ص�B
	 *  	C.�ظ�B��ֱ��temp��ջ��Ϊ��
	 */
	/**
	 * ����������������ǵݹ飩
	 * @param T
	 * 			�������ĸ����ָ��
	 */
	public static void inOrder(TreePointer T) {
		//��ָ��tempָ������
		TreePointer temp = new TreePointer();
		temp.setNode(T.getNode());
		
		//����ջ
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
	 * ����visitͳ�ƽ�㱻���ʵĴ���
	 * ��ջ��Ϊ��
	 * 	p != null  
	 * 		p.node.visit == 0
	 * 			p.node��ջ
	 * 			p.node.visit++
	 * 			p = p->lchild
	 * 		p.node.visit != 0
	 * 			syso(ss.pop.data)
	 * 			ss��Ϊ��
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
	
	//������
	/**
	 * �������ĺ���������ǵݹ飩
	 * @param T
	 * 			�������ĸ����ָ��
	 */
	public static void postOrder(TreePointer T) {
		TreePointer p = new TreePointer();
		p.setNode(T.getNode());
		
		TreeNode temp = new TreeNode();
		
		//����ջ
		SequenceStack<TreeNode> ss = new SequenceStack<>();
		ss.InitStack();
		
		int count = 0;
		
		while(!ss.StackEmpty() || count == 0) {
			if(p.getNode() != null) {
				//ֻ�е����δ������ʱ����Ҫ��ջ
				if(p.getNode().getVisit() == 0) {
					ss.Push(p.getNode());
					p.getNode().visit++;
					p.setNode(p.getNode().getLchild());
					
					//������ʾջ�ѱ��������ڶ��ο�ջʱ��Ϊ����
					count++;
				} else {
					//�ýڵ�ͨ��˫�׽����ʣ��ɸýڵ��ѱ����ʹ��������˫�׽������ҽ��������ʣ����˫�׽��
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
	 * ��α���������
	 * @param T
	 * 			�������ĸ�����ָ��
	 */
	public static void levelOrder(TreePointer T) {
		//��������
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		//����ָ��
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
	//ָ��ǰһ�η��ʵĽ��,ǰ
		static TreeNode pre = null;
	//����������������ǰ��
	/*
	 * 	˼·����һ��׼ȷ��
	 * 		�����жϽ������Һ��ӽ��
	 * 		
	 * 		��������������ж��������н������ӽ�����жϽ����Һ��Ӽ���
	 * 		
	 */
		/**
		 * ��������������������
		 * @param p
		 * 			�������ĸ����
		 */
		public static void preOrderThreadBiTree(TreeNode p) {
			preOrderThread(p);
			if(pre.getRchild() == null) {
				pre.rtag = 1;
			}
			
			pre = null;
		}
		
		/**
		 * �������������������򣩵���Ҫ����
		 * @param p
		 * 			�������ĸ����
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
		 * �������������������н��p�����������µĺ�̽��
		 * @param p
		 * 			���ؽ���ǰ�����
		 * @return
		 * 			���p�ĺ�̽��
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
	//��������������������
	/*
	 * ˼����ģ�һ�θ���һ���㣬���ʹ�õݹ�
	 */
	
	/**
	 * ��������������������
	 * @param p
	 * 			�������ĸ����
	 */
	public static void inOrderThreadBiTree(TreeNode p) {
		inOrderThread(p);
		if(pre.getRchild() == null) {
			pre.rtag = 1;
		}
		
		pre = null;
	}
	
	/**
	 * �������������������򣩵���Ҫ����
	 * @param p
	 * 			�������ĸ����
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
	 * �����������������������������µĵ�һ�����
	 * @param root
	 * 			���������������ĸ����
	 * @return
	 * 			�������������������������µĵ�һ�����
	 */
	public static TreeNode firstNodeIn(TreeNode root) {
		TreeNode tNode = root;
		while(tNode.ltag == 0) {
			tNode = tNode.getLchild();
		}
		
		return tNode;
	}
	
	/**
	 * �������������������н��p�����������µĺ�̽��
	 * @param p
	 * 			���ؽ���ǰ�����
	 * @return
	 * 			���p�ĺ�̽ڵ�
	 */
	public static TreeNode nextNodeIn(TreeNode p) {
		if(p.rtag == 1) {
			return p.getRchild();
		} else {
			return firstNodeIn(p.getRchild());
		}
	}
	
	/**
	 * ���������������Ķ�����
	 * @param root
	 * 				�������ĸ����
	 */
	public static void showInOrderThreadBiTree(TreeNode root) {
		TreeNode tNode = firstNodeIn(root);
		while(tNode != null) {
			System.out.println(tNode.getData());
			tNode = nextNodeIn(tNode);
		}
	}
	
	//����������������
	/*
	 * �ݹ鵽��������Ҷ�ӽ��
	 * ������ң�Ȼ��pre=p
	 */
	/**
	 * ����������������
	 * @param root
	 * 				�������ĸ����
	 */
	public static void postOrderthreadBitree(TreeNode root) {
		postOrderThread(root);
		pre = null;
	}
	/**
	 * ��������������������Ҫ����
	 * @param root
	 * 				�������ĸ����
	 */		
	private static void postOrderThread(TreeNode root) {
		TreeNode p = new TreeNode();
		p = root;
		
		if(p != null) {
			//�ݹ鵽��������Ҷ�ӽ��
			if(p.ltag == 0) {
				p.visit++;
				postOrderThread(p.getLchild());
			} 
			if(p.rtag == 0 && p.getRchild() != null && p.getRchild().visit == 0) {
				p.visit++;
				postOrderThread(p.getRchild());
			}
		
			//������ң�Ȼ��pre=p
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
	 * ���غ����������Ķ���������ʼ���
	 * @param root
	 * 				�������ĸ����
	 * @return
	 * 				����������ʼ���
	 */
	public static TreeNode firstNodePost(TreeNode root) {
		TreeNode first = new TreeNode();
		first = root;
		//Ѱ�ұ��������
		while(first.getLchild() != null) {
			 first = first.getLchild();
		}
		
		return first;
	}
	
	/**
	 * ���غ����������������н��ĺ�̽ڵ�
	 * @param root
	 * @param p
	 * @return
	 */
	//���ڴ洢����������е�temp��ÿ�ε���ʱֵ���ڵ�ʱ��Ч���ᵼ�·���ֵ�쳣
	static TreeNode result = new TreeNode();
	public static TreeNode nextNodePost(TreeNode root, TreeNode p) {
		TreeNode temp = new TreeNode();
		temp = root;
		
		if(temp != null) {
			//�ڽ���������Ѱ��
			if(temp.getLchild() != null && temp.ltag == 0) {
				if(temp.getLchild() == p) {
					//�ж��Ƿ��к�̽�������
					if(temp.getLchild().rtag == 1) {
						result = temp.getLchild().getRchild();
					} else {
					//Ѱ�ҽ��p�����ֵܵ�����µĽ��
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
				//�ڽ���������Ѱ��
				if(temp.getRchild() != null && temp.rtag == 0) {
					if(temp.getRchild() == p) {
						result = temp;
					} else {
						nextNodePost(temp.getRchild(), p);
					}
				}
			}
		}
		
		//���ؽ��
		return result;
	}
	
	/**
	 * ���������������Ķ�����
	 * @param root
	 * 				�������ĸ����
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
	
	//������
	/**
	 * �������ϡ����������α���
	 * @param root
	 * 				�������ĸ����
	 */
	public static void levelOrderReverse(TreeNode root) {
		//��������������в�α���
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		//ջ�����洢���ӵĽ�㣬������γ�ջ��Ϊ����
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
	
	//������
	/*
	 * ˼·
	 * 	���ò�α���
	 * 	ÿ�ζ�ȡһ��Ľ��ʱ����¼һ����n�����
	 * 	������n�����󣬸߶ȣ�1
	 * 	ֱ������Ϊ��
	 */
	/**
	 * ��������ĸ߶�
	 * @param root
	 * 				�������ĸ����
	 * @return
	 * 				�������ĸ߶�
	 */
	public static int height(TreeNode root) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		//��¼һ��Ľڵ���
		int count = 1;
		//�߶�
		int height = 0;
		
		cq.enQueue(root);
		while(!cq.queueEmpty()) {
			//������ʱ��¼��һ��Ľ����
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
	
	//������
	/*
	 * ˼·
	 * 	ͨ������������л�ȡ�����
	 * 	ͨ��������������жϸý������������
	 * 		�У���������������д˸�������һ�������Ϊ�˸��������ӽ��
	 * 			������������Ϊ�µ������ݹ�
	 * 		�ޣ��޲���
	 * 	ͨ��������������жϸý������������
	 * 		�У���������������д˸�������һ�������Ϊ�˸������Һ��ӽ��
	 * 			������������Ϊ�µ������ݹ�
	 * 		�ޣ��޲���
	 */
	
	//��¼�ݹ�����������������Ľ��������A�е�����
	static int has = 0;
	/**
	 * ͨ������������к�����������н����ö������Ķ�������
	 * @param A
	 * 			�����������
	 * @param B
	 * 			�����������
	 * @param rNum
	 * 			�������������������е�����
	 * @param lStart
	 * 			����������������е���ʼ����
	 * @param rEnd
	 * 			����������������еĽ�������
	 * @return
	 * 			��������ĸ����
	 */
	public static TreeNode creatLinkBiTreeByPreIn(TreeNode[] A, TreeNode[] B, int rNum, int lStart, int rEnd) {
		//Ѱ�Ҹ����������B�е�����
		TreeNode root = new TreeNode();
		root = A[rNum];
		//��¼�����������B�е�����
		int rNumB = lStart;
		for(int x = lStart; B[x].getData() != root.getData(); x++) {
			rNumB++;
		}
		//�����������
		//������
		if((rNumB - lStart) > 0) {
			//��������
			root.setLchild(A[++has]);
			
			creatLinkBiTreeByPreIn(A, B, has, lStart, (rNumB - 1));
		}
		
		//������
		if((rEnd - rNumB) > 0) {
			//�����Һ���
			root.setRchild(A[++has]);
			
			creatLinkBiTreeByPreIn(A, B, has, ++rNumB, rEnd);
		}
		
		return root;
	}
	
	//�ж�һ�����ն���������ʽ�洢�Ķ������Ƿ�����������
	/*
	 * ˼·
	 * 	���Ʋ�α���
	 * 	tag�����ڼ�¼��ǰ��Ľ���Ƿ��к���
	 * 	ʹ��level��¼��ǰ���ĸ���
	 * 	����һ���ж����Ƿ�ӵ�����Ӻ��Һ��� 
	 * 		���У���tag = 1�����亢����ӣ�
	 * 			    ��tag = 0������false
	 * 		ֻ��һ��������false
	 * 		����:��tag = 1������true
	 * 			  ��tag = 0
	 */
	/**
	 * �ж�һ�����ն���������ʽ�洢�Ķ������Ƿ�����������
	 * @param root
	 * 				�������ĸ����
	 * @return
	 * 				�Ƿ�����������
	 */
	public static boolean isFullBiTree(TreeNode root) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		TreeNode temp = new TreeNode();
		
		//��¼��ǰ��Ľڵ���
		int level = 1;
		//��¼��һ��Ľڵ���
		int nextLevel = 0;
		//��¼�ò��һ������Ƿ���Ҷ�ӽ��
		int tag = 0;
		
		cq.enQueue(root);
		while(!cq.queueEmpty()) {
			for(int x = 0; x < level; x++) {
				temp = cq.deQueue();
				
				if(temp.getLchild() != null && temp.getRchild() != null) {
					//��¼�ò��һ���������
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
	
	//������
	/*
	 * ˼·
	 * 	���ж�������������
	 * 	ֻҪ�ж�tag��һ���еı仯�����Ƿ�С��2
	 * 		�ǣ���һ��ΪҶ�ӽ�㣬tagӦʼ��Ϊ0
	 * 		�񣺲�����ȫ������
	 */
	/*------------------------------
	 * ���⣺���ϵĴ�����ܶ� 
	 */
	public static boolean isCompleteBiTree(TreeNode root) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		TreeNode temp = new TreeNode();
		
		//��¼��ǰ��Ľڵ���
		int level = 1;
		//��¼��һ��Ľڵ���
		int nextLevel = 0;
		//��¼�ò��һ������Ƿ��ǵ����ڶ����Ҷ�ӽ��򵥺��ӽ��
		int tag = 0;
		//��¼��һ���Ƿ�Ϊ�����ڶ��㣬tags=1˵����һ��Ϊ�����ڶ���
		int tags = 0;
		
		cq.enQueue(root);
		while(!cq.queueEmpty()) {
			for(int x = 0; x < level; x++) {
				temp = cq.deQueue();
				
				if(temp.getLchild() != null && temp.getRchild() != null) {
					//����һ��Ϊ�����ڶ��㣬��˲�Ľ�㲻���к��ӽ��
					if(tags == 1) {
						return false;
					}
					//��¼�ò��һ���������
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
	
	//�ڰ���
	/*
	 * ˼·
	 * 	�ò�α����ķ���
	 * 	�����ж�ÿ�����ķ�֧����
	 * 		����������+1
	 */
	/**
	 * ����һ�ø���������������˫��֧������
	 * @param root
	 * 			�������ĸ����
	 * @return
	 * 			�����������з�֧�ڵ����	
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
	 * ����˼·
	 * 	ʹ�õݹ�
	 */
	/**
	 * ʹ�õݹ����һ�ø���������������˫��֧������
	 * @param root
	 * 			�������ĸ����
	 * @return
	 * 			������������˫��֧���ĸ���
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
	
	//�ھ���
	/*
	 * ˼·
	 * 	ʹ�õݹ�
	 * 		�߽�����
	 * 			��ǰ���Ϊ��
	 * 		�ݹ�ǰ����
	 * 			���������򣩽�������Ϊ��ǰ���
	 * 			�����Һ����򣩽��Һ�����Ϊ��ǰ���
	 * 		�ݹ鷵�ض�
	 * 			����ǰ�������Ӻ��Һ��ӻ���
	 */
	public static void changeChildren(TreeNode root) {
		//�������ڰ�����������ʱ�洢���
		TreeNode temp = new TreeNode();
		
		//�߽�����
		if(root != null) {
			//�ݹ�ǰ����
			//�������������ж�ʵ����Ǳ߽���������˿���ʡ��
			//if(root.getLchild() != null) {
				changeChildren(root.getLchild());
			//}
			//if(root.getRchild() != null) {
				changeChildren(root.getRchild());
			//}
			
			//�ݹ鷵�ضΣ��������ӽ��
			temp = root.getLchild();
			root.setLchild(root.getRchild());
			root.setRchild(temp);
		}
	}

	//��ʮ��
	/*
	 * ˼·
	 * 	���������ʱ�����һ�����������ڼ�¼�ѱ����˶��ٽ��
	 * 	�����k����������1ʱ������ý���ֵ
	 */
	static int count = 0;
	/**
	 * ���Զ������洢�ṹ�洢�Ķ�����������������е�k������ֵ
	 * @param root
	 * 			�������ĸ����
	 * @param k
	 * 			��k�����
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
	
	//��ʮһ��
	/*
	 * ˼·
	 * 	ʹ���������
	 * 	��һ�����pre��¼��ǰ����ǰ�����
	 * 	���ĸ������Ҫ���⴦��
	 */
	/**
	 * ��������ÿһ��Ԫ��ֵΪvalue�Ľ�㣬ɾȥ����Ϊ�����������Һ��ӣ�ɾ˫�ף�
	 * @param root
	 * 			�������ĸ����
	 * @param value
	 * 			ָ����Ԫ��ֵ
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
					System.out.println("��������ɾ��");
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
	 * ˼·2
	 * 	���뵽�ģ�����ͨ���жϽ��ĺ��ӽ��ȥɾ�����ӵ�����
	 * 	�ò�α���һ�������Ӧ�û��һЩ
	 */
	/**
	 * ��������ÿһ��Ԫ��ֵΪvalue�Ľ�㣬ɾȥ����Ϊ������������˫�ף�ɾ���ӣ�
	 * @param root
	 * 			�������ĸ����
	 * @param value
	 * 			ָ����Ԫ��ֵ
	 */
	public static void deleteValueTree2(TreeNode root, String value) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		cq.enQueue(root);
		
		TreeNode temp = new TreeNode();
		
		if(root.getData().equals(value)) {
			//ɾ���������ζ����������ɾ��������û��˫�׽�㣬����ֻ��������
			System.out.println("��������ɾ��");
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
	
	//��ʮ����
	/*
	 * ʹ�÷ǵݹ�ĺ������
	 * ��������ָ�����ʱ���������ջ�н���ֵ����
	 */
	/**
	 * ��ӡֵΪvalue�Ľ�����������
	 * @param root
	 * 			�������ĸ����
	 * @param value
	 * 			ָ����ֵ
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
				//��ӡ���Ƚ��
				while(!ss.StackEmpty()) {
					TreeNode temp = new TreeNode();
					temp = ss.Pop();
					System.out.println(temp.getData());
				}
			} else if(top.getLchild() != null && top.getLchild().visit == 0) {
				//����֧����
				ss.Push(top.getLchild());
				top.getLchild().visit++;
			} else if(top.getRchild() != null && top.getRchild().visit == 0) {
				//����֧����
				ss.Push(top.getRchild());
				top.getRchild().visit++;
			} else {
				//��������Ҫ��Ľ����ջ
				ss.Pop();
			}
		}
	}
	
	//��ʮ����
	/*
	 * ˼·
	 * 	�÷ǵݹ�ĺ���������ҵ����p
	 * 	Ȼ�����γ�ջ�����Ƚ�㣬�������Ѱ�ҽ��q
	 * 		�ҵ�����Ϊ�������
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
				//���γ�ջ�����Ƚ�㣬�������Ѱ�ҽ��q
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
							 * top2.visit == 2������
							 * ��p��q���ӽڵ㣬�ᷢ����q���������ڵ�����
							 * ��ʱq.visit == 1
							 * ���ǽ�q����Ϊ�����ڵ�
							 * ��q��˫�׽ڵ������qʱ��q.visit == 2
							 * ��ʱq��˫�׽����Ϊp��q������������Ƚ��
							 */
							r = sonRoot;
							return r;
						}else if(top2.getLchild() != null && top2.getLchild().visit < 2) {
							//����֧����
							ss2.Push(top2.getLchild());
							top2.getLchild().visit++;
						} else if(top2.getRchild() != null && top2.getRchild().visit < 2) {
							//����֧����
							ss2.Push(top2.getRchild());
							top2.getRchild().visit++;
						} else {
							//��������Ҫ��Ľ����ջ
							ss2.Pop();
						}
					}
				}
			} else if(top.getLchild() != null && top.getLchild().visit == 0) {
				//����֧����
				ss.Push(top.getLchild());
				top.getLchild().visit++;
			} else if(top.getRchild() != null && top.getRchild().visit == 0) {
				//����֧����
				ss.Push(top.getRchild());
				top.getRchild().visit++;
			} else {
				//��������Ҫ��Ľ����ջ
				ss.Pop();
			}
		}
		
		return null;
	}
	
	//��ʮ����
	/*
	 * ˼·
	 * 		ʹ�ò�α���
	 * 		��¼ÿһ��Ľ����count
	 * 		�����ĸ�ֵ��width
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
				//���ò�ڵ����
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
	
	//��ʮ���
	/*
	 * ˼·1��
	 * 	ͨ���ݹ���׳˵��㷨����������������м���
	 * 	Ȼ�󴴽���ʽ������
	 * 	�������������
	 * 
	 * ˼·2��
	 * 	ֱ�Ӷ��������н��в���
	 * 	������ͨ������洢
	 * 	ÿ����ĸ���뵽���ӽڵ���������֮��
	 * 
	 * -------------------------------------
	 * ˼·1��˼·2ִ����������ܼ�
	 * �����д���ȫ
	 */
	//˼·1
	/**
	 * ��
	 */
	static int power = 0;
	/**
	 * ͨ�����еĽ�������������������Ĳ���
	 * @param quantity
	 * 			���еĽ�����
	 * @return
	 * 			���������Ĳ���
	 */
	private static int levelOfFullBiTree(int quantity) {
		if((Math.pow(2,power) - 1) != quantity) {
			power++;
			levelOfFullBiTree(quantity);
		}
		
		return power;
	}
//	public static void findPostByPre(TreeNode[] pre) {
//		//ͨ���ݹ���׳˵��㷨����������������м���
//		int quantity = pre.length + 1;
//		levelOfFullBiTree(quantity);
//		
//		//��¼�������ڼ�����
//		int count = 1;
//		TreeNode root = new TreeNode();
//		for(int x = 1; x < pre.length; x++) {
//			
//		}
//	}
//	
//	//˼·2
//	public static void finPostByPre2(Link)
	/*
	 * ˼·������������˼·�ı�
	 * ʹ�õݹ�
	 * 		�߽�������h1 < l1
	 * 		�ݹ��壺
	 * 			post[h2] = pre[l1]
	 * 			half = (h1-l1)/2
	 * 			��������l1 = l1+1; h1 = l1+half-1; l2 = l2; h2 = l2+half-1
	 * 			��������l1 = half+1; h2 =l1+half-1; l2 = l2+half; h2 = l2+half-1
	 * 	�ݹ�����post���еĿ�ȱ
	 * 		���õݹ������������level��
	 * 		��pre�ĵ�level-1����post�ĵ�0��ͬʱ����
	 * 			����ǰ��post[]Ϊ�գ��򽫵�ǰ��pre[]����post[]
	 * 			����ǰ��post[]�ǿգ�������
	 */
	/*----------------------------------------------
	 * Ū��������ı��ʣ��便������ô������
	 * ��
	 * ���ҵġ�ÿ����ĸ���뵽���ӽڵ���������֮������
	 * 
	 * ������ӽڵ������ͨ��half��l1,h1�������ͨ��l2,h2ȷ����λ��
	 * ��Ϊ���������������Ľ�����������һ�������Ľ�������1/2�Ĺ�ϵ
	 * 
	 * ������Ĳ���ֻ������ĸ����������ĸ���㣬�����ǡ�ÿ����ĸ��
	 * Ҷ�ӽ�����ڸ���������Ϻ����������ȱ
	 */
	/**
	 * �������������������������ĸ����������ĸ��������ں���������
	 * �Ķ�Ӧλ����
	 * @param pre
	 * 			������������
	 * @param l1
	 * 			�������е���ʼ����
	 * @param h1
	 * 			�������еĽ�������
	 * @param post
	 * 			������������
	 * @param l2
	 * 			�������е���ʼ����
	 * @param h2
	 * 			�������еĽ�������
	 */
	private static void changeRoot(TreeNode[] pre, int l1, int h1, 
			TreeNode[] post, int l2, int h2) {
		if(h1 >= l1) {
			post[h2] = pre[l1];
			int half = (h1-l1)/2;
			//������
			changeRoot(pre, l1+1, l1+half, post, l2, l2+half-1);
			//������
			changeRoot(pre, l1+half+1, l1+2*half, post, l2+half, l2+2*half-1);
		}
	}
	/**
	 * �����������е�Ҷ�ӽ����������ĸ����������ĸ�����Ѿ���λ��
	 * �������еĶ�Ӧλ����
	 * @param pre
	 * 			������������
	 * @param post
	 * 			������������
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
	 * ͨ��һ�������������������У������������
	 * @param pre
	 * 			������������
	 * @param l1
	 * 			�������е���ʼ����
	 * @param h1
	 * 			�������еĽ�������
	 * @param post
	 * 			������������
	 * @param l2
	 * 			�������е���ʼ����
	 * @param h2
	 * 			�������еĽ�������
	 */
	public static void findPostByPre3(TreeNode[] pre, int l1, int h1, 
			TreeNode[] post, int l2, int h2) {
		changeRoot(pre, l1, h1, post, l2, h2);
		
		//����post���еĿ�ȱ
		fillLeaf(pre, post);
		
	}
	
	//��ʮ����
	/*
	 * ˼·��
	 * 	ͨ������������ɴ����������η���Ҷ�ӽ��
	 * 		ͨ���ж����Ƿ��޺��ӽ���ж��Ƿ�ΪҶ�ӽ��
	 * 	��Ҷ�ӽ��������
	 * 	������Ϻ����γ��ӣ���ɵ�����
	 */
	public static TreePointer leafSingleLinked(TreeNode root) {
		//�洢Ҷ�ӽ��Ķ���
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		
		//�ǵݹ���������
		/*
		 * ֮���Բ��õݹ���������
		 * ����Ϊ����Ҫ����һ���µķ���
		 *
		 *	���ҵ������У��µķ�������ݹ����
		 *	�÷��������ж�
		 *	��ô��Ҫ�õ����߳�
		 *	
		 *	��ʹ�÷ǵݹ�������������򵥵Ķ�
		 *
		 * �ݹ�߽磺�ݹ鵽Ҷ�ӽ��
		 * �ݹ��壺���ý���Ҷ�ӽ��
		 * 			���������ӣ���ݹ鵽����
		 * 			�������Һ��ӣ���ݹ鵽�Һ���
		 *  
		 */
		//ģ��ݹ��ջ
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
	 * ʵ���ϣ��������򡢺����ڷ���Ҷ�ڵ�ʱ���Ǵ�������
	 * ������ڱ���ʱ����֯��������Ҫ���У�Ҳ�Ϳ���ʹ�õݹ�
	 * ���ϲ��õ���������ĵݹ飬������Ͳ�����������ĵݹ�����֮ǰ�ķǵݹ鷽����Ӧ
	 */
	/*
	 * ˼·
	 * 	ָ��prePointerָ��ǰ����㣬��ʼΪnull
	 * 		���ý��ΪҶ�ӽ��
	 * 			��prePointer = null
	 * 				prePointerָ���Ҷ�ӽ��
	 * 			��prePointer != null
	 *  			prePointer.getNode.setRchild = ��Ҷ�ӽ��
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
	
	//��ʮ����
	/*
	 * ͬʱ��α���T1��T2
	 *	���������ƣ�������г���ʼ����ͬ
	 * 
	 * ���ϲ��õ��ǵݹ�ķ���
	 * ͬʱ�ݹ�������������ж��������ĺ������
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
	
	//��ʮ����
	/*
	 * ����
	 * 	�����������ĺ���ǰ��
	 * 		������ǰ�������Һ��ӽ�㡣
	 * 			���Һ��ӽ��Ϊnull�����������ӽ��
	 * 
	 * 		�ҽ���ǰ���������ֵܡ�
	 * 			�����ֵ�Ϊnull���������һ�������ӽ������Ƚ��
	 * 		
	 * 		�����ǰ��������������ӣ��������Լ����ڵ������������׷�ݸ����
	 * 			��Ϊnull����Ϊnull
	 * 
	 * 
	 * 	��Ӧ�������������ĺ���ǰ��
	 * 		������ǰ�������Һ��ӽ��
	 * 			���Һ��ӽ��Ϊnull�����������ӽ��
	 * 
	 * 		�ҽ���ǰ���������ӵ�����
	 * 			��Ϊnull�����������ӵ����ӣ�֪���˸�����ltag=0������������
	 * 		����ͬ�ҽ��
	 * ---------------------------------------
	 * ԭ��
	 * 		�����ǰ�������ӵ�����
	 * 			��null����Ϊnull
	 * �������Ĳ�������������֣����ҽ��������ʵһ��
	 * ---------------------------------------
	 */
	/**
	 * ���������������������ָ������ں����ǰ�������㷨
	 * @param node
	 * 			ָ�����
	 * @return
	 * 			ָ�����ĺ���ǰ��
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
	//ԭ�棺���ҽ��ֿ�����
//	public static TreeNode predecessorOfPostByIn(TreeNode root) {
//		if(root.getRchild() != null && root.rtag == 0) {
//			return root.getRchild();
//		} else if(root.rtag == 1 && root.getLchild() != null && root.ltag == 0) {
//			return root.getLchild();
//		} else if(root.getLchild() == null && root.ltag == 1) {
//			//���䲻�Ǹ���㣬��������ͺ������ʼ���
//			return null;
//		}else if(root.getLchild().getRchild() == root) {
//			//��Ϊ�ҽ��
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
//			//��Ϊ����
//			if(root.getLchild().getLchild() != null) {
//				return root.getLchild().getLchild();
//			} else {
//				return null;
//			}
//		}
//		
//		return null;
//	}
	
	//��ʮ����
	/*
	 * TNND����Ȩ·�����������*Ȩֵ
	 * 1���������˼��
	 * ʹ�ò�α�������ÿһ���㣬����¼��ǰ�������Ĳ���
	 * ��������Ҷ�ӽ�㣬��������Ȩ·�����ȣ��������ۼӵ�wpl��
	 * ����������Ҷ�ӽ�㣬���亢�ӽ����ӣ�������α���
	 */
	public static int wpl(TreeNode root) {
		CyclicQueue<TreeNode> cq = new CyclicQueue<>();
		cq.initQueue();
		cq.enQueue(root);
		
		//��Ȩ·������
		int wpl = 0;
		//��¼��ǰ���
		int deep = 1;
		//��¼��ǰ�Ľ�����
		int count = 1;
		//��¼��һ��Ľ�����
		int nextCount = 0;
		//��¼��ǰ�������Ľ����
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
	 * ˼·2
	 * 	����˼·
	 * 	ʹ�õݹ���������
	 * 	����ǰ���ΪҶ�ӽ�㣬���ۼ�wpl��Ȼ������ݹ���������
	 * 	����ǰ����Ҷ�ӽ�㣬������ݹ���������
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
	
	//�ڶ�ʮ��
	/*
	 * ���ʽ������������Ǻ�׺���ʽ
	 * ���ʽ���������������׺���ʽ
	 * 1���������˼��
	 * 	����������ʽ��
	 * 	һ����������������ӽ���������ӽ�㣬���������֮ǰ���"("
	 * 	һ���������Һ��ӽ�������Һ��ӽ�㣬���������֮ǰ���")"�����ҵ��������������
	 * 	����3ʱ��ÿ��һ�㣬�������һ��")"
	 * 	
	 */
	/**
	 * ���ݱ��ʽ���������׺���ʽ
	 * @param root
	 * 			���ʽ���ĸ����
	 */
	public static void expressionTreeToNifix(TreeNode root) {
		expressionTreeToNifixOperator(root, null, 1);
	}
	/**
	 * ���ݱ��ʽ���������׺���ʽ����Ҫ����
	 * @param root
	 * 			���ʽ���ĸ����
	 * @param pre
	 * 			��ǰ�������Ľ���ǰ����㣬��ʼΪnull
	 * @param deep
	 * 			��ǰ����������ȣ���ʼΪ1
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
	 * ����˼·���Ӽ�࣬����
	 * 	���������ʱ�����˸�����Ҷ��㣬
	 * 	��������ڱ���������֮ǰ����"("���ڱ���������֮�����")"
	 * 	ʹ�ò����жϵ�ǰ����Ƿ�Ϊ�����
	 */
	public static void expressionTreeToNifex2(TreeNode root) {
		expressionTreeToNifix2Operator(root, 1);
	}
	private static void expressionTreeToNifix2Operator(TreeNode root, int deep) {
		if(root != null) {
			//Ҷ���
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