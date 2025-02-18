class Solution {
    public String smallestNumber(String pattern) {
        /**
        01234567
        IIIDIDDD

        012345678
        123549876

        III
        1234
        
        IDID
        13254

        IDIID
        132465

        3 
         */

        Stack<Integer> stack = new Stack<>(); 
        int n = pattern.length();
        int digit = 1;
        char[] ans = new char[n + 1];
        
        for(int idx=0; idx<n; idx++) {
            if(pattern.charAt(idx) == 'D') {
                stack.push(idx);
            } else {
                ans[idx] = (char)(digit + '0');
                digit++;

                while(!stack.isEmpty()) {
                    int index = stack.pop();
                    ans[index] = (char)(digit + '0');
                    digit++;
                }
            }
        }

        stack.add(n);

        while(!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = (char)(digit + '0');
            digit++;
        }

        return new String(ans);
    }
}