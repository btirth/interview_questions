class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(n, 0, 0, new char[2*n], 0);
        return res;
    }

    void backtrack(int n, int open, int close, char[] ch, int idx) {
        if(idx == 2*n) {
            if(open == close)
                res.add(new String(ch));
            return;
        }

        ch[idx] = '(';
        backtrack(n, open + 1, close, ch, idx + 1);

        if(open > close) {
            ch[idx] = ')';
            backtrack(n, open, close + 1, ch, idx + 1);
        }
    }
}