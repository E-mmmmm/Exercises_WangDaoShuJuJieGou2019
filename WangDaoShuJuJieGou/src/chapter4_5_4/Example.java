package chapter4_5_4;

import chapter3_1_4.SequenceStack;
import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//�����ܽ��е�����
public class Example {
	public static void main(String[] args) {
		TreeNode s1 = new TreeNode("1");
		TreeNode s2 = new TreeNode("2");
		TreeNode s3 = new TreeNode("3");
		TreeNode s4 = new TreeNode("4");
		TreeNode s5 = new TreeNode("5");
		TreeNode s6 = new TreeNode("6");
		TreeNode s7 = new TreeNode("7");
		TreeNode s8 = new TreeNode("H");
		TreeNode s9 = new TreeNode("I");
		TreeNode s10 = new TreeNode("10");
		TreeNode s11 = new TreeNode("K");
		TreeNode s12 = new TreeNode("12");
		TreeNode s13 = new TreeNode("M");
		TreeNode s14 = new TreeNode("N");
		TreeNode s15 = new TreeNode("O");
		
//		TreeNodeTool.ladd(s2, s1);
//		TreeNodeTool.radd(s3, s1);
//		TreeNodeTool.radd(s4, s2);
//		TreeNodeTool.radd(s5, s3);
//		TreeNodeTool.ladd(s6, s4);
		
//		TreeNodeTool.ladd(s2, s1);
//		TreeNodeTool.radd(s3, s1);
//		TreeNodeTool.ladd(s4, s2);
//		TreeNodeTool.radd(s5, s2);
//		TreeNodeTool.ladd(s6, s3);
//		TreeNodeTool.radd(s7, s3);
		
		TreeNodeTool.ladd(s5, s10);
		TreeNodeTool.radd(s12, s10);	
		TreeNodeTool.ladd(s4, s5);
		TreeNodeTool.radd(s7, s5);
		
		//��1��
//		System.out.println(du1(s1));
//		System.out.println(du11(s1));
		
		//��2��
//		System.out.println(du2(s1));
//		System.out.println(du22(s1));
		
		//��3��
//		System.out.println(du0(s1));
//		System.out.println(du00(s1));
		
		//��4��
//		System.out.println(deep(s1));
//		System.out.println(deep2(s1));

		//��5��
//		System.out.println(width(s1));
		
		//��6��
//		deleteLeaf(s1);
//		deleteLeaf2(s1);
		
		//��7��
//		System.out.println(findNode(s1, s7));
//		System.out.println(findNode2(s1, s7));
		
		//��8��
//		System.out.println(findMax(s1));
		
		//��9��
//		exchangeChild(s1);
		
		//��10��
//		preShow(s1);
		
		//˼ά��չ
		path(s10, 22);
		pathLeaf(s10, 22);
	}
	
	//��1��
	static int count = 0;
	public static int du1(TreeNode root) {
		if(root != null) {
			if((root.getLchild() == null && root.getRchild() != null) || 
					(root.getLchild()!= null && root.getRchild() == null)) {
				count++;
			}
			
			du1(root.getLchild());
			du1(root.getRchild());
		}
		
		return count;
	}
	//�޸İ�
	public static int du11(TreeNode root) {
		if(root == null) {
			return 0;
		} else if((root.getLchild() == null && root.getRchild() != null) || 
				(root.getLchild()!= null && root.getRchild() == null)) {
				return 1 + du11(root.getLchild())+ du11(root.getRchild());
		} else {
			return 0 + du11(root.getLchild())+ du11(root.getRchild());
		}
	}
	
	//��2��
	public static int du2(TreeNode root) {
		if(root != null) {
			if(root.getLchild() != null && root.getRchild() != null) {
				count++;
			}
			
			du2(root.getLchild());
			du2(root.getRchild());
		}
		
		return count;
	}
	//�޸İ�
	public static int du22(TreeNode root) {
		if(root == null) {
			return 0;
		} else if((root.getLchild() != null && root.getRchild() != null)) {
				return 1 + du22(root.getLchild())+ du22(root.getRchild());
		} else {
			return 0 + du22(root.getLchild())+ du22(root.getRchild());
		}
	}
	
