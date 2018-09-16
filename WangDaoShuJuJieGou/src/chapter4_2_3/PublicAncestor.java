package chapter4_2_3;
//������
public class PublicAncestor {
	public static void main(String[] args) {
		int[] arr = new int[]{0,1,2,3,0,4,0,5,0,0,6,0};
		publicAncestor(arr, 5, 4, true);
	}
	/*
	 * ˼·
	 * 	�������i��j�������е��±�
	 * 		int real1 = i
	 *  	int real2 = j
	 * 		�������ϣ�ֱ������ǰ���
	 * 			��arr[x] == 0��real++
	 * 	�ֱ����i��j��˫�׽ڵ�ı��
	 * 		����ͬ��������������Ƚڵ��ֵ
	 * 		����ͬ������������˫�׽ڵ��˫�׽ڵ�
	 * ע��
	 * 	i��j��Ԫ���������е��±꣬�������޹�
	 * 	����˳��洢Ҫ������ĵڶ���λ�ÿ�ʼ
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
