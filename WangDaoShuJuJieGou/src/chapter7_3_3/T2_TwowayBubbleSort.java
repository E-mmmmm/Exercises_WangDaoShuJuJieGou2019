package chapter7_3_3;
//第2题
public class T2_TwowayBubbleSort {
	public static void main(String[] args) {
		int[] arr = {5,2,1,9,7,3,8,4};
		tBS(arr);
		for(int x : arr) {
			System.out.print(x + ", ");
		}
	}
	
	public static void tBS(int[] arr) {
		boolean flag = true;//表示此趟排序有无改动顺序，若无即为排序完成true = 有改动
		int temp = 0;//用于暂存交换的元素
	
		for(int x = 0; x < arr.length/2; x++) {//已经被排序过的元素不参加下次排序,x表示从前往后排序的起始索引
			if(flag != false) {//判断从后往前排序后是否已经有序
				flag = false;//初始化flag
				
				if(x != arr.length-1-x) {//如果待排序的元素个数为一个，则代表排序完成
					for(int i = x; i < arr.length-1-x; i++) {//从前往后
						if(arr[i] > arr[i+1]) {
							temp = arr[i]; 
							arr[i] = arr[i+1];
							arr[i+1] = temp;
						
							flag = true;//若发生了交换则flag为true
						} 
					}
					
					if(flag != false) {//若从前往后排序扫描时发现序列有序，则不用从后往前再来一次
						for(int z = arr.length-2-x; z > x; z--) {//从后往前
							if(arr[z-1] > arr[z]) {
								temp = arr[z-1];
								arr[z-1] = arr[z];
								arr[z] = temp;
								
								flag = true;//若发生了交换则flag为true
							}
						}
					} else {
						return;//从前往后排序后已有序
					}
				} else {
					 return;//如果待排序的元素个数为一个，则代表排序完成
				}
			} else {
				return;//从后往前排序后已有序
			}
		}
	}
	/*
	 * 评语：
	 * 	我这个虽然比书上的复杂一些
	 * 	但考虑了更多排序成功的情况，节省了一些时间
	 * 			
	 */
}