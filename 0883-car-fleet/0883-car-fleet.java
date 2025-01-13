class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];

        for(int i=0; i<n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            double timeItReach = (double)(target - pairs[i][0]) / pairs[i][1];
            if(stack.isEmpty() || timeItReach > stack.peek()) {
                stack.push(timeItReach);
            }
        }

        return stack.size();
    }
}