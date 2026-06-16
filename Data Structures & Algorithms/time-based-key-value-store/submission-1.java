class TimeMap {

    Map<String, List<Pair<Integer, String>>> map ;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = map.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r =  values.size() - 1;
        String res = "";
        while( l <= r){

            int mid = l + (r-l)/2;

            if(values.get(mid).getKey() <= timestamp){
                res = values.get(mid).getValue();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;

    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return this.key;
        }

        public V getValue(){
            return this.value;
        }
    }
}
