class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char task: tasks) {
            freq[task-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer[]> q = new LinkedList<>();

        for(int i=0; i<26; i++) {
            if(freq[i] > 0)
                pq.add(freq[i]);
        }

        int t = 0;
        while(!pq.isEmpty() || !q.isEmpty()) {
            
            while(!q.isEmpty()) {
                Integer[] task = q.peek();
                if(task[1] <= t) {
                    q.remove();
                    pq.add(task[0]);
                } else {
                    break;
                }
            }

            if(!pq.isEmpty()) {
                Integer currTask = pq.remove();
                if(currTask > 1) {
                    q.add(new Integer[]{currTask-1, t+n+1});
                }
            }
            
            t++;
        }

        return t;
    }
}