class Solution {
    public int maxDiff(int num) {
        int firstNon9Digit = -1;
        int firstNon0Digit = -1;
        int secondNon0Digit = -1;
        int temp = num;
        while(temp > 0) {
            int digit = temp % 10;
            temp /= 10;

            if(digit != 9) {
                firstNon9Digit = digit;
            }

            if(digit != 0 && firstNon0Digit != digit) {
                secondNon0Digit = firstNon0Digit;
                firstNon0Digit = digit;
            }
        }

        int max = replace(num, firstNon9Digit, 9);
        int min = replace(num, secondNon0Digit, 0);
        min = min == 0 ? Integer.MAX_VALUE : min;
        
        min = Math.min(min, replace(num, firstNon0Digit, 1));
        
        return max - min;
    }

    int replace(int num, int oldDigit, int newDigit) {
        int temp = num;
        StringBuilder replacedNum = new StringBuilder("");

        while(temp > 0) {
            int digit = temp % 10;
            temp /= 10;
            if(digit == oldDigit) {
                digit = newDigit;
            }

            replacedNum.append(digit);
        }

        return Integer.valueOf(replacedNum.reverse().toString());
    }
}