package chapter2_2_3;

import java.io.IOException;
import java.util.ArrayList;

public class No1_Remove {
	public static void main(String[] args) throws IOException {
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
		
		System.out.println(removeSmallest(al));
		
		System.out.println("-----------------");
		
		for(Integer i : al) {
			System.out.println(i);
		}
	}

	public static int removeSmallest(ArrayList<Integer> al)
			throws IOException {
		if (al.isEmpty()) {
			throw new IOException("顺序表中无数据");
		} else {
			int result = al.get(0);
			int index = 0;
			for(int i = 1; i < al.size()-1; i++) {
				if(al.get(i) < result) {
					result = al.get(i);
					index = i;
				}
			}
			
			if(index != (al.size()-1)){
				al.set(index, al.get(al.size()-1));
				al.remove(al.size()-1);
			} else {
				al.remove(index);
			}
			
			return result;
		}
	}
}
