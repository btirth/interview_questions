class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int max = -1;

        for(int num: nums) {
            int sum = getDigitSum(num);
            if(sumMap.containsKey(sum)) {
                int val = sumMap.get(sum);
                max = Math.max(val+num, max);
                num = Math.max(num, val);
            }

            sumMap.put(sum, num);
        }

        return max;
    }

    int getDigitSum(int num) {
        int sum = 0;

        while(num > 0) {
            int digit = num%10;
            num /= 10;
            sum += digit;
        }

        return sum;
    }
}