class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int value : arr) {
            if (value < root) {
                return false;
            }

            while (!stack.isEmpty() && value > stack.peek()) {
                root = stack.pop();
            }

            stack.push(value);
        }

        return true;
    }
}