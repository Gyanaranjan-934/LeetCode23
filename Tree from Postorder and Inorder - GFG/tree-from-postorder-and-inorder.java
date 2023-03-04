//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    void setHashMap(HashMap<Integer,Integer> map,int[] inorder){
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
    }
    Node buildTree(int inorder[], int postorder[], int n) {
        // Your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        setHashMap(map,inorder);
        return solve(map,postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    Node solve(HashMap<Integer,Integer> map,int[] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd){
        
        if(postStart>postEnd || inStart>inEnd)return null;

        Node root = new Node(postorder[postEnd]);
        int rootInd = map.get(root.data);
        int inLeft = rootInd-inStart;
        int inRight = inEnd-rootInd;

        root.left = solve(map,postorder,postStart,postStart+inLeft-1,inorder,inStart,rootInd-1);
        root.right = solve(map,postorder,postStart+rootInd-inStart, postEnd-1,inorder,rootInd+1,inEnd);

        return root;
    }
    
}
