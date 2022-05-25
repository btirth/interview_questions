/*

You are given a 2D integer array stockPrices where stockPrices[i] = [dayi, pricei] indicates the price of the stock on day dayi is pricei. 
A line chart is created from the array by plotting the points on an XY plane with the X-axis representing the day and the Y-axis representing the price and connecting adjacent points. 

Return the minimum number of lines needed to represent the line chart.

Example 1:
  Input: stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
  Output: 3
  Explanation:
    The diagram above represents the input, with the X-axis representing the day and Y-axis representing the price.
    The following 3 lines can be drawn to represent the line chart:
    - Line 1 (in red) from (1,7) to (4,4) passing through (1,7), (2,6), (3,5), and (4,4).
    - Line 2 (in blue) from (4,4) to (5,4).
    - Line 3 (in green) from (5,4) to (8,1) passing through (5,4), (6,3), (7,2), and (8,1).
    It can be shown that it is not possible to represent the line chart using less than 3 lines.

Example 2:
  Input: stockPrices = [[3,4],[1,2],[7,8],[2,3]]
  Output: 1
  Explanation: As shown in the diagram above, the line chart can be represented with a single line.
 
Constraints:
  1 <= stockPrices.length <= 10^5
  stockPrices[i].length == 2
  1 <= dayi, pricei <= 10^9
  All dayi are distinct.

*/


class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if(n == 0 || n == 1) {
            return 0;
        }
        
        java.util.Arrays.sort(stockPrices, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int[] prev1 = stockPrices[0];
        int[] prev2 = stockPrices[1];
        int count = 1;
        
        for(int i=2; i<n; i++) {
            if(!onSameLine(prev1, prev2, stockPrices[i])) {
                count++;
                
            } 
            prev1 = prev2;
            prev2 = stockPrices[i];
        }
        
        return count;
    }
    
    boolean onSameLine(int[] a, int[] b, int[] c) {
        return (b[1]-a[1]) * (c[0]-a[0]) - (b[0]-a[0]) * (c[1]-a[1]) == 0;
    }
}
