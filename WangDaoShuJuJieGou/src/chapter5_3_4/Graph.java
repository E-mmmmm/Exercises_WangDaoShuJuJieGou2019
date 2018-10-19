package chapter5_3_4;

import chapter3_1_4.SequenceStack;
import chapter3_2_5.CyclicQueue;

/**
 * ͼ��
 * @author Administrator
 *
 */
public class Graph {
	/**
	 * ��Ǵ�ͼ������ͼ��������ͼ
	 * 0������ͼ
	 * 1������ͼ
	 * Ĭ��Ϊ����ͼ
	 */
	private int type = 0;
	/**
	 * ������
	 */
	private static int vexnum = 0;
	/**
	 * �ߣ�������
	 */
	private int arcnum = 0;
	/**
	 * �������ڽӾ���Ĵ�С
	 */
	private int capacity = 10;
	/**
	 * �����
	 */
	public VNode[] vertexs = new VNode[capacity];
	/**
	 * ����ķ��ʱ������
	 */
	private boolean[] visited =  new boolean[capacity];
	/**
	 * �ڽӾ���
	 */
	private int[][] mst = new int[capacity][capacity];
	/**
	 * ��ǰ���һ������Ķ����
	 */
	private int current = -1;
	
	/**
	 * ���췽������������ͼ������
	 * @param type ͼ������
	 * 			   0������ͼ
	 *             1������ͼ
	 */
	public Graph(int type) {
		super();
		this.type = type;
	}
	/**
	 * ��ȡ������
	 * @return
	 */
	public int getVexnum() {
		return vexnum;
	}
	/**
	 * ��ȡ�����
	 * @return
	 */
	public VNode[] getVertexs() {
		return vertexs;
	}
	/**
	 * ��ȡ��/����
	 * @return
	 */
	public int getArcnum() {
		return arcnum;
	}
	
