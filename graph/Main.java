import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;

    static int[] bfs(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph.get(curr)) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    q.add(next);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] dist1 = bfs(1, n); 
        int[] distx = bfs(x, n); 

        int maxSafe = 0;

        for (int i = 1; i <= n; i++) {
            if (distx[i] < dist1[i]) {   
                maxSafe = Math.max(maxSafe, dist1[i]); 
            }
        }

        System.out.println(2 * maxSafe);
    }
}