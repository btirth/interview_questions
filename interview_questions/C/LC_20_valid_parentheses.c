/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true
*/


bool isValid(char* s) {
    int len = strlen(s);
    if(len%2) return false;
    
    int limit = len/2;
    char *stack = malloc(limit);
    int idx = 0;
    
    for(int i=0; i<len; ++i){
        char cur = s[i];
        if(cur=='(' || cur=='{' || cur=='['){
            if(idx == limit) return false;
            stack[idx++] = cur;
        }else{
            if(idx == 0) return false;
            if(cur == '}' && stack[idx-1] == '{' || cur == ']' && stack[idx-1] == '[' || cur == ')' && stack[idx-1] == '('){
                idx--;
            }else{
                return false;
            }
        }
    }
    
    free(stack);
    return idx==0;
}