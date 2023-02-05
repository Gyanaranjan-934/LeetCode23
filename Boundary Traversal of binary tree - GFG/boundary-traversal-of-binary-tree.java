//{ Driver Code Starts
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
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
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
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    void leftNodes(Node node,ArrayList<Integer> list){
        while(node!=null){
            if(node.left!=null){
                list.add(node.data);
                node = node.left;
            }else if(node.right!=null){
                list.add(node.data);
                node = node.right;
            }else{
                break;
            }
        }
    }
    void rightNodes(Node node,ArrayList<Integer> list){
        ArrayList<Integer> temp = new ArrayList<>();
        while(node!=null){
            if(node.right!=null){
                temp.add(node.data);
                node = node.right;
            }else if(node.left!=null){
                temp.add(node.data);
                node = node.left;
            }else{
                break;
            }
        }
        // Collections.reverse(temp);
        for(int i=temp.size()-1;i>=0;i--)
            list.add(temp.get(i));
    }
    void leafNodes(Node node,ArrayList<Integer> list){
        if(node==null)return;
        leafNodes(node.left,list);
        leafNodes(node.right,list);
        if(node.left==null && node.right==null)list.add(node.data);
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> list = new ArrayList<>();
	    if(node!=null){
	        list.add(node.data);
	        if(node.left==null && node.right==null)
                return list;
	    }
	    leftNodes(node.left,list);
	   // list.remove(list.size()-1);
	    leafNodes(node,list);
	    rightNodes(node.right,list);
	   // list.remove(list.size()-1);
	    return list;
	}
}
