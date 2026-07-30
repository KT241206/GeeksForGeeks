class Solution {
    static final int MOD = 1000000007;

    public int countSubsets(int[] arr) {
        int[] freq = new int[31];
        for (int x : arr) freq[x]++;

        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        // mask[i] = prime factor mask if square-free, else -1
        int[] mask = new int[31];
        for (int x = 2; x <= 30; x++) {
            int t = x;
            int m = 0;
            boolean ok = true;

            for (int i = 0; i < 10; i++) {
                int p = prime[i];
                int cnt = 0;
                while (t % p == 0) {
                    t /= p;
                    cnt++;
                }
                if (cnt > 1) {
                    ok = false;
                    break;
                }
                if (cnt == 1) m |= (1 << i);
            }
            mask[x] = ok ? m : -1;
        }

        int SIZE = 1 << 10;
        long[] dp = new long[SIZE];
        dp[0] = 1;

        for (int v = 2; v <= 30; v++) {
            if (freq[v] == 0 || mask[v] == -1) continue;

            long[] ndp = dp.clone();
            int m = mask[v];

            for (int s = 0; s < SIZE; s++) {
                if ((s & m) == 0) {
                    int ns = s | m;
                    ndp[ns] = (ndp[ns] + dp[s] * freq[v]) % MOD;
                }
            }
            dp = ndp;
        }

        long ans = 0;
        for (int s = 1; s < SIZE; s++) {
            ans = (ans + dp[s]) % MOD;
        }

        // Every valid subset can include/exclude each '1'
        long mul = 1;
        for (int i = 0; i < freq[1]; i++) {
            mul = (mul * 2) % MOD;
        }

        ans = (ans * mul) % MOD;
        return (int) ans;
    }
}