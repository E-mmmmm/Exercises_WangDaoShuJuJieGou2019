package chapter2_2_3;

import java.util.Arrays;

public class OrderedSequenceList {
	private final int DEFAULT_CAPACITY = 10;
	private int size = 0;
	int[] arr;

	/**
	 * 创建一个指定长度的顺序表
	 * 
	 * @param size
	 *            指定 长度
	 */
	public OrderedSequenceList(int size) {
		super();
		arr = new int[size];
	}

	/**
	 * 创建一个默认长度的顺序表，默认长度为10
	 */
	public OrderedSequenceList() {
		super();
		arr = new int[DEFAULT_CAPACITY];
	}

	/**
	 * 在表尾添加指定元素
	 * 
	 * @param element
	 *            添加的元素
	 */
	public void insert(int element) {
		arr[size] = element;
		size++;

		sort();

		if (size == arr.length) {
			ensureCapacity(size + 10);
		}
	}

	private void sort() {
		if (size > 1) {
			int[] sbj = Arrays.copyOf(arr, size);
			Arrays.sort(sbj);
			arr = Arrays.copyOf(sbj, arr.length);
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
	 * 删除指定索引处的元素
	 * 
	 * @param index
	 *            指定的索引
	 */
	public void remove(int index) {
		for (int x = index; x < size - 1; x++) {
			arr[x] = arr[x + 1];
		}
		size--;
	}

	/**
	 * 判断该表是否为空
	 * 
	 * @return 为空则返回true
	 */
	public boolean isEmpty() {
		if (size != 0) {
			return false;
		}

		return true;
	}

	// 2.2.3 第四题
	public void removeBetween(int start, int end) {
		int startIndex = 0;
		int endIndex = 0;

		if (isEmpty()) {
			throw new RuntimeException("该表为空");
		} else {
			// 找到起始值最后一次出现的索引
			for (int x = 0; x < size; x++) {
				if (arr[x] == start) {
					startIndex = x;
				}
			}
			// 找到终止值第一次出现的索引
			for (int x = 0; x < size; x++) {
				if (arr[x] == end) {
					endIndex = x;
					break;
				}
			}

			if (startIndex >= endIndex) {
				throw new RuntimeException("数值异常");
			} else {
				for (int y = startIndex + 1; y < endIndex; y++) {
					remove(y--);
					// y--;
					endIndex--;
				}
			}
		}
	}

	// 第六题-1
	// 通过创建一个新数组来判断元素是否重复，时间复杂度为O(n^2)
	public void removeRepetition() {
		int[] record = new int[size];
		int recSize = 0;

		for (int x = 0; x < size; x++) {
			boolean flag = false;

			for (int y = 0; y < recSize + 1; y++) {
				if (arr[x] == record[y]) {
					flag = true;
				}
			}

			if (flag == true) {
				remove(x--);
				// x--;
			} else {
				record[recSize] = arr[x];
			}
		}
	}

	// 第六题-2
	// 因为该表本质上是一个有序int[]，所以设置两个变量min,max；
	// 开始时，为min和max赋予对应的arr[0]和arr[1]
	// 若当前的元素小于min或大于max的值，则相应的给变量重新赋予当前元素的值
	// 若当前的元素在min和max之间，则为重复元素，删除即可
	// 时间复杂度为O(n)
	public void removeRepetition2() {
		int min;
		int max;

		// 初始化min和max
		if (arr[0] <= arr[1]) {
			min = arr[0];
			max = arr[1];
		} else {
			min = arr[1];
			max = arr[0];
		}

		for (int x = 2; x < size; x++) {
			if (arr[x] >= min && arr[x] <= max) {
				remove(x--);
				// x--;
			} else if (arr[x] < min) {
				min = arr[x];
			} else if (arr[x] > max) {
				max = arr[x];
			}
		}

		// 若初始状况下arr[0]==arr[1]，此时需要删除一个
		if (arr[0] == arr[1]) {
			remove(1);
		}
	}

	// 第六题-2改
	// 分析“第六题-②”的代码后发现
	// 1、因为是有序数组，所以for循环中的条件arr[x]<min永不成立
	// 2、因为是有序数组，所以实际上上述代码所做的是判断一个元素是否和前一个元素相同，相同则删除，不同则保留
	// 因此改进如下
	// 时间复杂度为O(n)
	public void removeRepetition22() {
		for (int x = 0; x < size - 1; x++) {
			if (arr[x] == arr[x + 1]) {
				remove(x--);
			}
		}
	}

	// 第六题-3
	// 初始时将第一个元素看做非重复有序表
	// 判断下一个元素是否与第一个元素相同
	// 若相同，则继续判断下一个
	// 若不同，则将其插入前面的非重复有序表的表尾
	// 时间复杂度为O(n)
	// 注：看书上答案后，自己写成
	public void removeRepetition3() {
		int i = 0;
		for (int x = 1; x < size; x++) {
			if (arr[x] != arr[i]) {
				arr[++i] = arr[x];
			}
		}
		size = i + 1;
	}

	// 第七题-1
	// 简单的将两个有序表首尾相接，用Arrays.sort()排序
	public int[] merge(OrderedSequenceList arr2) {
		// 新数组，长度为两个有序表有效长度（size）之和
		int[] result = new int[this.size + arr2.size];

		// 将第一个有序表添加进新数组中
		for (int x = 0; x < this.size; x++) {
			result[x] = this.arr[x];
		}

		// 将第二个有序表添加进新数组中
		for (int x = 0; x < arr2.size; x++) {
			result[x + this.size] = arr2.arr[x];
		}

		// 将新数组排序
		Arrays.sort(result);

		return result;
	}

	// 第七题-2（看书的思路后）
	// 第一种方法其实很蠢，因为没有现成的方法可以将两个数组首尾相接，自己连接就非常麻烦
	// 而且在合并的时候，其实就可以伴随着排序了
	public int[] merge2(OrderedSequenceList arr2) {
		// 新数组，长度为两个有序表有效长度（size）之和
		int[] result = new int[this.size + arr2.size];

		// A.两个有序表各取两个元素，两者比较，较小的元素插入新数组中
		// B.再从较小的元素所在的有序表取一个元素，执行步骤A

		int x = 0;
		int y = 0;
		for (int z = 0; x < this.size && y < arr2.size; x++, y++, z++) {
			if (arr[x] <= arr2.arr[y]) {
				result[z] = arr[x];
				y--;
			} else if (arr[x] > arr2.arr[y]) {
				result[z] = arr2.arr[y];
				x--;
			}
		}

		if (x < this.size - 1) {
			for (; x < this.size; x++) {
				result[x + y] = this.arr[x];
			}
		} else if (y < arr2.size - 1) {
			for (; y < this.size; y++) {
				result[x + y] = arr2.arr[y];
			}
		}

		return result;
	}

	// merge2改版（看答案后）
	public int[] merge22(OrderedSequenceList arr2) {
		// 新数组，长度为两个有序表有效长度（size）之和
		int[] result = new int[this.size + arr2.size];

		// A.两个有序表各取两个元素，两者比较，较小的元素插入新数组中
		// B.再从较小的元素所在的有序表取一个元素，执行步骤A

		int x = 0;
		int y = 0;
		int z = 0;
		// for (int z = 0; x < this.size && y < arr2.size; x++, y++, z++) {
		// if (arr[x] <= arr2.arr[y]) {
		// result[z] = arr[x];
		// y--;
		// } else if (arr[x] > arr2.arr[y]) {
		// result[z] = arr2.arr[y];
		// x--;
		// }
		// }

		while (x < this.size && y < arr2.size) {
			if (arr[x] <= arr2.arr[y]) {
				result[z++] = arr[x++];
			} else if (arr[x] > arr2.arr[y]) {
				result[z++] = arr2.arr[y++];
			}
		}

		// if (x < this.size - 1) {
		// for (; x < this.size; x++) {
		// result[x + y] = this.arr[x];
		// }
		// } else if (y < arr2.size - 1) {
		// for (; y < this.size; y++) {
		// result[x + y] = arr2.arr[y];
		// }
		// }

		while (x < this.size) {
			result[z++] = this.arr[x++];
		}

		while (y < arr2.size) {
			result[z++] = arr2.arr[y++];
		}
		return result;
	}

	// 第九题
	// 二分查找法
	public void insertOrChange(int i) {
		int start = 0;
		int end = size - 1;
		int mid = (start + end) / 2;

		for (; start <= end; mid = (start + end) / 2) {
			if (i < arr[mid]) {
				end = mid - 1;

			} else if (i > arr[mid]) {
				start = mid + 1;

			} else if (i == arr[mid]) {
				break;
			}
		}

		if (i == arr[mid] && mid != size - 1) {
			int temp = arr[mid];
			arr[mid] = arr[mid + 1];
			arr[mid + 1] = temp;

		} else if (i < arr[mid]) {
			for (int x = size; x > mid; x--) {
				arr[x] = arr[x - 1];
			}
			arr[mid] = i;
			size++;

			if (size == arr.length) {
				ensureCapacity(size + 10);
			}
		} else if (i > arr[mid]) {
			for (int x = size; x > mid + 1; x--) {
				arr[x] = arr[x - 1];
			}

			arr[mid + 1] = i;
			size++;

			if (size == arr.length) {
				ensureCapacity(size + 10);
			}
		}
	}
}
