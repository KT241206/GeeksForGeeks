class Solution {
    public static int countPairs(int arr[], int k) {
        Arrays.sort(arr);
        
        int n = arr.length;
        int i = 0;
        int ans = 0;
        
        for (int j = 0; j < n; j++) {
            while (i < j && arr[j] - arr[i] >= k) {
                i++;
            }
            ans += (j - i);
        }
        
        return ans;
    }
}