/**
 * Definition for a binary tree TreeNode.
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
class Tuple{
    TreeNode node;
    int level;
    int dist;
    Tuple(TreeNode a,int b,int c){
        node = a;
        level = b;
        dist = c;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer,List<Tuple>> map = new TreeMap<>();
        
        q.add(new Tuple(root,0,0));
        
        while(!q.isEmpty()){

            int size = q.size();
            for(int i=0;i<size;i++){
                Tuple p = q.remove();
            
                if(!map.containsKey(p.dist)){
                    List<Tuple> list = new ArrayList<>();
                    list.add(p);
                    map.put(p.dist,list);
                }else map.get(p.dist).add(p);
                
                if(p.node.left!=null)q.add(new Tuple(p.node.left,p.level+1,p.dist-1));
                if(p.node.right!=null)q.add(new Tuple(p.node.right,p.level+1,p.dist+1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int key : map.keySet()){
            List<Tuple> list = map.get(key);
            Collections.sort(list,(x,y)->{
                if(x.level==y.level)return x.node.val-y.node.val;
                return x.level-y.level;
            });
            List<Integer> temp = new ArrayList<>();
            for(Tuple t : list){
                temp.add(t.node.val);
            }
            res.add(temp);
        }
        return res;
    }
}