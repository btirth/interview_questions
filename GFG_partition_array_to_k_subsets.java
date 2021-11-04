/*

Given an integer array a[ ] of N elements and an integer K, the task is to check if the array a[ ] could be divided into K non-empty subsets with equal sum of elements.
Note: All elements of this array should be part of exactly one partition.

Example 1:
  Input: 
  N = 5
  a[] = {2,1,4,5,6}
  K = 3
  Output: 
  1
  Explanation: we can divide above array 
  into 3 parts with equal sum as (2, 4), 
  (1, 5), (6)

Example 2:
  Input: 
  N = 5 
  a[] = {2,1,5,5,6}
  K = 3
  Output: 
  0
  Explanation: It is not possible to divide
  above array into 3 parts with equal sum.

Your Task:
You don't need to read input or print anything. Your task is to complete the function isKPartitionPossible() which takes the array a[], the size of the array N, and the value of K as inputs and returns true(same as 1) if possible, otherwise false(same as 0).

Expected Time Complexity: O(N*2N).
Expected Auxiliary Space: O(2N).

Constraints:
  1 ≤ K ≤ N ≤ 10
  1 ≤ a[i] ≤ 100

*/


class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here	
	    if(k == 1) {
	        return true;
	    }
	    int totalSum = 0;
	    for(int i: a) {
	        totalSum += i;
	    }
	    
	    if(k>n || totalSum % k != 0) {
	        return false;
	    }
	    helper(a, n, k, 0, new int[k], 0);
	    return partitionPossible;
    }
    
    boolean partitionPossible = false;
    void helper(int[] a, int n, int k, int idx, int[] sum, int nonEmptySets) {
        if(partitionPossible) {
            return;
        }
        
        if(idx == n) {
            if(nonEmptySets == k) {
                boolean flag = true;
                for(int i=1; i<k; i++) {
                    if(sum[i] != sum[i-1]) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    partitionPossible = true;
                }
            }
            return;
        }
        
        for(int i=0; i<k; i++) {
            if(i < nonEmptySets) {
                sum[i] += a[idx];
                helper(a, n, k, idx+1, sum, nonEmptySets);
                sum[i] -= a[idx];
            } else {
                sum[i] += a[idx];
                helper(a, n, k, idx+1, sum, nonEmptySets+1);
                sum[i] -= a[idx];
                break;
            }
        }
        
        return;
    }
}
