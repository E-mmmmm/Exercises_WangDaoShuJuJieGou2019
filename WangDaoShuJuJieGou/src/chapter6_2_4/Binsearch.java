package chapter6_2_4;
//µÚÁùÌâ
public class Binsearch {
	public static void main(String[] args) {
		int[] st = {7, 10, 13, 16, 19, 29, 32, 33, 37, 41, 43};
		int loc = binsearch(st, 29);
		System.out.println(loc);
	}
	
	public static int binsearch(int[] st, int key) {
		return binsearchOperation(st, 1, st.length, key);
	}
	
	private static int binsearchOperation(int[] st, int low, int high, int key) {
		if(low <= high) {
			int mid = (low + high) / 2 - 1;
			if(key < st[mid]) {
				binsearchOperation(st, low, mid-1, key);
			} else if(key > st[mid]) {
				binsearchOperation(st, mid+1, high, key);
			} else {
				return mid;
			}
		}
		
		return -1;
	}
}
