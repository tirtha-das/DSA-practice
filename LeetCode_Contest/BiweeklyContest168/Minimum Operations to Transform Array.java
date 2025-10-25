class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        long ans = 1;
        int n = nums1.length;
        int lastVal = nums2[n];
        int[] arr = new int[(int)(1e6)];
        for(int i=0;i<n;i++){
            if(nums1[i]<nums2[i]){
                ans += (nums2[i]-nums1[i]);
                arr[nums1[i]]++;
                arr[nums2[i]+1]--;
            }else if(nums1[i]>nums2[i]){
                ans += (nums1[i]-nums2[i]);
                arr[nums2[i]]++;
                arr[nums1[i]+1]--;
            }else{
                arr[nums1[i]]++;
                arr[nums1[i]+1]--;
            }
        }

        int close = Integer.MAX_VALUE;
        int active = 0;
        for(int i=0;i<arr.length;i++){
            active+=arr[i];
            if(active>0){
                close = Math.min(close,Math.abs(lastVal - i));
            }
        }

        ans += close;

        return ans;
    }
}