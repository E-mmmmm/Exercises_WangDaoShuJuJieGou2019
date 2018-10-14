package chapter5_3_4;

import chapter3_1_4.SequenceStack;

//图的DFS非递归算法，图采用邻接表形式
public class DFSNonRecursion {
	public static void main(String[] args) {
		//邻接表
		//初始化结点
		//顶点表
		VNode s1 = new VNode();
		VNode s2 = new VNode();
		VNode s3 = new VNode();
		VNode s4 = new VNode();
		VNode s5 = new VNode();
		//边表-非树
		ArcNode s12 = new ArcNode();
		ArcNode s13 = new ArcNode();
		ArcNode s14 = new ArcNode();
		ArcNode s21 = new ArcNode();
		ArcNode s24 = new ArcNode();
		ArcNode s25 = new ArcNode();
		ArcNode s31 = new ArcNode();
		ArcNode s35 = new ArcNode();
		ArcNode s41 = new ArcNode();
		ArcNode s42 = new ArcNode();
		ArcNode s45 = new ArcNode();
		ArcNode s52 = new ArcNode();
		ArcNode s53 = new ArcNode();
		ArcNode s54 = new ArcNode();
		//信息化结点
		//顶点表-共用
		s1.setData("1");
		s1.setFirst(s12);
		s2.setData("2");
		s2.setFirst(s21);
		s3.setData("3");
		s3.setFirst(s31);
		s4.setData("4");
		s4.setFirst(s41);
		s5.setData("5");
		s5.setFirst(s52);
		VNode[] vArr = {s1, s2, s3, s4, s5};
		//边表-非树
		s12.set(1, s13);
		s13.set(2, s14);
		s14.set(3, null);
		s21.set(0, s24);
		s24.set(3, s25);
		s25.set(4, null);
		s31.set(0, s35);
		s35.set(4, null);
		s41.set(0, s42);
		s42.set(1, s45);
		s45.set(4, null);
		s52.set(1, s53);
		s53.set(2, s54);
		s54.set(3, null);
		//图
		Graph g = new Graph(5, vArr, 7); 
	}
	/*
	 * 思路
	 * 	类似树的先序遍历的非递归算法
	 * 	利用栈来模拟递归
	 * 	
	 * 	若当前顶点w存在，则输出data并压栈，将w指向其第一个邻接点
	 * 	重复以上步骤，直到w = -1，表明此顶点的所有邻接点已被访问，已搜索到最深
	 */
	public static void DFS(Graph g) {
		//递归工作栈
		SequenceStack<Integer> ss = new SequenceStack<Integer>();
		ss.InitStack();
		
		VNode[] vArr = g.getVertexs();
		//搜索的起始顶点号
		int x = 0;
		int w = -1;
		while(!ss.StackEmpty()) {
			//将当前结点设置为已访问，并压栈
			vArr[x].setMark(true);
			ss.Push(x);
			
			w = GraphTool.firstNeighbor(vArr, x);
			if(vArr[w].isMark() == true) {
				w = GraphTool.nextNeighbor(vArr, x, w);
				while(w == -1) {
					int y = ss.Pop();
					w = GraphTool.nextNeighbor(vArr, y, vArr[y].getFirst());
				}
			}
		}
	}
}
