package chapter7_3_3;

public class T5_FindK {
	public static void main(String[] args) {
		int[] arr = {5, 4, 9, 1, 3, 8, 6};
		System.out.println(findK(arr, 0, arr.length-1, 6));
		for(int x : arr) {
			System.out.print(x + ", ");
		}
	}
	
	//基于随机快速排序
	public static int findK(int[] arr, int low, int high, int k) {
		int randomIndex = low + (int)(Math.random()*(high-low+1));
		swap(arr, randomIndex, low);
		int pivot = arr[low];
		int lowTemp = low;//由于下面会修改low和high，而递归时又要用到它们
		int highTemp = high;
		
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
		
		if(low == k) {
			return arr[low];
		} else if(k > low) {
			return findK(arr, low+1, highTemp, k);
		} else {
			return findK(arr, lowTemp, low-1, k);
		}
	}
	
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
