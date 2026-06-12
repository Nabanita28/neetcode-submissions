class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        //create pos and speed pairs and sort the cars according to position
        int[][] cars = new int[n][2];

        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        
        double timeSoFar = (double)(target - cars[0][0]) / cars[0][1];
        System.out.print(timeSoFar);
        int fleet = 1;

        for(int i=1; i<n; i++){
            double time = (double)(target - cars[i][0]) / cars[i][1];

            if( time > timeSoFar){
                fleet ++;
                timeSoFar = time;
            }

        }

        return fleet;
    }
}
