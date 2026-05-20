class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<tokens.length; i++){

            String c = tokens[i];

            if(c.equals("+")){
                if(stack.size() >= 2){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a+b);
                }
            } else if(c.equals("-")){
                if(stack.size() >= 2){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b-a);
                }
            } else if( c.equals("*") ){
                if(stack.size() >= 2){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a*b);
                }
            } else if (c.equals("/")){
                if(stack.size() >= 2){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                }
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
