//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    private void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void recFunc(int ind,char[] arr,ArrayList<String> res){
        if(ind==arr.length){
            res.add(String.valueOf(arr));
            return ;
        }
        
        for(int i=ind;i<arr.length;i++){
            swap(arr,i,ind);
            recFunc(ind+1,arr,res);
            swap(arr,i,ind);
        }
    }
    public ArrayList<String> permutation(String S)
    {
        char[] arr = S.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        
        recFunc(0,arr,res);
        Collections.sort(res);
        return res;
    }
	   
}
