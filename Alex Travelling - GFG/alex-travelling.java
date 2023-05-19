//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int cost;
    int node;
    Pair(int a,int b){
        this.cost = a;
        this.node = b;
    }
}
class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int[] row : flights){
            int u = row[0];
            int v = row[1];
            int c = row[2];
            adj.get(u).add(new Pair(c,v));
        }
        if(adj.get(k).size()==0)return -1;
        int[] minTime = new int[n+1];
        Arrays.fill(minTime,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.cost-y.cost);

        pq.add(new Pair(0,k));
        minTime[k] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.peek();
            int sNode = p.node;
            int sCost = p.cost;
            pq.remove();

            for(Pair pr : adj.get(sNode)){
                int nNode = pr.node;
                int nCost = pr.cost;
                if(nCost + sCost < minTime[nNode]){
                    pq.add(new Pair(nCost + sCost,nNode));
                    minTime[nNode] = nCost + sCost;
                }
            }
        }
        
        int maxi = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            
            maxi = Math.max(maxi,minTime[i]);
        }
        

        return maxi == Integer.MAX_VALUE ? -1 : maxi;
    }
}
