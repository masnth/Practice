/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1)
            return (new TreeNode(nums[0]));
        TreeNode ret;
        int len = nums.length;
        
        ret = buildTree(nums, 0, len-1);
        return ret;
    }
    
	// method to build the tree
    public TreeNode buildTree(int[] nums, int start, int end) {
        int max = 0, pos = 0;
        
		if (start == end)							// 1 elem to check
            return (new TreeNode(nums[start]));
        else if (start > end)						// no elem to check
            return null;
        
        for (int i = start; i < end+1; i++) {		// find the max value and its position
            if (max < nums[i]) {
                max = nums[i];
                pos = i;
            }
        }

        TreeNode root = new TreeNode(max);	
        root.left = buildTree(nums, start, pos-1);	// repeat for the left part
        root.right = buildTree(nums, pos+1, end);	// repeat for the right part
        return root;
    }
}