/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode ptr = root;
        while(true){
            if(ptr!=null){
                stk.push(ptr);
                ptr = ptr.left;
            }else{
                if(stk.isEmpty())break;
                TreeNode parent = stk.pop();
                inorder.add(parent.val);
                ptr = parent.right;
            }
        }
        return inorder;
    }
}