class Solution {
    public boolean canChange(String start, String target) {
        int lCount = 0;
        int rCount = 0;
        int len = start.length();
        int idx = 0;

        while(idx < len) {
            if(target.charAt(idx) == 'L') {
                if(rCount < 0) {
                    return false;
                }

                lCount++;
            } 

            if(start.charAt(idx) == 'L') {
                if(lCount <= 0 || rCount < 0) {
                    return false;
                }
                
                lCount--;
            } else if (start.charAt(idx) == 'R') {
                if(rCount > 0 || lCount > 0) {
                    return false;
                }

                rCount--;
            }

            if (target.charAt(idx) == 'R') {
                if(lCount > 0) {
                    return false;
                }
                rCount++;
            }

            if(rCount > 0) {
                return false;
            }

            idx++;
            
        }

        return lCount == 0 && rCount == 0;
    }
}