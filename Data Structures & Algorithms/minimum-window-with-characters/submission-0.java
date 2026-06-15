class Solution {
    public String minWindow(String s, String t) {

        if(s == null || t == null || t.isEmpty() || s.length() < t.length()){
            return "";
        }

        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> wmap = new HashMap<>();


        for(int i=0; i<t.length(); i++){

            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

        }

        int l = 0;
        int r = 0;

        String res = "";
        boolean found = false;


        while(r < n){

            wmap.put(s.charAt(r), wmap.getOrDefault(s.charAt(r), 0) + 1);

            r++;

            while(isValid(map, wmap)){
                //OUZODYX
                String str = s.substring(l, r);
               if(!found || res.length() > str.length()){
                    res = str;
                    found = true;
               }
               
               
               wmap.put(s.charAt(l), wmap.get(s.charAt(l)) - 1);
               l++;
               if(l >= n){
                    break;
               }
            }

        }
        return res;
    }

    boolean isValid(Map<Character, Integer> map, Map<Character, Integer> wmap){

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
 
            if(!wmap.containsKey(entry.getKey())){

                return false;
            }

            if(wmap.get(entry.getKey()) < entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
