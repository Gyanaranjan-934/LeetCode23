class Solution {
    private HashMap<String,HashMap<String,Double>> makeGraph(List<List<String>> equations, double[] values){
        HashMap<String,HashMap<String,Double>> adj = new HashMap<>();
        for(int i=0;i<values.length;i++){
            List<String> eqn = equations.get(i);
            String u = eqn.get(0);
            String v = eqn.get(1);
            double av = values[i]; //actual value
            double rv = 1.0/av; //reciprocal value
            if(adj.containsKey(u)){
                HashMap<String,Double> auxMap = adj.get(u);
                auxMap.put(v,av);
            }else{
                HashMap<String,Double> auxMap = new HashMap<>();
                auxMap.put(v,av);
                adj.put(u,auxMap);
            }

            if(adj.containsKey(v)){
                HashMap<String,Double> auxMap = adj.get(v);
                auxMap.put(u,rv);
            }else{
                HashMap<String,Double> auxMap = new HashMap<>();
                auxMap.put(u,rv);
                adj.put(v,auxMap);
            }

        }

        return adj;
    }
    private void dfs(String src,String dst,HashMap<String,HashMap<String,Double>> adj,HashSet<String> visited,double[] ans,double temp){
        
        visited.add(src);
        if(src.equals(dst)){
            ans[0] = temp;
            return;
        }

        for(Map.Entry<String, Double> entry : adj.get(src).entrySet()){
            String ne = entry.getKey();
            double val = entry.getValue();
            if(!visited.contains(ne)){
                dfs(ne,dst,adj,visited,ans,temp*val);
            }
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> adj = makeGraph(equations,values);
        double[] finalAns = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if(!adj.containsKey(src) || !adj.containsKey(dst))finalAns[i]=-1.0;
            else{
                HashSet<String> visited = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(src,dst,adj,visited,ans,temp);
                finalAns[i] = ans[0];
            }
        }
        return finalAns;
    }
    
    

}