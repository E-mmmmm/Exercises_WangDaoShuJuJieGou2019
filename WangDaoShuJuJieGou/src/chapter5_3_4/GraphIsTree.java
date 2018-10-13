package chapter5_3_4;

//判断一个无向图G是否是一棵树
public class GraphIsTree {
	public static void main(String[] args) {
		//邻接表
		//初始化结点
		//顶点表
		VNode s1 = new VNode();
		VNode s2 = new VNode();
		VNode s3 = new VNode();
		VNode s4 = new VNode();
		VNode s5 = new VNode();
		//边表-树
//		ArcNode s12 = new ArcNode();
//		ArcNode s13 = new ArcNode();
//		ArcNode s21 = new ArcNode();
//		ArcNode s24 = new ArcNode();
//		ArcNode s25 = new ArcNode();
//		ArcNode s31 = new ArcNode();
//		ArcNode s42 = new ArcNode();
//		ArcNode s52 = new ArcNode();
		
		//边表-非树
		ArcNode s12 = new ArcNode();
		ArcNode s13 = new ArcNode();
		ArcNode s21 = new ArcNode();
		ArcNode s24 = new ArcNode();
		ArcNode s25 = new ArcNode();
		ArcNode s31 = new ArcNode();
		ArcNode s35 = new ArcNode();
		ArcNode s42 = new ArcNode();
		ArcNode s52 = new ArcNode();
		ArcNode s53 = new ArcNode();
		//信息化结点
		//顶点表-共用
		s1.setData("1");
		s1.setFirst(s12);
		s2.setData("2");
		s2.setFirst(s21);
		s3.setData("3");
		s3.setFirst(s31);
		s4.setData("4");
		s4.setFirst(s42);
		s5.setData("5");
		s5.setFirst(s52);
		VNode[] vArr = {s1, s2, s3, s4, s5};
		//边表-树
		s12.set(1, s13);
		s13.set(2, null);
		s21.set(0, s24);
		s24.set(3, s25);
		s25.set(4, null);
		s31.set(0, null);
		s42.set(1, null);
		s52.set(1, null);
		
		System.out.println(graphIsTree(vArr, 0));
		
		//边表-非树
//		s12.set(1, s13);
//		s13.set(2, null);
//		s21.set(0, s24);
//		s24.set(3, s25);
//		s25.set(4, null);
//		s31.set(0, s35);
//		s35.set(4, null);
//		s42.set(1, null);
//		s52.set(1, s53);
//		s53.set(2, null);
//		
//		System.out.println(graphIsTree(vArr, 0));
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
	public static boolean graphIsTree(VNode[] vArr, int v){ 
		DFS(vArr, v);
		if(vNum == vArr.length && eNum == 2*(vArr.length-1)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 深度优先遍历
	 * @param vArr 图G的顶点表
	 * @param v 遍历的起始顶点
	 */
	private static void DFS(VNode[] vArr, int v) {
		if(v != -1) {
			vArr[v].setMark(true);
			vNum++;
			int w = GraphTool.firstNeighbor(vArr, v);
			
			while(w != -1) {
				eNum++;
				if(vArr[w].isMark() == false) {
					DFS(vArr, w);
				}
				
				w = GraphTool.nextNeighbor(vArr, v, w);
			}
		}
	}
}