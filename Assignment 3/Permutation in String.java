class Solution {
    boolean isTrue(int[] num1,int[] num2){
        for(int i=0;i<26;i++){
            if(num1[i]!=num2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        Arrays.fill(freq1,0);
        Arrays.fill(freq2,0);

        for(int i=0;i<s1.length();i++){
            freq1[(int)(s1.charAt(i)-'a')]++;
        }

        int k = s1.length();
        int left = 0;
        for(int right = 0;right<s2.length();right++){
            freq2[(int)(s2.charAt(right)-'a')]++;

            if(right-left==k-1){
                if(isTrue(freq1,freq2)){
                    return true;
                }
                freq2[(int)(s2.charAt(left)-'a')]--;
                left++;
            }
            

        }

       return false;

    }
}