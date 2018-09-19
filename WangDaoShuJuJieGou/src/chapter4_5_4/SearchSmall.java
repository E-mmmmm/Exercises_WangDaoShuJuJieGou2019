package chapter4_5_4;

import chapter3_1_4.SequenceStack;
import chapter4_3_3.TreeNode;
import chapter4_3_3.TreeNodeTool;

//第12题
public class SearchSmall {
	public static void main(String[] args) {
		BSTNode s52 = new BSTNode("52", 9);
		BSTNode s26 = new BSTNode("26", 4);
		BSTNode s71 = new BSTNode("71", 3);
		BSTNode s14 = new BSTNode("14", 1);
		BSTNode s32 = new BSTNode("32", 1);
		BSTNode s60 = new BSTNode("60", 1);
		BSTNode s93 = new BSTNode("93", 0);
		BSTNode s24 = new BSTNode("24", 0);
		BSTNode s41 = new BSTNode("41", 0);
		BSTNode s58 = new BSTNode("58", 0);
		
		TreeNodeTool.ladd(s26, s52);
		TreeNodeTool.radd(s71, s52);
		TreeNodeTool.ladd(s14, s26);
		TreeNodeTool.radd(s32, s26);
		TreeNodeTool.ladd(s60, s71);
		TreeNodeTool.radd(s93, s71);
		TreeNodeTool.radd(s24, s14);
		TreeNodeTool.radd(s41, s32);
		TreeNodeTool.ladd(s58, s60);
		
		BSTNode result1 = searchSmall(s52, 9);
		System.out.println(result1.getData());
		
		BSTNode result2 = searchSmall(s52, 9);
		System.out.println(result2.getData());
	}
	/*
	 * 思路
	 * 	比较该结点的count与k的关系
	 * 		count > k
	 * 			该结点的右结点
	 * 				为null
	 * 					从该结点开始中序遍历
	 * 				非null
	 * 					递归访问该结点的右结点
	 * 
	 * 		count+1 = k
	 * 			以该结点为子树的最右下结点
	 * 				
	 * 		count < k-1
	 * 			返回上一层递归，中序遍历找到第k元素
	 * 
	 * 		count = k
	 * 			从该结点开始中序遍历
	 */
	//时间复杂度大概符合要求，但是思路和书上思路相比不够好
	static BSTNode result = null;
	static BSTNode pre = null;
	public static BSTNode searchSmall(BSTNode root, int k) {
		if(root.getCount() >= k) {
			if(root.getRchild() == null || root.getCount() == k) {
				//中序遍历
				SequenceStack<BSTNode> ss = new SequenceStack<>();
				ss.InitStack();
				
				BSTNode temp = new BSTNode();
				int num = 0;
				while(root != null || !ss.StackEmpty()) {
					if(num < k) {
						if(root != null) {
							ss.Push(root);
							root = root.getLchild();
						} else {
							temp = ss.Pop();
							root = temp.getRchild();
							num++;
						}
					} else if(num == k) {
						result = temp;
						return result;
					}
				}
			} else {
				pre = root;
				searchSmall(root.getLchild(), k);
			}
 		} else if(root.getCount()+1 == k) {
 			while(root.getRchild() != null) {
 				root = root.getRchild();
 			}
 			result = root;
 			return result;
 		} else if(root.getCount() < k-1) {
			//中序遍历
			SequenceStack<BSTNode> ss = new SequenceStack<>();
			ss.InitStack();
			
			BSTNode temp = new BSTNode();
			int num = 0;
			while(pre != null || !ss.StackEmpty()) {
				if(num < k) {
					if(pre != null) {
						ss.Push(pre);
						pre = pre.getLchild();
					} else {
						temp = ss.Pop();
						pre = temp.getRchild();
						num++;
					}
				} else if(num == k) {
					result = temp;
					return result;
				}
			}
		}
		
		return result;
	}
	
	/*
	 * 思路（看答案后）
	 *  lchild != null
	 *  	lchild.count == k-1
	 *  		返回当前结点
	 * 		lchild.count > k-1
	 * 			目标结点在左子树中
	 * 		lchild.count < k-1
	 * 			rchild == null
	 * 				k == 1
	 * 					返回当前结点
	 * 				k != 1
	 * 					返回null
	 * 			rchild != null
	 * 				目标结点在右子树中，寻找第k-lchild.count+1个结点
	 *  lchild == null
	 *  	rchild == null
	 *  		k == 1
	 *     			返回当前结点
	 *     		k != 1
	 *				返回null
	 *		rchild != null
	 *			k == 1
	 *				返回当前结点
	 *			k != 1
	 *				目标结点在柚子树种，寻找第k-1个结点
	 */
	public static BSTNode searchSmall2(BSTNode root, int k) {
		if(root.getLchild() != null) {
			if(root.getLchild().getCount() == k-1) {
				result = root;
				return result;
			} else if(root.getLchild().getCount() > k-1) {
				searchSmall2(root.getLchild(), k);
			} else {
				if(root.getRchild() == null) {
					if(k == 1) {
						result = root;
						return result;
					} else {
						return null;
					}
				} else {
					searchSmall2(root.getRchild(), k-root.getLchild().getCount()+1);
				}
			}
		} else {
			if(root.getRchild() == null) {
				if(k == 1) {
					result = root;
					return result;
				} else {
					return null;
				}
			} else {
				if(k == 1) {
					result = root;
					return result;
				} else {
					searchSmall2(root.getRchild(), k-1);
				}
			}
		}
		return result;
	}
}