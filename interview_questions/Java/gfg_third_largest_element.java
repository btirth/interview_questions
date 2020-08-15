/*

Given an array of distinct elements. Find the third largest element in it. 

Example 1:
    Input:
    N = 5
    A[] = {2,4,1,3,5}
    Output: 3

Example 2:
    Input:
    N = 2
    A[] = {10,2}
    Output: -1

Your Task:
    Complete the function thirdLargest() which takes the array a[] and the size of the array, n, as input parameters 
    and returns the third largest element in the array. It return -1 if there are less than 3 elements in the given array.

*/


class GfG
{
    int thirdLargest(int a[], int n)
    {
	    // Your code here
	    if(n<3) {
	        return -1;
	    }
	    int[] maX = {0,0,a[0]};
        
     
        for(int i=1; i<n; i++) {
            if(a[i]>maX[2]) {
                maX[0] = maX[1];
                maX[1] = maX[2];
                maX[2] = a[i];
                 
            } else if(a[i]>maX[1]) {
                maX[0] = maX[1];
                maX[1] = a[i];
            } else if(a[i]>maX[0]) {
                maX[0] = a[i];
            }
        }
         
        return maX[0];
    }
}