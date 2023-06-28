class Pair {
    int node;
    double cost;

    Pair(int a, double b) {
        this.node = a;
        this.cost = b;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // making the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double c = succProb[i];
            adj.get(u).add(new Pair(v, c));
            adj.get(v).add(new Pair(u, c));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Double.compare(y.cost, x.cost));

        pq.add(new Pair(start, 1.0));
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start] = 1.0;

        while (!pq.isEmpty()) {
            Pair s = pq.poll();
            double sCost = s.cost;
            int sNode = s.node;

            for (Pair p : adj.get(sNode)) {
                double adjCost = p.cost;
                int adjNode = p.node;
                double mul = sCost * adjCost;

                if (mul > dist[adjNode]) {
                    dist[adjNode] = mul;
                    pq.add(new Pair(adjNode, mul));
                }
            }
        }

        return dist[end];
    }
}
