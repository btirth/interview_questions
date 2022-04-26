/*

You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

Example 1:
  Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
  Output: 20
  Explanation: We can connect the points as shown above to get the minimum cost of 20. Notice that there is a unique path between every pair of points.

Example 2:
  Input: points = [[3,12],[-2,5],[-4,1]]
  Output: 18

Constraints:
  1 <= points.length <= 1000
  -10^6 <= xi, yi <= 10^6
  All pairs (xi, yi) are distinct.

*/



//Djikstra's algorithm
class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] visited=new boolean[points.length];
        Node[] nodes=new Node[points.length];
        int ans=0;
        for(int i=0;i<points.length;i++){
            int[] point=points[i];
            nodes[i]=new Node(point[0], point[1], Integer.MAX_VALUE);
        }
        nodes[0].dist=0;
        
        int numNodes=points.length;
        while(numNodes>0){
            numNodes--;
            int minIndex=findNextNode(nodes, visited);
            ans+=nodes[minIndex].dist;
            visited[minIndex]=true;
            updateDistToAllNodes(nodes, minIndex, visited);
        }
        return ans;
    }
    
    public void updateDistToAllNodes(Node[] nodes, int index, boolean[] visited){
        int x=nodes[index].x;
        int y=nodes[index].y;
        for(int i=0;i<nodes.length;i++){
            if(!visited[i]){
                int newDist=Math.abs(nodes[i].x-x)+Math.abs(nodes[i].y-y);
                nodes[i].dist=Math.min(nodes[i].dist, newDist);
            }
        }
    }
    
    public int findNextNode(Node[] nodes, boolean[] visited){
        int min=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<nodes.length;i++){
            if(nodes[i].dist<min && !visited[i]){
                min=nodes[i].dist;
                ans=i;
            }
        }
        return ans;
    }
    
    class Node{
        int x, y;
        int dist;
        Node(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
}
