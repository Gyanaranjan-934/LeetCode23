//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    
    // private static void findTar(Node root,int tar){
    //     if(root==null)return ;
    //     findTar(root.left,tar);
    //     findTar(root.right,tar);
    //     if(root.data==tar){
    //         target = root;
    //         return;
    //     }
        
    // }
    public static Node setHashMap(HashMap<Node,Node> map,Node root,int tar){
        map.put(root,null);
        Node target = new Node(0);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp = q.remove();
                if(temp.data == tar)target = temp;
                if(temp.left != null){
                    q.add(temp.left);
                    map.put(temp.left,temp);
                }
                if(temp.right != null){
                    q.add(temp.right);
                    map.put(temp.right,temp);
                }
            }
        }
        return target;
    }
    public static int minTime(Node root, int tar) 
    {
        // Your code goes here
        // findTar(root,tar);
        HashMap<Node,Node> parent = new HashMap<>();
        Node target = setHashMap(parent,root,tar);
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Boolean> visited = new HashMap<>();
        q.add(target);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp = q.remove();
                if(temp.left!=null && !visited.containsKey(temp.left)){
                    q.add(temp.left);
                    visited.put(temp.left,true);
                }
                if(temp.right!=null && !visited.containsKey(temp.right)){
                    q.add(temp.right);
                    visited.put(temp.right,true);
                }
                Node ptr = parent.get(temp);
                if(ptr!=null && !visited.containsKey(ptr)){
                    q.add(ptr);
                    visited.put(ptr,true);
                }
            }
            cnt++;
        }
        return cnt-1;
    }
}