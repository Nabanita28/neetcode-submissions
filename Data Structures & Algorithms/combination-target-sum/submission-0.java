class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        combinationSumRecur(res, subset, nums, target, 0);
        return res;
    }

    void combinationSumRecur(List<List<Integer>> res, List<Integer> subset, int[] nums, int target, int i){

        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }

        if(target < 0 || i >= nums.length){
            return;
        }

        subset.add(nums[i]);
        combinationSumRecur(res, subset, nums, target - nums[i], i);
        subset.remove(subset.size() - 1);
        combinationSumRecur(res, subset, nums, target, i+1);


    }

}
