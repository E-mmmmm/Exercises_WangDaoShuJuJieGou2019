package chapter2_2_3;

/*
 * 思路：设序列A、B的长度为n
 * 创建一个数组s，长度为n
 * 分别从序列A、B中各取第一个元素（分别设为c、d)并比较
 * 较小的元素（设是c）放入数组s中
 * 再从元素c所在的序列中取第二个元素与元素d比较
 * 直到数组s填满为止
 * 中位数为s[n-1]
 * 
 * 时间复杂度O(n),空间复杂度O(n)
 */
public class No11 {
	public static int midNumber(int[] a, int[] b, int n) {
		int[] s = new int[n];

		for (int x = 0, y = 0, z = 0; z < n; z++) {
			if (a[x] <= b[y]) {
				s[z] = a[x++];
			} else if (a[x] > b[y]) {
				s[z] = b[y++];
			}
		}

		return s[n - 1];
	}

	/*
	 * 答案思路 具体见书 通俗理解： 若a<b，则大数列的中位数只会在A的大的一半和B的小的一半
	 * 若a>b，则大数列的中位数只会在A的小的一半和B的大的一半 因此，不停重复后，就会从A,B中各得到一个元素
	 * 小的那个就是，因为程序中/2只会向下取整
	 * 时间复杂度O（log(2)n) 空间复杂度O(1)
	 */
	public static int midNumber2(int[] A, int[] B, int n) {
		int startA = 0;
		int endA = n - 1;
		
		int startB = 0;
		int endB = n - 1;
		
		int midA = (endA + startA) / 2;
		int midB = (endB + startB) / 2;

		while (startA != endA && startB != endB) {
			
			if (A[midA] == B[midB]) {
				return A[midA];

			} else if (A[midA] < B[midB]) {
				if((endA + startA) % 2 == 0) {
					startA = midA;
					endB = midB;
				} else {
					startA = midA + 1;
					endB = midB;
				}
			} else if (A[midA] > B[midB]) {
				if((endB + startB) % 2 == 0) {
					endA = midA;
					startB = midB;
				} else {
					endA = midA;
					startB = midB + 1;
				}
			}
			
			midA = (endA + startA) / 2;
			midB = (endB + startB) / 2;
		}
		
		if (A[midA] < B[midB]) {
			return A[midA];
		} else {
			return B[midB];
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 43, 52, 63, 90 };
		int[] b = new int[] { 5, 8, 20, 55, 70 };

		System.out.println(midNumber2(a, b, a.length));
	}
}
