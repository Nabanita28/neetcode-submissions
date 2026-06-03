class Solution {

    private int ROWS = 0;
    private int COLS = 0;

    class Island{
        int x;
        int y;
        Island(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {

        ROWS = grid.length;
        COLS = grid[0].length;

        boolean[][] visited = new boolean[ROWS][COLS];
        int count = 0;

        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(grid[i][j] == '1'){
                    if(!visited[i][j]){
                        bfs(visited, grid, i, j);
                        count++;
                    }
                }
            }
        }
        return count;
        
    }

    void bfs(boolean[][] visited, char[][] grid, int r, int c){

        Queue<Island> q = new LinkedList<>();
        Island island = new Island(r, c);
        visited[island.x][island.y] = true;
        q.add(island);

        while(!q.isEmpty()){

            Island curr = q.poll();

            List<Island> neighbours = getValidNeighbours(grid, curr.x, curr.y);

            for( Island i : neighbours ){
                if(!visited[i.x][i.y]){
                    q.add(i);
                    visited[i.x][i.y] = true;
                }
            }
        }
    }

    List<Island> getValidNeighbours(char[][] grid, int r, int c){
        
        List<Island> islands = new ArrayList<>();

        islands.add(new Island(r+1, c));
        islands.add(new Island(r-1, c));
        islands.add(new Island(r, c+1));
        islands.add(new Island(r, c-1));

        return islands.stream().filter(island -> island.x >= 0 
                                            && island.y >= 0 
                                            && island.x < grid.length 
                                            && island.y < grid[0].length
                                            && grid[island.x][island.y] == '1').collect(Collectors.toList());

    }
}
