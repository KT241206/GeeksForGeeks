class Solution {
    public int countMinOperations(int arr[]) {
        int increments = 0;
        int maxBits = 0;

        for (int num : arr) {
            increments += Integer.bitCount(num);

            if (num > 0) {
                int bits = 32 - Integer.numberOfLeadingZeros(num);
                maxBits = Math.max(maxBits, bits);
            }
        }

        return increments + Math.max(0, maxBits - 1);
    }
}