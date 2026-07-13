class Solution {
   class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root;
    private int ROWS = 0;
    private int COLS = 0;
   
    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        
        root = new TrieNode();
        
        for(String word : words){
            TrieNode cur = root;
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(cur.children[ch - 'a'] == null){
                    cur.children[ch - 'a'] = new TrieNode();
                }
                cur = cur.children[ch - 'a'];

            }
            cur.word = word;
        }
        List<String> res = new ArrayList<>();
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    void dfs(char[][] board, int r, int c, TrieNode node, List<String> res){

        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] == '#' || node == null){
            return ;
        }
        
        char ch = board[r][c];
        TrieNode cur = node.children[ch - 'a'];

        if(cur == null){
            return;
         }

        if(cur != null){
            if(cur.word != null){
                res.add(cur.word);
                cur.word = null;
            }
        }
        
        board[r][c] = '#';

        dfs(board,  r+1, c, cur, res);
         dfs(board,  r-1, c, cur, res);
          dfs(board,  r, c+1, cur, res);
           dfs(board,  r, c-1, cur, res);

        board[r][c] = ch;
        
        
    }
}
