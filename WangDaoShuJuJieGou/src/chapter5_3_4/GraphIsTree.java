package chapter5_3_4;

//�ж�һ������ͼG�Ƿ���һ����
public class GraphIsTree {
	public static void main(String[] args) {
		//����ͼ
		Graph g = new Graph(0);
		//�ڽӱ�
		//��
		//��Ӷ���
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
		//��ӱ�
		g.addEdge(ver1, ver2);
		g.addEdge(ver1, ver3);
		g.addEdge(ver2, ver4);
		g.addEdge(ver2, ver5);
		//����
//		g.addEdge(ver3, ver5);
//		System.out.println(g.graphIsTree());
		g.DFSTraverse();
		System.out.println();
		g.DFSNonRecursion(ver1);

	}	

}