package chapter2_2_3;

//第12题  书上思路
/*
 * 理解：
 * 		只有序列中出现次数最多的那个元素，才有可能是出现次数大于n/2次的
 */
public class No12 {
	public static int majority(int[] arr, int n) {
		//保存候选的主元素,初始时将序列中的第一个元素作为候选的主元素
		int c = arr[0];
		//统计候选主元素出现的次数
		int num = 0;
		
		//查找候选主元素
		for (int x = 1; x < n; x++) {
			//如果此元素与候选主元素相同，则num加一
			if (arr[x] == c) {
				num++;
				
			//若此元素与候选主元素不同，则将此元素作为新的候选主元素，并且将num重新赋值为1
			} else {
				c = arr[x];
				num = 1;
			}
		}
		
		//判断候选主元素是否真的是主元素
		int count = 0;
		for (int x = 0; x < n; x++) {
			if(arr[x] == c) {
				count++;
			}
		}
		
		if (count>n/2) {
			//确认候选主元素
			return c;
		} else {
			//无候选主元素
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 1, 5, 1, 6, 1};
		
		System.out.println(majority(arr, arr.length));
	}
}