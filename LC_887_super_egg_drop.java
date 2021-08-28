/*

You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.

You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.

Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.

Return the minimum number of moves that you need to determine with certainty what the value of f is.

Example 1:
  Input: k = 1, n = 2
  Output: 2
  Explanation: 
  Drop the egg from floor 1. If it breaks, we know that f = 0. Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1. If it does not break, then we know f = 2.
  Hence, we need at minimum 2 moves to determine with certainty what the value of f is.

Example 2:
  Input: k = 2, n = 6
  Output: 3

Example 3:
  Input: k = 3, n = 14
  Output: 4

Constraints:
  1 <= k <= 100
  1 <= n <= 10^4

*/



class Solution {
    int[][] dp = new int[101][10001];
    
    public  int superEggDrop(int k, int n) {
       
        for(int i=0;i<101;i++){
            for(int j=0;j<10001;j++){
                dp[i][j]=-1;
            }
        }
        return helper( k,  n);
    }
        
    
    public int helper(int k, int n){
        
        if(n==0 || n==1){
            return n;
        }
        
        if(k==1){
            return n;
        }
        
        if(dp[k][n]!=-1){
            return dp[k][n];
        }
        
        int min= Integer.MAX_VALUE;
        int low=1,high=n;
        
        while(low <= high)
        {
            int mid=(low + high) / 2;
            int down=helper(k-1,mid-1);   
            int up=helper(k,n-mid) ;   
            int temp=1+Math.max(down,up);          
            if(down<up){                 
              low = mid+1;                       
            }
            else                             
            {    
                high = mid-1;
            }
            min = Math.min(min,temp);              
        }
        
          return dp[k][n]=min;  
        
    }
}
