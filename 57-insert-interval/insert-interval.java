class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer[]> ans = new ArrayList<>();
        boolean added = false;

        for(int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];

            // case in which new interval will get inserted.
            if(!added) {
                if(newInterval[0] >= start && newInterval[0] <= end) {
                    end = Math.max(end, newInterval[1]);
                    added = true;
                } else if(start >= newInterval[0]) {
                    ans.add(new Integer[]{newInterval[0], newInterval[1]});
                    added = true;
                }
            }
            
            if(added && ans.size()>0) {
                Integer[] prev = ans.get(ans.size()-1);
                if(start <= prev[1]) {
                    ans.remove(ans.size()-1);
                    start = Math.min(start, prev[0]);
                    end = Math.max(prev[1], end);
                }
            }
        
            ans.add(new Integer[]{start, end});
        }

        if(!added) {
            ans.add(new Integer[]{newInterval[0], newInterval[1]});
        }

        int[][] arr = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++) {
            Integer[] a = ans.get(i);
            arr[i] = new int[]{a[0], a[1]};
        }

        return arr;
    }
}