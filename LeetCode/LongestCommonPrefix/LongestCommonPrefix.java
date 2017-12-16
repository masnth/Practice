class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int pos = 0;
        String retS = "";
        while (pos < strs[0].length()) {
            for (int i = 1; i < strs.length; i++) {
                if (pos >= strs[i].length())
                    return retS;
                if (strs[i].charAt(pos) != strs[0].charAt(pos))
                    return retS;
            }
            retS = retS.concat(Character.toString(strs[0].charAt(pos)));          
            pos++;
        }
        return retS; 
    }
}