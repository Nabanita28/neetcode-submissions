class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[]{0, 0});

        boolean[] visited = new boolean[n];
        int totalCost = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];

            if(visited[u]){
                continue;
            }
            visited[u] = true;
            totalCost = totalCost + cost;

            for(int v = 0; v<n; v++){
                if(!visited[v]){
                int dist = getManhattanDistance(points[u], points[v]);
                pq.offer(new int[]{dist, v});
                }
               
            }
        }
        return totalCost;
    }

    int getManhattanDistance(int[] u, int[] v){
        return Math.abs(u[0] - v[0]) + Math.abs(u[1] - v[1]);
    }
}
