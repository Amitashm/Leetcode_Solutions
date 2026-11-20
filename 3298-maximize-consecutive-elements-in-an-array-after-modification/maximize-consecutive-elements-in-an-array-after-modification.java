class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        int maxVal = nums[nums.length - 1];

        // dp[v] = longest consecutive run ending at value v
        int[] dp = new int[maxVal + 2];
        int ans = 0;

        for (int x : nums) {
            // Option 1: raise x to x + 1, extending the run that ends at x.
            // This must be updated first so it reads dp[x] from earlier elements only.
            dp[x + 1] = dp[x] + 1;

            // Option 2: keep x as it is, extending the run that ends at x - 1.
            dp[x] = dp[x - 1] + 1;

            ans = Math.max(ans, Math.max(dp[x], dp[x + 1]));
        }

        return ans;
    }
}