class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        //compute freq for every element
        //start from 1st number in the array and find the starting element of the streak
        //keep decrementing the count from freq

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
        }

        for(int num : hand){
            int start = num;

            while(map.getOrDefault(start - 1, 0) > 0){
                start--;
            }
            while(start <= num){
                while(map.getOrDefault(start, 0) > 0){
                for(int i = start; i<start+groupSize; i++){
                   if( map.getOrDefault(i, 0) == 0){
                    return false;
                   }
                   map.put(i, map.get(i) - 1);
                }
            }
                start++;
            }
            
        }
        return true;
    }
}