	/**
	 * �ж�ͼ�Ƿ���ڱ�(x,y)��<x,y>
	 * @param g	�жϵ�ͼ
	 * @param x ����ߵ�һ�����������ߵĻ�β
	 * @param y ����ߵ���һ�����������ߵĻ�ͷ
	 * @return ���ߴ����򷵻�true�����򷵻�false
	 */
	public boolean adjacent(int x, int y) {
		if(mst[x][y] == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * �г�ͼ������x���ڵı�
	 * ����ʾ�䶥��ź�data
	 * @param g ������ͼ
	 * @param x �����Ľ��
	 */
	public void Neighbors(int x) {
		ArcNode arcNode = vertexs[x].getFirst();
		while(arcNode != null) {
			System.out.println(arcNode.getAdjvex() + vertexs[arcNode.getAdjvex()].getData());
			arcNode = arcNode.getNext();
		}
	}
	
	/**
	 * �Զ�����
	 */
	private void ensureCapacity() {
		capacity += 10;
		//����������
		VNode[] vertexsTemp = new VNode[capacity];
		for(int x = 0; x < vexnum; x++) {
			vertexsTemp[x] = vertexs[x];
		}
		vertexs = vertexsTemp;
		
		//���ʱ�����������
		boolean[] visitedTemp = new boolean[capacity];
		for(int x = 0; x < vexnum; x++) {
			visitedTemp[x] = visited[x];
		}
		visited = visitedTemp;
		
		//�ڽӾ��������
		int[][] mstTemp = new int[capacity][capacity];
		for(int x = 0; x < vexnum; x++) {
			for(int y = 0; y < vexnum; y++) {
				mstTemp[x][y] = mst[x][y];
			}
		}
		mst = mstTemp;
	}
	
	/**
	 * ���Ҷ�����ͼ�е�λ��
	 * @param g ͼ
	 * @param x ���ҵĶ���
	 * @return	���ö�����ڣ��򷵻�����ͼ�е�λ�ã����򷵻�-1
	 */
	public int location(VNode x) {
		for(int i = 0; i < current; i++) {
			if(vertexs[i] == x) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * ��ͼ����Ӷ���
	 * @param g	����Ӷ����ͼ
	 * @param x	����ӵĶ���
	 */
	public int insertVertex(VNode x) {
		//�Զ�����
		if(vexnum == capacity) {
			ensureCapacity();
		}
		//��� 
		vertexs[++current] = x;
		visited[current] = false;
		
		return current;
	}
	
	/**
	 * ɾ������
	 * @param g ������ͼ
	 * @param x ɾ���Ķ���
	 */
	public void deleteVertex(int x) {
		if(x > current || x == -1) {
			System.out.println("�ö��㲻����");
			return;
		} else if(x == current) {
			//�Ӷ������ɾ��
			vertexs[current] = null;
			//���ڽӾ�����ɾ��
			for(int z = 0; z < current; z++) {
				mst[current][z] = 0;
				mst[z][current] = 0;
			}
			current--;
		} else {
			//�Ӷ������ɾ��
			vertexs[x] = null;
			trimVertexs(x);
			//���ڽӾ�����ɾ��
			//������
			for(int line = 0; line < current; line++) {
				for(int column = x; column < current-1; column++) {
					mst[line][column] = mst[line][column+1];
				}
			}
			//������
			for(int column = 0; column < current; column++) {
				for(int line = x; line < current-1; line++) {
					mst[column][line] = mst[column][line+1];
				}
			}
			//�����������Ч����
			for(int z = 0; z < current; z++) {
				mst[current][z] = 0;
				mst[z][current] = 0;
			}
			
			current--;
		}
	}
	
	/**
	 * �������
	 * @param loc �������ʼ�����
	 */
	private void trimVertexs(int loc) {
		for(int x = loc; x < vertexs.length-1; x++) {
			vertexs[x] = vertexs[x+1];
		}
	}
	
	/**
	 * ����߲����ڣ�����ͼ����Ӹñ�
	 * @param g	������ͼ
	 * @param x ����ߵ�һ�㣬����ߵĻ�β
	 * @param y ����ߵ���һ�㣬����ߵĻ�ͷ
	 */
	public void addEdge(int x, int y) {
		//�ڽӱ�
		if(x == -1 || y == -1 || x > current || y > current) {
			System.out.println("���㲻���ڣ��޷���ӱ�");
			return;
		} else {
			//����x���ڽӵ�y
			ArcNode arcY = new ArcNode();
			arcY.setAdjvex(y);

			ArcNode arcNode = vertexs[x].getFirst();
			if(vertexs[x].getFirst() != null) {
				while(arcNode.getNext() != null) {
					if(arcNode.getAdjvex() != y) {
						arcNode = arcNode.getNext();
					} else {
						System.out.println("�ñ��Ѵ���");
					}
				}
				
				arcNode.setNext(arcY);
			} else {
				vertexs[x].setFirst(arcY);
			}
		}
		//�ڽӾ���
		mst[x][y] = 1;
		
		//��������ͼ����Ҫ�ٷ������һ��
		if(type == 0) {
			//�ڽӱ�
			ArcNode arcX = new ArcNode();
			arcX.setAdjvex(x);
			
			if(vertexs[y].getFirst() == null) {
				vertexs[y].setFirst(arcX);
			} else {
				ArcNode arcNode = vertexs[y].getFirst();
				while(arcNode.getNext() != null) {
					arcNode = arcNode.getNext();
				}
				
				arcNode.setNext(arcX);
			}
			
			//�ڽӾ���
			mst[y][x] = 1;
		}
	}
	
	/**
	 * ���ߴ��ڣ����ͼ��ɾ���ñ�
	 * @param g ������ͼ
	 * @param x ����ߵ�һ�����������ߵĻ�β
	 * @param y	����ߵ���һ�����������ߵĻ�ͷ
	 */
	public void removeEdege(int x, int y) {
		//�ڽӾ���
		mst[x][y] = 0;
		
		//�ڽӱ�
		//ָ��Ҫɾ���ı߱����ǰ�����
		if(vertexs[x].getFirst() == null) {
			System.out.println("�ñ߲����ڣ��޷�ɾ��");
			return;
		} else {
			ArcNode pre = new ArcNode();
			ArcNode node = new ArcNode();
			
			node = vertexs[x].getFirst();
			
			if(node.getAdjvex() == y) {
				//��Ҫɾ���ı߱���Ϊ�߱�ı�ͷ
				vertexs[x].setFirst(null);
			} else {
				while(node != null) {
					if(node.getAdjvex() == y) {
						pre.setNext(node.getNext());
						return;
					} else {
						pre = node;
						node = node.getNext();
					}
				}
				
				System.out.println("�ñ߲����ڣ��޷�ɾ��");
			}
		}
	}
	
	/**
	 * ��ͼG�ж���x�ĵ�һ���ڽӵ㣬�����򷵻ض���š�
	 * ��xû���ڽӵ��ͼ�в�����x���򷵻�-1��
	 * @param g ͼg
	 * @param x	����x
	 * @return ������x�����������ڽӵ㣬�򷵻����һ���ڽӵ�Ķ���ţ�
	 * 			���򣬷���-1��
	 */
	public int firstNeighbor(int x) {
		ArcNode first = vertexs[x].getFirst();
		if(x < 0 || x > current || first == null) {
			return -1;
		} else {
			return first.getAdjvex();
		}
	}
	
	/**
	 * ���ض���x���ڽӵ�y����һ���ڽӵ�Ķ����
	 * @param vArr �����
	 * @param x	����x
	 * @param y ����y
	 * @return �ڽӵ�Ķ���ţ����������򷵻�-1
	 */
	public int nextNeighbor(int x, int y) {
		ArcNode arcNode = vertexs[x].getFirst();
		
		while(arcNode != null && arcNode.getNext() != null) {
			if(arcNode.getAdjvex() != y) {
				arcNode = arcNode.getNext();
			} else {
				return arcNode.getNext().getAdjvex();
			}
		}
		
		return -1;
	}
	
	/**
	 * ��ͼg�ж���x��һ��δ���ʹ����ڽӵ�
	 * @param g ����x���ڵ�ͼ 
	 * @param x ����x
	 * @return �ڽӵ�Ķ���ţ����������򷵻�-1
	 */
	public int unVisitedNeighbor(int x) {
		ArcNode arcNode = vertexs[x].getFirst();
		while(arcNode != null) {
			if(visited[arcNode.getAdjvex()] == false) {
				return arcNode.getAdjvex();
			}else {
				arcNode = arcNode.getNext();
			}
		}
		
		return -1;
	}
	
	/*
	 * ˼·�������
	 * 	�����ص����ڽ������֮��һһ��Ӧ
	 * 	�������ڽӱ�洢
	 * 		��Ϊ��������һ�α��������еĽ�㣬���ұ������ı���=�����-1
	 * 		����������ȱ��������Ҽ�¼���������Ľ�����ͱ���
	 * 	�������ڽӾ���洢
	 * 		
	 * 	
	 */
	/**
	 * ��¼������
	 */
	static int vNum = 0;
	/**
	 * ��¼����
	 */
	static int eNum = 0;
	
	/**
	 * �ж�һ������ͼG�Ƿ���һ����
	 * @param vArr ͼG�Ķ����
	 * @param v	�жϵ���ʼ����
	 * @return ���ͼG�����򷵻�true�����򷵻�false
	 */
	public  boolean graphIsTree(){ 
		DFSOfGIT(0);
		
		//���÷���״̬
		for(int x = 0; x <= current; x++) {
			visited[x] = false;
		}
		
		System.out.println("vNum:" + vNum + " ,eNum:" + eNum);
		if(vNum == current+1 && eNum == 2*(current)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * ���graphIsTreeʹ�õ�������ȱ���
	 * @param v DFS����ʼ����
	 */
	private  void DFSOfGIT(int v) {
		visited[v] = true;
		int w = firstNeighbor(v);
		vNum++;
		
		while(w != -1) {
			eNum++;

			if(visited[w] == false) {
				DFSOfGIT(w);
			}
			
			w = nextNeighbor(v, w);
		}
		
	}
	
	/**
	 * ������ȱ���
	 */
	public void DFSTraverse() {
		for(int x = 0; x < current; x++) {
			if(visited[x] == false) {
				DFS(x);
			}
		}
		
		//���÷���״̬
		for(int x = 0; x <= current; x++) {
			visited[x] = false;
		}
	}
	/**
	 * ������ȱ���
	 * @param v DFS����ʼ����
	 */
	private  void DFS(int v) {
		System.out.print(vertexs[v].getData() + ", ");
		visited[v] = true;
		int w = firstNeighbor(v);
		
		while(w != -1) {
			if(visited[w] == false) {
				DFS(w);
			}
			
			w = nextNeighbor(v, w);
		}
	}
	
	/**
	 * ��ʾ����x����Ϣ
	 * @param x ����x
	 */
	public void displayVertex(int x) {
		System.out.print(vertexs[x].getData() + ", ");
	}
	
	/*
	 * ��3��
	 * ˼·
	 * 	����������������ķǵݹ��㷨
	 * 	����ջ��ģ��ݹ�
	 * 	
	 *  1�������ܣ�����һ���ڽӵ�δ���ʹ��Ķ��㣬���������ѹ��ջ��
	 *  2�����޷�����1����ջ�ǿգ����ջ�е���һ������
	 *  3����1��2���޷����������㷨����
	 */
	/**
	 * �ǵݹ��DFS
	 * @param v DFS����ʼ����
	 */
	public void DFSNonRecursion(int v) {
		//�ݹ鹤��ջ
		SequenceStack<Integer> ss = new SequenceStack<Integer>();
		ss.InitStack();
		ss.Push(v);
		displayVertex(v);
		visited[v] = true;
		
		//��ǰ����
		int w = -1;
		while(!ss.StackEmpty()) {
			w = unVisitedNeighbor((int)ss.GetTop());
			if(w == -1) {
				ss.Pop();
			} else {
				displayVertex(w);
				visited[w] = true;
				ss.Push(w);
			}
		}
		
		//���÷���״̬
		for(int x = 0; x <= current; x++) {
			visited[x] = false;
		}
	}
	
	//��4�⣨1��
	boolean flag = false;
	/**
	 * ����������ȱ������ж��Ƿ�����ɶ���i������j��·��
	 * @param i ����i
	 * @param j ����j
	 * @return ·�������򷵻�true�����򷵻�false
	 */
	public boolean IsPathByDFS(int i, int j) {
		//��flag������������ã�����ʹ��ǰ��Ҫ����flag
		flag = false;
		
		IsPathByDFSOperation(i, j);
		
		//���÷���״̬
		for(int x = 0; x <= current; x++) {
			visited[x] = false;
		}
		
		return flag;
	}
	private void IsPathByDFSOperation(int i, int j) {
		if(i == j) {
			flag =  true;
			return;
		} else {
			visited[i] = true;
			int w = firstNeighbor(i);
			while(w != -1) {
				if(visited[w] == false) {
					IsPathByDFSOperation(w, j);
				}
				w = nextNeighbor(i, w);
			}
		}
	}
	
	//��4�⣨2��
	/**
	 * ���ڹ�����ȱ������ж��Ƿ�����ɶ���i������j��·��
	 * @param i ����i
	 * @param j ����j
	 * @return ·�������򷵻�true�����򷵻�false
	 */
	public boolean IsPathByBFS(int i, int j) {
		//��flag������������ã�����ʹ��ǰ��Ҫ����flag
		flag = false;
		
		IsPathByBFSOperation(i, j);
		
		//���÷���״̬
		for(int x = 0; x <= current; x++) {
			visited[x] = false;
		}
		
		return flag;
	}
	private void IsPathByBFSOperation(int i, int j) {
		CyclicQueue<Integer> cq = new CyclicQueue<>();
		cq.initQueue();
		
		cq.enQueue(i);
		visited[i] = true;
		int w = -1;
		
		while(!cq.queueEmpty()) {
			w = cq.deQueue();
			int v = firstNeighbor(w);
				
			while(v != -1) {
				if(visited[v] != true) {
					if(v == j) {
						flag = true;
					}
					cq.enQueue(v);
					visited[v] = true;
				}
				v = nextNeighbor(w, v);
			}
		}
	}
	
	/*
	 * ��5��
	 * ˼·
	 * 	���ڷǵݹ��������ȱ���
	 *  �Ӷ���i��ʼ�������������jʱ������j�Ƿ񱻷��ʣ����ջ�е����ж���
	 *  ��ջΪ��ʱ������
	 */
	public void showPath(int i, int j) {
		SequenceStack<Integer> ss = new SequenceStack<>();
		ss.InitStack();
		//����ջ
		SequenceStack<Integer> assist = new SequenceStack<>();
		assist.InitStack();
		
		ss.Push(i);
		visited[i] = true;
		int w = -1;
		
		while(!ss.StackEmpty()) {
			w = firstNeighbor((int)ss.GetTop());
			
			if(w != -1) {
				//���·��
				if(w == j) {
					System.out.print("No.1: ");
					int temp = -1;
					while(!ss.StackEmpty()) {
						assist.Push((int)ss.Pop());
					}
					while(!assist.StackEmpty()) {
						temp = assist.Pop();
						displayVertex(temp);
						ss.Push(temp);
					}
					displayVertex(w);
					System.out.println();
				}
				
				if(visited[w] != true) {
					ss.Push(w);
				} else {
			}
		}
		
		while(!ss.StackEmpty()) {
			w = unVisitedNeighbor((int)ss.GetTop());
			
			//���·��
			if(w == j) {
				System.out.print("No.1: ");
				int temp = -1;
				while(!ss.StackEmpty()) {
					assist.Push((int)ss.Pop());
				}
				while(!assist.StackEmpty()) {
					temp = assist.Pop();
					displayVertex(temp);
					ss.Push(temp);
				}
				displayVertex(w);
				System.out.println();
			}
			
			if(w == -1) {
				ss.Pop();
			} else {
				ss.Push(w);
				visited[w] = true;
			}
		}
		
		//���÷���״̬
		for(int x = 0; x <= current; x++) {
			visited[x] = false;
		}
		}}
}