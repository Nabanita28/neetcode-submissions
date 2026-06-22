class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }

        int l = 0;
        List<Integer> res = new ArrayList<>();

        while (l < n) {
            int r = map.get(s.charAt(l));
            int count = 0;

            while (l <= r) {
                r = Math.max(r, map.get(s.charAt(l)));
                l++;
                count++;
            }
        res.add(count);
            
        }
        return res;
    }
}
