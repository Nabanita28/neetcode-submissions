class Solution {

    public String encode(List<String> strs) {

        String res = "";
        if(strs.size() == 0){
            return res;
        }

        for(int i=0; i<strs.size(); i++){
            res = res + strs.get(i).length() + "#" + strs.get(i) ;
        }

        return res;
    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();

        int j = 0;
        for(int i = 0; i<str.length(); i++){
        String num = "";

            while( str.charAt(j) != '#') {

                 num = num + str.charAt(j);
               
                j++;
            }
             if(str.charAt(j) == '#'){
                i = j+1;
            }

            String s = "";
            int number = Integer.parseInt(num);
            while( number > 0){
                s = s + str.charAt(i);
                i++;
                number--;
            }
            res.add(s);
            j = i;

        }
        return res;
    }
}
