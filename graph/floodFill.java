class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
       
        int original = image[sr][sc];
        
        if(original == color) return image;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        visited[sr][sc] = true;
        image[sr][sc] = color;

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

              if(nx>=0 && ny>=0 && nx<n && ny<m && image[nx][ny] == original && !visited[nx][ny]){
                visited[nx][ny] = true;
                image[nx][ny] = color;
                 q.add(new int[]{nx, ny});
              }
            }
        }
        return image;
    }
}