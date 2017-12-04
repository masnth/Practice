/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // tips: create a nonsense root then return its next elem
        // remember to check for null 
        
        
        int sum = 0, reminder = 0, val = 0;                     // val is the value in current ListNode
        ListNode ret = new ListNode(0), curr = ret;             // curr to track of the current ListNode
        boolean l1End = false, l2End = false;  
        while (!l1End || !l2End) {
            int l1v = l1 != null ? l1.val : 0;
            int l2v = l2 != null ? l2.val : 0;
            
            sum = l1v + l2v + reminder;
                       
            /* if (!started) {
                ret = new ListNode(val);
                curr = ret;
                started = true;
            }
            else {
                curr.next = new ListNode(val);
                curr = curr.next;
            } */
            
            reminder = sum / 10;   
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if (l1 == null || l1.next == null) { 
                l1End = true;
            }
            l1 = l1End ? null : l1.next;
            
            if (l2 == null || l2.next == null) {
                l2End = true;
            }
            l2 = l2End ? null : l2.next;
        }
        if (reminder != 0)
            curr.next = new ListNode(reminder);
        return ret.next;
    }
}