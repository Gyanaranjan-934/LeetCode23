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
    int res = Integer.MIN_VALUE;
    private int recFunc(TreeNode root){
        if(root==null)return 0;

        int left = recFunc(root.left);
        int right = recFunc(root.right);
        int temp = left+right+root.val;
        res = Math.max(temp,res);
        int sum = Math.max(left,right)+root.val;
        return sum<=0 ? 0 : sum;

    }
    public int maxPathSum(TreeNode root) {
        int maxi = recFunc(root);
        return res;
    }
}