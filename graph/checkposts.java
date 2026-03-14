import java.util.*;

public class checkposts {

    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] cost = new long[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextLong();
        }

        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;  
            int v = sc.nextInt() - 1;

            adj.get(u).add(v);
            graph.get(v).add(u);  
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs1(i, stack, visited, adj);
            }
        }

        Arrays.fill(visited, false);

        long totalMinCost = 0;
        long ways = 1;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) { 
                List<Integer> component = new ArrayList<>();
                dfs2(node, visited, graph, component);

                long min = Long.MAX_VALUE;
                for (int v : component) {
                    min = Math.min(min, cost[v]);
                }

                long count = 0;
                for (int v : component) {
                    if (cost[v] == min) count++;
                }

                totalMinCost += min;
                ways = (ways * count) % MOD;
            }
        }

        System.out.println(totalMinCost + " " + ways);
    }

    static void dfs1(int node, Stack<Integer> stack,
                     boolean[] visited, List<List<Integer>> adj) {

        visited[node] = true;

        for (int next : adj.get(node)) {
            if (!visited[next]) {
                dfs1(next, stack, visited, adj);
            }
        }

        stack.push(node); 
    }

    static void dfs2(int node, boolean[] visited,
                     List<List<Integer>> graph,
                     List<Integer> component) {

        visited[node] = true;
        component.add(node);

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs2(next, visited, graph, component);
            }
        }
    }
}