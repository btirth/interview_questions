/*

Given a weighted, undirected and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.

Example 1:
  Input:
    S = 0
  Output:
    0 9
  Explanation:
    The source vertex is 0. Hence, the shortest distance of node 0 is 0 and the shortest distance from node 9 is 9 - 0 = 9.

Example 2:
  Input:
    S = 2
  Output:
    4 3 0
  Explanation:
    For nodes 2 to 0, we can follow the path- 2-1-0. This has a distance of 1+3 = 4, whereas the path 2-0 has a distance of 6. So, the Shortest path from 2 to 0 is 4. The other distances are pretty straight-forward.
 
Your Task:
  You don't need to read input or print anything. Your task is to complete the function dijkstra()  which takes number of vertices V and an adjacency list adj as input parameters and returns a list of integers,
  where ith integer denotes the shortest distance of the ith node from Source node. Here adj[i] contains a list of lists containing two integers where the first integer j denotes that there is an edge between i and j and second integer w denotes that the weight between edge i and j is w.

Expected Time Complexity: O(V^2).
Expected Auxiliary Space: O(V^2).

Constraints:
  1 ≤ V ≤ 1000
  0 ≤ adj[i][j] ≤ 1000
  0 ≤ S < V

*/

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int V;
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        V = v; 
        int[][] graph = new int[V][V];
        for(int i=0; i<V; i++) {
            ArrayList<ArrayList<Integer>> n = adj.get(i);
            for(ArrayList<Integer> vertex : n) {
                graph[i][vertex.get(0)] = vertex.get(1);
            }
        }
        
        return dijkstra(graph, S);
    }
    
    static int[] dijkstra(int[][] graph, int S) {
        boolean[] visited = new boolean[V];
        int[] w = new int[V];
        Arrays.fill(w, Integer.MAX_VALUE);
        w[S] = 0;
        
        for(int i=0; i<V-1; i++) {
            int idx = minDistance(visited, w);
            visited[idx] = true;
            
            for(int v=0; v<V; v++) {
                if(!visited[v] && graph[idx][v] != 0 && w[idx] != Integer.MAX_VALUE) {
                    w[v] = Math.min(w[v], w[idx]+graph[idx][v]);
                }
            }
            
        }

        return w;
    }
    
    static int minDistance(boolean[] visited, int[] dist) {
        int minDist = Integer.MAX_VALUE;
        int minIdx = -1;
        
        for(int i=0; i<V; i++) {
            if(visited[i] == false && dist[i] < minDist) {
                minIdx = i;
                minDist = dist[i];
            }
        }
        
        return minIdx;
    }
}

