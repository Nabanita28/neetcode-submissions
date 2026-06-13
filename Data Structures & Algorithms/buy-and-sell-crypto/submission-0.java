class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int l = 0;
        int r = 1;
        int max = 0;

        while(r < n){
            if(prices[l] < prices[r]){
                max = Math.max(max, prices[r] - prices[l]);
                r++;
            } else {
                l = r;
                r++;
            }
        }
        return max;
    }
}
