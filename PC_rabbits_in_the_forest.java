/*

1. There are some rabbits in the forest and each rabbit has some color.
2. Some(possibly all) rabbits are selected from them and they tell you about the number of other rabbits having the same color as them.
3. You are given an array(arr) that contains the answers of all selected rabbits.
4. You have to find the minimum number of rabbits that could be in the forest.

Input Format
  A number N
  arr1
  arr2.. N numbers
Output Format
  A number representing the minimum number of rabbits in the forest.

Constraints
  1 <= N <= 1000
  0 <= arr[i] <= 1000
  
Sample Input
  5
  1 0 1 0 0
Sample Output
  5

*/

  public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val: arr) {
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        
        int count = 0;
        for(int key: map.keySet()) {
            int gs = key+1;
            int value = map.get(key);
            int ng = (int)Math.ceil(value*1.0/gs*1.0);
            count += ng*gs;
        }
        return count;
    }
