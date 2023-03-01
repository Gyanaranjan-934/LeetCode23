//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    static Node target;
    private static void findTar(Node root,int tar){
        if(root==null)return ;
        findTar(root.left,tar);
        findTar(root.right,tar);
        if(root.data==tar){
            target = root;
            return;
        }
        
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int tar , int K)
    {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> res = new ArrayList<>();
        findTar(root,tar);
        distanceK(root, target, K, res);
        Collections.sort(res);
        return res;
        
    }
    private static int distanceK(Node node, Node target, int K, List<Integer> res) {
        if (node == null) {
            return 0;
        }
        if (node == target) { // found the target for the current subtree
            traverseSubtree(node, K, res);
            return 1;
        }
        int distLeft = distanceK(node.left, target, K, res); // distance to target in the left subtree
        if (distLeft != 0) {
            if (distLeft == K) {
                res.add(node.data);
            } else if (distLeft < K) {
                traverseSubtree(node.right, K - distLeft - 1, res); // visit the right subtree looking for nodes at a given distance
            }
            return distLeft + 1; // return distance to target + 1
        }
        int distRight = distanceK(node.right, target, K, res); // distance to target in the right subtree
        if (distRight != 0) {
            if (distRight == K) {
                res.add(node.data);
            } else if (distRight < K) {
                traverseSubtree(node.left, K - distRight - 1, res); // visit the left subtree looking for nodes at a given distance
            }
            return distRight + 1; // return distance to target + 1
        }
        return 0; // if reached this place, then there is no target in the current subtree
    }

    private static void traverseSubtree(Node node, int K, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (K == 0) { // found a node at a given distance
            res.add(node.data);
            return;
        }
        traverseSubtree(node.left, K - 1, res); // go down until we find a node at a distance of K
        traverseSubtree(node.right, K - 1, res); // (if the depth of the subtree allows us to do this)
    }
};