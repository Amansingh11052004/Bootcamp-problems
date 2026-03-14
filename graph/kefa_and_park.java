import java.util.*;

public class kefa_and_park{

    static List<List<Integer>> graph = new ArrayList<>();
    static int n, m;
    static int[] cats;
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        cats = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            cats[i] = sc.nextInt();
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1, 0);
        System.out.println(ans);
    }

    static void dfs(int node, int consecutive) {
        visited[node] = true;

        if (cats[node] == 1) consecutive++;
        else consecutive = 0;

        if (consecutive > m) return;

        boolean isLeaf = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                isLeaf = false;
                dfs(child, consecutive);
            }
        }

        if (isLeaf) ans++;
    }
}