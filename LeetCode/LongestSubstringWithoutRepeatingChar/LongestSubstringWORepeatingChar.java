class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return s.length();
        Map<Character, Integer> dic = new HashMap<Character, Integer>();
        int maxLen = 0, curLen = 0;	// curLen is the current length of substring
        int startPos = 1; 			// start position of this current substring
        int v;						// position of repeating char
        
        for (int i = 0; i < s.length(); i++) {
            v = dic.containsKey(s.charAt(i)) ? dic.get(s.charAt(i)) : -1; 
            //if (!dic.containsKey(s.charAt(i)) || dic.get(s.charAt(i)) < startPos) {
            if (v < startPos) {
                curLen++;
                if (maxLen < curLen)
                    maxLen = curLen;
            }
            else {
                curLen = i + 1 - v;
                startPos = v + 1;
            }
            dic.put(s.charAt(i), i + 1); 
        }
        return maxLen;
    }
}