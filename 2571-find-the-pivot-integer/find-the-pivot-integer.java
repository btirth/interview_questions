class Solution {
    public int pivotInteger(int n) {
        if(n==1) {
            return 1;
        }
        int left = 1;
        int right = n;
        int leftSum = 0;
        int rightSum = 0;
        while(left<=right) {

            if(leftSum < rightSum) {
                leftSum += left;
                left++;
            } else {
                rightSum += right;
                right--;
            }

            if(left == right && leftSum == rightSum) {
                return left;
            }
        }

        return -1;
    }
}