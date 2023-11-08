class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dx = Math.abs(sx-fx);
        int dy = Math.abs(sy-fy);

        // if the endpoint is out of scope for the t distance then you won't be able to reach there
        // if you're standing on end point but since t==1 you'll have to move and you won't able to come at the same point.
        if((dx>t || dy>t) || (t==1 && (dx==0 && dy==0))) {
            return false;
        } 

        return true;
    }
}