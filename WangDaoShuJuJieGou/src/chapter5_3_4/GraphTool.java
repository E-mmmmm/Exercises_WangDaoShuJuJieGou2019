package chapter5_3_4;

import chapter5_2_6.AdjSideListNode;
import chapter5_2_6.AdjVertexListNode;

public class GraphTool {
	/**
	 * 求图G中顶点x的第一个邻接点，若有则返回顶点号。
	 * 若x没有邻接点或图中不存在x，则返回-1。
	 * @param vArr 顶点表
	 * @param x	顶点x
	 * @return 若顶点x存在且其有邻接点，则返回其第一个邻接点的顶点号，
	 * 			否则，返回-1。
	 */
	public static int firstNeighbor(VNode[] vArr, int x) {
		if(x < 0 || x >= vArr.length || vArr[x].getFirst() == null) {
			return -1;
		} else {
			return vArr[x].getFirst().getAdjvex();
		}
	}
	
	/**
	 * 返回除y之外顶点x的下一个邻接点的顶点号
	 * @param vArr 顶点表
	 * @param x	顶点x
	 * @param y 顶点y
	 * @return 返回除y之外顶点x的下一个邻接点的顶点号，
	 * 			若y是x的最后一个邻接点，则返回-1
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
