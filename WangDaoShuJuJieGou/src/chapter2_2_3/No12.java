package chapter2_2_3;

//��12��  ����˼·
/*
 * ��⣺
 * 		ֻ�������г��ִ��������Ǹ�Ԫ�أ����п����ǳ��ִ�������n/2�ε�
 */
public class No12 {
	public static int majority(int[] arr, int n) {
		//�����ѡ����Ԫ��,��ʼʱ�������еĵ�һ��Ԫ����Ϊ��ѡ����Ԫ��
		int c = arr[0];
		//ͳ�ƺ�ѡ��Ԫ�س��ֵĴ���
		int num = 0;
		
		//���Һ�ѡ��Ԫ��
		for (int x = 1; x < n; x++) {
			//�����Ԫ�����ѡ��Ԫ����ͬ����num��һ
			if (arr[x] == c) {
				num++;
				
			//����Ԫ�����ѡ��Ԫ�ز�ͬ���򽫴�Ԫ����Ϊ�µĺ�ѡ��Ԫ�أ����ҽ�num���¸�ֵΪ1
			} else {
				c = arr[x];
				num = 1;
			}
		}
		
		//�жϺ�ѡ��Ԫ���Ƿ��������Ԫ��
		int count = 0;
		for (int x = 0; x < n; x++) {
			if(arr[x] == c) {
				count++;
			}
		}
		
		if (count>n/2) {
			//ȷ�Ϻ�ѡ��Ԫ��
			return c;
		} else {
			//�޺�ѡ��Ԫ��
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 1, 5, 1, 6, 1};
		
		System.out.println(majority(arr, arr.length));
	}
}