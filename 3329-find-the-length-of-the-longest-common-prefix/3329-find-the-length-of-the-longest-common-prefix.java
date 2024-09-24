class Solution {
    class Prefix {
        Prefix[] child;

        Prefix() {
            child = new Prefix[10];
        }
    }

    int longestCommPrefix = 0;
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Prefix prefix = new Prefix();
        for(int num: arr1) {
            createTrie("" + num, prefix);
        }

        for(int num: arr2) {
            checkTrie("" + num, prefix);
        }

        return longestCommPrefix;
    }

    void createTrie(String num, Prefix prefix) {
        for(char ch: num.toCharArray()) {
            if(prefix.child[ch-'0'] == null)
                prefix.child[ch-'0'] = new Prefix();
            prefix = prefix.child[ch-'0'];
        }
    }

    void checkTrie(String num, Prefix prefix) {
        int currPrefixSize = 0;
        for(char ch: num.toCharArray()) {
            if(prefix.child[ch-'0'] != null) {                
                currPrefixSize++;
                prefix = prefix.child[ch-'0'];
            } else {
                break;
            }
        }

        longestCommPrefix = Math.max(longestCommPrefix, currPrefixSize);
    }
}