import java.util.*;
 
public class fox_2_dot_bfs {
    
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
 
    static class pair {
        int x, y, px, py;
        pair(int x, int y, int px, int py) {
            this.x = x;
            this.y = y;
            this.px = px;
            this.py = py;
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
 
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }
 
        visited = new boolean[n][m];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j, grid[i][j])) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }
 
    static boolean bfs(int sx, int sy, char color) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(sx, sy, -1, -1));
        visited[sx][sy] = true;
 
        while (!q.isEmpty()) {
            pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
 
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
 
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (grid[nx][ny] != color) continue;
 
                if (visited[nx][ny]) {
                    
                    if (!(curr.px == nx && curr.py == ny)) 
                        return true;
                } else {
                    visited[nx][ny] = true;
                    q.add(new pair(nx, ny, x, y));
                }
            }
        }
        return false;
    }
}