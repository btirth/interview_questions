class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length-1;
        int count = 0;

        while(l<=r) {
            if(r>0 && people[r] + people[r-1] <= limit) {
                r -= 2;
            } else if(people[r] + people[l] <= limit) {
                r--;
                l++;
            } else {
                r--;
            }
            count++;
        }

        return count;
    }
}