class Solution {

    private int ROWS;
    private int COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] visitedPac = new boolean[ROWS][COLS];
        boolean[][] visitedAtl = new boolean[ROWS][COLS];

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        // add all sources in queues
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if( r == 0 || c == 0){
                    q1.add(new int[]{r,c});
                }
                if(r == ROWS - 1 || c == COLS - 1){
                    q2.add(new int[]{r, c});
                }
            }
        }

        bfs(q1, visitedPac, heights);
        bfs(q2, visitedAtl, heights);

        List<List<Integer>> res = new ArrayList<>();

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(visitedPac[r][c] && visitedAtl[r][c]){
                    res.add(Arrays.stream(new int[]{r,c}).boxed().toList());
                }
            }
        }

    return res;
    }


    void bfs(Queue<int[]> q, boolean[][] visited, int[][] heights){

        while(!q.isEmpty()){
            int[] node = q.poll();

            int row = node[0];
            int col = node[1];
            visited[row][col] = true;

            int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];

                if(r < 0 || c < 0 || r >= ROWS || c >= COLS || heights[row][col] > heights[r][c] || visited[r][c]){
                    continue;
                }
                q.add(new int[]{r, c});
            }
        }
    }
}