	//��3��
	public static int du0(TreeNode root) {
		if(root != null) {
			if(root.getLchild() == null && root.getRchild() == null) {
				count++;
			}
			
			du0(root.getLchild());
			du0(root.getRchild());
		}
		
		return count;
	}
	//�޸İ�
	public static int du00(TreeNode root) {
		if(root == null) {
			return 0;
		} else if((root.getLchild() == null && root.getRchild() == null)) {
				return 1 + du00(root.getLchild())+ du00(root.getRchild());
		} else {
			return 0 + du00(root.getLchild())+ du00(root.getRchild());
		}
	}
	
	//��4��
	//��¼ÿ��Ҷ������ȣ�����������Ǹ����������ĸ߶�
	static int max = 0;
	static int deep = 0;
	public static int deep(TreeNode root) {
		if(root != null) {
			deep++;
			if(root.getLchild() == null && root.getRchild() == null) {
				if(deep > max) {
					max = deep;
				}
				deep = 0;
			}
			
			deep(root.getLchild());
			deep(root.getRchild());
		}
		
		return max;
	}
	//�����ϴ𰸺�
	public static int deep2(TreeNode root) {
		if(root == null) {
			return 0;
		} else {
			int left = deep2(root.getLchild());
			int right = deep2(root.getRchild());
			return 1+Math.max(left, right);
		}
	}
	
	//��5��
	/* ���ϵ��㷨������һ���ģ����ǽ���һ������洢ÿ��Ľ����
	 * Ȼ��������飬�ҳ����ֵ
	 */
	public static int width(TreeNode root) {
		int[] arr = new int[100];
		widthOperator(root, 1,arr);
		int max = 0;
		for(int x = 0; x < arr.length; x++) {
			if(arr[x] > max) {
				max = arr[x];
			}
		}
		
		return max;
	}
	public static void widthOperator(TreeNode root, int deep, int[] arr) {
		if(root != null) {
			arr[deep]++;
			widthOperator(root.getLchild(), deep+1, arr);
			widthOperator(root.getRchild(), deep+1, arr);
		}
	}
	
	//��6��
	/*
	 * �ݹ�������
	 * ����ǰ����к��ӽ�㣬����false�����򷵻�true
	 * ����һ��ݹ鷵��true���򽫵�ǰ���Ķ�Ӧ���ӽ��ɾȥ
	 */
	public static boolean deleteLeaf(TreeNode root){
		if(root != null) {
			if(root.getLchild() == null && root.getRchild() == null) {
				return true;
			} else {
				if(deleteLeaf(root.getLchild()) == true) {
					root.setLchild(null);
				}
				if(deleteLeaf(root.getRchild()) == true) {
					root.setRchild(null);
				}
			}
		}
		
		return false;
	}
	
	/*
	 * �������ϵĴ���������޸�
	 * ���ҵĴ���õĵط�����
	 * 1��ȥ���˲���Ҫ�ķ���ֵ
	 * 2��˼·�Ƚ�ֱ�ӣ�ֱ���жϵ�ǰ���ĺ��ӽ���Ƿ���Ҷ�ӽ�㣬
	 *    ��Ҫ�޸����ֱ���޸ģ������ûص���һ��ݹ�
	 */
	public static void deleteLeaf2(TreeNode root) {
		if(root != null) {
			if(root.getLchild() != null) {
				if(root.getLchild().getLchild() != null || 
						root.getLchild().getRchild() != null) {
					deleteLeaf2(root.getLchild());
				} else {
					root.setLchild(null);
				}
			}
			if(root.getRchild() != null) {
				if(root.getRchild().getLchild() != null || 
						root.getRchild().getRchild() != null) {
					deleteLeaf2(root.getRchild());
				} else {
					root.setRchild(null);
				}
			}
		} 			
	}
	
	//��7��
	static int result = 0;
	public static int findNode(TreeNode root, TreeNode target) {
		findNodeOperator(root, target, 1);
		return result; 
	}
	public static int findNodeOperator(TreeNode root, TreeNode target, int deep) {
		if(root != null) {
			if(!root.getData().equals(target.getData())) {
				findNodeOperator(root.getLchild(), target, deep+1);
				findNodeOperator(root.getRchild(), target, deep+1);
			} else {
				result = deep;
			}
		}
		
		return result;
 	}
	/*
	 * ���ϵĴ�
	 * ����return���Ӳ�������һ���µ��㷨˼·
	 */
	public static int findNode2(TreeNode root, TreeNode target) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		if(root.getData().equals(target.getData())) {
			return 1;
		}
		
