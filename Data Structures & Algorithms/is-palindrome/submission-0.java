class Solution {
    public boolean isPalindrome(String s) {
         String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = cleanString.length();
        int j = len - 1;
        int i = 0;

        while(i<j){
            if(cleanString.charAt(i) != cleanString.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
