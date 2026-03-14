import java.util.*;
public class party{
    static List<List<Integer>> graph = new ArrayList<>();
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] boss = new int[n];
        List<Integer> roots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boss[i] = sc.nextInt();
 
            if(boss[i] == -1){
                roots.add(i);
            }
            else{
                graph.get(boss[i] - 1).add(i);
            }
        }
        int maxDepth = 1;
        for(int root : roots){
            maxDepth = Math.max(maxDepth, dfs(root));
        }
        System.out.println(maxDepth);
    }
    static int dfs(int node){
        int depth = 1;
        for(int child : graph.get(node)){
            depth = Math.max(depth, 1 + dfs(child));
        }
        return depth;
    }
}