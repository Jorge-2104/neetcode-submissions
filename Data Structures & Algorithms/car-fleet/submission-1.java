class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new int[] {position[i], speed[i]};
        }

        Arrays.sort(cars, (a,b) -> b[0]-a[0]);

        int fleetCount = 0;
        double bestTime = -1.0;

        for (int i = 0; i < cars.length; i++) {
            double time = (double) (target-cars[i][0]) / cars[i][1];

            if (time > bestTime) {
                fleetCount++;
                bestTime = time;
            }
        }

        return fleetCount;
    }
}
