import java.util.LinkedList;
import java.util.Queue;

public class maxAreaOIsland {
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxArea = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    if(!visited[i][j]){
                        maxArea = Math.max(maxArea, bfs(i,j,visited, grid));
                        }
                    }
                }
            }
        
       return maxArea;
    }
    public int bfs(int i, int j, boolean[][] visited, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
       int area = 0;
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
            area++;
            for(int[] d: direc){
                int nx = x + d[0];
                int ny = y + d[1];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && grid[nx][ny] == 1){
                  visited[nx][ny] = true;
                  q.add(new int[]{nx,ny});
                
                }
            }
        }
        return area;
    }

}
