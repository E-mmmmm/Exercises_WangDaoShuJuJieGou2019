package chapter7_4_3;

public class IsSmallRootHeap {
	public static void main(String[] args) {
		int[] arr = {23, 25, 68, 52, 60, 72};
		System.out.println(isSmallRootHeap(arr));
	}
	
	public static boolean isSmallRootHeap(int[] arr) {
		if(arr.length % 2 == 0) {//存在一个单分支结点
			if(arr[arr.length-1] < arr[arr.length/2 -1]) {//处理单分支结点
				return false;
			}
			for(int x = arr.length/2 -1; x > 0; x--) {//处理双分支结点
				if(arr[2*x -1] < arr[x-1] || arr[2*x] < arr[x-1]) {
					return false;
				}
			}
		} else {//皆为双分支结点
			for(int x = arr.length/2; x > 0; x--) {
				if(arr[2*x -1] < arr[x-1] || arr[2*x] < arr[x-1]) {
					return false;
				}
			}	
		}
		return true;
	}
}
