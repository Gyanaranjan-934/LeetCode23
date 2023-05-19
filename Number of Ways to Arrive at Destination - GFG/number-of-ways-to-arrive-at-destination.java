//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class CityTime {
    int city;
    long time;
    
    CityTime(int city, long time) {
        this.city = city;
        this.time = time;
    }
}

class Solution {
    
    private static int MOD = 1000000007;
    
    private static List<List<CityTime>> createAdjacancyList(List<List<Integer>> roads, 
        int v) {
        List<List<CityTime>> adj = new ArrayList<>();
        
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (List<Integer> road: roads) {
            adj.get(road.get(0)).add(new CityTime(road.get(1), road.get(2)));
            adj.get(road.get(1)).add(new CityTime(road.get(0), road.get(2)));
        }
        
        return adj;
    }
    
    private static void getMinTimeFromCity(List<List<CityTime>> adj, 
        CityTime from, PriorityQueue<CityTime> pq, long[] minTime, int[] maxWays) {
        int connectedCities = adj.get(from.city).size();
        for (int i = 0; i < connectedCities; i++) {
            CityTime curr = adj.get(from.city).get(i);
            long totalTime = curr.time + from.time;
            if (minTime[curr.city] >= totalTime) {
                maxWays[curr.city] = (maxWays[curr.city] + maxWays[from.city]) % MOD;
                if (minTime[curr.city] > totalTime) {
                    minTime[curr.city] = totalTime;
                    pq.offer(new CityTime(curr.city, totalTime));
                }
            }
        }
    }
    
    private static void bfTraversal(List<List<CityTime>> adj, PriorityQueue<CityTime> pq,
        long[] minTime, int[] maxWays) {
        minTime[0] = 0;
        maxWays[0] = 1;
        pq.offer(new CityTime(0, 0));
        while (!pq.isEmpty()) {
            CityTime curr = pq.poll();
            getMinTimeFromCity(adj, curr, pq, minTime, maxWays);
        }
    }
    
    private static int getPathsWithMinTime(List<List<CityTime>> adj, int v) {
        long[] minTime = new long[v];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        int[] maxWays = new int[v];
        PriorityQueue<CityTime> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(CityTime ct1, CityTime ct2) {
                return Long.compare(ct1.time, ct2.time);
            }
        });
        bfTraversal(adj, pq, minTime, maxWays);
        return maxWays[v - 1];
    }

    public static int countPaths(int n, List<List<Integer>> roads) {
        List<List<CityTime>> adj = createAdjacancyList(roads, n);
        return getPathsWithMinTime(adj, n);
    }
}