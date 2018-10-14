package chapter5_3_4;
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
	private int vexnum = 0;
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
	private VNode[] vertexs = new VNode[capacity];
	/**
	 * �ڽӾ���
	 */
	int[][] mst = new int[capacity][capacity];
	/**
	 * ��ǰ���һ������Ķ����
	 */
	int current = -1;
	/**
	 * ���췽������������ͼ������
	 * @param type ͼ������
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
	public boolean adjacent(Graph g, VNode x, VNode y) {
		int xLoc = location(g, x);
		int yLoc = location(g, y);
		
		if(mst[xLoc][yLoc] == 1) {
			return true;
		} else {
			return false;
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
	public int location(Graph g, VNode x) {
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
	public void insertVertex(Graph g, VNode x) {
		//�Զ�����
		if(vexnum == capacity) {
			ensureCapacity();
		}
		//��� 
		vertexs[current++] = x;
	}
	
	/**
	 * ɾ������
	 * @param g ������ͼ
	 * @param x ɾ���Ķ���
	 */
	public VNode deleteVertex(Graph g, VNode x) {
		int loc = location(g, x);
		
		if(loc > current || loc == -1) {
			System.out.println("�ö��㲻����");
			return null;
		} else if(loc == current) {
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
			vertexs[loc] = null;
			trimVertexs(loc);
			//���ڽӾ�����ɾ��
			//������
			for(int line = 0; line < current; line++) {
				for(int column = loc; column < current-1; column++) {
					mst[line][column] = mst[line][column+1];
				}
			}
			//������
			for(int column = 0; column < current; column++) {
				for(int line = loc; line < current-1; line++) {
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
		
		return x;
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
	public void addEdge(Graph g, VNode x, VNode y) {
		int xLoc = location(g, x);
		int yLoc = location(g, y);
		//�ڽӱ�
		if(xLoc == -1 || yLoc == -1 || xLoc > current || yLoc > current) {
			System.out.println("���㲻���ڣ��޷���ӱ�");
			return;
		} else {
			//����x���ڽӵ�y
			ArcNode arcY = new ArcNode();
			arcY.setAdjvex(yLoc);

			ArcNode arcNode = x.getFirst();
			if(x.getFirst() != null) {
				while(arcNode.getNext() != null) {
					if(arcNode.getAdjvex() != yLoc) {
						arcNode = arcNode.getNext();
					} else {
						System.out.println("�ñ��Ѵ���");
					}
				}
				
				arcNode.setNext(arcY);
			} else {
				x.setFirst(arcY);
			}
		}
		//�ڽӾ���
		mst[xLoc][yLoc] = 1;
		
		//��������ͼ����Ҫ�ٷ������һ��
		if(type == 0) {
			//�ڽӱ�
			ArcNode arcX = new ArcNode();
			arcX.setAdjvex(xLoc);
			
			if(y.getFirst() == null) {
				y.setFirst(arcX);
			} else {
				ArcNode arcNode = y.getFirst();
				while(arcNode.getNext() != null) {
					arcNode = arcNode.getNext();
				}
				
				arcNode.setNext(arcX);
			}
			
			//�ڽӾ���
			mst[yLoc][xLoc] = 1;
		}
	}
	/**
	 * ���ߴ��ڣ����ͼ��ɾ���ñ�
	 * @param g ������ͼ
	 * @param x ����ߵ�һ�����������ߵĻ�β
	 * @param y	����ߵ���һ�����������ߵĻ�ͷ
	 */
	public void removeEdege(Graph g, VNode x, VNode y) {
		int xLoc = location(g, x);
		int yLoc = location(g, y);
		
		//�ڽӾ���
		mst[xLoc][yLoc] = 0;
		
		//�ڽӱ�
		//ָ��Ҫɾ���ı߱����ǰ�����
		if(x.getFirst() == null) {
			System.out.println("�ñ߲����ڣ��޷�ɾ��");
			return;
		} else {
			ArcNode pre = new ArcNode();
			ArcNode node = new ArcNode();
			
			node = x.getFirst();
			
			if(node.getAdjvex() == yLoc) {
				//��Ҫɾ���ı߱���Ϊ�߱�ı�ͷ
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
				
				System.out.println("�ñ߲����ڣ��޷�ɾ��");
			}
		}
	}
	
	/**
	 * ��ͼG�ж���x�ĵ�һ���ڽӵ㣬�����򷵻ض���š�
	 * ��xû���ڽӵ��ͼ�в�����x���򷵻�-1��
	 * @param vArr �����
	 * @param x	����x
	 * @return ������x�����������ڽӵ㣬�򷵻����һ���ڽӵ�Ķ���ţ�
	 * 			���򣬷���-1��
	 */
	public static int firstNeighbor(VNode[] vArr, int x) {
		if(x < 0 || x >= vArr.length || vArr[x].getFirst() == null) {
			return -1;
		} else {
			vArr[x].getFirst().setMark(true);
			return vArr[x].getFirst().getAdjvex();
		}
	}
	
	/**
	 * ���س�y֮�ⶥ��x����һ���ڽӵ�Ķ����
	 * @param vArr �����
	 * @param x	����x
	 * @param y ����y
	 * @return ���س�y֮�ⶥ��x����һ���ڽӵ�Ķ���ţ�
	 * 			��y��x�����һ���ڽӵ㣬�򷵻�-1
	 */
	public static int nextNeighbor(VNode[] vArr, int x, int y) {
		ArcNode arcNode = vArr[x].getFirst();
		
		while(arcNode != null) {
			if(arcNode.getAdjvex() == y || 
					arcNode.isMark() == true) {
				arcNode.setMark(true);
				arcNode = arcNode.getNext();
			} else if(arcNode.isMark() == false) {
				arcNode.setMark(true);
				return arcNode.getAdjvex();
			}
		}
		
		return -1;
	}
}
