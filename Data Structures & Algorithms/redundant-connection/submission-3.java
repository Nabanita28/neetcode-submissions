class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        //create the graph
        //compute the indegrees
        //select the nodes with indegree=1
        //iterate the edges and return the edge with indegree > 0
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>(n+1);//n+1 because nodes are labeled from 1 to n.
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n+1];//n+1 because nodes are labeled from 1 to n.

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0]; int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[v]++;
            indegree[u]++;
        }

        for(int i=1; i<=n; i++){
            if(indegree[i] == 1){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            indegree[node]--;

            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i]==1){
                    q.add(i);
                }
            }
        }

        for(int i=edges.length-1; i>=0; i--){
            int u = edges[i][0];
            int v = edges[i][1];

            if(indegree[u] > 0 && indegree[v] > 0){
                return new int[]{u,v};
            }
        }
        return new int[]{-1, -1};
    }
}
