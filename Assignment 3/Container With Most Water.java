class Solution {
    public int maxArea(int[] height) 
    {
        int l=0,r=height.length-1;
        int max=0;
        while(l<r)
        {
            int h=Math.min(height[l],height[r]);
            max=Math.max(((r-l)*h),max);
            if(h==height[l])
            {
                l++;
            }
            else{
                r--;
            }
        }
        return max;
        
    }
}