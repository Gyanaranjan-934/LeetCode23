//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class DisJointSet{
    ArrayList<Integer> size;
    ArrayList<Integer> parent;
    DisJointSet(int n){
        size = new ArrayList<>();
        parent = new ArrayList<>();
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findParent(int a){
        if(parent.get(a)==a)return a;
        parent.set(a,findParent(parent.get(a)));
        return parent.get(a);
    }
    
    public void findUnion(int a,int b){
        int pa = findParent(a);
        int pb = findParent(b);
        
        if(size.get(pa)<size.get(pb)){
            parent.set(pa,pb);
            size.set(pb,size.get(pb)+size.get(pa));
        }else{
            parent.set(pb,pa);
            size.set(pa,size.get(pb)+size.get(pa));
        }
    }
    
}

class Solution {

    public int Solve(int n, int[][] connections) {
        if(connections.length<n-1)return -1;

        DisJointSet ds = new DisJointSet(n);

        for(int[] row:connections){
            ds.findUnion(row[0],row[1]);
        }
        int cnt = 0;
        for(int i=0;i<ds.parent.size();i++){
            if(ds.parent.get(i)==i)cnt++;
        }

        return cnt-1;
    }
}