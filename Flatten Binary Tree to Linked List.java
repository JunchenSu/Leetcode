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
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        if(root.left != null) {
            root.right = root.left;
            TreeNode rightMostOfLeft = root;
            while(rightMostOfLeft.right != null) rightMostOfLeft = rightMostOfLeft.right;
            rightMostOfLeft.right = temp;
        }
        root.left = null;
    }
}
/*
Note that the problem requires in-place operation.The flatten procedure is like: cut the left child and set to right, the right child is then linked to somewhere behind the left child. Where should it be then? Actually the right child should be linked to the most-right node of the left node. So the algorithm is as follows:
(1) store the right child (we call R)
(2) find the right-most node of left child
(3) set R as the right-most node's right child.
(4) set left child as the right child
(5) set the left child NULL
(6) set current node to current node's right child.
(7) iterate these steps until all node are flattened.
*/

/*Easier Solution*/
private TreeNode prev = null;

public void flatten(TreeNode root) {
    if (root == null)
        return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
}
