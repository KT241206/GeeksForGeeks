class Solution {
    public int maxIndexDifference(String s) {
        int[] best = new int[26];

        // best[i] = farthest ending index reachable from ANY processed
        // occurrence of ('a' + i)
        for (int i = 0; i < 26; i++) {
            best[i] = -1;
        }

        int ans = -1;

        for (int i = s.length() - 1; i >= 0; i--) {

            int ch = s.charAt(i) - 'a';

            // End index if we start from THIS occurrence
            int end = i;

            // Jump to any next alphabet on the right
            if (ch < 25 && best[ch + 1] != -1) {
                end = Math.max(end, best[ch + 1]);
            }

            // Update the best end for this character
            best[ch] = Math.max(best[ch], end);

            // Every 'a' is a valid starting point
            if (ch == 0) {
                ans = Math.max(ans, end - i);
            }
        }

        return ans;
    }
}