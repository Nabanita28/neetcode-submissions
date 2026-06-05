class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length < n-1){
            return false;
        }

        //construct the tree by iterating on edges
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
       

        q.add(new int[]{0,-1});
        set.add(0);

        while(!q.isEmpty()){
            int[] node = q.poll();
            int curr = node[0];
            int parent = node[1];

            for(int nei : adj.get(curr)){
                if(nei == parent){
                    continue;
                }

                if(set.contains(nei)){
                    return false;
                }

                set.add(nei);
                q.add(new int[]{nei, curr});
            }
        
        }

    return set.size() == n;
    }
}
