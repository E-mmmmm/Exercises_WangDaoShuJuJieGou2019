package chapter2_2_3;

public class No10 {
	/*
	 * 第十题，书上思路 将其看做为把由数组ab转化为数组ba（数组a为前p个元素，数组b为余下的n-p个元素） 先将数组a逆置，得到a^-1b
	 * 再将数组b逆置，得到a^-1b^-1 最后将a^-1b^-1逆置，得到(a^-1b^-1)^-1=ba
	 * 设Reverse函数执行将数组元素逆置的操作 对abcdefg向左循环移动3（p=3）个位置的过程如下： Reverse(0
	 * ,p-1),cbadefg Reverse(p, n-1),cbagfed Reverse(0, n-1),defgabc
	 * 注：Reverse中，两个参数分别表示数组中带转换元素的始末位置
	 * 时间复杂度O(n) 空间复杂度O(1)
	 */
	// arr为带转换的数组，n为数组长度
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
	 * 我的思路2 创建大小为p的辅助数组s 将数组arr中前p个元素存入数组s中 将数组arr中剩余的n-p个元素前移p个位置
	 * 将数组s中的元素从数组arr的第p-n个位置依次放回
	 * 时间复杂度O(n) 空间复杂度O(p)
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
