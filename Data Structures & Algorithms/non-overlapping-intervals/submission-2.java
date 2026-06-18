class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        //By sorting intervals by their end times, we can easily check if the next interval overlaps with the previous one.
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int end = intervals[0][1];
        int count = 0;

        for(int i=1; i<intervals.length; i++){

            if(end > intervals[i][0]){
                count++;
            }
            else {
                end = intervals[i][1];
            }
        }

        return count;
    }
}
