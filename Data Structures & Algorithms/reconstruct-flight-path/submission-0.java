class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        

        //Greedy DFS
        //construct the adj list
        Map<String, Queue<String>> adj = new HashMap<>();

        for(List<String> ticket : tickets){
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> res = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        stack.push("JFK");

        while(!stack.isEmpty()){

            String curr = stack.peek();

            if(!adj.containsKey(curr) || adj.get(curr).isEmpty()){
                res.addFirst(stack.pop());
            } else {
                stack.push(adj.get(curr).poll());
            }
        }
        return res;

    }
}
