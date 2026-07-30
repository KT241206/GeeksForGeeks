class Solution {
    public int maxSubsetXOR(int[] arr) {
        int n = arr.length;
        int index = 0;

        // Process bits from MSB to LSB
        for (int bit = 31; bit >= 0; bit--) {
            int maxIndex = -1;

            // Find an element with the current bit set
            for (int i = index; i < n; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    maxIndex = i;
                    break;
                }
            }

            if (maxIndex == -1)
                continue;

            // Swap pivot element to current index
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;

            // Eliminate current bit from all other elements
            for (int i = 0; i < n; i++) {
                if (i != index && (arr[i] & (1 << bit)) != 0) {
                    arr[i] ^= arr[index];
                }
            }

            index++;
        }

        // Find maximum XOR
        int ans = 0;
        for (int num : arr) {
            ans = Math.max(ans, ans ^ num);
        }

        return ans;
    }
}