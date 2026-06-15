class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s2.length();
        int m = s1.length();

        if(m > n){
            return false;
        }

        int[] freq = new int[26];

        for(int i=0; i<m; i++){
            freq[s1.charAt(i) - 'a']--;
            freq[s2.charAt(i) - 'a']++;
        }

        if (checkSum(freq)){
            return true;
           }

        for(int i=m; i<n; i++){

           freq[s2.charAt(i) - 'a']++;

           freq[s2.charAt(i-m) - 'a']--;

           if (checkSum(freq)){
            return true;
           }

        }

        return false;
    }

    boolean checkSum(int[] freq){
        for(int i=0; i<26; i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }
}
