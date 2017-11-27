// Definition for singly-linked list:
// template<typename T>
// struct ListNode {
//   ListNode(const T &v) : value(v), next(nullptr) {}
//   T value;
//   ListNode *next;
// };
//
ListNode<int> * reverseNodesInKGroups(ListNode<int> * l, int k) {
    ListNode<int> * root = l;
    ListNode<int> * triv;
    ListNode<int> * prevv;
    ListNode<int> * prev;
    ListNode<int> * nextt;
    ListNode<int> * curr = root;
    int c = k;
    int start = 0;
    int stop = 0;
    if (c != 1) {
        while(curr != nullptr && stop != 1) {
            c = k;
            if (start != 0) {
                prevv = curr;
                curr = curr->next;         
            }                   
            while (c > 1) {
                curr = curr->next;
                if (curr == nullptr)
                    return l;
                c--;
            }           
            if (start == 0) {
                l = curr;
                start = 1;
            }
            else {
                root = prevv->next;
                prevv->next = curr;
            }
            prev = root;
            root = root->next;
            nextt = root->next;
            if (curr->next == nullptr) {
                prev = new ListNode<int>(prev->value);
                stop = 1;
            }
            else {
                prev->next = curr->next;
                curr = prev; 
            }

            for (int i = 1; i < k; i++) {
                root->next = prev;
                prev = root;
                if (nextt != nullptr) {
                    root = nextt;
                    nextt = nextt->next;
                }
            }
        }    
    }
    return l;
}
