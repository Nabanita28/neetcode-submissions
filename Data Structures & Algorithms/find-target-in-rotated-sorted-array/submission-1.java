class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int l = 0;
        int r = n;

        //find pivot
        while(l < r){

            int mid = l + (r-l)/2;

            if(nums[mid] > nums[r]){
                l = mid+1;
            } else{
                r = mid;
            }
        }

        int pivot = l;

        int result = binarySearch(nums, target, 0, pivot-1);

        if(result != -1){
            return result;
        }

        return binarySearch(nums, target, pivot, n);


        
    }

    int binarySearch(int[] nums, int target, int l, int r){

        while( l<= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid -1 ;
            }
        }
        return -1;
    }
}
