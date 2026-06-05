class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //build the graph = adj
        //compute the indegree array
        //put all the nodes whose indegree is 0 into queue
        //proess the nodes into the queue

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){

            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;

        }

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int finish = 0;

        while( !q.isEmpty()){

            int node = q.poll();
            finish++;

            for(int i : adj.get(node)){

                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }

        return finish == numCourses;
    }
}
