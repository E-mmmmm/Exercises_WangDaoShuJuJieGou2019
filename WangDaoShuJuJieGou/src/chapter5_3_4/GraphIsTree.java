package chapter5_3_4;

//�ж�һ������ͼG�Ƿ���һ����
public class GraphIsTree {
	public static void main(String[] args) {
		//�ڽӱ�
		//��ʼ�����
		//�����
		VNode s1 = new VNode();
		VNode s2 = new VNode();
		VNode s3 = new VNode();
		VNode s4 = new VNode();
		VNode s5 = new VNode();
		//�߱�-��
//		ArcNode s12 = new ArcNode();
//		ArcNode s13 = new ArcNode();
//		ArcNode s21 = new ArcNode();
//		ArcNode s24 = new ArcNode();
//		ArcNode s25 = new ArcNode();
//		ArcNode s31 = new ArcNode();
//		ArcNode s42 = new ArcNode();
//		ArcNode s52 = new ArcNode();
		
		//�߱�-����
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
		//��Ϣ�����
		//�����-����
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
		//�߱�-��
		s12.set(1, s13);
		s13.set(2, null);
		s21.set(0, s24);
		s24.set(3, s25);
		s25.set(4, null);
		s31.set(0, null);
		s42.set(1, null);
		s52.set(1, null);
		
		System.out.println(graphIsTree(vArr, 0));
		
		//�߱�-����
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
	public static boolean graphIsTree(VNode[] vArr, int v){ 
		DFS(vArr, v);
		if(vNum == vArr.length && eNum == 2*(vArr.length-1)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * ������ȱ���
	 * @param vArr ͼG�Ķ����
	 * @param v ��������ʼ����
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