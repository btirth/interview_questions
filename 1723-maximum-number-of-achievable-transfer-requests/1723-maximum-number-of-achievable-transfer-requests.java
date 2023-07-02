class Solution {
    int ans = 0;
    int[] buildings;
    public int maximumRequests(int n, int[][] requests) {
        buildings = new int[n];
        backTracking(requests, 0, 0);
        return ans;
    }

    void backTracking(int[][] req, int idx, int count) {
        if(idx == req.length) {
            for(int i=0; i<buildings.length; i++) {
                if(buildings[i] != 0) {
                    return;
                }
            }
            
            ans = Math.max(ans, count);
            return;
        }

        // do not process request.
        backTracking(req, idx+1, count);

        // process the request.
        buildings[req[idx][0]]++;
        buildings[req[idx][1]]--;

        backTracking(req, idx+1, count+1);
        
        buildings[req[idx][0]]--;
        buildings[req[idx][1]]++;
    }
}