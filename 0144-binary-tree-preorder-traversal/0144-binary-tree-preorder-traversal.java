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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode ptr = root;
        while(true){
            if(ptr!=null){
                preorder.add(ptr.val);
                stk.push(ptr);
                ptr = ptr.left;
            }else{
                if(stk.isEmpty())break;
                TreeNode parent = stk.pop();
                ptr = parent.right;
            }
        }
        return preorder;
    }
}