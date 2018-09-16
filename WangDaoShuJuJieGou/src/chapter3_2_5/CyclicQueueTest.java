package chapter3_2_5;
//第一题的测试类
public class CyclicQueueTest {
	public static void main(String[] args) {
		CyclicQueue<Integer> cq = new CyclicQueue<>();
		cq.initQueue();
		
		System.out.println(cq.queueEmpty());
		System.out.println("-------------");
		
		cq.enQueue(1);
		cq.enQueue(2);
		cq.enQueue(3);
		cq.enQueue(4);
		cq.enQueue(5);
		
//		System.out.println(cq.getHead());
//		System.out.println("-------------");
//		
//		System.out.println(cq.queueEmpty());
//		System.out.println("-------------");
//		
//		System.out.println(cq.getHead());
//		System.out.println("-------------");
//		
//		cq.deQueue();
//		System.out.println(cq.getHead());
//		System.out.println("-------------");
//		
//		cq.enQueue(6);
//		cq.enQueue(7);
//		cq.enQueue(8);
//		cq.enQueue(9);
//		cq.enQueue(10);
//		cq.enQueue(11);
//		cq.enQueue(12);
//		System.out.println(cq.getHead());
		
		cq.reverse();
		System.out.println(cq.deQueue());
		System.out.println(cq.deQueue());
		System.out.println(cq.deQueue());
		System.out.println(cq.deQueue());
		System.out.println(cq.deQueue());
	}
}
