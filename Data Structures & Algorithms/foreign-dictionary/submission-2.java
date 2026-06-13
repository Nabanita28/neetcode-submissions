class Solution {
    public String foreignDictionary(String[] words) {

        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i=1; i<words.length; i++){
            String w1 = words[i-1];
            String w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            int j = 0;

            if(w1.length() > w2.length() && w1.substring(0, len).equals(w2.substring(0, len))){
                return "";
            }

            while(j < len && w1.charAt(j) == w2.charAt(j)){
                j++;
            }
            if(j < len){
                if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
                    adj.computeIfAbsent(w1.charAt(j), k -> new HashSet<>())
                        .add(w2.charAt(j));

                indegree.put(w2.charAt(j), indegree.getOrDefault(w2.charAt(j), 0)+ 1);
                }
            }
        }

        Queue<Character> q = new LinkedList<>();

        
        for(char c : indegree.keySet()){

                if(indegree.get(c) == 0){
                    q.offer(c);
                }
        }
        


        StringBuilder res = new StringBuilder();

        while(!q.isEmpty()){
            char ch = q.poll();
            res.append(ch);

            if(adj.containsKey(ch)){
                for(char nei : adj.get(ch)){

                    indegree.put(nei, indegree.get(nei) - 1);

                    if(indegree.get(nei) == 0){
                        q.offer(nei);
                    }

                }
            }


        }

        if(res.length() != indegree.size()){
            return "";
        }
        return res.toString();
    }
}
