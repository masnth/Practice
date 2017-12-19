
// NAIVE IMPLEMENT
class Solution {
    private Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
    
    class ListComparator<Integer extends Comparable<Integer>> 
        implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> l1, List<Integer> l2) {
            Iterator<Integer> lt1 = l1.iterator();
            Iterator<Integer> lt2 = l2.iterator();
            Integer n1 = lt1.next();
            Integer n2 = lt2.next();
            if (n1 == n2) {
                n1 = lt1.next();
                n2 = lt2.next();
                if (n1 == n2) {
                    n1 = lt1.next();
                    n2 = lt2.next();
                    return(n1.compareTo(n2));
                }
                else
                    return(n1.compareTo(n2));
            }
            else
                return (n1.compareTo(n2));
        }
    }   
    
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> retSet = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (dic.containsKey(nums[i]))
                dic.put(nums[i], dic.get(nums[i]) + 1);
            else
                dic.put(nums[i], 1);
        }
        
        if (dic.size() == 1) {
            if (dic.containsKey(0) && dic.get(0) > 2)
                retSet.add(check(0,0,0));
        }
        else { 
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    int need = 0 - nums[i] - nums[j];
                    if (dic.containsKey(need)) {
                        List<Integer> temp = check(need, nums[i], nums[j]);
                        if (temp != null)
                            retSet.add(temp);
                    }
                }
                dic.remove(nums[i]);
            }
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>(retSet);
        Collections.sort(ret, new ListComparator());
        return ret;
    }
                
    private List<Integer> check(int need, int a, int b) {
        if (need == 0 && a == 0 && b == 0)
            return (dic.get(need) > 2 ? getList(need, a, b) : null);
        if (!dic.containsKey(need))
            return null;
        else {
            if (need != a && need != b)
                return getList(need, a, b);
            else {
                if (dic.get(need) > 1)
                    return getList(need, a, b);
                else
                    return null;
            }
        }
    }
    
    private List<Integer> getList(int a, int c, int b) {
        List<Integer> ret = new LinkedList<Integer>();
        int f = 0, s = 0, t = 0;
        f = Math.min(a, Math.min(b,c));
        t = Math.max(a, Math.max(b,c));
        s = 0 - f - t;
        ret.add(f);
        ret.add(s);
        ret.add(t);
        return ret;
    }
    
}