package chapter2_2_3;

import java.util.Arrays;

public class SequenceList {
	private final int DEFAULT_CAPACITY = 10;
	private int size = 0;
	int[] arr;

	/**
	 * 创建一个指定长度的顺序表
	 * 
	 * @param size
	 *            指定 长度
	 */
	public SequenceList(int size) {
		arr = new int[size];
	}

	/**
	 * 创建一个默认长度的顺序表，默认长度为10
	 */
	public SequenceList() {
		arr = new int[DEFAULT_CAPACITY];
	}

	/**
	 * 在表尾添加指定元素
	 * 
	 * @param element
	 *            添加的元素
	 */
	public void insert(Integer element) {
		arr[size] = element;
		size++;
		if (size == arr.length) {
			ensureCapacity(size + 10);
		}
	}

	/**
	 * 如有必要，增加此 SequenceList 实例的容量，以确保它至少能够容纳最小容量参数所指定的元素数。
	 * 
	 * @param minCapacity
	 *            所需的最小容量
	 */
	private void ensureCapacity(int minCapacity) {
		arr = Arrays.copyOf(arr, minCapacity);
	}

	/**
	 * 遍历该顺序表
	 */
	public void print() {
		for (int x = 0; x < size; x++) {
			System.out.println(arr[x]);
		}
	}

	/**
	 * 判断该表是否为空
	 * 
	 * @return 为空则返回true
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}

		return false;
	}

	/**
	 * * 删除指定索引处的元素
	 * 
	 * @param index
	 *            指定的索引
	 * @return
	 * 			       被删除的元素
	 */
	public int remove(int index) {
		int a = arr[index];
		
		for (int x = index; x < size - 1; x++) {
			arr[x] = arr[x + 1];
		}
		size--;
		
		return a;
	}
	
	public int getSize() {
		return size;
	}

	// 2.2.3 第三题
	/**
	 * 删除所有值为element的数据元素
	 * 
	 * @param element
	 *            需要删除的元素
	 */
	public void removeX(Integer element) {
		for (int x = 0; x < size; x++) {
			if (arr[x] == element) {
				remove(x--);
				//x--;
			}
		}
	}

	// 第五题
	// 从前向后遍历，用变量k记录在s到t之间的元素的个数。若当前遍历的元素不属于s到t，则向前移动k个位置，否则k++
	public void removeBetween(Integer start, Integer end) {
		int k = 0;

		if (isEmpty()) {
			throw new RuntimeException("该表为空");
		} else if (start >= end) {
			throw new RuntimeException("数值异常");
		} else {
			for (int x = 0; x < size; x++) {
				if ((arr[x] >= start) && (arr[x] <= end)) {
					k++;
				} else {
					arr[x - k] = arr[x];

				}
			}
			size -= k;
		}
	}
	
	/*
	 * 第十题
	 * 创建一个变量temp，将arr[0]取出放置在变量temp中
	 * 然后将arr[1]及其之后的所有元素向前移一位
	 * 再将temp置入数组末尾
	 * 重复以上步骤p次
	 * 空间复杂度为O(n)
	 * 时间复杂度  本以为是O(n) 实际上是O(n^2)
	 */
	public void slip(int times) {
		//将arr[0]取出放置在变量temp中
		int temp = 0;
		for(int x = 0; x < times; x++) {
			temp = arr[0];
			
			//然后将arr[1]及其之后的所有元素向前移一位
			for(int y = 0;y < arr.length-1; y++) {
				arr[y] = arr[y+1];
			}
			
			//再将temp置入数组末尾
			arr[arr.length-1] = temp;
		}
	}
}
