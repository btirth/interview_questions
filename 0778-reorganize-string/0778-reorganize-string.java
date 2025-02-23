class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i=0; i<26; i++) {
            if(freq[i] > 0)
                pq.add(new int[]{i, freq[i]});
        }

        StringBuilder sb = new StringBuilder("");
        int[] ans = new int[n];
        int idx = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(idx == 0 || (cur[0] != ans[idx-1])) {
                ans[idx] = cur[0];
                if(cur[1] > 1)
                    pq.add(new int[]{cur[0], cur[1] - 1});
            } else {
                if(pq.isEmpty()) {
                    return "";
                }

                int[] next = pq.poll();
                pq.add(cur);
                ans[idx] = next[0];
                if(next[1] > 1)
                    pq.add(new int[]{next[0], next[1] - 1});
            }

            idx++;
        }

        for(int i: ans) {
            sb.append((char)(i + 'a'));
        }

        return sb.toString();
    }
}