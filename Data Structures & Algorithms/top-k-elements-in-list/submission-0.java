class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<Integer>[] freq = new List[nums.length+1];
        for(int i=0; i<nums.length+1; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry entry : map.entrySet()){
            int key = (int)entry.getKey();
            int val = (int)entry.getValue();
            freq[val].add(key); 
        }

        List<Integer> res = new ArrayList();

        for(int i=freq.length-1; i>0 ; i--){
            for(int n : freq[i]){
                res.add(n);
                if(res.size() == k){
                    return res.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
