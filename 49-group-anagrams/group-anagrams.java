class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs) {

                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                String sorted = new String(ch);

            List<String> pairs = map.getOrDefault(sorted, new ArrayList<String>());
            pairs.add(str);
            map.put(sorted, pairs);
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}