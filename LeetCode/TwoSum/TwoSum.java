class Solution {
    public int[] twoSum(int[] nums, int target) {
        int tracking = 0;
        int ret[] = new int[2];
        Map<Integer, Integer> seen = new HashMap<Integer, Integer>();
        
        if (nums == null)
            return ret;
        
        for (int i : nums) {
            if (!seen.containsKey(target-i)) {
                seen.put(i, tracking);
            }
            else {
                ret[1] = tracking;
                ret[0] = seen.get(target-i);
                return ret;
            }
            tracking++;
        }
        return ret;
        
    }
}