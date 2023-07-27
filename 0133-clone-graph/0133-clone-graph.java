/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node temp = q.poll();
            map.put(temp,new Node(temp.val));
            for(Node neighbor : temp.neighbors){
                if(!map.containsKey(neighbor))q.add(neighbor);
            }
        }

        for(Node oldNode : map.keySet()){
            Node newNode = map.get(oldNode);
            for(Node oldNeighbor : oldNode.neighbors){
                newNode.neighbors.add(map.get(oldNeighbor));
            }
        }

        return map.get(node);
    }
}