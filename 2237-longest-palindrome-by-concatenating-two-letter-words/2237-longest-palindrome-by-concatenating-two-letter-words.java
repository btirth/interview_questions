class Solution {
    public int longestPalindrome(String[] words) {
        /**
        first observation -> each word is of 2 chars

        if I have to a word
        -> (1) reverse word should be there or
        -> (2) word should have same char

        I can only use 1 word of type 2

        So now the task is to find number of words where reverse is present in words
        let's say that's number is M words

        length = (M * 2)

        if type 2 isn't used then ans = length + 2

        Now to fidn if reverse is rpesent or not,
        We can use hashmap, because for every word there should be equal no. of reverse
        So we'll need freq hash map.

        lc = 1
        cl = 1
        gg = 1

        we process lc -> cl is in map

        length += min(lcf, clf)
        update map for lcf and clf

        if both char is equal
            -  we can consider freq/2
        
         */

        HashMap<String, Integer> freq = new HashMap<>();

        for(String word: words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        } 

        int len = 0;
        int middle = 0;
        for(String word: words) {
            if(freq.get(word) == 0) {
                continue;
            }

            if(word.charAt(0) == word.charAt(1)) {
                int f = freq.get(word);
                if(f%2 == 0) {
                    len += f; // 4 -> 8
                } else {
                    middle = 2;
                    len += (f-1);
                }
                
                freq.put(word, 0);
            } else {
                String reverseWord = "" + word.charAt(1) + word.charAt(0);
                if(freq.containsKey(reverseWord)) {
                    len += (2*Math.min(freq.get(word), freq.get(reverseWord)));
                    freq.put(reverseWord, 0);
                }

                freq.put(word, 0);
            }
        }



        return middle + (len * 2);
    }
}