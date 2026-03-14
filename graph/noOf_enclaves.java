class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        visited[i][j] = true;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }

        int[][] direc = {
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int[] d : direc){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && 
                   grid[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

     
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]) count++;
            }
        }

        return count;
    }
}
