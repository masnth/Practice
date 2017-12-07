class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ret = 0;
        // solution for unsorted array
        /*for (int i = 0; i < nums.length; i++)
            ret = ret ^ nums[i];
        */
        int i = nums.length/2; 
        int min = 0, max = nums.length-1;
        while(i > min && i < max) {
            if (nums[i] != nums[i+1] && nums[i] != nums[i - 1])   // center
                return nums[i];
            else if (nums[i] == nums[i+1])                        
                i = i+1;
            if (i%2 == 0) {                                         // left half  
                i -= 2;
                max = i;
                i = min + (max - min + 1) / 2;
            }
            else {                                                 // right half  
                min = i + 1;
                i = min + (max - min + 1) / 2;
            }
        }
       
        return nums[i];
    }
}