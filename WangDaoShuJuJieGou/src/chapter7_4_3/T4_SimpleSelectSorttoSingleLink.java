package chapter7_4_3;

//第4题
public class T4_SimpleSelectSorttoSingleLink {
	public static void main(String[] args) {
		SingleLink s0 = new SingleLink();
		SingleLink s1 = new SingleLink(44);
		SingleLink s2 = new SingleLink(12);
		SingleLink s3 = new SingleLink(3);
		SingleLink s4 = new SingleLink(42);
		SingleLink s5 = new SingleLink(32);
		SingleLink s6 = new SingleLink(6);
		SingleLink s7 = new SingleLink(7);
		SingleLink s8 = new SingleLink(-5);
		
		s0.rearAdd(s1);
		s1.rearAdd(s2);
		s2.rearAdd(s3);
		s3.rearAdd(s4);
		s4.rearAdd(s5);
		s5.rearAdd(s6);
		s6.rearAdd(s7);
		s7.rearAdd(s8);
		
		simpleSelectSort(s0);
		print(s0);
	}
	
	private static void simpleSelectSort(SingleLink head) {
		//最小值
		SingleLink min = head.getNext();
		//最小值所在结点的前驱结点
		SingleLink preM = head;
		
		//待排序序列的首结点
		SingleLink sequence = head.getNext();
		//待排序序列的首结点的前驱结点
		SingleLink preS = head;
		
		//当前正在比较的结点
		SingleLink p = sequence.getNext();
		//当前正在比较的结点的前驱结点
		SingleLink preP = sequence;
		
		while(sequence.getNext() != null) {
			while(p != null) {
				if(p.getValue() < min.getValue()) {
					min = p;
					preM = preP;
				}
				preP = preP.getNext();
				p = p.getNext();
			}
			
			if(min != sequence) {
					swap(preM, min, preS, sequence);
			}
			
			//初始化下一趟的指针
			preM = min;
			sequence = min.getNext();
			preS = min;
			min = sequence;
			p = sequence.getNext();
			preP = sequence;
		}
	}

	private static void swap(SingleLink preM, SingleLink min, 
			SingleLink preS, SingleLink sequence) {
		if(sequence.getNext() != min) {//两结点不相邻
			SingleLink temp = min.getNext();
			min.setNext(sequence.getNext());
			sequence.setNext(temp);
			preM.setNext(sequence);
			preS.setNext(min);
		} else {//两结点相邻
			sequence.setNext(min.getNext());
			min.setNext(sequence);
			preS.setNext(min);
		}
	}

	private static void print(SingleLink head) {
		SingleLink temp = head;
		boolean flag = false;//用于跳过单链表的头结点
		while(temp != null) {
			if(flag != true) {
				flag = true;
			} else {
				System.out.print(temp.getValue() + ", ");
			}
			
			temp = temp.getNext();
		}
	}
}
