class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = height[0];
        int maxR = height[height.length - 1];
        int sum = 0;

        while(l < r){
            if(maxL <= maxR){
                l++;
                maxL = Math.max(maxL, height[l]);
                sum = sum + (maxL - height[l]);
                
            } else{
                r--;
                maxR = Math.max(maxR, height[r]);
                sum = sum + (maxR - height[r]);
            }
        }
        return sum;
    }
}
