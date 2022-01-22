/*

Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. 
If an array is sorted in the reverse order then the inversion count is the maximum. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 
Example 1:
  Input: N = 5, arr[] = {2, 4, 1, 3, 5}
  Output: 3
  Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

Example 2:
  Input: N = 5
  arr[] = {2, 3, 4, 5, 6}
  Output: 0
  Explanation: As the sequence is already sorted so there is no inversion count.

Example 3:
  Input: N = 3, arr[] = {10, 10, 10}
  Output: 0
  Explanation: As all the elements of array are same, so there is no inversion count.

Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 5*10^5
1 ≤ arr[i] ≤ 10^18

*/



class Solution
{
   // arr[]: Input Array
   // N : Size of the Array arr[]
   //Function to count inversions in the array.
   static long inversionCount(long[] arr, long N)
   {
       long ans = mergeSort(arr,0,(int)N-1);
       return ans;


   }
   
   public static long mergeSort(long[] arr, int low, int high){
       if(low>=high){
           return 0;
       }
       
       int mid = low + (high-low)/2;
       
      long l =  mergeSort(arr,low,mid);   //left sorted
       long r = mergeSort(arr,mid+1,high);    //right sorted
       
      long lr =  merge(arr,low,mid,mid+1,high);
       return l+r+lr;
   }
   
   public static long merge(long[] arr, int a1l, int a1r, int a2l, int a2r){
       long inv = 0;
       long[] res = new long[a1r-a1l+a2r-a2l+2];
       int i = a1l, j = a2l, k = 0;
       while(i<=a1r && j<=a2r){
           if(arr[i]>arr[j]){
               res[k] = arr[j];
               k++;
               j++;
               inv+=a1r-i+1;
           } else {
               res[k] = arr[i];
               i++;
               k++;
           }
       }
       
       while(i<=a1r){
           res[k] = arr[i];
           i++;
           k++;
       }
       
       while(j<=a2r){
           res[k] = arr[j];
           k++;
           j++;
       }
       
       for(int x=a1l;x<=a2r;x++){
           arr[x] = res[x-a1l];
       }
       
       return inv;
   }
}
