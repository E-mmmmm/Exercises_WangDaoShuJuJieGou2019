package chapter7_3_3;
//��7��

public class T7_DutchFlag {
	public static void main(String[] args) {
		int[] arr = {0, 2, 1, 1, 0, 0, 1, 2, 2, 1, 0, 2, 1, 1, 0};
		dutchFlag(arr);
		for(int x : arr) {
			System.out.print(x + ", ");
		}
	}
	/*
	 * ˼·�������ϴ𰸣�
	 * 	���졢�ס�������0,1,2���������з�Ϊǰ�����в�����
	 * 	������ָ��pre��cur��tail
	 * 	pre��ǰ��ĩβ�ĺ�һ��Ԫ��
	 * 	cur����ǰ��������Ԫ��
	 * 	tail���󲿿�ͷ��ǰһ��Ԫ��
	 *  ��ǰ������
	 * 	cur���������
	 * 	0��swap(pre, cur)��pre++��cur++
	 * 	1��cur++
	 * 	2��swap(tail, cur)��tail--��û��cur++�Է�������cur��ָ����ɫ��
	 * 
	 * Ϊ�ο��ǽ�����cur��ָ����ɫ�������ǽ�����cur��ָ���ɫ��
	 * 	��Ϊ���Ǵ�ǰ���������cur��pre������ָ��1ʱ�Ż�ֿ�
	 * 	�ܹ���֤pre��Ȼָ��ǰ��ĩβ�ĺ�һ��Ԫ�أ���pre��cur֮��û��0
	 * 	������ɫ�����󣬽�����curλ�õ���Ϊ0,2��
	 * 	��ʱ��cur++������ܻᵼ�¸�Ԫ�ر����ڴ����λ��
	 * 	���Ӻ���ǰ������������෴
	 */
	public static void dutchFlag(int[] arr) {
		int pre = 0;
		int tail = arr.length-1;
		int cur = 0;
		
		while(cur < tail) {
			switch(arr[cur]) {
			case 0: {
				swap(arr, cur, pre);
				pre++;
				cur++;
				break;
			}
			
			case 1: {
				cur++;
				break;
			}
			
			case 2: {
				swap(arr, tail, cur);
				tail--;
				break;
			}
			}
		}
	}
	
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
