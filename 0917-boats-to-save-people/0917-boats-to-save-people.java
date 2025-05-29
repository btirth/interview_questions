class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /**
        Binary search
        left = 1
        right = people.len

        mid
        -> Check if possible?
        -> We can take 2 people? -> Sort the array and take small and big
        
         */
        Arrays.sort(people);
        int count = 0;
        int left = 0;
        int right = people.length - 1;

        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
                count++;
            } else {
                count++;
                right--;
            }
        }

        return count;

    }

    
}