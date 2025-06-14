class Solution {
    public int minMaxDifference(int num) {
        int firstNon9Digit = -1;
        int firstNon0Digit = -1;
        int temp = num;
        while(temp > 0) {
            int digit = temp % 10;
            temp /= 10;

            if(digit != 9) {
                firstNon9Digit = digit;
            }

            if(digit != 0) {
                firstNon0Digit = digit;
            }
        }

        int max = replace(num, firstNon9Digit, 9);
        int min = replace(num, firstNon0Digit, 0);
        System.out.println(max+" "+min);
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