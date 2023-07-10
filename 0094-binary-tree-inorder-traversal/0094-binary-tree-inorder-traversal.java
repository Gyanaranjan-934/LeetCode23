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
    private void inorder(TreeNode root,List<Integer> list){
        // if(root==null)return;
        // inorder(root.left,list);
        // list.add(root.val);
        // inorder(root.right,list);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        
        if(root==null)return list;

        while(true){
            if(root!=null){
                stk.push(root);
                root = root.left;
            }else{
                if(stk.isEmpty())break;
                root = stk.peek();
                list.add(root.val);
                stk.pop();
                root = root.right;
            }
        }

        return list;
    }
}