class Solution {
    public int countFriendsPairings(int n) {
        int MOD = 1000000007;

        if (n <= 2) return n;

        long a = 1;
        long b = 2;

        for (int i = 3; i <= n; i++) {
            long c = (b + ((long)(i - 1) * a) % MOD) % MOD;
            a = b;
            b = c;
        }

        return (int)b;
    }
}