package chapter3_3_6;

import chapter3_1_4.SequenceStack;

//第三题
//看书的答案后自己的理解
/*
 * 思想
 * 	假设n=5
 *	 	创建变量fv1 = p0，fv2 = p1
 * 		创建一个容量为4的栈(@代表运算过程，运算数区分前后)
 * 			top=3，存储p2 = fv2@fv1, fv1 = fv2, fv2 = top3, top--（出栈）
 * 			top=2，存储p3 = fv2@fv1, fv1 = fv2, fv2 = top2, top--（出栈）
 * 			top=1，存储p4 = fv2@fv1, fv1 = fv2, fv2 = top1, top--（出栈）
 * 			top=0，存储p5 = fv2@fv1, fv1 = fv2, fv2 = top0, top--（出栈）
 * 
 * 	为n
 * 		创建变量fv1 = p0，fv2 = p1
 * 		创建一个容量为n-1的栈(@代表运算过程，运算数区分前后)
 * 			top=n-2，存储p2 = fv2@fv1, fv1 = fv2, fv2 = top(n-2)
 * 			top=n-3，存储p3 = fv2@fv1, fv1 = fv2, fv2 = top(n-3)
 * 			.
 * 			.
 * 			.
 * 			top=1，存储p4 = fv2@fv1, fv1 = fv2, fv2 = top1	
 * 			top=0，存储p5 = fv2@fv1, fv1 = fv2, fv2 = top0
 * 
 * 		if(n==0) return fv1
 * 		if(n>0) return fv2
 */
public class RecursionIsNotRecursion {
	public static void main(String[] args) {
		System.out.println(stackOfRecursion(2, 2));
	}
	
	public static double stackOfRecursion(int n, double x) {
		//递归结构体
		class Struct {
			//用于记录n
			public int no;
			//用于记录Pn(x)
			public double val;
			
			public void setVal(double val) {
				this.val = val;
			}
		}
		
		SequenceStack<Struct> ss = new SequenceStack<>(n);
		ss.InitStack();
		
		for(int i = n; i >= 2; i--) {
			//创建递归结构体
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
