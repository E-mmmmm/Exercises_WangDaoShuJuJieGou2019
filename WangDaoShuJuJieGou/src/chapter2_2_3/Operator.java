package chapter2_2_3;

public class Operator {
	public static void main(String[] args) {
		SequenceList sl = new SequenceList(7);
		
		sl.insert(1);
		sl.insert(4);
		sl.insert(3);
		sl.insert(1);
		sl.insert(6);
		sl.insert(1);
		sl.insert(7);
		
		sl.print();
		
		System.out.println("-----------------");
		
		//������
		// sl.removeX(1);
		// sl.print();
		
		//������
		//sl.removeBetween(1, 4);
		//sl.removeBetween(3, 1);
		//sl.print();
		
		//��ʮ��
		//����ǰ��ر�insert()���Զ����ݹ���	
		//sl.slip(6);
		//sl.print();
	}
}
