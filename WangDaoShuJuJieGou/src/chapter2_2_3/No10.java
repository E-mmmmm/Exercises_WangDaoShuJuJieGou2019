package chapter2_2_3;

public class No10 {
	/*
	 * ��ʮ�⣬����˼· ���俴��Ϊ��������abת��Ϊ����ba������aΪǰp��Ԫ�أ�����bΪ���µ�n-p��Ԫ�أ� �Ƚ�����a���ã��õ�a^-1b
	 * �ٽ�����b���ã��õ�a^-1b^-1 ���a^-1b^-1���ã��õ�(a^-1b^-1)^-1=ba
	 * ��Reverse����ִ�н�����Ԫ�����õĲ��� ��abcdefg����ѭ���ƶ�3��p=3����λ�õĹ������£� Reverse(0
	 * ,p-1),cbadefg Reverse(p, n-1),cbagfed Reverse(0, n-1),defgabc
	 * ע��Reverse�У����������ֱ��ʾ�����д�ת��Ԫ�ص�ʼĩλ��
	 * ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
	 */
	// arrΪ��ת�������飬nΪ���鳤��
	public static void slip(int[] arr, int n, int p) {
		Reverse(arr, 0, p - 1);
		Reverse(arr, p, n - 1);
		Reverse(arr, 0, n - 1);
	}

	public static void Reverse(int[] arr, int start, int end) {
		int temp = 0;
		for (int x = 0; x < (end - start + 1) / 2; x++) {
			temp = arr[start + x];
			arr[start + x] = arr[end - x];
			arr[end - x] = temp;
		}
	}

	/*
	 * �ҵ�˼·2 ������СΪp�ĸ�������s ������arr��ǰp��Ԫ�ش�������s�� ������arr��ʣ���n-p��Ԫ��ǰ��p��λ��
	 * ������s�е�Ԫ�ش�����arr�ĵ�p-n��λ�����ηŻ�
	 * ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(p)
	 */
	public static void slip2(int[] arr, int n, int p) {
		int[] temp = new int[p];
		for (int x = 0; x < p; x++) {
			temp[x] = arr[x];
		}
		for (int x = 0; x < n - p; x++) {
			arr[x] = arr[p + x];
		}
		for(int x = n-p; x < n;x++) {
			arr[x] = temp[x-n+p];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
		//slip(arr, 6, 3);
		slip(arr,6,3);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
