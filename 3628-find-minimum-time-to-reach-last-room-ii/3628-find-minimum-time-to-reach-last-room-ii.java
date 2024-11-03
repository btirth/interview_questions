class Solution {
    class Node implements Comparable<Node>{
        int time;
        int i;
        int j;

        Node(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }

        public int compareTo(Node node) {
            return Integer.compare(this.time, node.time);
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = moveTime.length;
        int m = moveTime[0].length;
        int len = n*m;
        boolean[][] visited = new boolean[n][m];
        pq.add(new Node(0, 0, 0));
        int[][] directions = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visited[node.i][node.j]) {
                continue;
            }
            visited[node.i][node.j] = true;
            
            if(node.i == n-1 && node.j == m-1) {
                return node.time;
            }

            for(int[] dir: directions) {
                int x = node.i + dir[0];
                int y = node.j + dir[1];
                int p = 2 - ((x+y)%2);
                if(x>=0 && y>=0 && x<n && y<m)
                    pq.add(new Node(x, y, Math.max(node.time, moveTime[x][y]) + p));
            }
        }

        return -1;
    }
}