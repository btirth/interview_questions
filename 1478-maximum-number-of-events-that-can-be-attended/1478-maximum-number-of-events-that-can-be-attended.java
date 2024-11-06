class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[1], b[1]));

        TreeSet<Integer> days = new TreeSet<>();
        for(int i=1; i<=100001; i++) {
            days.add(i);
        } 

        int count = 0;
        for(int[] event:events) {
            int day = days.ceiling(event[0]);
            if(day <= event[1]) {
                count++;
                days.remove(day);
            }
        }

        return count;
    }
}