class Solution {
    public int[] maximumBeauty(int[][] items, int[] q) {
        int qLen = q.length;
        Arrays.sort(items, (a,b) -> Integer.compare(a[0], b[0]));
        int[][] queries = new int[qLen][2];

        for(int i=0; i<qLen; i++) {
            queries[i][0] = i;
            queries[i][1] = q[i];
        }

        Arrays.sort(queries, (a,b) -> Integer.compare(a[1], b[1]));
        int[] maxBeauty = new int[qLen];
        int currMaxBeauty = 0;
        int itemIdx = 0;

        for(int i=0; i<qLen; i++) {
            while(itemIdx < items.length && items[itemIdx][0] <= queries[i][1]) {
                currMaxBeauty = Math.max(currMaxBeauty, items[itemIdx][1]);
                itemIdx++;
            }

            maxBeauty[queries[i][0]] = currMaxBeauty;
        }

        return maxBeauty;
    }
}