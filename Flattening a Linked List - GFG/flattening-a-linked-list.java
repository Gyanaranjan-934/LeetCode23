//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}
// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
// without space
    class GfG
    {
        Node flatten(Node root)
        {
    	    if(root==null || root.next==null)return root;
    	    Node head = merge(root,flatten(root.next));
    	    return head;
        }
        Node merge(Node head1,Node head2){
            
            Node ptr1 = head1;
            Node ptr2 = head2;
            
            Node head = new Node(-1);
            Node ptr = head;
            
            while(ptr1!=null && ptr2!=null){
                if(ptr1.data < ptr2.data){
                    ptr.bottom = ptr1;
                    ptr1 = ptr1.bottom;
                }else{
                    ptr.bottom = ptr2;
                    ptr2 = ptr2.bottom;
                }
                ptr = ptr.bottom;
            } 
            if(ptr1!=null)ptr.bottom = ptr1;
            else ptr.bottom =ptr2;
            
            return head.bottom;
        }
    }
// using space 
// class GfG {
//     Node flatten(Node root) {
//         PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.data - y.data);
//         Node ptr = root;
//         Node newHead = new Node(0);  // Corrected initialization
//         Node newPtr = newHead;
        
//         while (ptr != null) {
//             pq.add(ptr);
//             ptr = ptr.next;
//         }
        
//         while (!pq.isEmpty()) {
//             Node node = pq.poll();
//             newPtr.bottom = node;  // Updated to bottom instead of next
//             newPtr = newPtr.bottom;  // Updated to bottom instead of next
            
//             if (node.bottom != null)
//                 pq.add(node.bottom);
//         }
        
//         return newHead.bottom;  // Updated to bottom instead of next
//     }
// }
