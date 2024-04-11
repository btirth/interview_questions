class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder builder = new StringBuilder();
        final int L = num.length();
        for(int i = 0; i < L; i++){
            while(builder.length() > 0 
                  && builder.charAt(builder.length() - 1) > num.charAt(i)
                 && k > 0){
                builder.deleteCharAt(builder.length() - 1);
                k--;
            }
            
            if(builder.length() > 0 || num.charAt(i) != '0'){
                builder.append(num.charAt(i));
            }
        }
        
        // to pop up the extra digits from end
        while(builder.length() > 0 && k > 0){
            builder.deleteCharAt(builder.length() - 1);
            k--;
        }
        
        if(builder.length() == 0) return "0";
        return builder.toString();
    }
}