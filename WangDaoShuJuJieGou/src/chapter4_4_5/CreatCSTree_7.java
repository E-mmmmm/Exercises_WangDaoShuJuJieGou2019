package chapter4_4_5;

import chapter4_3_3.TreeNode;


//第七题
/*
 * 将层次序列和每个结点的度存储进数组中
 * 根据每个结点a的度n，将结点a的后一个结点b，作为a的左孩子
 * 再向后取n-1个结点作为b的右孩子，b的右孩子的右孩子……以此类推
 * 然后对b做同样的操作
 */
public class CreatCSTree_7 {
	public static void main(String[] args) {
		TreeNode A = new TreeNode("A");
		TreeNode B = new TreeNode("B");
		TreeNode C = new TreeNode("C");
		TreeNode D = new TreeNode("D");
		TreeNode E = new TreeNode("E");
		TreeNode F = new TreeNode("F");
		TreeNode G = new TreeNode("G");
		TreeNode H = new TreeNode("H");
		TreeNode I = new TreeNode("I");
		TreeNode J = new TreeNode("J");
		TreeNode K = new TreeNode("K");
		TreeNode L = new TreeNode("L");
		TreeNode M = new TreeNode("M");
		TreeNode N = new TreeNode("N");
	
		TreeNode[] CSNode = {A, B, C, D, E, F, G, H, I, J, K, L, M, N};
		int[] degree = {3, 1, 2, 3, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0};
		
		creatCSTree(CSNode, degree);
	}
	
	public static void creatCSTree(TreeNode[] CSNode, int[] degree) {
		//指向双亲结点
		int parent = 0;
		//指向孩子结点
		int child = parent + 1;
		
		while(parent < CSNode.length) {
			int count = degree[parent];
			//赋予双亲结点孩子结点
			for(int x = 0; x < count; x++) {
				if(x == 0) {
					CSNode[parent].setLchild(CSNode[child]);
				} else {
					CSNode[child++].setRchild(CSNode[child]);
				}
				
				//处理完一家子结点后，下一家的孩子结点应为下一个结点
				if(x == degree[parent] - 1) {
					child++;
				}
			}
			//所有孩子以添加完毕，循环结束
			if(child == CSNode.length) {
				break;
			}
			//无论该节点是否右孩子，走完上面的代码，就要操作下一个找孩子结点
			parent++;
		}
	}
}
