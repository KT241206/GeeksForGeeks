class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = Math.max(h[0], l[0]);

        for (int i = 1; i < n; i++) {
            // Do low-effort today
            int low = dp[i] + l[i];

            // Do high-effort today:
            // yesterday must be skipped
            int high = dp[i - 1] + h[i];

            dp[i + 1] = Math.max(low, high);
        }

        return dp[n];
    }
}