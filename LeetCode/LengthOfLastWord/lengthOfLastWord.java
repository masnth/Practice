class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        int pos = s.length() - 1;
        if (s.length() == 0)
            return 0;
        while (s.charAt(pos) != ' ') {
            len++;
            pos--;
            if (pos < 0)
                break;
        }
        return len;
    }
}