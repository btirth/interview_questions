/*

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:
  Input: numCourses = 2, prerequisites = [[1,0]]
  Output: [0,1]
  Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:
  Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
  Output: [0,2,1,3]
  Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
  So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:
  Input: numCourses = 1, prerequisites = []
  Output: [0]
 
Constraints:
  1 <= numCourses <= 2000
  0 <= prerequisites.length <= numCourses * (numCourses - 1)
  prerequisites[i].length == 2
  0 <= ai, bi < numCourses
  ai != bi
  All the pairs [ai, bi] are distinct.

*/


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        
        for(int[] pre : prerequisites) {
            graph[pre[0]][pre[1]] = true;
        }
        
        if(detectCycle(graph)) {
            return new int[0];
        }
        
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<numCourses; i++) {
            if(visited[i] == false) {
                dfs(graph, visited, st, i);        
            }
        }
        
        int[] ans = new int[numCourses];
        int idx = numCourses-1;
        while(!st.empty()) {
            ans[idx] = st.pop();
            idx--;
        }
        return ans;
    }
    
    void dfs(boolean[][] graph, boolean[] visited, Stack<Integer> st, int idx) {
        visited[idx] = true;
        
        for(int i=0; i<graph.length; i++) {
            if(graph[idx][i] && visited[i] == false) {
                dfs(graph, visited, st, i);
            }
        }
        st.push(idx);
    }
    
    boolean detectCycle(boolean[][] graph) {
        int[] visited = new int[graph.length];
        
        for(int i=0; i<graph.length; i++) {
            if(visited[i] == 0 && graphColoring(graph, visited, i)) {
                return true;
            }
        }
        
        return false;
    }
    
    boolean graphColoring(boolean[][] graph, int[] visited, int v) {
        if(visited[v] == 1) {
            return true;
        }
        
        if(visited[v] == 2) {
            return false;
        }
        
        visited[v] = 1;
        for(int i=0; i<graph[v].length; i++) {
            if(graph[v][i] && graphColoring(graph, visited, i)) {
                return true;
            }
        }
        
        visited[v] = 2;
        return false;
    }
}
