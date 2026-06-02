class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesisRecur(0, 0, res, sb, n);
        return res;
        
    }

    void generateParenthesisRecur(int open, int close, List<String> res, StringBuilder sb, int n){
        
        if(open == close && open == n){
            res.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append("(");
            generateParenthesisRecur(open+1, close, res, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            generateParenthesisRecur(open, close+1, res, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
