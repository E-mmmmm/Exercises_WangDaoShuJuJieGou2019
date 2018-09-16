package chapter2_2_3;

import java.util.Arrays;

public class OrderedSequenceList {
	private final int DEFAULT_CAPACITY = 10;
	private int size = 0;
	int[] arr;

	/**
	 * ����һ��ָ�����ȵ�˳���
	 * 
	 * @param size
	 *            ָ�� ����
	 */
	public OrderedSequenceList(int size) {
		super();
		arr = new int[size];
	}

	/**
	 * ����һ��Ĭ�ϳ��ȵ�˳���Ĭ�ϳ���Ϊ10
	 */
	public OrderedSequenceList() {
		super();
		arr = new int[DEFAULT_CAPACITY];
	}

	/**
	 * �ڱ�β���ָ��Ԫ��
	 * 
	 * @param element
	 *            ��ӵ�Ԫ��
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
	 * ���б�Ҫ�����Ӵ� SequenceList ʵ������������ȷ���������ܹ�������С����������ָ����Ԫ������
	 * 
	 * @param minCapacity
	 *            �������С����
	 */
	private void ensureCapacity(int minCapacity) {
		arr = Arrays.copyOf(arr, minCapacity);
	}

	/**
	 * ������˳���
	 */
	public void print() {
		for (int x = 0; x < size; x++) {
			System.out.println(arr[x]);
		}
	}

	/**
	 * ɾ��ָ����������Ԫ��
	 * 
	 * @param index
	 *            ָ��������
	 */
	public void remove(int index) {
		for (int x = index; x < size - 1; x++) {
			arr[x] = arr[x + 1];
		}
		size--;
	}

	/**
	 * �жϸñ��Ƿ�Ϊ��
	 * 
	 * @return Ϊ���򷵻�true
	 */
	public boolean isEmpty() {
		if (size != 0) {
			return false;
		}

		return true;
	}

	// 2.2.3 ������
	public void removeBetween(int start, int end) {
		int startIndex = 0;
		int endIndex = 0;

		if (isEmpty()) {
			throw new RuntimeException("�ñ�Ϊ��");
		} else {
			// �ҵ���ʼֵ���һ�γ��ֵ�����
			for (int x = 0; x < size; x++) {
				if (arr[x] == start) {
					startIndex = x;
				}
			}
			// �ҵ���ֵֹ��һ�γ��ֵ�����
			for (int x = 0; x < size; x++) {
				if (arr[x] == end) {
					endIndex = x;
					break;
				}
			}

			if (startIndex >= endIndex) {
				throw new RuntimeException("��ֵ�쳣");
			} else {
				for (int y = startIndex + 1; y < endIndex; y++) {
					remove(y--);
					// y--;
					endIndex--;
				}
			}
		}
	}

	// ������-1
	// ͨ������һ�����������ж�Ԫ���Ƿ��ظ���ʱ�临�Ӷ�ΪO(n^2)
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

	// ������-2
	// ��Ϊ�ñ�������һ������int[]������������������min,max��
	// ��ʼʱ��Ϊmin��max�����Ӧ��arr[0]��arr[1]
	// ����ǰ��Ԫ��С��min�����max��ֵ������Ӧ�ĸ��������¸��赱ǰԪ�ص�ֵ
	// ����ǰ��Ԫ����min��max֮�䣬��Ϊ�ظ�Ԫ�أ�ɾ������
	// ʱ�临�Ӷ�ΪO(n)
	public void removeRepetition2() {
		int min;
		int max;

		// ��ʼ��min��max
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

		// ����ʼ״����arr[0]==arr[1]����ʱ��Ҫɾ��һ��
		if (arr[0] == arr[1]) {
			remove(1);
		}
	}

	// ������-2��
	// ������������-�ڡ��Ĵ������
	// 1����Ϊ���������飬����forѭ���е�����arr[x]<min��������
	// 2����Ϊ���������飬����ʵ���������������������ж�һ��Ԫ���Ƿ��ǰһ��Ԫ����ͬ����ͬ��ɾ������ͬ����
	// ��˸Ľ�����
	// ʱ�临�Ӷ�ΪO(n)
	public void removeRepetition22() {
		for (int x = 0; x < size - 1; x++) {
			if (arr[x] == arr[x + 1]) {
				remove(x--);
			}
		}
	}

	// ������-3
	// ��ʼʱ����һ��Ԫ�ؿ������ظ������
	// �ж���һ��Ԫ���Ƿ����һ��Ԫ����ͬ
	// ����ͬ��������ж���һ��
	// ����ͬ���������ǰ��ķ��ظ������ı�β
	// ʱ�临�Ӷ�ΪO(n)
	// ע�������ϴ𰸺��Լ�д��
	public void removeRepetition3() {
		int i = 0;
		for (int x = 1; x < size; x++) {
			if (arr[x] != arr[i]) {
				arr[++i] = arr[x];
			}
		}
		size = i + 1;
	}

	// ������-1
	// �򵥵Ľ������������β��ӣ���Arrays.sort()����
	public int[] merge(OrderedSequenceList arr2) {
		// �����飬����Ϊ�����������Ч���ȣ�size��֮��
		int[] result = new int[this.size + arr2.size];

		// ����һ���������ӽ���������
		for (int x = 0; x < this.size; x++) {
			result[x] = this.arr[x];
		}

		// ���ڶ����������ӽ���������
		for (int x = 0; x < arr2.size; x++) {
			result[x + this.size] = arr2.arr[x];
		}

		// ������������
		Arrays.sort(result);

		return result;
	}

	// ������-2�������˼·��
	// ��һ�ַ�����ʵ�ܴ�����Ϊû���ֳɵķ������Խ�����������β��ӣ��Լ����Ӿͷǳ��鷳
	// �����ںϲ���ʱ����ʵ�Ϳ��԰�����������
	public int[] merge2(OrderedSequenceList arr2) {
		// �����飬����Ϊ�����������Ч���ȣ�size��֮��
		int[] result = new int[this.size + arr2.size];

		// A.����������ȡ����Ԫ�أ����߱Ƚϣ���С��Ԫ�ز�����������
		// B.�ٴӽ�С��Ԫ�����ڵ������ȡһ��Ԫ�أ�ִ�в���A

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

	// merge2�İ棨���𰸺�
	public int[] merge22(OrderedSequenceList arr2) {
		// �����飬����Ϊ�����������Ч���ȣ�size��֮��
		int[] result = new int[this.size + arr2.size];

		// A.����������ȡ����Ԫ�أ����߱Ƚϣ���С��Ԫ�ز�����������
		// B.�ٴӽ�С��Ԫ�����ڵ������ȡһ��Ԫ�أ�ִ�в���A

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

	// �ھ���
	// ���ֲ��ҷ�
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
