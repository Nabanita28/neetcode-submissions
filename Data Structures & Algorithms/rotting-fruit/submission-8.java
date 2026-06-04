class Solution {

    private int ROWS;
    private int COLS;

    public int orangesRotting(int[][] grid) {
        
        //use multi source bfs
        //add all 2 to the queue
        //maintain a time counter and increment after every bfs level traversal
        //before return the answer, check the grid again to ensure if there are any fresh fruit available
        ROWS = grid.length;
        COLS = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int minTime = 0;
        int fresh = 0;
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){

                if(grid[i][j] == 1){
                    fresh++;
                }

                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {0, -1},
                        {1, 0}, {0, 1}};


        while(fresh > 0 && !q.isEmpty() ){

            int size = q.size();
                
          for(int i=0; i<size; i++){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir : dirs){

                int r = row + dir[0];
                int c = col + dir[1];

                if( r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] != 1){
                    continue;
                }

                q.add(new int[]{r,c});
                grid[r][c] = 2;
                fresh--;
            }
          }      
            
            minTime++;
        }

        return fresh > 0 ? -1 : minTime;

    }
}
