package chapter3_1_4;

import java.io.IOException;
import java.util.Scanner;

//综合应用第3题第2问
public class isLegal {
	public static void main(String[] args) throws IOException {
		int n = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入操作序列的长度：");
		n = Integer.parseInt(sc.nextLine());
		
		char[] crr = new char[n];
		
		for(int x = 0; x < n; x++) {
			System.out.println("请输入操作字符：");
			char[] temp = sc.nextLine().toCharArray();
			crr[x] = temp[0];
		}
		
		System.out.println(isLegal(crr));
 	}
	
	public static boolean isLegal(char[] crr){
		int len = crr.length;
		int top = -1;
		
		for(int x = 0; x < len; x++) {
			if(crr[x] == 'I') {
				top++;
			} else if(crr[x] == 'O') {
				top--;
			} else {
				System.out.println("请别瞎JB输入！");
				return false;
			}
			
			if(top < -1) {
				return false;
			}
		}
		
		if(top == -1) {
			return true;
		}
		
		return false;
	}
}
