class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Set<Integer>[] pre = new HashSet[numCourses];
        List<Integer>[] post = new ArrayList[numCourses];

        int[] inorder = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++) {
            pre[i] = new HashSet<>();
            post[i] = new ArrayList<>();
        }

        for(int[] p: prerequisites) {
            inorder[p[1]]++;
            pre[p[1]].add(p[0]);
            post[p[0]].add(p[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(inorder[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            Set<Integer> prereq = new HashSet<>();

            for(int p: pre[node]) {
                prereq.add(p);
                prereq.addAll(pre[p]);
            }

            for(int p: post[node]) {
                inorder[p]--;

                if(inorder[p] == 0) {
                    q.add(p);
                }
            }

            pre[node] = prereq;
        }


        List<Boolean> ans = new ArrayList<>();
        for(int[] query: queries) {
            if(pre[query[1]].contains(query[0])) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }


        return ans;
    }
}