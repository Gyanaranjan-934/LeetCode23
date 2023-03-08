//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

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
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
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
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
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
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
     public static ArrayList<Integer> solve(Node root) {
        if (root == null) {
            return new ArrayList<>(Arrays.asList(1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE));
        }

        if (root.left == null && root.right == null) {
            return new ArrayList<>(Arrays.asList(1, 1, root.data, root.data));
        }

        ArrayList<Integer> left = solve(root.left);
        ArrayList<Integer> right = solve(root.right);

        if (left.get(0) == 1 && right.get(0) == 1) {
            if (root.data > left.get(3) && root.data < right.get(2)) {
                int x = left.get(2);
                int y = right.get(3);

                if (x == Integer.MAX_VALUE) {
                    x = root.data;
                }

                if (y == Integer.MIN_VALUE) {
                    y = root.data;
                }

                return new ArrayList<>(Arrays.asList(1, left.get(1) + right.get(1) + 1, x, y));
            }
        }

        return new ArrayList<>(Arrays.asList(0, Math.max(left.get(1), right.get(1)), 0, 0));
    }
    
    // Return the size of the largest sub-tree which is also a BST
    
    static int largestBst(Node root)
    {
        // Write your code here
        
        ArrayList<Integer> list = solve(root);
        return list.get(1);
    }
    
}