/*

Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
 

Example 1:

Input:

Output:
3
Explanation:
  We can clearly see that there are 3 Strongly Connected Components in the Graph

Example 2:
  Input:

  Output:
  1
  Explanation:
  All of the nodes are connected to each other. So, there's only one SCC.

Your Task:
  You don't need to read input or print anything. Your task is to complete the function kosaraju() which takes the number of vertices V and adjacency list of the graph as
  inputs and returns an integer denoting the number of strongly connected components in the given graph.
 
Expected Time Complexity: O(V+E).
Expected Auxiliary Space: O(V).
 
Constraints:
  1 ≤ V ≤ 5000
  0 ≤ E ≤ (V*(V-1))
  0 ≤ u, v ≤ N-1
  Sum of E over all testcases will not exceed 25*10^6

*/



class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[][] graph = new boolean[V][V];
        
        for(int i=0; i<V; i++) {
            ArrayList<Integer> v = adj.get(i);
            for(int a : v) {
                graph[i][a] = true;
            }
        }
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) {
            if(visited[i] == false) {
                dfs(V, graph, visited, st, i);
            }
        }
        
        graph = new boolean[V][V];
        for(int i=0; i<V; i++) {
            ArrayList<Integer> v = adj.get(i);
            for(int a : v) {
                graph[a][i] = true;
            }
        }
        
        Arrays.fill(visited, false);
        int scc = 0;
        
        while(!st.empty()) {
            int idx = st.pop();
            if(visited[idx] == false) {
                reverseDFS(V, graph, visited, idx);
                scc++;
            }
            
        }
        
        return scc;
    }
    
    void dfs(int V, boolean[][] graph, boolean[] visited, Stack<Integer> st, int idx) {
        visited[idx] = true;
        for(int i=0; i<V; i++) {
            if(visited[i] == false && graph[idx][i]) {
                dfs(V, graph, visited, st, i);
            }
        }
        
        st.push(idx);
    }
    
    void reverseDFS(int V, boolean[][] graph, boolean[] visited, int idx) {
        visited[idx] = true;
        for(int i=0; i<V; i++) {
            if(visited[i] == false && graph[idx][i]) {
                reverseDFS(V, graph, visited, i);
            }
        }
    }
}
