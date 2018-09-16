package chapter3_3_6;

import chapter3_2_5.CyclicQueue;

//������
/*
 * ˼·
 * 	��һ������Ϊ10���������ɴ�
 * 	�ö���q1�����Ŷӵȴ��ĳ���
 * 	�ö���q2������ȶ���
 * 	��K����ͳ���H�����
 * 	��������q1
 * 		K����q2��������k
 * 		H�������飬������h
 * 			��h=4&&k>0,q2����һ����������
 * 			��h=4&&k=0,��������
 * 	���������������л��пգ���q2������������
 */
/*
 * ����Ϊԭ��˼·���о�����������
 * �����𰸺��֪�����ͳ��ͻ����Ƿֿ��Ŷӵ�
 * 
 * ��һ������Ϊ10���������ɴ�
 * �ö���q1����ͳ�����
 * �ö���q2�����������
 * 
 * ��q1��Ϊ�գ������������,k++
 * 	k=4ʱ
 * 		q2��Ϊ�գ����������飬k=0
 * 		q2Ϊ�գ�q1ȫ�������飬ֱ����������q1��
 * 	k<4&&q1�գ�q2����ʱ
 * 		q2ȫ�������飬ֱ����������q2��
 * ��q1Ϊ�գ�q2��Ϊ����q2���������飬ֱ����������q2��
 * 
 */
/*
 * �ɴ�Ҳ���Բ���Ӧ���ö��б�ʾ
 * �����복����ͬ������Ͳ�����
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
