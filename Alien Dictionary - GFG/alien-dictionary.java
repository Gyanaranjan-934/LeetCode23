//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void findTopo(ArrayList<ArrayList<Integer>> adj,int k,ArrayList<Integer> list){
        int[] indeg = new int[k];
        for(int i=0;i<k;i++){
            for(int j:adj.get(i)){
                indeg[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<k;i++){
            if(indeg[i]==0)q.add(i);
        }
        
        while(!q.isEmpty()){
            int m = q.remove();
            list.add(m);
            for(int i : adj.get(m)){
                indeg[i]--;
                if(indeg[i]==0)q.add(i);
            }
        }
        
    }
    public String findOrder(String [] dict, int N, int K)
    {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=1;i<N;i++){
            String word1 = dict[i-1];
            String word2 = dict[i];
            
            makeEdges(adj,word1,word2);
            
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        findTopo(adj,K,list);
        
        String res = "";
        
        for(int i:list){
            res += Character.toString((char)(i+97));
        }
        
        return res;
    }
    public void makeEdges(ArrayList<ArrayList<Integer>> adj,String word1,String word2){
        int i=0;
        int j=0;
        while(i<word1.length() && j<word2.length()){
            if(word1.charAt(i)!=word2.charAt(j)){
                int u = word1.charAt(i) - 'a';
                int v = word2.charAt(j) - 'a';
                adj.get(u).add(v);
                return;
            }
            i++;
            j++;
        }
        // if(i<word.length() && j==word2.length()){
        //     int u = word1.charAt(i) - "a";
        //     int v = word2.charAt(j) = "a";
        //     adj.get(u).add(v);
        //     return;
        // }
    }
}









