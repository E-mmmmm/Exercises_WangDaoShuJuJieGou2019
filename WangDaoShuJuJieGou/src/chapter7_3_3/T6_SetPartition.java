package chapter7_3_3;
//第6题
/*
 * 1、基本设计思想
 * 	按照快速排序的思想，用枢轴元素将集合分为两部分
 * 	枢轴元素m（设其索引为k）有以下3种情况([]表示向下取整）
 * 	k = [n/2]:划分成功，算法结束
 * 	k < [n/2]：m及其之前的元素属于A1，继续将m之后的元素进行划分
 * 	k > [n/2]：m及其之后的元素属于A2，继续将m之前的元素进行划分
 * 	
 * 3、平均时间复杂度：O(n)（答案如此，但怎么得来的呢？）
 * 	     空间复杂度：O(1)
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
