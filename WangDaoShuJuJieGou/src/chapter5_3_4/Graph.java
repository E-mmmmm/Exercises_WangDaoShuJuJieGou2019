package chapter5_3_4;

import chapter3_1_4.SequenceStack;
import chapter3_2_5.CyclicQueue;

/**
 * 图类
 * @author Administrator
 *
 */
public class Graph {
	/**
	 * 标记此图是无向图还是有向图
	 * 0：无向图
	 * 1：有向图
	 * 默认为无向图
	 */
	private int type = 0;
	/**
	 * 顶点数
	 */
	private static int vexnum = 0;
	/**
	 * 边（弧）数
	 */
	private int arcnum = 0;
	/**
	 * 顶点表和邻接矩阵的大小
	 */
	private int capacity = 10;
	/**
	 * 顶点表
	 */
	public VNode[] vertexs = new VNode[capacity];
	/**
	 * 顶点的访问标记数组
	 */
	private boolean[] visited =  new boolean[capacity];
	/**
	 * 邻接矩阵
	 */
	private int[][] mst = new int[capacity][capacity];
	/**
	 * 当前最后一个顶点的顶点号
	 */
	private int current = -1;
	
	/**
	 * 构造方法，必须声明图的类型
	 * @param type 图的类型
	 * 			   0：无向图
	 *             1：有向图
	 */
	public Graph(int type) {
		super();
		this.type = type;
	}
	/**
	 * 获取顶点数
	 * @return
	 */
	public int getVexnum() {
		return vexnum;
	}
	/**
	 * 获取顶点表
	 * @return
	 */
	public VNode[] getVertexs() {
		return vertexs;
	}
	/**
	 * 获取边/弧数
	 * @return
	 */
	public int getArcnum() {
		return arcnum;
	}
	
