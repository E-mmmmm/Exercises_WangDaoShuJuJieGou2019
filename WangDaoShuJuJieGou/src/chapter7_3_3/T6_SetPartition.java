package chapter7_3_3;
//��6��
/*
 * 1���������˼��
 * 	���տ��������˼�룬������Ԫ�ؽ����Ϸ�Ϊ������
 * 	����Ԫ��m����������Ϊk��������3�����([]��ʾ����ȡ����
 * 	k = [n/2]:���ֳɹ����㷨����
 * 	k < [n/2]��m����֮ǰ��Ԫ������A1��������m֮���Ԫ�ؽ��л���
 * 	k > [n/2]��m����֮���Ԫ������A2��������m֮ǰ��Ԫ�ؽ��л���
 * 	
 * 3��ƽ��ʱ�临�Ӷȣ�O(n)������ˣ�����ô�������أ���
 * 	     �ռ临�Ӷȣ�O(1)
 */
public class T6_SetPartition {
	public static void main(String[] args) {
		int[] arr = {8, 9, 7, 1, 3, 2, 6, 4};
		System.out.println(setPartition(arr));
	}
	
	public static int setPartition(int[] arr) {
		return partition(arr, 0, arr.length-1);
	}
	
	public static int partition(int[] arr, int low, int high) {
		int lowTemp = low;
		int highTemp = high;
		boolean flag = false;
		
		while(flag != true) {
			int randomIndex = low + (int)(Math.random() * (high-low+1));
			swap(arr, randomIndex, low);
			int pivot = arr[low];
			while(low < high) {
				while(low < high && arr[high] >= pivot) {
					high--;
				}
				arr[low] = arr[high];
				
				while(low < high && arr[low] <= pivot) {
					low++;
				}
				arr[high] = arr[low];
			}
			arr[low] = pivot;
			
			if(low == (arr.length-1)/2) {
				flag = true;
			} else if(low < (arr.length-1)/2) {
				low += 1;
				high = highTemp;
			} else {
				high -= 1;
				low = lowTemp;
			}
		}
		
		int s1 = 0;
		int s2 = 0;
		if(arr.length % 2 == 0) {
			for(int x = 0; x < low+1; x++) {
				s1 += arr[x];
			}
			for(int x = low+1; x < arr.length; x++) {
				s2 += arr[x];
			}
		} else {
			for(int x = 0; x < low; x++) {
				s1 += arr[x];
			}
			for(int x = low; x < arr.length; x++) {
				s2 += arr[x];
			}
		}
		
		System.out.println("low:" + low);
		return s2-s1;
	} 
	
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
