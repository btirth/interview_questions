/*

Inversion Count

For a given integer array/list of size N, find the total number of 'Inversions' that may exist.
An inversion is defined for a pair of integers in the array/list when the following two conditions are met.
A pair (arr[i], arr[j]) is said to be an inversion when,
1. arr[i] > arr[j] 
2. i < j

Where 'arr' is the input array/list, 'i' and 'j' denote the indices ranging from [0, N).
Input format :
The first line of input contains an integer N, denoting the size of the array.

The second line of input contains N integers separated by a single space, denoting the elements of the array.
Output format :
The only line of output prints the total count of inversions in the array.
Note:
You are not required to print anything. Return the total number of inversion count.
Constraints :
1 <= N <= 10^5 
1 <= arr[i] <= 10^9

Time Limit: 1sec
Sample Input 1 :
3
3 2 1
Sample Output 1 :
3
Explanation of Sample Input 1:
We have a total of three pairs which satisfy the condition of inversion. (3, 2), (2, 1) and (3, 1).
Sample Input 2 :
5
2 5 1 3 4
Sample Output 2 :
4

@csalgoe Output 2 :
4

*/


public class HelloWorld{
    
    public static int inversion(int[] arr, int start, int end) {
        if(start >= end) {
            return 0;
        }
        int count = 0;
        int mid = (start+end)/2;
        count+=inversion(arr, start, mid);
        count+=inversion(arr, mid+1, end);
        
        
        for(int i=start; i<=mid; i++) {
            for(int j=mid+1; j<=end; j++) {
                if(arr[i] > arr[j]) {
                    count += 1;
                }
            }
        }
        
        return count;
    }
        
     public static void main(String []args){
        System.out.println("Hello World");
        int[] arr = {2,5,1,3,4};
        int inv = inversion(arr, 0, arr.length-1);
        System.out.println(inv);
     }
}