		return Math.max(findNode2(root.getLchild(), target), 
				findNode2(root.getRchild(), target))+1;
	}
	
	//��8��
	public static int findMax(TreeNode root) {
		if(root != null) {
			if(Integer.parseInt(root.getData()) > max) {
				max = Integer.parseInt(root.getData());
			} 
			findMax(root.getLchild());
			findMax(root.getRchild());
		}
		
		return max;
	}
	
	//��9��
	/*
	 * ˼·
	 * 	�������ں��ӽ���򽻻�����
	 * 	Ȼ�����η��������Ӻ��Һ���
	 * 	�����Ϊ���򷵻���һ��ݹ�
	 */
	public static void exchangeChild(TreeNode root) {
		if(root != null) {
			if(!(root.getLchild() ==null && root.getRchild() == null)) {
				TreeNode temp = root.getLchild();
				root.setLchild(root.getRchild());
				root.setRchild(temp);
			}
			
			exchangeChild(root.getLchild());
			exchangeChild(root.getRchild());
		}
	}
	
	//��10��
	public static void preShow(TreeNode root) {
		preShowOperator(root, 1);
	}
	public static void preShowOperator(TreeNode node, int deep) {
		if(node != null) {
			System.out.println(node.getData() + "---" + deep);
			preShowOperator(node.getLchild(), deep+1);
			preShowOperator(node.getRchild(), deep+1);
		}
	}
	
	//˼ά��չ
	/*	--------------------------------
	 * 	�˷�������Ŀ�г���
	 * 	��ĿҪ��ÿ�ζ����ʵ�Ҷ���
	 * 	���˷������ж���һ����·��
	 * 	--------------------------------
	 * 	ʹ�ú���ǵݹ�
	 * 	��sum��¼·���ĺ�
	 * 		��ջʱ��sum+node->data
	 * 		��ջʱ��sum-node->data
	 *  ��sum = value
	 *  ��ջ�е�Ԫ�����γ�ջ����һ����ջ��
	 *  �ٴӸ���ջ�����γ�ջ����ӡ��㣬����ջ
	 *  ֱ����������������
	 */
	public static void path(TreeNode root, int value) {
		int sum = 0;
		//��ջ
		SequenceStack<TreeNode> master = new SequenceStack<>();
		master.InitStack();
		//����ջ
		SequenceStack<TreeNode> assist = new SequenceStack<>();
		assist.InitStack();
		
		TreeNode temp = new TreeNode();
		
		while(root != null || !master.StackEmpty()) {
			if(root != null) {
				if(root.visit == 0) {
					master.Push(root);
					root.visit++;
					//��ջʱ��sum+node->data
					sum += Integer.parseInt(root.getData());
					root = root.getLchild();
				}
				
				if(sum == value) {
					TreeNode exch = new TreeNode(); 
					while(!master.StackEmpty()) {
						assist.Push((TreeNode)master.Pop());
					}
					
					while(!assist.StackEmpty()) {
						exch = assist.Pop();
						System.out.print(exch.getData() + " ");
						master.Push(exch);	
					}
					System.out.println();
				}
			} else {
				temp = master.GetTop();
				if(temp.visit == 1) {
					root = temp.getRchild();
					temp.visit++;
				} else if(temp.visit == 2){
					master.Pop();
					//��ջʱ��sum-node->data
					sum -= Integer.parseInt(temp.getData());
				}
			}
		}
	}
	
	//�����ϵ��������ʾд��
	public static void pathLeaf(TreeNode root, int value) {
		TreeNode[] tn = new TreeNode[10];
		pathLeafOperator(root, tn, 0, 0, value);
	}
	public static void pathLeafOperator(TreeNode root, TreeNode[] tn, int x, 
		int sum, int value) {
		if(root != null) {
			tn[x] = root;
			sum += Integer.parseInt(root.getData());
			
			if(!(root.getLchild() == null && root.getRchild() == null)) {
				pathLeafOperator(root.getLchild(), tn, x+1, sum, value);
				pathLeafOperator(root.getRchild(), tn, x+1, sum, value);
				
				tn[x] = null;
				sum -= Integer.parseInt(root.getData());
			} else {
				if(sum == value) {
					for(int y = 0; y < tn.length; y++) {
						if(tn[y] != null) {
							System.out.print(tn[y].getData() + " ");
						} else {
							break;
						}
					}
					System.out.println();
				}
				
				tn[x] = null;
				
			}
		} 
	}
}