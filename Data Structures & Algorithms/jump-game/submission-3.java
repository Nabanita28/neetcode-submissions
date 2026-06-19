class Solution {
    public boolean canJump(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        max = Math.max(nums[0]+0, max);
        int i = 1;

       while(i < nums.length){

        if(i > max){
            return false;
         }
         max = Math.max(nums[i]+i, max);
            i++;
       }
        return  true;
    }
}
