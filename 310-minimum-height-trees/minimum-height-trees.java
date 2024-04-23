class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	if (n == 1)
		return List.of(0);

	var adjList = getAdjList(edges);
	var q = getQ(adjList);

	while (n > 2) {
		n -= q.size();
		
		for (var i = q.size(); i > 0; i--) {
			var head = q.poll();

			for (var neighbor : adjList.get(head)) {
				adjList.get(neighbor).remove(head);
				if (adjList.get(neighbor).size() == 1)
					q.add(neighbor);
			}
		}
	}
	return q;
}

private Map<Integer, Set<Integer>> getAdjList(int[][] edges) {
	var adjList = new HashMap<Integer, Set<Integer>>();
	for (var edge : edges) {
		adjList.computeIfAbsent(edge[0], k -> new HashSet<>())
			   .add(edge[1]);
		adjList.computeIfAbsent(edge[1], k -> new HashSet<>())
			   .add(edge[0]);
	}
	return adjList;
}

private LinkedList<Integer> getQ(Map<Integer, Set<Integer>> adjList) {
	var q = new LinkedList<Integer>();
	for (var entry : adjList.entrySet())
		if (entry.getValue().size() == 1)
			q.add(entry.getKey());
	return q;
}
}