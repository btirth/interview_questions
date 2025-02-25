class Solution {
    public int numOfSubarrays(int[] arr) {
        /**
        Can I say that if number of odd values in array are odd that's good array -> Yes

        Can I do prefix sum to count odd values? -> Yes

        [1,3,5] -> [1,2,3]
        At start -> evenNumber = 1, oddNumber = 0
        1 -> [1] -> evenNumber = 1, oddNumber = 1
        3 will say I am odd so I need number of sub arrays with even number of odd values
            which are 0 so nothing but 1
            3 is odd so evenNumber = 1 + oddNumber = 2, oddNumber = 1 + evenNumber = 2
        5 -> I am odd I need sub array with even number of odd values
            even = even + odd = 4, odd = odd + even = 4

        
        for i in (0, n-1):
            if(arr[i]%2 == 0) {
                continue;
            }

            int temp = evenNumber;
            evenNumber += oddNumber;
            oddNumber += evenNumber;

        return oddNumber;    


        [1,2,3,4]   
        even = 1;
        [1] = 1 [even=1, odd = 1]
        [2]    = 2   [even=2, odd = 1]
        [1,2] = 3 [even=2, odd=2]
        [3] = 3 [even=2, odd=3]
        [2,3] = 5 [even=2, odd=4]
        [1,2,3]  = 6 [even=3, odd=4]
        [4] = 4 [even=4, odd=4]
        [3,4] = 7 [even=4, odd=5]
        [2,3,4] = 9 [even=4, odd=6]
        [1,2,3,4] = 10 [even=5, odd=6]
        [5] = 5 [even=5, odd=7]
        [4,5] = 9  [even=5, odd=8]
        [3,4,5] = 12 [even=6, odd=8]
        [2,3,4,5] = 14 [even=7, odd=8]
        [1,2,3,4,5] = 15 [even=7, odd=9]

        1 -> [even=0, odd=1]
        2 -> [even = 1 + even, odd = odd] = [1,1]
        3 -> [even = odd, odd = 1 + even] = [1,2]
        4 -> [even= 1 + even, odd=odd] = [2,2]
        5 -> [even= odd, odd=1 + even] = [2,3]

        1 + 1 + 2 + 2 + 4 = 10
         */

        int n = arr.length;
        int evenSumArrays = 0;
        int oddSumArrays = 0;
        int ans = 0;
        int mod = 1000_000_007;
        for(int num: arr) {
            if(num % 2 == 0) {
                evenSumArrays += 1;
            } else {
                int temp = evenSumArrays;
                evenSumArrays = oddSumArrays;
                oddSumArrays = 1 + temp;
            }

            ans = (ans + oddSumArrays)%mod;
        }

        return ans; 
    }
}