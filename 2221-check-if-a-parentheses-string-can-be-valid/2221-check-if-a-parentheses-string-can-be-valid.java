class Solution {
    public boolean canBeValid(String s, String locked) {
        /**
        
        For given length constraint O(n^2) will not work
        Hence, DP memoization and tabular approach will not work
        
        Better than that is O(n) and O(n logn) 
        -> I don't think O(n logn) is even in the picture

        Can we do O(n)

        -> at each point keep track of lockedOpen, lockedClose, unlocked

        if(lockedClose > lockedOpen + unlocked) {
            return false;
        } 

        if lockedOpen becomes greater than lockedClose will have to wait until we reach the end of s.

        At the end of S
    
        if(lockedClose != lockedOpen) {
            unlocked -= Math.abs(lockedOpen - lockedClose) // dedicate unlock for open/close 
        }

        return unlocked%2 == 0 // check if remaining are same or not, will divide equally.
         */

        int lockedCounter = 0;
        int unlocked = 0;
        int len = s.length();

        if(len%2 != 0) {
            return false;
        }

        for(int i=0; i<len; i++) {
            if(locked.charAt(i) == '0') {
                unlocked++;
            } else if(s.charAt(i) == '(') {
                lockedCounter++;
            } else {
                if(lockedCounter > 0) {
                    lockedCounter--;
                } else if(unlocked > 0) {
                    unlocked--;
                } else {
                    return false;
                }
            } 
        }

        unlocked = 0;
        lockedCounter = 0;
        for(int i=len-1; i>=0; i--) {
            if(locked.charAt(i) == '1') {
                if(s.charAt(i) == '(') {
                    if(lockedCounter < 0) {
                        lockedCounter++;
                    } else {
                        if(unlocked <= 0) {
                            return false;
                        }
                        unlocked--;
                    }
                } else {
                    lockedCounter--;
                }
            } else {
                unlocked++;
            }   
        }

        if(lockedCounter > 0) {
            return false;
        }

        return true;
    }
}