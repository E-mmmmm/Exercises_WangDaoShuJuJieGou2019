package chapter2_2_3;

//第八题
public class No8_ChangePosition {
	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
		int[] arr2 = new int[] { 7, 8, 9 };
		int[] result = new int[arr1.length + arr2.length];

		// 将arr1、arr2放入result中
		int x = 0;
		for (; x < arr1.length; x++) {
			result[x] = arr1[x];
		}

		for (; x < arr1.length + arr2.length; x++) {
			result[x] = arr2[x - arr1.length];
		}

		for (int i : result) {
			System.out.println(i);
		}

		System.out.println("---------------");

		// changePosition(arr1.length, result);
		changePosition2(result, arr2.length);
		for (int i : result) {
			System.out.println(i);
		}
	}

	public static void changePosition(int length, int[] arr) {
		int[] temp = new int[length];

		for (int x = 0; x < length; x++) {
			temp[x] = arr[x];
		}

		for (int x = length, y = 0; x < arr.length; x++, y++) {
			arr[y] = arr[x];
		}

		for (int x = arr.length - length, y = 0; x < arr.length; x++, y++) {
			arr[x] = temp[y];
		}
	}

	// 书提供的答案在空间复杂度上较小
	public static void changePosition2(int[] result, int length1) {
		reverse(result, 0, result.length - 1);
		 reverse(result, 0, length1 - 1);
		 reverse(result, length1, result.length - 1);
	}

	private static void reverse(int[] arr, int start, int end) {
		for (int x = start, y = end; x < y; x++, y--) {
			int temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
		}

	}
}
