class Solution {

    int ROWS = 0;
    int COLS = 0;
    static final int INF = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {

        ROWS = grid.length;
        COLS = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                if(grid[r][c] == 0){
                   q.add(new int[]{r, c});
                }
            }
        }

        if(q.size() == 0)
        return;
    
 int[][] dirs = {{-1, 0}, {0, -1},
                 {1, 0}, {0, 1}};

    while(!q.isEmpty()){

        int[] node = q.poll();

        int row = node[0];
        int col = node[1];

        for(int[] dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];

            if(r<0 || c<0 || r >= ROWS || c >= COLS ||
                grid[r][c] != INF){
                continue;
            }
            q.add(new int[]{r,c});
            grid[r][c] = grid[row][col] + 1;
        }

    }
}
}