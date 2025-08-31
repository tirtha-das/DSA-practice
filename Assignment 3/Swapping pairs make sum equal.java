// User function Template for Java

class Solution {
    boolean isPossibile(int[] small, int[] big,int k){
        int start = 0;
        for(int i=0;i<big.length;i++){
            int val = big[i];
            if(val-small[start]>k){
                start++;
                i--;
                if(start==small.length) return false;
            }else if(val-small[start]==k){
                 return true;
            }
        }
        
        return false;
    }
    
    boolean findSwapValues(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        
        int sum1 = 0,sum2 = 0;
        
        for(int val:a){
            sum1+=val;
        }
        
        for(int val:b){
            sum2+=val;
        }
        
        int sum = (sum1+sum2);
        
        if(sum%2!=0) return false;
        int limit = sum/2;
        
        if(sum1<sum2){
            int k = limit-sum1;
           return isPossibile(a,b,k);
        }else{
             int k = limit-sum2;
           return isPossibile(b,a,k);
        }
    }
}
