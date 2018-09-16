package chapter3_3_6;

import chapter3_2_5.CyclicQueue;

//第四题
/*
 * 思路
 * 	以一个长度为10的数组代表渡船
 * 	用队列q1代表排队等待的车队
 * 	用队列q2代表调度队列
 * 	用K代表客车，H代表火车
 * 	遍历队列q1
 * 		K进入q2，并计数k
 * 		H进入数组，并计数h
 * 			若h=4&&k>0,q2出队一辆进入数组
 * 			若h=4&&k=0,继续遍历
 * 	遍历结束后，若队列还有空，则q2出队填满数组
 */
/*
 * 以上为原版思路，感觉不符合题意
 * 看过答案后才知道，客车和货车是分开排队的
 * 
 * 以一个长度为10的数组代表渡船
 * 用队列q1代表客车队列
 * 用队列q2代表货车序列
 * 
 * 若q1不为空，则出队如数组,k++
 * 	k=4时
 * 		q2不为空，出队入数组，k=0
 * 		q2为空，q1全部入数组，直到数组满或q1空
 * 	k<4&&q1空，q2不空时
 * 		q2全部入数组，直到数组满或q2空
 * 若q1为空，q2不为空则q2出队入数组，直到数组满或q2空
 * 
 */
/*
 * 渡船也可以并且应该用队列表示
 * 操作与车队相同，代码就不改了
 */
public class Ferry {
	public static void main(String[] args) {
		CyclicQueue<Character> q1 = new CyclicQueue<Character>();
		q1.initQueue();
		q1.enQueue('K');
		q1.enQueue('K');
		q1.enQueue('K');
		q1.enQueue('K');
		q1.enQueue('K');
		q1.enQueue('K');
		q1.enQueue('K');
		q1.enQueue('K');
		q1.enQueue('K');
		
		CyclicQueue<Character> q2 = new CyclicQueue<Character>();
		q2.initQueue();
		q2.enQueue('H');
		q2.enQueue('H');
		q2.enQueue('H');
		q2.enQueue('H');
		q2.enQueue('H');
	
		char[] chr = ferry(q1, q2);
		for(int x = 0; x < chr.length; x++) {
			System.out.println(chr[x]);
		}
	
	}
	
	public static char[] ferry(CyclicQueue<Character> q1, CyclicQueue<Character> q2) {
		char[] chr = new char[10];
		int k = 0;
		int location = 0;
		
		while(location != 10) {
			if(k <4) {
				if(!q1.queueEmpty()) {
					chr[location++] = q1.deQueue();
					k++;
				} else if(q1.queueEmpty()) {
					if(!q2.queueEmpty()) {
						while(location != 10 && !q2.queueEmpty()) {
							chr[location++] = q2.deQueue();
						}
						
						return chr;
					} else if (q2.queueEmpty()) {
						return chr;
					}
				}
			} else if(k == 4) {
				if(!q2.queueEmpty()) {
					chr[location++] = q2.deQueue();
					k = 0;
				} else if(q2.queueEmpty()) {
					while(location != 10 && !q1.queueEmpty()) {
						chr[location++] = q1.deQueue();
					}
					
					return chr;
				}
			}
		}
		
		return chr;
	}
}
