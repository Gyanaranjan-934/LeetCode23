class Pair {
    TreeNode node;
    int ind;

    Pair(TreeNode a, int b) {
        this.node = a;
        this.ind = b;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxi = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            int curr_id = q.peek().ind;
            int first = 0,last=0;
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                if(i==0)first=p.ind-curr_id;
                if(i==size-1)last=p.ind-curr_id;
                if (p.node.left != null) {
                    q.add(new Pair(p.node.left, p.ind * 2));
                }
                if (p.node.right != null) {
                    q.add(new Pair(p.node.right, p.ind * 2 + 1));
                }
            }
            maxi = Math.max(maxi,last-first+1);
        }

        return maxi;
    }
}
