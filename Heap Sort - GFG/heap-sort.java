//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends


class Solution
{
    
    int parent(int key){
        return (key-1)/2;
    }
    int leftChild(int key){
        return (2*key+1);
    }
    int rightChild(int key){
        return 2*key+2;
    }
    
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        
        if(left<n && arr[left]>arr[largest])largest = left;
        if(right<n && arr[right]>arr[largest])largest = right;
        
        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,n,largest);
        }
    }
    
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
            
        for(int i=n-1;i>0;i--){
            swap(arr,i,0);
            heapify(arr,i,0);
        }
    }
 }
 
 
