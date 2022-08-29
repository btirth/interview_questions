/*

1. You are given an array(arr) of integers.
2. You have to find the element(x) with maximum frequency in the given array. 
3. Also, you have to find the smallest subarray which has all occurrences of the most frequent element i.e x.

Note -> If there are two or more elements with maximum frequency and the same subarray size then print the subarray which occurs first in the given array.

Input Format
  A number N
  arr1
  arr2.. N numbers
Output Format
  A number(x) representing the maximum frequency element in the given array.
  Two numbers representing the start and end index of the smallest subarray with all occurrences of the most frequent element.

Constraints
  1 <= N <= 10^6
  1 <= arr[i] <= 10^5

Sample Input
  8
  4 1 1 2 2 1 3 3
Sample Output
  1
  1
  5

*/

  public static void solution(int[] arr) {
        // write your code here
        int maxFreq = 1;
        int element = arr[0];
        int start = 0;
        int end = 0;
        
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        HashMap<Intege
        r, Integer> occuranceMap = new HashMap<>();
        
        
        for(int i=0; i<arr.length; i++) {
            if(!idxMap.containsKey(arr[i])) {
                idxMap.put(arr[i], i);
            }
            
            occuranceMap.put(arr[i], occuranceMap.getOrDefault(arr[i],0)+1);
            
            if(maxFreq < occuranceMap.get(arr[i])) {
                maxFreq = occuranceMap.get(arr[i]);
                element = arr[i];
                start = idxMap.get(arr[i]);
                end = i;
            } else if(maxFreq == occuranceMap.get(arr[i])) {
                
                if(end-start > i-idxMap.get(arr[i])) {
                    
                    element = arr[i];
                    start = idxMap.get(arr[i]);
                    end = i;
                } else if(end-start == i-idxMap.get(arr[i]) && start > idxMap.get(arr[i])) {
                   
                    element = arr[i];
                    start = idxMap.get(arr[i]);
                    end = i;
                }
            }
        }
        
        System.out.println(element);
        System.out.println(start);
        System.out.println(end);
  
    }
