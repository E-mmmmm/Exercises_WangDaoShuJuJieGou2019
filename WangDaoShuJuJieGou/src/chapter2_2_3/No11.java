package chapter2_2_3;

/*
 * ˼·��������A��B�ĳ���Ϊn
 * ����һ������s������Ϊn
 * �ֱ������A��B�и�ȡ��һ��Ԫ�أ��ֱ���Ϊc��d)���Ƚ�
 * ��С��Ԫ�أ�����c����������s��
 * �ٴ�Ԫ��c���ڵ�������ȡ�ڶ���Ԫ����Ԫ��d�Ƚ�
 * ֱ������s����Ϊֹ
 * ��λ��Ϊs[n-1]
 * 
 * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
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
	 * ��˼· ������� ͨ����⣺ ��a<b��������е���λ��ֻ����A�Ĵ��һ���B��С��һ��
	 * ��a>b��������е���λ��ֻ����A��С��һ���B�Ĵ��һ�� ��ˣ���ͣ�ظ��󣬾ͻ��A,B�и��õ�һ��Ԫ��
	 * С���Ǹ����ǣ���Ϊ������/2ֻ������ȡ��
	 * ʱ�临�Ӷ�O��log(2)n) �ռ临�Ӷ�O(1)
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
