class Solution {
    public boolean isHappy(int n) {
        List<Integer> numbers = new ArrayList<>();

        while(n != 1) {
            if(numbers.contains(n)) {
                return false;
            }
            numbers.add(n);
            int sum = 0;
            while(n > 0) {
                int val = n%10;
                n /= 10;
                sum += (val*val);
            }

            n = sum;
        }

        return true;
    }
}