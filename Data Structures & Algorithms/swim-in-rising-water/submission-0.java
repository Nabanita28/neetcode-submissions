class Solution {
    public int swimInWater(int[][] grid) {
        
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int row = grid.length;
        int col = grid[0].length;

        q.add(new int[]{grid[0][0], 0, 0});
        boolean[][] visited = new boolean[row][col];

        int[][] dirs = {{-1,0}, {0,-1},
                                 {1, 0}, {0,1}};
           

        while(!q.isEmpty()){

            int[] curr = q.poll();

            int time = curr[0];
            int r = curr[1];
            int c = curr[2];
            visited[r][c] = true;

            if(r == row-1 && c == col-1){
                return time;
            }

            for(int[] dir : dirs){

                
                int nr = r + dir[0];
                int nc = c + dir[1];
                

                if(nr < 0 || nc < 0 || nr >= row || nc >= col){
                    continue;
                }

                int t = grid[nr][nc];
                if(!visited[nr][nc]){
                    q.add(new int[]{Math.max(time, t), nr, nc});
                }
            }
        }
        return row*col;
    }
}
