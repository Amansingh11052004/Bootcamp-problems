import java.util.LinkedList;
import java.util.Queue;

public class isLand_Perimeter {
    
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                if(!visited[i][j]){
                    ans = bfs(i, j, visited, grid);
                 }
                }
            }
        }
        return ans;
    }
    public int bfs(int i, int j, boolean[][] visited, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        
        int[][] direc = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
        };
    int total = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            for(int[] d: direc){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx<0 || nx>=n || ny<0 || ny>=m) total++;
                else if(grid[nx][ny] == 0) total++;

                else if(!visited[nx][ny]){
                  visited[nx][ny] = true;
                  q.add(new int[]{nx,ny});
                }
               
            }
        }
        return total;
    }

}
