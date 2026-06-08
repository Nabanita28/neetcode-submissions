class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        

        //construct the graph - adj list
        //create minheap and maintain a visited set

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] edge : times){
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        //sort the priority queue by time
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

            if(adj.containsKey(n1)){
            for(int[] nei : adj.get(n1)){

                int n2 = nei[0];
                int w2 = nei[1];

              
                if(!visited.contains(n2)){
                    q.offer(new int[]{n2, w1+w2});
                }
            }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
