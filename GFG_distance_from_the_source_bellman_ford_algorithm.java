/*

Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.
 

Example 1:
  Input:

  S = 0
  Output:
  0 9
  Explanation:
  Shortest distance of all nodes from source is printed.

Example 2:
  Input:

  S = 2
  Output:
  1 6 0
  Explanation:
  For nodes 2 to 0, we can follow the path-2-0. This has a distance of 1. For nodes 2 to 1, we cam follow the path-2-0-1, which has a distance of 1+5 = 6,
 
Your Task:
You don't need to read input or print anything. Your task is to complete the function bellman_ford()  which takes number of vertices V and an E sized list of lists of three integers where the three integers are u,v, and w; denoting there's an edge from u to v, which has a weight of w as input parameters and returns a list of integers where the ith integer denotes the distance of ith node from source node. If some node isn't possible to visit, then it's distance should be 100000000(1e8).

Expected Time Complexity: O(V*E).
Expected Auxiliary Space: O(V).

Constraints:
  1 ≤ V ≤ 500
  1 ≤ E ≤ V*(V-1)
  -1000 ≤ adj[i][j] ≤ 1000
  0 ≤ S < V

*/


class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        int E = adj.size();
        int[][] graph = new int[E][3];
        
        for(int i=0; i<E; i++) {
            ArrayList<Integer> ver = adj.get(i);
            graph[i][0] = ver.get(0);
            graph[i][1] = ver.get(1);
            graph[i][2] = ver.get(2);
        }
        
       int []dist = new int[V];
       Arrays.fill(dist, 100000000);
     
        dist[S] = 0;
        for (int i = 0; i < V - 1; i++)
        {
            for (int j = 0; j < E; j++)
            {
                if (dist[graph[j][0]] != 100000000 && dist[graph[j][0]] + graph[j][2] < dist[graph[j][1]])
                    dist[graph[j][1]] = dist[graph[j][0]] + graph[j][2];
            }
        }
        return dist;
    }
}
