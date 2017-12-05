class Solution {
    public int reverse(int x) {
        // this condition makes the program run faster
		// about 1.5 time without it.
		// according to leetcode timing
		if (x / 10 == 0)
            return x;
		
        int rev = 0;
        int si = x > 0 ? 1 : -1;
        
		// the less condition to check, the faster to run
		// in case you have many conditions, put one that 
		// easier to eliminate to the front
		
		while (x != 0) {
            int val = x % 10;
            x = x / 10;
            rev = rev*10 + val;
            if (x*si < 10 && x*si > 0) {
                if (si > 0 && rev > Integer.MAX_VALUE / 10)
                    return 0;
                if (si < 0 && rev < Integer.MIN_VALUE / 10)
                    return 0;
            }
        }
        return rev;
    }
}