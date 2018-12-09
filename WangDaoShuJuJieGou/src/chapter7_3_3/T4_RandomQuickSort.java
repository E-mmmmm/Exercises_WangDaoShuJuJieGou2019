package chapter7_3_3;

//第4题
public class T4_RandomQuickSort {
	public static void main(String[] args) {
		int[] arr = {2,1,5,4,3};
		randomQuickSort(arr, 0, arr.length-1);
		for(int x : arr) {
			System.out.print(x + ", ");
		}
	}
	public static void randomQuickSort(int[] arr ,int low, int high) {
		if(low < high) {
			int pivotpos = partition(arr, low, high);
			randomQuickSort(arr, low, pivotpos-1);
			randomQuickSort(arr, pivotpos+1, high);
		}
	}
	public static int partition(int[] arr, int low, int high) {
		//随机数的产生是关键
		int randomIndex = low + (int)(Math.random()*(high-low+1)); 
		int pivot = arr[randomIndex];
		swap(arr , randomIndex, low);
		
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
		return low;
	}
	
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
