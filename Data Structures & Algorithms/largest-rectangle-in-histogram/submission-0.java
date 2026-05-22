class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        //left
        for(int i=0; i<n; i++){
            left[i] = -1;

            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
        //right
        for(int i=n-1; i>=0; i--){
            right[i] = n;

            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        //calculate

        for(int i=0; i<n; i++){
            left[i] = left[i] + 1;
            right[i] = right[i] -1;
            max = Math.max(max, heights[i]*(right[i] - left[i] + 1));

        }
        return max;
    }
}
