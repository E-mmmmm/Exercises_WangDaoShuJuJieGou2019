package chapter4_2_3;
//第五题
public class PublicAncestor {
	public static void main(String[] args) {
		int[] arr = new int[]{0,1,2,3,0,4,0,5,0,0,6,0};
		publicAncestor(arr, 5, 4, true);
	}
	/*
	 * 思路
	 * 	首先求出i、j在数组中的下标
	 * 		int real1 = i
	 *  	int real2 = j
	 * 		遍历集合，直到至当前编号
	 * 			若arr[x] == 0，real++
	 * 	分别求出i、j的双亲节点的编号
	 * 		若相同，则输出公共祖先节点的值
	 * 		若不同，继续求两个双亲节点的双亲节点
	 * 注意
	 * 	i、j是元素在数组中的下标，和内容无关
	 * 	树的顺序存储要从数组的第二个位置开始
	 */	
	public static void publicAncestor(int[] arr, double i, double j, boolean flag) {
		double real1 = i;
		double real2 = j;
		
		if(flag == true) {
			for(int x = 1; x < arr.length; x++) {
				if(arr[x] == 0) {
					real1++;
				} else if(arr[x] == i) {
					break;
				}
			}
			for(int x = 1; x < arr.length; x++) {
				if(arr[x] == 0) {
					real2++;
				} else if(arr[x] == j) {
					break;
				}
			}
		}
		
		double parent1 = Math.floor((real1 - 2) / 2) + 1;
		double parent2 = Math.floor((real2 - 2) / 2) + 1;
		
		if(parent1 != parent2) {
			publicAncestor(arr, parent1, parent2, false);
		} else {
			System.out.println(arr[(int)parent1]);
		}
	}
}
