class Solution {
    public int passThePillow(int n, int time) {
        // if(time < n-1) {
        //     return time+1;
        // }

        // int pass = n-1;
        // int dir = (int)Math.ceil((double)time/(pass));
        // int pos = time%pass;
        // System.out.println(dir+" "+pos);
        
        // if(dir%2 == 0) {
        //     return n-pos;
        // }

        // return n-pos;
        boolean ltor = true;
        while(time > n-1) {
            ltor = !ltor;
            time -= n-1;
        }

        return ltor ? time+1 : n-time;
    }
}