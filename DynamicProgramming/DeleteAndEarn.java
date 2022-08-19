class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> allPoints = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int val = allPoints.getOrDefault(nums[i], 0);
            allPoints.put(nums[i], val+nums[i]);
            max = Math.max(nums[i], max);
        }

        return maxPoints(max, allPoints, dp);
    }

    private int maxPoints(int max, Map<Integer, Integer> allPoints, Map<Integer, Integer> dp){
        if(max<=0) return 0;
        if(dp.containsKey(max)) return dp.get(max);
        int gain = allPoints.getOrDefault(max, 0);
        dp.put(max, Math.max(maxPoints(max-2, allPoints, dp)+gain, maxPoints(max-1, allPoints, dp)));
        return dp.get(max);
    }
}
