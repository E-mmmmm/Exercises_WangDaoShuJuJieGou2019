package chapter5_2_6;
/*
 * 思路
 * 	按照邻接表的顶点表的长度，创建一个初始化的邻接矩阵
 * 	依次遍历邻接表，修改矩阵的对应元素
 */
public class No_4 {
	public static void main(String[] args) {
		//邻接表
		//初始化结点
		//顶点表
		AdjVertexListNode s1 = new AdjVertexListNode();
		AdjVertexListNode s2 = new AdjVertexListNode();
		AdjVertexListNode s3 = new AdjVertexListNode();
		AdjVertexListNode s4 = new AdjVertexListNode();
		AdjVertexListNode s5 = new AdjVertexListNode();
		//边表
		AdjSideListNode s12 = new AdjSideListNode();
		AdjSideListNode s15 = new AdjSideListNode();
		AdjSideListNode s21 = new AdjSideListNode();
		AdjSideListNode s25 = new AdjSideListNode();
		AdjSideListNode s23 = new AdjSideListNode();
		AdjSideListNode s24 = new AdjSideListNode();
		AdjSideListNode s32 = new AdjSideListNode();
		AdjSideListNode s34 = new AdjSideListNode();
		AdjSideListNode s42 = new AdjSideListNode();
		AdjSideListNode s45 = new AdjSideListNode();
		AdjSideListNode s43 = new AdjSideListNode();
		AdjSideListNode s54 = new AdjSideListNode();
		AdjSideListNode s51 = new AdjSideListNode();
		AdjSideListNode s52 = new AdjSideListNode();
		//信息化结点
		//顶点表
		s1.setData("1");
		s1.setFirstarc(s12);
		s2.setData("2");
		s2.setFirstarc(s21);
		s3.setData("3");
		s3.setFirstarc(s32);
		s4.setData("4");
		s4.setFirstarc(s42);
		s5.setData("5");
		s5.setFirstarc(s54);
		AdjVertexListNode[] adjVertexList = {s1, s2, s3, s4, s5};
		//边表
		s12.set(s2, s15);
		s15.set(s5, null);
		s21.set(s1, s25);
		s25.set(s5, s23);
		s23.set(s3, s24);
		s24.set(s4, null);
		s32.set(s2, s34);
		s34.set(s4, null);
		s42.set(s2, s45);
		s45.set(s5, s43);
		s43.set(s3, null);
		s54.set(s4, s51);
		s51.set(s1, s52);
		s52.set(s2, null);
		
		int[][] adjMatrix = adjListToMatrix(adjVertexList);
		for(int[] vertex : adjMatrix) {
			for(int side : vertex) {
				System.out.print(side + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] adjListToMatrix(AdjVertexListNode[] adjVertexList) {
		//创建初始化的矩阵，以二维数组表示
		int[][] adjMatrix = new int[adjVertexList.length][adjVertexList.length];
		//遍历邻接表将信息填入矩阵中
		for(int x = 0; x < adjVertexList.length; x++) {
			AdjSideListNode node = adjVertexList[x].getFirstarc();
			while(node != null) {
				adjMatrix[x][Integer.parseInt(node.getAdjvex().getData())-1] = 1;
				node = node.getNextarc();
			}
		}
		
		return adjMatrix;
	}
}
