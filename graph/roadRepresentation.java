import java.util.*;
 
public class roadRepresentation {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int V = sc.nextInt();
        int E = sc.nextInt();
 
        int[][] edges = new int[E][3];
 
        for(int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
 
        long ans = road(V, edges);
        if(ans == -1){
            System.out.println("IMPOSSIBLE");
        }
        else{
        System.out.println(ans);
        }
 
    }
    public static long road(int V, int[][] edges) {
 
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<>());
        }
 
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
 
            graph.get(u).add(new int[]{v, wt});
            graph.get(v).add(new int[]{u, wt});
        }
 
        boolean[] visited = new boolean[V+1];
        long mst = 0;
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
 
        pq.add(new int[]{1, 0});
 
        while(!pq.isEmpty()) {
 
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            if(visited[node]) continue;
            mst += cost;
            count++;
            visited[node] = true;
 
            for(int[] next : graph.get(node)) {
 
                int child = next[0];
                int wt = next[1];
 
                if(!visited[child]) {
                    pq.add(new int[]{child, wt});
                }
            }
        }
        if(count != V) return -1;
        return mst;
        
    }
}
 
