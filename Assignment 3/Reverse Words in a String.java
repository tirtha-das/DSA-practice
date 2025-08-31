class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder("");

        int start = s.length()-1;

        while(start>=0){
            while(start>=0 && Character.isWhitespace(s.charAt(start))){
                start--;
            }

            int end = start;
            if(end==start){
            while(start>=0 && !Character.isWhitespace(s.charAt(start))){
                start--;
            }
            if(start<end){
            if(res.length()>0){
                res.append(" ");
            }

             res.append(s.substring(start+1,end+1));
            }
            
            }
        }

        return res.toString();
    }
}