class Solution {
    public String optimalDivision(int[] nums) {
        String ret = "";
        //if (nums.length == 1)
         //   return ret.concat(Integer.toString(nums[0]));
        
        for (int i = 0; i < nums.length; i++) {
            ret = ret.concat(Integer.toString(nums[i]));
            if (i==nums.length-1 && nums.length > 2)
                ret = ret.concat(")");    
            if (i != nums.length-1 && nums.length > 1)
                ret = ret.concat("/");
            if (i==0 && nums.length > 2) 
                ret = ret.concat("(");
        }
        return ret;
    }
}