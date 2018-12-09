package chapter7_3_3;
//第3题
public class T3_OddFrontEven {
	public static void main(String[] args) {
		int[] arr = {4,2,1,3};
		oFE2(arr);
		for(int x : arr) {
			System.out.print(x + ", ");
		}
	}
	//采用快速排序的思路 （书上的思路 我的做法）
	//时间复杂度O(n) 空间复杂度O(1)
	//遍历一趟即可
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
	
	//采用快速排序的思路 （书的思路 书的做法）
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
	
	//采用冒泡排序的思路 （我的）
	//时间复杂度O(n^2) 空间复杂度O(1)
	public static void oFE(int[] arr) {
		int low = 0;//下界
		int high = arr.length-1;//上界
		
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