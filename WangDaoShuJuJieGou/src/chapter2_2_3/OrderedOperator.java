package chapter2_2_3;

public class OrderedOperator {
	public static void main(String[] args) {
		OrderedSequenceList osl = new OrderedSequenceList();
		OrderedSequenceList osl2 = new OrderedSequenceList();

		osl.insert(1);
		osl.insert(8);
		osl.insert(5);
		// osl.insert(1);
		osl.insert(3);
		// osl.insert(5);
		osl.insert(9);
		// osl.insert(1);
		// osl.insert(5);
		osl.insert(4);
		// osl.insert(1);
		osl.insert(6);
		osl.print();

		System.out.println("-------------");

		// osl2.insert(2);
		// osl2.insert(7);
		// osl2.insert(6);
		// osl2.insert(3);
		//
		// osl2.print();
		//
		// System.out.println("-------------");

		// 第四题
		// osl.removeBetween(1, 5);
		// osl.removeBetween(9, 5);
		// osl.print();

		// 第六题
		// osl.removeRepetition();
		// osl.removeRepetition2();
		// osl.removeRepetition3();
		// osl.removeRepetition22();
		// osl.print();

		// 第七题
		// int[] result = osl.merge(osl2);
		// int[] result = osl.merge22(osl2);
		// for (int i : result) {
		// System.out.println(i);

		// 第九题
		// osl.insertOrChange(3);
		// osl.insertOrChange(2);
		// osl.insertOrChange(33);
		// osl.insertOrChange(9);
		// osl.insertOrChange(1);
		// osl.print();

	}
}
