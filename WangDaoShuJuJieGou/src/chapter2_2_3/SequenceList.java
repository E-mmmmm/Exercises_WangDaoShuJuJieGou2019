package chapter2_2_3;

import java.util.Arrays;

public class SequenceList {
	private final int DEFAULT_CAPACITY = 10;
	private int size = 0;
	int[] arr;

	/**
	 * ����һ��ָ�����ȵ�˳���
	 * 
	 * @param size
	 *            ָ�� ����
	 */
	public SequenceList(int size) {
		arr = new int[size];
	}

	/**
	 * ����һ��Ĭ�ϳ��ȵ�˳���Ĭ�ϳ���Ϊ10
	 */
	public SequenceList() {
		arr = new int[DEFAULT_CAPACITY];
	}

	/**
	 * �ڱ�β���ָ��Ԫ��
	 * 
	 * @param element
	 *            ��ӵ�Ԫ��
	 */
	public void insert(Integer element) {
		arr[size] = element;
		size++;
		if (size == arr.length) {
			ensureCapacity(size + 10);
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
	 * �жϸñ��Ƿ�Ϊ��
	 * 
	 * @return Ϊ���򷵻�true
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}

		return false;
	}

	/**
	 * * ɾ��ָ����������Ԫ��
	 * 
	 * @param index
	 *            ָ��������
	 * @return
	 * 			       ��ɾ����Ԫ��
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

	// 2.2.3 ������
	/**
	 * ɾ������ֵΪelement������Ԫ��
	 * 
	 * @param element
	 *            ��Ҫɾ����Ԫ��
	 */
	public void removeX(Integer element) {
		for (int x = 0; x < size; x++) {
			if (arr[x] == element) {
				remove(x--);
				//x--;
			}
		}
	}

	// ������
	// ��ǰ���������ñ���k��¼��s��t֮���Ԫ�صĸ���������ǰ������Ԫ�ز�����s��t������ǰ�ƶ�k��λ�ã�����k++
	public void removeBetween(Integer start, Integer end) {
		int k = 0;

		if (isEmpty()) {
			throw new RuntimeException("�ñ�Ϊ��");
		} else if (start >= end) {
			throw new RuntimeException("��ֵ�쳣");
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
	 * ��ʮ��
	 * ����һ������temp����arr[0]ȡ�������ڱ���temp��
	 * Ȼ��arr[1]����֮�������Ԫ����ǰ��һλ
	 * �ٽ�temp��������ĩβ
	 * �ظ����ϲ���p��
	 * �ռ临�Ӷ�ΪO(n)
	 * ʱ�临�Ӷ�  ����Ϊ��O(n) ʵ������O(n^2)
	 */
	public void slip(int times) {
		//��arr[0]ȡ�������ڱ���temp��
		int temp = 0;
		for(int x = 0; x < times; x++) {
			temp = arr[0];
			
			//Ȼ��arr[1]����֮�������Ԫ����ǰ��һλ
			for(int y = 0;y < arr.length-1; y++) {
				arr[y] = arr[y+1];
			}
			
			//�ٽ�temp��������ĩβ
			arr[arr.length-1] = temp;
		}
	}
}
