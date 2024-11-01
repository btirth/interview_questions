class Solution {
    public String makeFancyString(String s) {
        char[] sChar = s.toCharArray();
        int leftPt = 0;
        int rightPt = 0;
        for(int i=0; i<s.length(); i++) {
            if(sChar[leftPt] == sChar[i]) {
                if(i - leftPt <= 1) {
                    sChar[rightPt] = sChar[i];
                    rightPt++;
                }
            } else {
                leftPt = i;
                sChar[rightPt] = sChar[i];
                rightPt++;
            }
        }

        return new String(sChar).substring(0, rightPt);
    }
}