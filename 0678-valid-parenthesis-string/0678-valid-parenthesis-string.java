class Solution {
    public boolean checkValidString(String s) {
        /**
        same no. of ( and )
        diff of ( - ) <= no. of *


        
        
         */

        int openCloseCount = 0;
        int anyCount = 0;

        for(char ch: s.toCharArray()) {
            if(ch == '*') {
                anyCount++;
            } else if(ch == '(') {
                openCloseCount++;
            } else {
                openCloseCount--;

                if(openCloseCount < 0) {
                    if(anyCount > 0) {
                        openCloseCount++;
                        anyCount--;
                    } else {
                        return false;
                    }
                }
            }
        } 

        /**
        We checked for any extra close we have * or not before that. 
        But what about extra open??
        We'll have to check if for extra open there's extra * after that or not.
         */

        if(openCloseCount == 0) {
            return true;
        }

        openCloseCount = 0;
        anyCount = 0;

        for(int i=s.length() - 1; i>=0; i--) {
            char ch = s.charAt(i);
            if(ch == '*') {
                anyCount++;
            } else if(ch == '(') {
                openCloseCount--;

                if(openCloseCount < 0) {
                    if(anyCount > 0) {
                        openCloseCount++;
                        anyCount--;
                    } else {
                        return false;
                    }
                }
            } else {
                openCloseCount++;
            }
        } 


        return Math.abs(openCloseCount) <= anyCount;
    }
}