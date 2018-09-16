package chapter3_3_6;

import chapter3_1_4.SequenceStack;

//������
//����Ĵ𰸺��Լ������
/*
 * ˼��
 * 	����n=5
 *	 	��������fv1 = p0��fv2 = p1
 * 		����һ������Ϊ4��ջ(@����������̣�����������ǰ��)
 * 			top=3���洢p2 = fv2@fv1, fv1 = fv2, fv2 = top3, top--����ջ��
 * 			top=2���洢p3 = fv2@fv1, fv1 = fv2, fv2 = top2, top--����ջ��
 * 			top=1���洢p4 = fv2@fv1, fv1 = fv2, fv2 = top1, top--����ջ��
 * 			top=0���洢p5 = fv2@fv1, fv1 = fv2, fv2 = top0, top--����ջ��
 * 
 * 	Ϊn
 * 		��������fv1 = p0��fv2 = p1
 * 		����һ������Ϊn-1��ջ(@����������̣�����������ǰ��)
 * 			top=n-2���洢p2 = fv2@fv1, fv1 = fv2, fv2 = top(n-2)
 * 			top=n-3���洢p3 = fv2@fv1, fv1 = fv2, fv2 = top(n-3)
 * 			.
 * 			.
 * 			.
 * 			top=1���洢p4 = fv2@fv1, fv1 = fv2, fv2 = top1	
 * 			top=0���洢p5 = fv2@fv1, fv1 = fv2, fv2 = top0
 * 
 * 		if(n==0) return fv1
 * 		if(n>0) return fv2
 */
public class RecursionIsNotRecursion {
	public static void main(String[] args) {
		System.out.println(stackOfRecursion(2, 2));
	}
	
	public static double stackOfRecursion(int n, double x) {
		//�ݹ�ṹ��
		class Struct {
			//���ڼ�¼n
			public int no;
			//���ڼ�¼Pn(x)
			public double val;
			
			public void setVal(double val) {
				this.val = val;
			}
		}
		
		SequenceStack<Struct> ss = new SequenceStack<>(n);
		ss.InitStack();
		
		for(int i = n; i >= 2; i--) {
			//�����ݹ�ṹ��
			Struct s = new Struct();
			s.no = i;
			
			ss.Push(s);
		}
		
		//P0
		double fv1 = 1;
		//P1
		double fv2 = 2*x;
		
		while(ss.getTop() >= 0) {
			Struct temp = ss.GetTop();
			temp.val = 2 * x * fv2 - 2 * (n - 1) * fv1;
			
			fv1 = fv2;
			fv2 = temp.val;
			
			ss.Pop();
		}
				
		if(n == 0) {
			return fv1;
		}
		
		return fv2;
	}
}
