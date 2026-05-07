class Solution {
    public int maxArea(int[] height) {
         
        int i = 0; 
        int j = height.length - 1;
        int max = -1;
        int amt = 0;

        while( i < j){
            
            amt = Math.min(height[i], height[j]) * (j-i);

            max = Math.max(amt, max);

            if(height[i] < height[j]){
                i++;
            } else if(height[i] > height[j]){
                j--;
            } else{
                j--;
            }
            
        }
        return max;
    }
}
