/*

1. You are given an array(arr) which contains only 0's and 1's.
2. You have to find the maximum number of consecutive 1's in the given array if you can flip at most one zero.

Input Format
  A number N
  arr1
  arr2... N numbers
Output Format
  A number representing maximum number of consecutive 1's after flipping at most one zero.

Constraints
  1 <= N <= 10^5
  0 <= arr[i] <= 1
  
Sample Input
  6
  1 1 0 0 1 1
Sample Output
  3

*/


import java.util.*;

public class Main {

    public static int solution(int[] arr){
        // write your code here
        int ans = 0;
        int count = 0;
        int j=0;
        boolean containsZero = false;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 1) {
                count++;
                
            } else {
                if(containsZero) {
                    while(j<i && arr[j] != 0) {
                        j++;
                        count--;
                    }
                    j++;
                } else {
                    count++;
                }
                containsZero = true;
            }
            ans = Math.max(ans, count); 
        }
        
        return ans;
    }
}
