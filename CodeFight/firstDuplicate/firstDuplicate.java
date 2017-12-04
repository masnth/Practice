int firstDuplicate(std::vector<int> a) {
    using namespace std;
    unordered_map<int, int> res;
    unordered_map<int, int>::iterator curr;
    for (int i = 0; i < a.size(); i++) 
    {
        curr = res.find(a[i]);
        if (curr != res.end()) 
            return curr->second;
        res.emplace(a[i],a[i]);
    }
    return -1;
}
