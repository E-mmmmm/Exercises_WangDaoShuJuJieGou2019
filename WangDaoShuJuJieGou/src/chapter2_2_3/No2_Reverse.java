package chapter2_2_3;

import java.util.ArrayList;

public class No2_Reverse {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(2);
		al.add(4);
		al.add(7);
		al.add(5);
		al.add(3);
		al.add(9);

		for(Integer i : al) {
			System.out.println(i);
		}
		
		System.out.println("-----------------");
		
		reverse(al);
		
		System.out.println("-----------------");
		
		for(Integer i : al) {
			System.out.println(i);
	}
}
	public static void reverse(ArrayList<Integer> al) {
		int temp;
		for(int start = 0, end = al.size()-1; start < end; start++, end--) {
			temp = al.get(start);
			al.set(start, al.get(end));
			al.set(end, temp);
		}
	}
}