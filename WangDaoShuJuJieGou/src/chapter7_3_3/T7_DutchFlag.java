package chapter7_3_3;
//第7题

public class T7_DutchFlag {
	public static void main(String[] args) {
		int[] arr = {0, 2, 1, 1, 0, 0, 1, 2, 2, 1, 0, 2, 1, 1, 0};
		dutchFlag(arr);
		for(int x : arr) {
			System.out.print(x + ", ");
		}
	}
	/*
	 * 思路：（书上答案）
	 * 	将红、白、蓝看做0,1,2，并将序列分为前部、中部、后部
	 * 	设三个指针pre，cur，tail
	 * 	pre：前部末尾的后一个元素
	 * 	cur：当前遍历到的元素
	 * 	tail：后部开头的前一个元素
	 *  从前向后遍历
	 * 	cur的三种情况
	 * 	0：swap(pre, cur)，pre++，cur++
	 * 	1：cur++
	 * 	2：swap(tail, cur)，tail--（没有cur++以防交换后，cur仍指向蓝色）
	 * 
	 * 为何考虑交换后cur仍指向蓝色而不考虑交换后cur仍指向红色？
	 * 	因为这是从前往后遍历，cur和pre仅会在指向1时才会分开
	 * 	能够保证pre必然指向前部末尾的后一个元素，而pre和cur之间没有0
	 * 	而若蓝色交换后，交换到cur位置的若为0,2，
	 * 	此时若cur++，则可能会导致该元素被丢在错误的位置
	 * 	若从后向前遍历，则情况相反
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
