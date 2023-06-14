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
    int prev = (int)(-1e9);
    private void inorder(TreeNode root,int[] arr){
        if(root==null)return;
        inorder(root.left,arr);
        arr[0]=Math.min(arr[0],Math.abs(root.val-prev));
        prev = root.val;
        inorder(root.right,arr);
        
    }
    public int getMinimumDifference(TreeNode root) {
        int[] arr = new int[1];
        arr[0]=Integer.MAX_VALUE;
        inorder(root,arr);
        return arr[0];
        // int mini = Integer.MAX_VALUE;
        // for(int i=1;i<arr.size();i++){
        //     mini = Math.min(mini,arr.get(i)-arr.get(i-1));
        // }
        // return mini;
    }
}