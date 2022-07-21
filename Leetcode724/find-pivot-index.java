class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftArray[] = new int[n];
        int rightArray[] = new int[n];
        
        for(int i=0;i<n;i++){
            if(i>0)
                leftArray[i] = nums[i]+leftArray[i-1];
            else
                leftArray[i] = nums[i];
        }
        
        for(int i=n-1;i>=0;i--){
            if(i<n-1)
                rightArray[i]=nums[i]+rightArray[i+1];
            else
                rightArray[i] = nums[i];
       }
        
        if(leftArray[n-1]!=rightArray[0]){
            return -1;
        }
        
        for(int i=0;i<n;i++){
            if(leftArray[i]==rightArray[i])
                return i;
        }
        return -1;
    }
}
