class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int poppedIdx = stack.pop();
                int height = heights[poppedIdx];

                int leftBound = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftBound - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int poppedIdx = stack.pop();
            int height = heights[poppedIdx];

            int leftBound = stack.isEmpty() ? -1 : stack.peek();
            int width = heights.length - leftBound - 1;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
