class Solution {
    public boolean isValid(String s) {
        Stack<Character> ch = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                ch.push(']');
            else if (s.charAt(i) == '{') 
                ch.push('}');
            else if (s.charAt(i) == '(') 
                ch.push(')');
            else {
                if (ch.empty() || s.charAt(i) != ch.pop())
                    return false;
            }
        }
        return ch.empty() ? true:false;
    }
}