class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int seq = 0;
        for(int i=0; i<nums.length; i++){

            if(!set.contains(nums[i] - 1)){
                int length = 1;
                while(set.contains(nums[i] + length)){
                    length++;
                }
                seq = Math.max(seq, length);
            }
        }
        return seq;
    }
}