	/**
	 * 判断图是否存在边(x,y)或<x,y>
	 * @param g	判断的图
	 * @param x 无向边的一个顶点或有向边的弧尾
	 * @param y 无向边的另一个顶点或有向边的弧头
	 * @return 若边存在则返回true，否则返回false
	 */
	public boolean adjacent(int x, int y) {
		if(mst[x][y] == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 列出图中与结点x相邻的边
	 * 会显示其顶点号和data
	 * @param g 操作的图
	 * @param x 操作的结点
	 */
	public void Neighbors(int x) {
		ArcNode arcNode = vertexs[x].getFirst();
		while(arcNode != null) {
			System.out.println(arcNode.getAdjvex() + vertexs[arcNode.getAdjvex()].getData());
			arcNode = arcNode.getNext();
		}
	}
	
	/**
	 * 自动扩容
	 */
	private void ensureCapacity() {
		capacity += 10;
		//顶点表的扩容
		VNode[] vertexsTemp = new VNode[capacity];
		for(int x = 0; x < vexnum; x++) {
			vertexsTemp[x] = vertexs[x];
		}
		vertexs = vertexsTemp;
		
		//访问标记数组的扩容
		boolean[] visitedTemp = new boolean[capacity];
		for(int x = 0; x < vexnum; x++) {
			visitedTemp[x] = visited[x];
		}
		visited = visitedTemp;
		
		//邻接矩阵的扩容
		int[][] mstTemp = new int[capacity][capacity];
		for(int x = 0; x < vexnum; x++) {
			for(int y = 0; y < vexnum; y++) {
				mstTemp[x][y] = mst[x][y];
			}
		}
		mst = mstTemp;
	}
	
	/**
	 * 查找顶点在图中的位置
	 * @param g 图
	 * @param x 查找的顶点
	 * @return	若该顶点存在，则返回其在图中的位置，否则返回-1
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
	 * 在图中添加顶点
	 * @param g	被添加顶点的图
	 * @param x	被添加的顶点
	 */
	public int insertVertex(VNode x) {
		//自动扩容
		if(vexnum == capacity) {
			ensureCapacity();
		}
		//添加 
		vertexs[++current] = x;
		visited[current] = false;
		
		return current;
	}
	
	/**
	 * 删除顶点
	 * @param g 操作的图
	 * @param x 删除的顶点
	 */
	public void deleteVertex(int x) {
		if(x > current || x == -1) {
			System.out.println("该顶点不存在");
			return;
		} else if(x == current) {
			//从顶点表中删除
			vertexs[current] = null;
			//从邻接矩阵中删除
			for(int z = 0; z < current; z++) {
				mst[current][z] = 0;
				mst[z][current] = 0;
			}
			current--;
		} else {
			//从顶点表中删除
			vertexs[x] = null;
			trimVertexs(x);
			//从邻接矩阵中删除
			//整理列
			for(int line = 0; line < current; line++) {
				for(int column = x; column < current-1; column++) {
					mst[line][column] = mst[line][column+1];
				}
			}
			//整理行
			for(int column = 0; column < current; column++) {
				for(int line = x; line < current-1; line++) {
					mst[column][line] = mst[column][line+1];
				}
			}
			//清除残留的无效数据
			for(int z = 0; z < current; z++) {
				mst[current][z] = 0;
				mst[z][current] = 0;
			}
			
			current--;
		}
	}
	
	/**
	 * 整理顶点表
	 * @param loc 整理的起始顶点号
	 */
	private void trimVertexs(int loc) {
		for(int x = loc; x < vertexs.length-1; x++) {
			vertexs[x] = vertexs[x+1];
		}
	}
	
	/**
	 * 如果边不存在，则在图中添加该边
	 * @param g	操作的图
	 * @param x 无向边的一点，有向边的弧尾
	 * @param y 无向边的另一点，有向边的弧头
	 */
	public void addEdge(int x, int y) {
		//邻接表
		if(x == -1 || y == -1 || x > current || y > current) {
			System.out.println("顶点不存在，无法添加边");
			return;
		} else {
			//顶点x的邻接点y
			ArcNode arcY = new ArcNode();
			arcY.setAdjvex(y);

			ArcNode arcNode = vertexs[x].getFirst();
			if(vertexs[x].getFirst() != null) {
				while(arcNode.getNext() != null) {
					if(arcNode.getAdjvex() != y) {
						arcNode = arcNode.getNext();
					} else {
						System.out.println("该边已存在");
					}
				}
				
				arcNode.setNext(arcY);
			} else {
				vertexs[x].setFirst(arcY);
			}
		}
		//邻接矩阵
		mst[x][y] = 1;
		
		//若是无向图，需要再反向添加一次
		if(type == 0) {
			//邻接表
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
			
			//邻接矩阵
			mst[y][x] = 1;
		}
	}
	
	/**
	 * 若边存在，则从图中删除该边
	 * @param g 操作的图
	 * @param x 有向边的一个顶点或有向边的弧尾
	 * @param y	有向边的另一个顶点或有向边的弧头
	 */
	public void removeEdege(int x, int y) {
		//邻接矩阵
		mst[x][y] = 0;
		
		//邻接表
		//指向要删除的边表结点的前驱结点
		if(vertexs[x].getFirst() == null) {
			System.out.println("该边不存在，无法删除");
			return;
		} else {
			ArcNode pre = new ArcNode();
			ArcNode node = new ArcNode();
			
			node = vertexs[x].getFirst();
			
			if(node.getAdjvex() == y) {
				//若要删除的边表结点为边表的表头
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
				
				System.out.println("该边不存在，无法删除");
			}
		}
	}
	
	/**
	 * 求图G中顶点x的第一个邻接点，若有则返回顶点号。
	 * 若x没有邻接点或图中不存在x，则返回-1。
	 * @param g 图g
	 * @param x	顶点x
	 * @return 若顶点x存在且其有邻接点，则返回其第一个邻接点的顶点号，
	 * 			否则，返回-1。
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
	 * 返回顶点x的邻接点y的下一个邻接点的顶点号
	 * @param vArr 顶点表
	 * @param x	顶点x
	 * @param y 顶点y
	 * @return 邻接点的顶点号，做不存在则返回-1
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
	 * 求图g中顶点x的一个未访问过的邻接点
	 * @param g 顶点x所在的图 
	 * @param x 顶点x
	 * @return 邻接点的顶点号，若不存在则返回-1
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
	 * 思路（看书后）
	 * 	树的特点在于结点与结点之间一一对应
	 * 	若采用邻接表存储
	 * 		若为树，则能一次遍历到所有的结点，并且遍历到的边数=结点数-1
	 * 		采用深度优先遍历，并且记录所遍历到的结点数和边数
	 * 	若采用邻接矩阵存储
	 * 		
	 * 	
	 */
	/**
	 * 记录顶点数
	 */
	static int vNum = 0;
	/**
	 * 记录边数
	 */
	static int eNum = 0;
	
	/**
	 * 判断一个无向图G是否是一棵树
	 * @param vArr 图G的顶点表
	 * @param v	判断的起始顶点
	 * @return 如果图G是树则返回true，否则返回false
	 */
	public  boolean graphIsTree(){ 
		DFSOfGIT(0);
		
		//重置访问状态
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
	 * 配合graphIsTree使用的深度优先遍历
	 * @param v DFS的起始顶点
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
	 * 深度优先遍历
	 */
	public void DFSTraverse() {
		for(int x = 0; x < current; x++) {
			if(visited[x] == false) {
				DFS(x);
			}
		}
		
		//重置访问状态
		for(int x = 0; x <= current; x++) {
			visited[x] = false;
		}
	}
	/**
	 * 深度优先遍历
	 * @param v DFS的起始顶点
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
	 * 显示顶点x的信息
	 * @param x 顶点x
	 */
	public void displayVertex(int x) {
		System.out.print(vertexs[x].getData() + ", ");
	}
	
	/*
	 * 第3题
	 * 思路
	 * 	类似树的先序遍历的非递归算法
	 * 	利用栈来模拟递归
	 * 	
	 *  1、若可能，访问一个邻接的未访问过的顶点，标记它，并压入栈中
	 *  2、若无法做到1，且栈非空，则从栈中弹出一个顶点
	 *  3、若1、2都无法做到，则算法结束
	 */
	/**
	 * 非递归的DFS
	 * @param v DFS的起始顶点
	 */
	public void DFSNonRecursion(int v) {
		//递归工作栈
		SequenceStack<Integer> ss = new SequenceStack<Integer>();
		ss.InitStack();
		ss.Push(v);
		displayVertex(v);
		visited[v] = true;
		
		//当前顶点
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
		
		//重置访问状态
		for(int x = 0; x <= current; x++) {
			visited[x] = false;
		}
	}
	
	//第4题（1）
	boolean flag = false;
	/**
	 * 基于深度优先遍历，判断是否存在由顶点i到顶点j的路径
	 * @param i 顶点i
	 * @param j 顶点j
	 * @return 路径存在则返回true，否则返回false
	 */
	public boolean IsPathByDFS(int i, int j) {
		//因flag被多个函数共用，所以使用前需要重置flag
		flag = false;
		
		IsPathByDFSOperation(i, j);
		
		//重置访问状态
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
	
	//第4题（2）
	/**
	 * 基于广度优先遍历，判断是否存在由顶点i到顶点j的路径
	 * @param i 顶点i
	 * @param j 顶点j
	 * @return 路径存在则返回true，否则返回false
	 */
	public boolean IsPathByBFS(int i, int j) {
		//因flag被多个函数共用，所以使用前需要重置flag
		flag = false;
		
		IsPathByBFSOperation(i, j);
		
		//重置访问状态
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
	 * 第5题
	 * 思路
	 * 	基于非递归的深度优先遍历
	 *  从顶点i开始，当遍历到结点j时，无论j是否被访问，输出栈中的所有顶点
	 *  当栈为空时，结束
	 */
	public void showPath(int i, int j) {
		SequenceStack<Integer> ss = new SequenceStack<>();
		ss.InitStack();
		//辅助栈
		SequenceStack<Integer> assist = new SequenceStack<>();
		assist.InitStack();
		
		ss.Push(i);
		visited[i] = true;
		int w = -1;
		
		while(!ss.StackEmpty()) {
			w = firstNeighbor((int)ss.GetTop());
			
			if(w != -1) {
				//输出路径
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
			
			//输出路径
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
		
		//重置访问状态
		for(int x = 0; x <= current; x++) {
			visited[x] = false;
		}
		}}
}