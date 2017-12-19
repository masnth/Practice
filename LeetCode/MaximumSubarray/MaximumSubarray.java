class Solution {
    public int maxSubArray(int[] nums) {
        int maxTilNow = Integer.MIN_VALUE, curMax = maxTilNow - nums[0];
        for (int i = 0; i < nums.length;i++) {
            curMax = curMax+nums[i] < nums[i] ? nums[i] : curMax+nums[i];
            maxTilNow = maxTilNow < curMax ? curMax : maxTilNow;
        }
        return maxTilNow;
    }
}