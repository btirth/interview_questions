/*

Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.

Example 1:
  Input : 
    N = 5
    A[] = {-8, 2, 3, -6, 10}
    K = 2
  Output : -8 0 -6 -6
  Explanation :
    First negative integer for each window of size k {-8, 2} = -8
    {2, 3} = 0 (does not contain a negative integer)
    {3, -6} = -6
    {-6, 10} = -6
 
Example 2:
  Input : 
    N = 8
    A[] = {12, -1, -7, 8, -15, 30, 16, 28}
    K = 3
  Output : -1 -1 -7 -15 -15 0 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function printFirstNegativeInteger() which takes the array A[], its size N and an integer K 
as inputs and returns the first negative number in every window of size K starting from the first till the end. If a window does not contain a negative integer , then return 0 for that window.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K)

Constraints:
1 <= N <= 10^5
-10^5 <= A[i] <= 10^5
1 <= K <= N

*/


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        ArrayList<Long> ansList = new ArrayList<>();
        Queue<Long> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            if(i < K-1) {
                if(A[i] < 0) {
                    q.add(A[i]);
                }
            } else {
                if(!q.isEmpty() && i>=K && q.peek() == A[i-K]) {
                    q.poll();
                }
                if(A[i] < 0) {
                    q.add(A[i]);
                }
                
                if(q.isEmpty()) {
                    ansList.add((long)0);
                } else {
                    ansList.add(q.peek());
                }
            }
        }
        
        long[] ans = new long[ansList.size()];
        for(int i=0; i<ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        
        return ans;
    }
}
