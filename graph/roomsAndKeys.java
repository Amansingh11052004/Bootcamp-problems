import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class roomsAndKeys {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        bfs(0, rooms, visited);
        for(boolean v : visited){
            if(!v) return false;
        }
    return true;
    } 
    public void bfs(int start, List<List<Integer>> rooms, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next: rooms.get(curr)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}

