class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, "");
        return list;
    }

    void generate(int n, int open, int close, String s) {
        if(close == n) {
            list.add(s);
            return;
        }

        if(open < n)
            generate(n, open+1, close, s + "(");

        if(close < open)
            generate(n, open, close+1, s + ")");
    }
}