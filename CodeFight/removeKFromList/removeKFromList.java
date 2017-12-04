// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    ListNode<Integer> current = l;
    ListNode<Integer> previous = l;
    if (current == null) 
        return null;
    else {
        while (current != null) {
            if (current.value == k) {
                if (current == l) {
                    if (l.next == null)
                        return null;
                    else {
                        l = l.next;
                        current = l;
                        previous = current;
                    }
                }
                else {
                    previous.next = current.next;
                    current = current.next;
                }
            }
            else {
                previous = current;
                current = current.next;
            }
        }
        return l;
    }
}
