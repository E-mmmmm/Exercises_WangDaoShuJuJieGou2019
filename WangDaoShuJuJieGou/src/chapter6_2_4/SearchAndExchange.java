package chapter6_2_4;

import chapter2_3_7.DoubleLinkedListTool;
import chapter2_3_7.Node;
import chapter2_3_7.Pointer;
import chapter2_3_7.SingleLinkedListTool;

//第七题
public class SearchAndExchange {
	public static void main(String[] args) {
		//顺序结构
		int[] st = {7, 10, 13, 16, 19, 29, 32, 33, 37, 41, 43};
		System.out.println(sequential(st, 7));
		for(int i : st) {
			System.out.print(i+", ");
		}
		
		System.out.println();
		System.out.println("---------------");
		//链式存储
		Node h = new Node();
		Node s1 = new Node(7);
		Node s2 = new Node(10);
		Node s3 = new Node(16);
		Node s4 = new Node(13);
		
		Pointer head = new Pointer();
		
		DoubleLinkedListTool.headAddWithHeadNode(head, s4);
		DoubleLinkedListTool.headAddWithHeadNode(head, s3);
		DoubleLinkedListTool.headAddWithHeadNode(head, s2);
		DoubleLinkedListTool.headAddWithHeadNode(head, s1);
		DoubleLinkedListTool.headAddWithHeadNode(head, h);
		
		
		Node node = linked(h, 20);
		
		if(node != null) {
			System.out.println(node.getData());
		} else {
			System.out.println("无此结点");
		}
		
		Pointer p = new Pointer();
		p.setNode(h);
		while(p.getNode() != null) {
			System.out.print(p.getNode().getData() + ", ");
			p.setNode(p.getNode().getNext());
		}
	}
	
	public static int sequential(int[] st, int key) {
		for(int x = 0; x < st.length; x++) {
			if(key == st[x]) {
				if(x > 0) {
					int temp = st[x-1];
					st[x-1] = key;
					st[x] = temp;
				}
				
				return x;
			}
		}
		
		return -1;
	}
	
	public static Node linked(Node head, int key) {
		Pointer pre = new Pointer();
		pre.setNode(head);
		Pointer p = new Pointer();
		p.setNode(head.getNext());
		
		while(p.getNode() != null) {
			if((int)p.getNode().getData() != key) {
				pre.setNode(p.getNode());
				p.setNode(p.getNode().getNext());
			} else {
				if(pre.getNode() != head) {
					pre.getNode().getPrior().setNext(p.getNode());
					Node temp = p.getNode().getNext();
					p.getNode().setNext(pre.getNode());
					pre.getNode().setNext(temp);
				}
				
				return p.getNode();
			}
		}
		
		return null;
	}
}
