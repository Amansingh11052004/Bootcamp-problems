class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] direc = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int[] d : direc){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx>=0 && ny >= 0 && nx<n && ny<m && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return distance;
    }
}