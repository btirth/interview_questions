/*

Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.

Note: The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.

Example 1:
  Input:
    N=6
    knightPos[ ] = {4, 5}
    targetPos[ ] = {1, 1}
  Output: 3
  Explanation: Knight takes 3 step to reach from (4, 5) to (1, 1): (4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
 
Your Task:
  You don't need to read input or print anything. Your task is to complete the function minStepToReachTarget() which takes the inital position of Knight (KnightPos), the target position of Knight (TargetPos) and the size of the chess board (N) as an input parameters and returns the minimum number of steps required by the knight to reach from its current position to the given target position.

Expected Time Complexity: O(N^2).
Expected Auxiliary Space: O(N^2).

Constraints:
1 <= N <= 1000
1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N

*/


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        Queue<int[]> q = new LinkedList<>();
        KnightPos[0] = KnightPos[0] - 1;
        KnightPos[1] = KnightPos[1] - 1;
        
        TargetPos[0] = TargetPos[0] - 1;
        TargetPos[1] = TargetPos[1] - 1;
        q.add(KnightPos);
        int count = 0;
        int[][] visited = new int[N][N];
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                visited[i][j] = -1;
            }
        }
        
        visited[KnightPos[0]][KnightPos[1]] = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] curr = q.poll();
                int[] nextPos = new int[2];
                
                for(int i=0; i<8; i++) {
                    nextPos[0] = curr[0] + dx[i];
                    nextPos[1] = curr[1] + dy[i];
                    
                    if(nextPos[0] >= 0 && nextPos[1] >= 0 && nextPos[1] < N && nextPos[0] < N) {
                        if(visited[nextPos[0]][nextPos[1]] == -1) {
                            visited[nextPos[0]][nextPos[1]] = visited[curr[0]][curr[1]];
                            q.add(nextPos);    
                        }
                    }
                    
                    if(nextPos[0] == TargetPos[0] && nextPos[1] == TargetPos[1]) {
                        return visited[nextPos[0]][nextPos[1]];
                    }
                }
            }
            count++;
        }
        
        return count;
    }
}
