class Solution {
    class Node {
        public int min;
        public int max;

        public Node (int num) {
            min = num;
            max = num;
        }
    }
    
    
    public int longestConsecutive(int[] nums) {
        Map<Integer, Node> r = new HashMap<Integer, Node>();
        int maxLen = 1;
        int currLen = 1;
        int tempMax, tempMin;
        
        if (nums.length == 0 || nums.length == 1) 
            return nums.length;
            
        for (int i = 0; i < nums.length; i++) {
            if (!r.containsKey(nums[i]))
                r.put(nums[i], new Node(nums[i]));
        }
        
        Iterator<Integer> it = r.keySet().iterator();

        while(it.hasNext()) {
            Integer key = it.next();
            if (r.containsKey(key+1) && r.containsKey(key-1)) {
                tempMax = Math.max(Math.max(r.get(key-1).max, r.get(key).max), r.get(key+1).max);
                tempMin = Math.min(Math.min(r.get(key-1).min, r.get(key).min), r.get(key+1).min);
                r.get(key-1).max = tempMax;
                r.get(key).max = tempMax;
                r.get(key).min = tempMin;
                r.get(key+1).min = tempMin;
                
                r.get(r.get(key).min).max = tempMax;
                r.get(r.get(key).max).min = tempMin;
            }
            
            else if (r.containsKey(key+1) && !r.containsKey(key-1)) {
                tempMax = Math.max(r.get(key).max, r.get(key+1).max);
                tempMin = Math.min(r.get(key).min, r.get(key+1).min);
                r.get(key).max = tempMin;
                r.get(key).max = tempMax;
                r.get(r.get(key).max).min = tempMin;
            }
            
            else if (!r.containsKey(key+1) && r.containsKey(key-1)) {
                tempMax = Math.max(r.get(key).max, r.get(key-1).max);
                tempMin = Math.min(r.get(key).min, r.get(key-1).min);
                r.get(key-1).max = tempMax;
                r.get(key).min = tempMin;
                r.get(r.get(key).min).max = tempMax;
            } 

            if (maxLen < r.get(key).max - r.get(key).min + 1)
                maxLen = r.get(key).max - r.get(key).min + 1;
        }
        
        return maxLen;
    }
}