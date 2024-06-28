class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            String val = "";
            if(i%3 == 0) {
                val += "Fizz";
            }

            if(i%5 == 0) {
                val += "Buzz";
            }

            if(val.length() == 0) {
                val += i;
            }

            ans.add(val);
        }

        return ans;
    }
}