// Definition for singly-linked list:
// template<typename T>
// struct ListNode {
//   ListNode(const T &v) : value(v), next(nullptr) {}
//   T value;
//   ListNode *next;
// };
//
ListNode<int> * mergeTwoLinkedLists(ListNode<int> * l1, ListNode<int> * l2) {
    using namespace std;
    int left, right = 0;
    short start = 0;
    ListNode<int> * res;
    ListNode<int> * curr;
    
    // left l1. right l2.
    if (l1 != nullptr && l2 != nullptr)
    {
        if (l1->value <= l2->value) 
        {
            curr = new ListNode<int>(l1->value);
            l1 = l1->next;
        }
        else
        {
            curr = new ListNode<int>(l2->value);
            l2 = l2->next;
        }
    }
    else if (l1 == nullptr && l2 == nullptr) 
        return res;
    else if (l2 == nullptr) {
        curr = new ListNode<int>(l1->value);
        l1 = l1->next;
    }
    else{
        curr = new ListNode<int>(l2->value);
        l2 = l2->next;
    }    
    res = curr;  
    cout << "Starting the loop" << endl;
    while (l1 != nullptr || l2 != nullptr) 
    {
        if (l1 != nullptr && l2 != nullptr)
        {
            if (l1->value <= l2->value) 
            {
                left = 1;
                right = 0;
            }
            else {
                left = 0;
                right = 1;
            }
        }
        else if (l1 == nullptr) {
            left = 0;
            right = 1;
        }
        else {
            left = 1;
            right = 0;
        }
        if (left == 1)
        {
            curr->next = new ListNode<int>(l1->value);
            l1 = l1->next;
        }
        if (right == 1) 
        {
            curr->next = new ListNode<int>(l2->value);
            l2 = l2->next; 
        }
        curr = curr->next;    
    }
    return res;
}
