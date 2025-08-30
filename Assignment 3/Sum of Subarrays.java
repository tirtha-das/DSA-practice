class Solution {
    public int subarraySum(int[] arr) {
        // code here
      int sum = 0,n = arr.length;
      
      for(int i=n-1;i>=0;i--){
          int forward = (n-i);
          int backward = i+1;
          
          sum += (forward*backward*arr[i]);
      }
      
      return sum;
        
    }
}
