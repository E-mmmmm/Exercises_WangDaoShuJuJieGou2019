package chapter5_3_4;

import chapter5_2_6.AdjSideListNode;
import chapter5_2_6.AdjVertexListNode;

public class GraphTool {
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
