class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean x = false;
        boolean y = false;
        boolean z = false;

        for(int[] triplet : triplets){
            x = x || (triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]);
            y = y || (triplet[0] <= target[0] && triplet[1] == target[1] && triplet[2] <= target[2]);
            z = z || (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] == target[2]);

            if(x && y && z){
                return true;
            }
        }
        return false;
    }
}
