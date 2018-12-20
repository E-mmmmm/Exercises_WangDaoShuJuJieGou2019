package chapter7_6_3;
//第2题
/*
 * 待排序序列基本有序，使用直接插入排序
 * 首先遍历整个序列，寻找前后序列的分界
 * 若后序列最小值大于前序列最大值，则找不到分界，且整个序列有序，算法结束
 * 若后序列最小值小于前序列最大值，则开始执行直接插入排序，
 * 直到后序列的最小值完成插入，算法结束
 */
public class T2_Sort {
	public static void main(String[] args) {
		
	}
	
	public static void insertSort(int[] arr) {
		//后序列的最小值的索引
		int boundary = -1;
		
		//遍历整个序列，寻找前后序列的分界
		for(int x = 0; x < arr.length -1; x++) {
			if(arr[x] > arr[x+1])
		}
	}
}
