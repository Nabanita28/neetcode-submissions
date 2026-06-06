class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }
       // Bidirectional BFS
       //Define 2 queues: beginq and endq, 2 maps tp keep track of the visited nodes and the steps
       //1 set to hold the list of words
       
       Map<String, Integer> map1 = new HashMap<>();
       Map<String, Integer> map2 = new HashMap<>();
       Queue<String> q1 = new LinkedList<>();
       Queue<String> q2 = new LinkedList<>();
       Set<String> set = new HashSet<>(wordList);

       
        map1.put(beginWord, 1);
        map2.put(endWord, 1);

        q1.add(beginWord);
        q2.add(endWord);
        int m = wordList.get(0).length();
        while(!q1.isEmpty() && !q2.isEmpty()){

            //swap queues and maps 
            if(q1.size() > q2.size()){
                Queue<String> tempQ = q1;
                q1 = q2;
                q2 = tempQ;

                Map<String, Integer> tempMap = map1;
                map1 = map2;
                map2 = tempMap;
            }

        
        int size = q1.size();
        for(int k = 0; k<size; k++){
            String word = q1.poll();
            int steps = map1.get(word);

            for(int i=0; i<m; i++){
                for(char c = 'a'; c <= 'z'; c++){
                    if(c == word.charAt(i)){
                        continue;
                    }
                    String nei = word.substring(0, i) + c + word.substring(i+1);
                    if(!set.contains(nei)){
                        continue;
                    }
                    if(map2.containsKey(nei)){
                        return map2.get(nei) + steps;
                    }
                    if(!map1.containsKey(nei)){
                        map1.put(nei, steps+1);
                        q1.add(nei);
                    }
                }
            }
        }
    }
            
    return 0;
       
    }
}
