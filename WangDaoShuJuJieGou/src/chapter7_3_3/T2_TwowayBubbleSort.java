package chapter7_3_3;
//��2��
public class T2_TwowayBubbleSort {
	public static void main(String[] args) {
		int[] arr = {5,2,1,9,7,3,8,4};
		tBS(arr);
		for(int x : arr) {
			System.out.print(x + ", ");
		}
	}
	
	public static void tBS(int[] arr) {
		boolean flag = true;//��ʾ�����������޸Ķ�˳�����޼�Ϊ�������true = �иĶ�
		int temp = 0;//�����ݴ潻����Ԫ��
	
		for(int x = 0; x < arr.length/2; x++) {//�Ѿ����������Ԫ�ز��μ��´�����,x��ʾ��ǰ�����������ʼ����
			if(flag != false) {//�жϴӺ���ǰ������Ƿ��Ѿ�����
				flag = false;//��ʼ��flag
				
				if(x != arr.length-1-x) {//����������Ԫ�ظ���Ϊһ����������������
					for(int i = x; i < arr.length-1-x; i++) {//��ǰ����
						if(arr[i] > arr[i+1]) {
							temp = arr[i]; 
							arr[i] = arr[i+1];
							arr[i+1] = temp;
						
							flag = true;//�������˽�����flagΪtrue
						} 
					}
					
					if(flag != false) {//����ǰ��������ɨ��ʱ���������������ôӺ���ǰ����һ��
						for(int z = arr.length-2-x; z > x; z--) {//�Ӻ���ǰ
							if(arr[z-1] > arr[z]) {
								temp = arr[z-1];
								arr[z-1] = arr[z];
								arr[z] = temp;
								
								flag = true;//�������˽�����flagΪtrue
							}
						}
					} else {
						return;//��ǰ���������������
					}
				} else {
					 return;//����������Ԫ�ظ���Ϊһ����������������
				}
			} else {
				return;//�Ӻ���ǰ�����������
			}
		}
	}
	/*
	 * ���
	 * 	�������Ȼ�����ϵĸ���һЩ
	 * 	�������˸�������ɹ����������ʡ��һЩʱ��
	 * 			
	 */
}