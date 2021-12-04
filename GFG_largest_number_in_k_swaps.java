/*

Given a number K and string str of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of str at most K times.

Example 1:
  Input:
    K = 4
    str = "1234567"
  Output:
  7654321
  Explanation: Three swaps can make the input 1234567 to 7654321, swapping 1 with 7, 2 with 6 and finally 3 with 5

Example 2:
  Input:
  K = 3
  str = "3435335"
  Output:
  5543333
  Explanation: Three swaps can make the input 3435335 to 5543333, swapping 3 with 5, 4 with 5 and finally 3 with 4 

Your task:
You don't have to read input or print anything. Your task is to complete the function findMaximumNum() which takes the string and an integer as input and returns a string containing the largest number formed by perfoming the swap operation at most k times.

Expected Time Complexity: O(n!/(n-k)!) , where n = length of input string
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ |str| ≤ 30
1 ≤ K ≤ 10

*/


class Solution
{
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
        {
            //code here.
            int n = str.length();
            max = str.toCharArray();
            helper(str.toCharArray(), k, 0);
            return new String(max);
        }
        
    static char[] max;
    public static void helper(char[] ch, int k, int swap) {
        if(swap == k) {
            return;
        }
        
        for(int i=0; i<ch.length; i++) {
            for(int j=i+1; j<ch.length; j++) {
                if(Integer.valueOf(ch[i]) < Integer.valueOf(ch[j])) {
                    swap(ch, i, j);
                    check(ch);
                    helper(ch, k, swap+1);
                    swap(ch, i, j);
                }
            }
        }
    }
    
    public static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    
    private static void check(char[] arr) {
        int i = 0, n = arr.length;
        while(i < n && arr[i] == max[i]) {
            ++i;
        }
        
        if(i < n && arr[i] > max[i]) {
            while(i < n) max[i] = arr[i++];
        }
    }
    
}
