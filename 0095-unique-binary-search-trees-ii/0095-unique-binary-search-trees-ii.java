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
    private List<TreeNode> recFunc(int start,int end){
        List<TreeNode> list = new ArrayList<>();
        if(end<start){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftList = recFunc(start,i-1);
            List<TreeNode> rightList = recFunc(i+1,end);
            for(TreeNode left : leftList){
                for(TreeNode right : rightList){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
    public List<TreeNode> generateTrees(int n) {
        
        return recFunc(1,n);
        
    }
}