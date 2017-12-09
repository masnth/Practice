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
    //public int findBottomLeftValue(TreeNode root) {
        // I tried 2 ways
        
        // 1st one is to make 2 queues as parent and
        // children. When parent are popped, its left
        // and right are added to chilren.
        // Every time I pop all of element
        // of parent out, I will use children as parent
        // Repeat this process until both parent and chilren
        // are empty.
        
        // 2nd one use only 1 queue.
        
        // Try recursive tmr.
        
        /*
        if (root.left == null && root.right == null)
            return root.val;
        Queue<TreeNode> pa = new LinkedList<TreeNode>();
        //Queue<TreeNode> ch = new LinkedList<TreeNode>();
        TreeNode cur = root;
        int ret = 0, init = 0;
        pa.add(root);
        pa.add(new TreeNode(-59000));
        while (true) {
            /* 
            cur = pa.poll();
            if (init == 0) {
                init = 1;
                ret = cur.val;
            }
            if (cur.left != null) ch.add(cur.left);
            if (cur.right != null) ch.add(cur.right);
            if (pa.peek() == null) {
                while(ch.peek() != null)
                    pa.add(ch.poll());
                init = 0;
            } 
            /
            
            if (init == 1 && pa.peek().val == -59000)
                break;
            cur = pa.poll();
            //System.out.println(cur.val);
            if (cur.val == -59000) {
                pa.add(new TreeNode(-59000));
                init = 1;
            }
            else {
                if (init == 1)
                    ret = cur.val;
                init = 0;
                if (cur.left != null) pa.add(cur.left);
                if (cur.right != null) pa.add(cur.right);
            }
        }
        
        return ret;
    */
    //}
	
	// recursive method
	
	TreeNode cur;
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val;
        Queue<TreeNode> pa = new LinkedList<TreeNode>();
        pa.add(root);
        return checkTree(pa);
    }
    
    public int checkTree(Queue<TreeNode> pa) {
        Queue<TreeNode> ch = new LinkedList<TreeNode>();
        int ret = pa.peek().val;
        while(pa.peek() != null) {
            cur = pa.poll();
            if (cur.left != null) ch.add(cur.left);
            if (cur.right != null) ch.add(cur.right);
        }
        
        if (ch.peek() != null) 
            ret = checkTree(ch);
        return ret;
    }
}