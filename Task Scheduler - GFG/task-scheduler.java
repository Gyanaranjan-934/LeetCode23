//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            char a[] = new char[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.next().charAt(0);
            }
            Solution obj = new Solution();
            int ans = obj.leastInterval(n, k, a);
            System.out.println(ans);
        }
    }
    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) { in = is; }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Pair{
    int val;
    int time;
    Pair(int a,int b){
        this.val = a;
        this.time = b;
    }
}
class Solution {
    static int leastInterval(int N, int K, char tasks[]) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch-'A']++;
        }
        // PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        // Queue<Pair> q = new LinkedList<>();
        
        // for(int i:freq)
        //     if(i>0)pq.add(i);
            
        // int time = 0;
        // while(!pq.isEmpty() || !q.isEmpty()){
        //     if(!q.isEmpty() && time==q.peek().time)pq.add(q.poll().val);
            
        //     int task = 0;
            
        //     if(!pq.isEmpty())
        //         task = pq.poll();
            
        //     time++;
        //     if(task>1)q.add(new Pair(task-1,time+K));
        // }
        // return time;
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleTime = (maxFreq - 1) * K;
        for (int i = 24; i >= 0; i--) {
            idleTime -= Math.min(maxFreq - 1, freq[i]);
        }
        idleTime = Math.max(0, idleTime);
        return idleTime + N;
    }
}