package LeetCode;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class J572_Subtree_of_Another_Tree {

	public boolean isSubtree(TreeNode s, TreeNode t) {		
		String sStr = convertToPreOrderString(s);
		String tStr = convertToPreOrderString(t);
		return sStr.contains(tStr);
    }
	
	public String convertToPreOrderString(TreeNode node) {
		if (node == null) return "#";
		//using pre-order to traversal
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			TreeNode tem = stack.pop();
			if (tem == null)
				sb.append(",#");
			else {
				sb.append("," + tem.val);
				stack.push(tem.right);
				stack.push(tem.left);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		TreeNode s = new TreeNode(3);
		TreeNode s1 = new TreeNode(4);
		TreeNode s2 = new TreeNode(5);
		TreeNode s3 = new TreeNode(1);
		TreeNode s4 = new TreeNode(2);
		TreeNode s5 = new TreeNode(0);
		s.left = s1;
		s.right = s2;
		s1.left = s3;
		s1.right = s4;
		s4.left = s5;
		
		TreeNode t = new TreeNode(4);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t.left = t1;
		t.right = t2;
		
		TreeNode ts1 = new TreeNode(1);
		TreeNode ts2 = new TreeNode(1);
		ts1.left = ts2;
		
		TreeNode tss1 = new TreeNode(1);
		
		System.out.println(new J572_Subtree_of_Another_Tree().isSubtree(ts1, tss1));
		
		
	}

}
