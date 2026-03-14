import java.util.*;

public class cyclic_component {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

       
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                if(bfs(i)){
                    count++;
                }
            }
        }
    System.out.println(count);
    }
    static boolean bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);
         
        boolean isCycle = true;
        while(!q.isEmpty()){
        int curr = q.poll();
        
       if(graph.get(curr).size() != 2){
        isCycle = false;
       }

        for(int child : graph.get(curr)){
            if(!visited[child]){
                visited[child] = true;
                q.add(child);
            }
        }
    }
    return isCycle;
    }
}