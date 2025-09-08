class Solution {
    public int[] getNoZeroIntegers(int n) {
        int first = 1;

        while(first <= n/2) {
            boolean firstContains = containsZero(first);
            boolean secondContains = containsZero(n - first);

            if(!firstContains && !secondContains) {
                break;
            }

            first++;
        }

        return new int[]{first, n - first};
    }

    boolean containsZero(int n) {
        while(n > 0) {
            int digit = n % 10;
            System.out.println(digit);
            if(digit == 0) {
                return true;
            }

            n = n / 10;
        }

        return false;
    }
}