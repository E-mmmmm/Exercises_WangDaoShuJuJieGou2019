package chapter3_1_4;

import java.io.IOException;
import java.util.Scanner;

//�ۺ�Ӧ�õ�3���2��
public class isLegal {
	public static void main(String[] args) throws IOException {
		int n = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������������еĳ��ȣ�");
		n = Integer.parseInt(sc.nextLine());
		
		char[] crr = new char[n];
		
		for(int x = 0; x < n; x++) {
			System.out.println("����������ַ���");
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
				System.out.println("���ϹJB���룡");
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
