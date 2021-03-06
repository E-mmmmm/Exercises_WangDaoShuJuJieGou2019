package chapter5_3_4;

//判断一个无向图G是否是一棵树
public class GraphTest {
	public static void main(String[] args) {
		//创建图
		Graph g = new Graph(0);
		//邻接表
		//树
		//添加顶点
		VNode v1 = new VNode("A");
		VNode v2 = new VNode("B");
		VNode v3 = new VNode("C");
		VNode v4 = new VNode("D");
		VNode v5 = new VNode("E");
		int ver1 = g.insertVertex(v1);
		int ver2 = g.insertVertex(v2);
		int ver3 = g.insertVertex(v3);
		int ver4 = g.insertVertex(v4);
		int ver5 = g.insertVertex(v5);
		//添加边
		g.addEdge(ver1, ver2);
		g.addEdge(ver1, ver3);
		g.addEdge(ver1, ver4);
		g.addEdge(ver1, ver5);
		g.addEdge(ver2, ver3);
		g.addEdge(ver2, ver4);
		g.addEdge(ver2, ver5);
		g.addEdge(ver3, ver4);
		g.addEdge(ver3, ver5);
		g.addEdge(ver4, ver5);
		//非树
//		g.addEdge(ver3, ver5);
//		g.showPath(ver1, ver5);
		g.findPath(ver1, ver5);
	}	
}