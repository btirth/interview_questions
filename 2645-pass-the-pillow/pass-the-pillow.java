class Solution {
    public int passThePillow(int n, int time) {
        int dir = (int)Math.ceil((double)time/(n-1));
        int pos = time - ((dir-1) * (n-1));
        
        if(dir%2 == 0) {
            return n-pos;
        }

        return pos+1;
    }
}