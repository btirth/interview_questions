class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        Stack<String> st = new Stack<>();

        for(int i=0; i<words.length; i++) {
            String word = words[i].trim();

            if(word.length() > 0) {
                st.push(word);
            }
        }

        StringBuilder reversedWords = new StringBuilder("");   

        while(!st.isEmpty()) {
            reversedWords.append(st.pop());
            if(!st.isEmpty()) {
                reversedWords.append(" ");
            }
        }

        return reversedWords.toString();
    }
}