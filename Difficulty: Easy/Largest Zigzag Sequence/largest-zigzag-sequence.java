class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] newDp = new int[n];

            for (int j = 0; j < n; j++) {
                int best = 0;

                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        best = Math.max(best, dp[k]);
                    }
                }

                newDp[j] = mat[i][j] + best;
            }

            dp = newDp;
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[j]);
        }

        return ans;
    }
}