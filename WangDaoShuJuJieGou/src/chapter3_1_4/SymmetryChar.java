package chapter3_1_4;

import chapter2_3_7.Node;
import chapter2_3_7.Pointer;
import chapter2_3_7.SingleLinkedListTool;

//��4��
public class SymmetryChar {
	public static void main(String[] args) throws Throwable {
		//����������
		Node<Character> s1 = new Node<>('x');
		Node<Character> s2 = new Node<>('y');
		Node<Character> s3 = new Node<>('x');
		Node<Character> s4 = new Node<>('a');
		Node<Character> s5 = new Node<>('y');
		
		Pointer front = new Pointer();
		
		SingleLinkedListTool.frontAdd(s3, front);
		SingleLinkedListTool.frontAdd(s5, front);
		SingleLinkedListTool.frontAdd(s2, front);
		SingleLinkedListTool.frontAdd(s1, front);
		SingleLinkedListTool.frontAdd(s4, front);
		
		SingleLinkedListTool.show(front);
		
		System.out.println(isSymmetry(front));
	}
	
	public static <T> boolean isSymmetry(Pointer front) {
		SequenceStack<T> ss = new SequenceStack<>();
		ss.InitStack();
		
		Pointer p = new Pointer();
		p.setNode(front.getNode());
		
		while(p.getNode() != null) {
			ss.Push((T)p.getNode().getData());
			p.setNode(p.getNode().getNext());
		}
		
		int mid = ss.getTop()/2;
		int len = 0;
		int flag = 0;
		
		if(ss.getTop() %2 != 0) {
			len = mid+1;
		} else if (ss.getTop()%2 == 0) {
			len = mid;
			flag = 1;
		}
		//����벿�ִ�������
		Object[] temp = new Object[len];
		for(int x = 0; x < len; x++) {
			temp[x] = ss.Pop();
		}
		
		//�����������ַ���ȥ���м�Ĳ�����Ƚϵ�Ԫ��
		if(flag == 1) {
			ss.Pop();
		}
		
		//�Ƚ�ǰ�벿��
		for(int x = 0; x < len; x++) {
			if(!temp[temp.length-1-x].equals(ss.Pop())) {
				return false;
			}
		}
		
		return true;
	}
}
