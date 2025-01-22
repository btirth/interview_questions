class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> fullJustify(String[] words, int maxWidth) {
        /**
        
        
        handleLine
        - words, currW, maxW
        currW - length of words + 1;
        extraSpace = maxW - currW
        extraSpacePerWord = extraSpace % (words.len - 1)

        add extraSpacePerWord after each word if the word is not the lasst word



        handleLastLine
        - words [words for last line]
        lastLine = words[0]

        for word in words:
            lastLine += " " + word;

        while(lastLine.size < maxW) {
            lastLine += " ";
        }    

        ans.add(lastLine)    
         */

        int n = words.length;
        int left = 0;
        int right = 0;
        int currW = 0;

        while(right < n) {
            while(right < n && currW + words[right].length() <= maxWidth) {
                currW += words[right].length() + 1;
                right++;
            }
    
            if(right == n) {
                addLastLine(words, left, maxWidth);
            } else {
                addLine(words, left, right-1, maxWidth, currW - 1);
                left = right;
                currW = 0;
            }
            
        } 

        return ans;
    }

    void addLine(String[] words, int left, int right, int maxW, int currW) {
        int extraSpace = maxW - currW;
        int equalExtraSpacePerWord = extraSpace;
        int extraSpaceForLeftWords = 0;

        if(right > left) {
            equalExtraSpacePerWord = extraSpace / (right - left);
            extraSpaceForLeftWords = extraSpace - (equalExtraSpacePerWord * (right - left));
        }
        
        
        StringBuilder sb = new StringBuilder("");
        int idx = left;
        while(idx <= right) {

            sb.append(words[idx]);

            if(idx != right) {
                sb.append(" ");
                int extraSpaceForCurrWord = equalExtraSpacePerWord;

                while(extraSpaceForCurrWord > 0) {
                    sb.append(" ");
                    extraSpaceForCurrWord--;
                }


                if(extraSpaceForLeftWords > 0) {
                    sb.append(" ");
                    extraSpaceForLeftWords--;
                }
            }

            
            idx++;
        }

        while(sb.length() < maxW) {
            sb.append(" ");
        }

        ans.add(sb.toString());
        
    }

    void addLastLine(String[] word, int left, int maxW) {
        StringBuilder sb = new StringBuilder("");

        for(int idx = left; idx < word.length; idx++) {
            sb.append(word[idx]);

            if(idx != word.length - 1) {
                sb.append(" ");
            }
        }

        while(sb.length() < maxW) {
            sb.append(" ");
        }

        ans.add(sb.toString());
     }
}