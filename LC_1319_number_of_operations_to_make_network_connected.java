/*

There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. 
Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, 
and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

Example 1:
  Input: n = 4, connections = [[0,1],[0,2],[1,2]]
  Output: 1
  Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.

Example 2:
  Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
  Output: 2

Example 3:
  Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
  Output: -1
  Explanation: There are not enough cables.

Constraints:
  1 <= n <= 10^5
  1 <= connections.length <= min(n * (n - 1) / 2, 10^5)
  connections[i].length == 2
  0 <= ai, bi < n
  ai != bi
  There are no repeated connections.
  No two computers are connected by more than one cable.

*/

class Solution {
    int[] root;
    int extraEdges = 0;

    public int makeConnected(int n, int[][] connections) {
        root = new int[n];
        for(int i=0; i<n; i++) {
            root[i] = i;
        }    

        for(int[] connection: connections) {
            union(connection[0], connection[1]);
        }

        int components = 0;
        for(int i=0; i<n; i++) {
            if(root[i] == i) {
                components++;
            }
        }

        return extraEdges >= components-1 ? components-1 : -1;
    }

    int findParent(int i) {
        if(i == root[i]) {
            return i;
        }

        // to optimize the search next time.
        return root[i] = findParent(root[i]);
    }

    void union(int i, int j) {
        int p1 = findParent(i);
        int p2 = findParent(j);

        if(p1 == p2) {
            extraEdges++;
        } else {
            root[p1] = p2;
        }
    }
}
