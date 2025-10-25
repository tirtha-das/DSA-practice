class Solution {
    String forward(String s,int len){
        StringBuilder sb = new StringBuilder(s);
        int i=0,j=len-1;
        while(i<j){
            char temp = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,temp);
            i++;
            j--;
        }

        return sb.toString();
    }

    String backward(String s,int len){
        StringBuilder sb = new StringBuilder(s);
        int sz = s.length();
        int i=sz-len,j=sz-1;
        while(i<j){
            char temp = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,temp);
            i++;
            j--;
        }

        return sb.toString();
    }
    
    public String lexSmallest(String s) {
        String small = s;
        for(int i=1;i<=s.length();i++){
            String s1 = forward(s,i);
            String s2 = backward(s,i);

            if(small.compareTo(s1)>0){
                small = s1;
            }

            if(small.compareTo(s2)>0){
                small = s2;
            }
        }

        return small;
    }
}