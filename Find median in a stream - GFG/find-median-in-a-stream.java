//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y)->y-x);
    public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        if(maxHeap.size()==0){
            maxHeap.add(x);
            return;
        }
        
        if(maxHeap.size()>minHeap.size()){
            if(x<maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(x);
            }
            else{
                minHeap.add(x);
            }
        }else{
            if(x<maxHeap.peek())maxHeap.add(x);
            else{
                minHeap.add(x);
                maxHeap.add(minHeap.poll());
            }
        }
        
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       if(maxHeap.size()>minHeap.size()+1)minHeap.add(maxHeap.poll());
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(maxHeap.size()>minHeap.size())return maxHeap.peek();
        return (minHeap.peek()+maxHeap.peek())/2.0;
    }
    
}