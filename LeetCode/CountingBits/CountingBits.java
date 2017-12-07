class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num+1];
        ret[0] = 0;
        if (num == 0)
            return ret;
        
        ret[1] = 1;
        if (num == 1)
            return ret; 
        
        ret[2] = 1;

        // if i has n bits of 1, 2*i has the same
		// amount of 1 because 2*i is i shifted left
		// 1 position. 2*i+1 has 1 more bit of 1
		
		for (int i = 1; i <= num/2; i++) {
            ret[i*2] = ret[i];
            if (i == num/2 && i*2 + 1 > num)
                    break;
            ret[i*2+1] = ret[i] + 1;
        }
        return ret;  
    }
}