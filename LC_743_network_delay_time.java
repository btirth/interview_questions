/*

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:
  Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
  Output: 2

Example 2:
  Input: times = [[1,2,1]], n = 2, k = 1
  Output: 1

Example 3:
  Input: times = [[1,2,1]], n = 2, k = 2
  Output: -1
 

Constraints:
  1 <= k <= n <= 100
  1 <= times.length <= 6000
  times[i].length == 3
  1 <= ui, vi <= n
  ui != vi
  0 <= wi <= 100
  All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

*/


class Solution {
    private final Map<Integer, List<Node>> connected = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            connected.putIfAbsent(time[0], new ArrayList<>());
            connected.get(time[0]).add(new Node(time[2], time[1]));
        }
        connected.forEach((source, nodes) -> nodes.sort(Comparator.comparing(Node::travelTime)));
        int[] receivedTime = new int[n + 1]; Arrays.fill(receivedTime, 1, receivedTime.length, Integer.MAX_VALUE);
        dfs(receivedTime, 0, k);
        
        int max = Arrays.stream(receivedTime).max().orElseThrow(RuntimeException::new);
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private void dfs(int[] receivedTime, int currentTime, int currentNode) {
        if (receivedTime[currentNode] <= currentTime) return;
        receivedTime[currentNode] = currentTime;
        if (connected.containsKey(currentNode))
            connected.get(currentNode).forEach(node -> dfs(receivedTime, currentTime + node.travelTime(), node.destination()));
    }

    public record Node(int travelTime, int destination) {}
}
