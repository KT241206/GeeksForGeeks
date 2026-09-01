class Solution {
    static final long MOD = 1000000007L;

    public int palindromicStrings(int n, int k) {
        long ans = 0;

        // Even length palindromes: length = 2*m
        // Odd length palindromes: length = 2*m + 1

        for (int len = 1; len <= n; len++) {
            int pairs = len / 2;
            long count = 1;

            if (len % 2 == 0) {
                // P(k, pairs)
                for (int i = 0; i < pairs; i++) {
                    count = (count * (k - i)) % MOD;
                }
            } else {
                // Choose middle character first: k choices
                count = k;

                // P(k-1, pairs)
                for (int i = 0; i < pairs; i++) {
                    count = (count * (k - 1 - i)) % MOD;
                }
            }

            ans = (ans + count) % MOD;
        }

        return (int) ans;
    }
}