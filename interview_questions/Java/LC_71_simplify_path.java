/*

Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period '.' refers to the current directory. Furthermore, a double period '..' moves the directory up a level.

Note that the returned canonical path must always begin with a slash '/', and there must be only a single slash '/' between two directory names. 
The last directory name (if it exists) must not end with a trailing '/'. Also, the canonical path must be the shortest string representing the absolute path.

 

Example 1:
    Input: path = "/home/"
    Output: "/home"
    Explanation: Note that there is no trailing slash after the last directory name.

Example 2:
    Input: path = "/../"
    Output: "/"
    Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

Example 3:
    Input: path = "/home//foo/"
    Output: "/home/foo"
    Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

Example 4:
    Input: path = "/a/./b/../../c/"
    Output: "/c"
    

Constraints:
    1 <= path.length <= 3000
    path consists of English letters, digits, period '.', slash '/' or '_'.
    path is a valid Unix path.

*/



// Method 1 : Faster than 2nd
class Solution {
    public String simplifyPath(String path) {
        
        String[] s = path.split("/");
        String[] str = new String[s.length];
        int i=0;
        for(String st : s) {
            if(st.equals("") || st.equals(".")) {
                continue;
            } else if (st.equals("..")) {
               
                if(i>0) {
                    i--;    
                } else {
                    continue;
                }
                
            } else {
                str[i] = st;
                i++;
                
                
            }
        }
        StringBuilder finalStr = new StringBuilder("/");
        for(int j=0; j<i; j++) {
            if(str[j]==null) {
                break;
            } else {
                
                finalStr.append(str[j]);
                if(j<i-1) {
                    finalStr.append("/");    
                }
                
                
            }
        }
        
        return new String(finalStr);
        
    }
}




// Method 2

class Solution {
    public String simplifyPath(String path) {
        Stack<String> str = new Stack<String>();
        
        for(String s : path.split("/")) {
            if(s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
               
                if(!str.empty()) {
                    str.pop();    
                } else {
                    continue;
                }
                
            } else {
                
                str.push(s);
            }
        }
        
        int i = str.size()-1;
        String[] ans = new String[str.size()];
        while(!str.empty()) {
            ans[i] = str.pop();
            i--;
        }
        return "/" + String.join("/", ans);   
        
    }
}