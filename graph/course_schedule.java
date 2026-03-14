class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
  
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            adj.get(prereq).add(course); 
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }

  
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int next : adj.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }


        return count == numCourses;
    }
}

