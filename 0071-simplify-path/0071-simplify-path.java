/* 
Q: abs path, /, -> simplified Canonical path
. , .., ///-> /, 
anything else: a VAlid dir or file  name

example, ..., .... are valid names
/ | / | ^* /$, unless the i/p is///// -> /
I -> O: String -> String

Test case: 1 ///sys/class/.././kernel/config.gz
-> /sys/kernel/config.z

maximum path length: 
path consists of : digits, -, ., /, letters, -> what about any other special characters

A1: use a stack and traverse the string,
start with split teh string by /=> all the valid paths in the array
would remove multiple occurences of / in a single go
if there are . or .. , we handle the top ele accordingly

T: O(n);
S: O(n) ; stack plus an String[]

Test case: 1 ///sys/class/.././kernel/config.gz
-> /sys/kernel/config.z

Edge case: 
1: path : //// -> /
2: 

*/


class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.trim().split("/");
        if(arr.length == 0){
            return "/";
        }
        StringBuilder sb = new StringBuilder();

        for(String curr: arr){
            //.
            if(curr.equals(".") || curr.equals("")){
                continue;
            }else if(curr.equals("..")){ // ..
                int lastSlash = sb.lastIndexOf("/");
                if(lastSlash != -1){
                    sb.delete(lastSlash, sb.length());
                }
            }else{
                sb.append("/").append(curr);
            }
            
            
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}