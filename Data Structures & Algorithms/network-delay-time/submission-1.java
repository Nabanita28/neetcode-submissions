class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        

        //construct the graph - adj list
        //create minheap and maintain a visited set

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i=1; i<=n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : times){

            int n1 = edge[0];
            int n2 = edge[1];
            int t = edge[2];

            adj.get(n1).add(new int[]{n2, t});

        }

        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.offer(new int[]{k, 0});

        Set<Integer> visited = new HashSet<>();

        int t=0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int n1 = curr[0];
            int w1 = curr[1];

            if(visited.contains(n1)){
                    continue;
            }
            visited.add(n1);
            t = w1;

            for(int[] nei : adj.get(n1)){

                int n2 = nei[0];
                int w2 = nei[1];

              
                if(!visited.contains(n2)){
                    q.offer(new int[]{n2, w1+w2});
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
