class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){

            //if we dont find any smaller left bar, we mark that position as -1 

            left[i] = -1;

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = n-1; i>=0; i--){
            right[i] = n;

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int area = 0;
        for(int i=0; i<n; i++){
            left[i] += 1;
            right[i] -= 1;
            area = Math.max(area, heights[i]*(right[i] - left[i] + 1));
        }

        return area;
    }
}
