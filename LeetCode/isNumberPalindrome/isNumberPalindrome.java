class Solution {
    public boolean isPalindrome(int x) {
        // get the total digit of int x, call it n
        // then when we take x % 10 to get digit l
        // we subtract it to x= (x-l*10^(n))/10
        // keep doing it until we have 1 digit left
        // or x == 0;
        
        // example
        //   23532 % 10 = 2 (l=2, n=5)
        //   (23532 - 2*10^5)/10 = 353 

        // good tricks, instead of doing like the top
        // we could try using another number
        // newNum = newNum*10 + (x%10);
        // x /= 10;
        
        if (x < 0) {
            //throw new Exception("Negative number");
            return false;
        }
        
        if (x / 10 == 0)
            return true;
        
        if (x % 10 == 0)
            return false;
        
        int rev = reverse(x);
        return (x-rev == 0);
 
    }
    
    public int reverse(int x) {
		if (x / 10 == 0)
            return x;
        int rev = 0;
        int si = x > 0 ? 1 : -1;
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