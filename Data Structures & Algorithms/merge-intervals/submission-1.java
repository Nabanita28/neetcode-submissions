class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i = 1; i<intervals.length; i++){
            int[] prev = res.get(res.size()-1);
            int[] curr = intervals[i];
            int start = curr[0];
            int lastTime = prev[1];

            if(lastTime >= start){
                res.remove(res.size()-1);
                prev = new int[]{prev[0], Math.max(lastTime, curr[1])};
                res.add(prev);
            } else {
                res.add(new int[]{curr[0], curr[1]});
            }
        }
        int[][] output = new int[res.size()][2];

        for(int i =0; i<res.size(); i++){
            output[i] = res.get(i);
        }

        return output;
    }
}
