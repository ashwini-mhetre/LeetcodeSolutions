class Solution {
    public int deleteAndEarn(int[] nums) {
        return dfs(nums, new boolean[nums.length]);
    }

    private int dfs(int[] nums, boolean[] visited) {
        if(nums.length==0)
            return 0;

        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            visited[i] = true;
            int current = nums[i];
            List<Integer> remaining = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if(visited[j]) continue;
                if (nums[j] != current - 1 && nums[j] != current + 1) {
                    remaining.add(nums[j]);
                }
            }
            currentSum += dfs(remaining.stream()
                    .mapToInt(Integer::intValue)
                    .toArray(), new boolean[remaining.size()]);
            maxSum = Math.max(maxSum, currentSum + current);
        }
        return maxSum;
    }
}
