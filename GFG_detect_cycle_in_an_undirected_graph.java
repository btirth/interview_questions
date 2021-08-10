/*

Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Example 1:
  Input:   
  Output: 1
  Explanation: 1->2->3->4->1 is a cycle.

Example 2:
  Input: 
  Output: 0
  Explanation: No cycle in the graph.

Your Task:
  You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not.
 
Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)
 
Constraints:
  1 ≤ V, E ≤ 105

*/



class Solution
{
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                if(dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(int idx, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[idx] = true;
        ArrayList<Integer> child = adj.get(idx);
        for(int i=0; i<child.size(); i++) {
            if(!visited[child.get(i)]) {
                if(dfs(child.get(i), idx, adj, visited)) {
                    return true;
                }    
            } else if(child.get(i) != parent) {
                return true;
            }
            
        }
        
        return false;
    }
}
