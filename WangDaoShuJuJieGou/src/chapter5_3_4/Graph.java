package chapter5_3_4;

import chapter3_1_4.SequenceStack;

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
	private int vexnum = 0;
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
	private VNode[] vertexs = new VNode[capacity];
	/**
	 * 邻接矩阵
	 */
	int[][] mst = new int[capacity][capacity];
	/**
	 * 当前最后一个顶点的顶点号
	 */
	int current = -1;
	
	private boolean[] visited =  new boolean[vexnum];
	
	/**
	 * 构造方法，必须声明图的类型
	 * @param type 图的类型
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
	public boolean adjacent(Graph g, int x, int y) {
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
	public void Neighbors(Graph g, int x) {
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
	public int location(Graph g, VNode x) {
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
	public void insertVertex(Graph g, VNode x) {
		//自动扩容
		if(vexnum == capacity) {
			ensureCapacity();
		}
		//添加 
		vertexs[current++] = x;
	}
	
	/**
	 * 删除顶点
	 * @param g 操作的图
	 * @param x 删除的顶点
	 */
	public void deleteVertex(Graph g, int x) {
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
	public void addEdge(Graph g, int x, int y) {
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
	public void removeEdege(Graph g, VNode x, VNode y) {
		int xLoc = location(g, x);
		int yLoc = location(g, y);
		
		//邻接矩阵
		mst[xLoc][yLoc] = 0;
		
		//邻接表
		//指向要删除的边表结点的前驱结点
		if(x.getFirst() == null) {
			System.out.println("该边不存在，无法删除");
			return;
		} else {
			ArcNode pre = new ArcNode();
			ArcNode node = new ArcNode();
			
			node = x.getFirst();
			
			if(node.getAdjvex() == yLoc) {
				//若要删除的边表结点为边表的表头
				x.setFirst(null);
			} else {
				while(node != null) {
					if(node.getAdjvex() == yLoc) {
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
	 * @param vArr 顶点表
	 * @param x	顶点x
	 * @return 若顶点x存在且其有邻接点，则返回其第一个邻接点的顶点号，
	 * 			否则，返回-1。
	 */
	public int firstNeighbor(VNode[] vArr, int x) {
		if(x < 0 || x >= vArr.length || vArr[x].getFirst() == null) {
			return -1;
		} else {
			vArr[x].getFirst().setMark(true);
			return vArr[x].getFirst().getAdjvex();
		}
	}
	
	/**
	 * 返回顶点x的邻接点y的下一个邻接点的顶点号
	 * @param vArr 顶点表
	 * @param x	顶点x
	 * @param y 顶点y
	 * @return 邻接点的顶点号，做不存在则返回-1
	 */
	public int nextNeighbor(VNode[] vArr, int x, int y) {
		ArcNode arcNode = vArr[x].getFirst();
		
		while(arcNode != null) {
			if(arcNode.getAdjvex() != y) {
				arcNode = arcNode.getNext();
			} else if(arcNode.getNext() != null) {
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
	public int unVisitedNeighbor(Graph g, VNode x) {
		ArcNode arcNode = x.getFirst();
		while(arcNode != null) {
			if(arcNode.isMark() == false) {
				return arcNode.getAdjvex();
			}else {
				arcNode = arcNode.getNext();
			}
		}
		
		return -1;
	}
	/*
	 * 思路
	 * 	类似树的先序遍历的非递归算法
	 * 	利用栈来模拟递归
	 * 	
	 *  1、若可能，访问一个邻接的为访问过的顶点，标记它，并压入栈中
	 *  2、若无法做到1，且栈非空，则从栈中弹出一个顶点
	 *  3、若1、2都无法做到，则算法结束
	 */
	public void DFS(Graph g) {
		//递归工作栈
		SequenceStack<Integer> ss = new SequenceStack<Integer>();
		ss.InitStack();
		
		ss.Push(0);
		//当前顶点的顶点号
		int top = -1;
		//当前顶点的邻接点的顶点号
		int nei = -1;
		while(!ss.StackEmpty()) {
			top = ss.GetTop();
			System.out.println();
			nei = unVisitedNeighbor(g, vertexs[top]);
		}
	}
}
