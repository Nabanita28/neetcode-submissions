class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<>();
        combinationSum2Recur(res, subset, candidates, target, 0);
        return res;

    }

    void combinationSum2Recur(List<List<Integer>> res, List<Integer> subset, int[] candidates, int target, int i){

        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }

        if(target < 0 || i == candidates.length){
            return;
        }

        subset.add(candidates[i]);
        combinationSum2Recur(res, subset, candidates, target-candidates[i], i+1);
        subset.remove(subset.size() - 1);

        while(i+1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        combinationSum2Recur(res, subset, candidates, target, i+1);

    }
}
