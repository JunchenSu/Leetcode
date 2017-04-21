 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    private Stack<TreeNode> stack = null;
    private TreeNode current = null;
    
    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty()||current != null;
    }

    /** @return the next smallest number */
    public int next() {//similar to the inorder traversal
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
        TreeNode smallest = stack.pop();
        current = smallest.right;
        return smallest.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
