class Solution {
    public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] colors = new int[n];   // 0:not visited; 1 or -1: two colors
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++)  // loop for each node
			if (colors[i] == 0) {    // if not colored (not visited), give a color to the node
				colors[i] = 1;
				q.add(i);
				while (!q.isEmpty()) {  // BFS
					int current = q.poll();
					for (int adjacent  : graph[current])  // give the opposite color to all connected nodes
						if (colors[adjacent] == 0) {
							colors[adjacent] = -colors[current];
							q.add(adjacent);
						} else if (colors[current] == colors[adjacent])
							return false;
				}
			}
		return true;
	}

    
}