// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
boolean isListPalindrome(ListNode<Integer> l) {
    int length = 1;
    
    if (l == null || l.next == null) 
        return true;
    
    ListNode<Integer> temp = l;
    ListNode<Integer> next = l;
    ListNode<Integer> prev = l;
     
    while (temp.next != null) {
        temp = temp.next;
        length++;
        
    }
    temp = l;
    
    for (int i = 0; i < (length+1)/2; i++) {
        temp = temp.next;    
    }
    
    if (temp.next != null) {
        prev = temp.next;
        if (temp.next.next != null) {
            next = temp.next.next;
            for (int i = (length+1)/2; i+2 < length; i++) {
                prev.next = temp;
                temp = prev;
                prev = next;
                next = prev.next;
            }
            prev.next = temp; 
            temp = l;
            for (int i = 0; i < length/2; i++) {
                if (!temp.value.equals(prev.value)) {  
                    return false;
                }
                temp = temp.next;
                prev = prev.next;
            }
            return true;
        }
        else {
            prev.next = temp;
            if (prev.value == l.value 
                && prev.next.value == l.next.value) {
                return true;
            }
            else 
                return false;
        }
    }
    else {
        if (temp.value == l.value)
            return true;
        else 
            return false;
    }   
}