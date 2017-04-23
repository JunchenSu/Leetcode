/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode res = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        if(p.right != null) return findSuccessorInRight(p.right);
        else return findSuccessorInTop(root,p);
        //return null;
    }
    
    private TreeNode findSuccessorInRight(TreeNode node) {
        while(node.left != null) node = node.left;
        return node;
    }
    
    private TreeNode findSuccessorInTop(TreeNode root, TreeNode p) {
        if(root.val == p.val) return res;
        if(root.val > p.val) {
         res = root;
         return findSuccessorInTop(root.left,p);   
        } else {
            return findSuccessorInTop(root.right,p);
        }
    }
}
