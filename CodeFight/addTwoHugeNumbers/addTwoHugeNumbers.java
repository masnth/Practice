// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
    a = reverseList(a);
    b = reverseList(b);
    //System.out.println(a.next.next.next.value);
    int r = (a.value + b.value) % 10000;
    int rem = (a.value + b.value)/10000;
    ListNode<Integer> res = new ListNode(r);
    ListNode<Integer> curr = res;
    a = a.next;
    b = b.next;
    //System.out.println(a.value + ", " + b.value);
    while (a != null || b != null) {
        if (a != null && b != null) {
            r = (a.value + b.value + rem) % 10000;
            rem = (a.value + b.value + rem)/10000;
            curr.next = new ListNode(r);
            a = a.next;
            b = b.next;
        }
        else if (a!= null) {
            r = (a.value + rem) % 10000;
            rem = (a.value + rem) / 10000;
            curr.next = new ListNode(r);
            a = a.next;
        }
        else {
            r = (b.value + rem) % 10000;
            rem = (b.value + rem) / 10000;
            curr.next = new ListNode(r);
            b = b.next;
        }
        curr = curr.next;
    }
    if (rem != 0) 
        curr.next = new ListNode(rem);
    
    res = reverseList(res);
    return res;
}

// This is the program to reverse the order of singly LL
// input: root of list
// output: root of the reverse list
// 
ListNode<Integer> reverseList(ListNode<Integer> in) {
    if (in == null || in.next == null) 
        return in;
    ListNode<Integer> prev = in;
    ListNode<Integer> curr = in.next;
    if (in.next.next == null) {
        curr.next = prev;
        prev.next = null;
        return curr;
    }
    ListNode<Integer> next = in.next.next;
    prev.next = null;
    while (next != null) {
        curr.next = prev;
        prev = curr;
        curr = next;
        next = curr.next;
    }
    curr.next = prev;
    return curr;
}