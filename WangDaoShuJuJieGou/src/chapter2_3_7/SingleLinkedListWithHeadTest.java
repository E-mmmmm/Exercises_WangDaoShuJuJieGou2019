package chapter2_3_7;

/**
 * 有头结点的单链表的测试类
 * 
 * @author 一汪
 * 
 */
public class SingleLinkedListWithHeadTest {
	public static void main(String[] args) {
		// 创建节点
		Node<Integer> s1 = new Node<>(21);
		Node<Integer> s2 = new Node<>(-7);
		Node<Integer> s3 = new Node<>(-15);
		Node<Integer> s4 = new Node<>(-15);
		Node<Integer> s5 = new Node<>(15);
		Node<Integer> head = new Node<>();

		// 创建头指针
		Pointer frontPointer = new Pointer();
		// 构建单链表
		SingleLinkedListTool.frontAdd(s1, frontPointer);
		SingleLinkedListTool.frontAdd(s2, frontPointer);
		SingleLinkedListTool.frontAdd(s3, frontPointer);
		SingleLinkedListTool.frontAdd(s4, frontPointer);
		SingleLinkedListTool.frontAdd(s5, frontPointer);
		SingleLinkedListTool.frontAdd(head, frontPointer);

		SingleLinkedListTool.show(frontPointer);
		System.out.println("---------------------");
		
		// 创建第二个单链表，与第一个单链表有公共节点
		Node<Integer> s10 = new Node<>(9);
		Node<Integer> s9 = new Node<>(8);
		Node<Integer> s6 = new Node<>(4);
		Node<Integer> s7 = new Node<>(7);
		Node<Integer> s8 = new Node<>(9);
		Node<Integer> head2 = new Node<>();
		
		// 创建头指针
		Pointer frontPointer2 = new Pointer();
	
		// 构建单链表
		SingleLinkedListTool.frontAdd(s1, frontPointer2);
		SingleLinkedListTool.frontAdd(s2, frontPointer2);
//		SingleLinkedListTool.frontAdd(s3, frontPointer2);
//		SingleLinkedListTool.frontAdd(s4, frontPointer2);
//		SingleLinkedListTool.frontAdd(s5, frontPointer2);
		//SingleLinkedListTool.frontAdd(s10, frontPointer2);
//		SingleLinkedListTool.frontAdd(s9, frontPointer2);
//		SingleLinkedListTool.frontAdd(s6, frontPointer2);
//		SingleLinkedListTool.frontAdd(s7, frontPointer2);
		SingleLinkedListTool.frontAdd(s8, frontPointer2);
		SingleLinkedListTool.frontAdd(head2, frontPointer2);
		
		//SingleLinkedListTool.show(frontPointer2);
		System.out.println("---------------------");
		
		// //第二题
		// Pointer currentPointer = new Pointer();
		// currentPointer.setNode(frontPointer.getNode());
		// SingleLinkedListTool.deleteAllXWithHead("A", frontPointer,
		// currentPointer);
		// SingleLinkedListTool.show(frontPointer);

		// 第三题
		// SingleLinkedListTool.reverse(frontPointer);

		// 第四题
		// SingleLinkedListTool.minimum(frontPointer);
		// SingleLinkedListTool.show(frontPointer);

		// 第五题
		// 我的方法
		// SingleLinkedListTool.localReverse(frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		// 书上方法一
		// SingleLinkedListTool.localReverse2(frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		// 书上方法二
		// SingleLinkedListTool.localReverse3(frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		
		// 第六题
		// SingleLinkedListTool.increase(frontPointer);
		// SingleLinkedListTool.increase2(frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		
		// 第七题
		// SingleLinkedListTool.delBetween(0, 8, frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		
		//第八题
		//System.out.println(SingleLinkedListTool.publicNode(frontPointer, frontPointer2));
		
		//第九题
		//SingleLinkedListTool.increaseShow(frontPointer);
		//System.out.println("-----------------");
		//SingleLinkedListTool.show(frontPointer);
		
		//第十题
		//Pointer headB = SingleLinkedListTool.mkDouble(frontPointer);
		//System.out.println("A:");
		//SingleLinkedListTool.show(frontPointer);
		//System.out.println("B:");
		//SingleLinkedListTool.show(headB);
		
		//第十二题
		// SingleLinkedListTool.deleteRepeat(frontPointer);
		// SingleLinkedListTool.show(frontPointer);
		
		//第十三题
		//Pointer headA = SingleLinkedListTool.dualIncreaseToSingleDecrease(frontPointer, frontPointer2);
		//SingleLinkedListTool.show(headA);
		
		//第十四题
		//Pointer headC = SingleLinkedListTool.publicNodeWithNewList(frontPointer, frontPointer2);
		//Pointer headC = SingleLinkedListTool.publicNodeWithNewList2(frontPointer, frontPointer2);
		//SingleLinkedListTool.show(headC);
		
		//第十五题
		//Pointer headA = SingleLinkedListTool.intersection(frontPointer, frontPointer2);
		//SingleLinkedListTool.show(headA);
		
		//第十六题 
		/*-----------------------------------------------
		 * 热烈庆祝此题是第一个代码一次通过的题！！！
		 * 2018/8/4 15:40
		 *-----------------------------------------------
		 */
		//boolean flag = SingleLinkedListTool.isContinuousSequence(frontPointer, frontPointer2);
		//System.out.println(flag);
		
		//第二十一题
		//System.out.println(SingleLinkedListTool.lastK(frontPointer, 3));
		
		//第二十二题
		//Pointer r = SingleLinkedListTool.findPublic(frontPointer, frontPointer2);
		//Pointer r = SingleLinkedListTool.findPublic2(frontPointer, frontPointer2);
		//System.out.println(r.getNode());
		
		//第二十三题
//		SingleLinkedListTool.differAbsoluteValue(frontPointer);
		SingleLinkedListTool.differAbsoluteValue2(frontPointer, 21);
		SingleLinkedListTool.show(frontPointer);
	}
}
