class Solution {
    public int minSwaps(String s) {
        int count = 0;
        int replace = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '[') {
                count++;
            } else {
                if(count > 0) {
                    count--;
                } else {
                    count++;
                    replace++;
                }
                    
            }
        }

        return replace;
    }
}