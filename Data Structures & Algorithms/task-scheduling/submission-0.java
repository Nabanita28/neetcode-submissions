class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : freq) {
            if (i > 0) {
                pq.add(i);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (pq.isEmpty()) {
                time = q.peek()[1];
            } else {
                int t = pq.poll() - 1;
                if (t > 0) {
                    q.add(new int[] {t, time + n});
                }
            }

            // put tasks from queue to heap
            if (!q.isEmpty() && time == q.peek()[1]) {
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}
