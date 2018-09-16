package chapter4_4_5;

import chapter4_3_3.TreeNode;


//������
/*
 * ��������к�ÿ�����Ķȴ洢��������
 * ����ÿ�����a�Ķ�n�������a�ĺ�һ�����b����Ϊa������
 * �����ȡn-1�������Ϊb���Һ��ӣ�b���Һ��ӵ��Һ��ӡ����Դ�����
 * Ȼ���b��ͬ���Ĳ���
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
		//ָ��˫�׽��
		int parent = 0;
		//ָ���ӽ��
		int child = parent + 1;
		
		while(parent < CSNode.length) {
			int count = degree[parent];
			//����˫�׽�㺢�ӽ��
			for(int x = 0; x < count; x++) {
				if(x == 0) {
					CSNode[parent].setLchild(CSNode[child]);
				} else {
					CSNode[child++].setRchild(CSNode[child]);
				}
				
				//������һ���ӽ�����һ�ҵĺ��ӽ��ӦΪ��һ�����
				if(x == degree[parent] - 1) {
					child++;
				}
			}
			//���к����������ϣ�ѭ������
			if(child == CSNode.length) {
				break;
			}
			//���۸ýڵ��Ƿ��Һ��ӣ���������Ĵ��룬��Ҫ������һ���Һ��ӽ��
			parent++;
		}
	}
}
