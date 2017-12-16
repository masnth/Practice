class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return nums.length;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] == nums[j-1]) {
                i++;
                if (i >= nums.length) return j;
            }
            if (j != i)
                nums[j] = nums[i];
            j++;
        }
        return j;
    }
}

/*
Method 1: naive
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return nums.length;
        int len = nums.length, j = 1, cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] == cur) {
                i++;
                len--;        // can be replaced by j
                if (len < 2 || i >= nums.length) return len;
            }
            if (j != i)
                swap(nums, i, j); // need not to swap, just replace
            cur = nums[j];
            j++;
        }
        return len;
    }
    
    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
*/