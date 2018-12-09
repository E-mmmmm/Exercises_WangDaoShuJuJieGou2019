package chapter7_3_3;
//��3��
public class T3_OddFrontEven {
	public static void main(String[] args) {
		int[] arr = {4,2,1,3};
		oFE2(arr);
		for(int x : arr) {
			System.out.print(x + ", ");
		}
	}
	//���ÿ��������˼· �����ϵ�˼· �ҵ�������
	//ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
	//����һ�˼���
	public static void oFE2(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		
		for(; low < high; low++) {
			if(arr[low] % 2 == 0) {
				for(; high > low; high--) {
					if(arr[high] % 2 != 0) {
						swap(arr, low, high);
						break;
					}
				}
			}
		}
	}
	
	//���ÿ��������˼· �����˼· ���������
	public static void oFE3(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		
		while(low < high) {
			while(low < high && arr[low] % 2 !=0) {
				low++;
			}
			while(low < high && arr[low] % 2 == 0) {
				high--;
			}
			
			if(low < high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
	}
	
	//����ð�������˼· ���ҵģ�
	//ʱ�临�Ӷ�O(n^2) �ռ临�Ӷ�O(1)
	public static void oFE(int[] arr) {
		int low = 0;//�½�
		int high = arr.length-1;//�Ͻ�
		
		boolean flag = true;
		
		while(low < high && flag == true) {
			flag = false;
			for(int x = low; x < high; x++) {
				if(arr[x] % 2 == 0 && arr[x+1] % 2 == 1) {
					swap(arr, x, x+1);
					flag = true;
				}
			}
			high--;
		}
	}
	
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}