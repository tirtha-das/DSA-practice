import java.io.*;
import java.util.*;

public class Solution {

     static boolean check(StringBuilder sb){
         Stack<Character> st = new Stack<>();

         for(int i=0;i<sb.length();i++){
             if(sb.charAt(i)=='(' || sb.charAt(i)=='{'){
                 st.push(sb.charAt(i));
             }else if(st.size()>0 && st.peek()=='(' && sb.charAt(i)==')'){
                 st.pop();
             }else if(st.size()>0 && st.peek()=='{' && sb.charAt(i)=='}'){
                 st.pop();
             }else{
                 return false;
             }
         }

        return true;
     }

    static void solve(int open1,int close1,int open2,int close2,StringBuilder sb){
         if(open1==0 && close1==0 && open2==0 && close2==0){
             if(check(sb)){
              System.out.println(sb.toString());
             }
             return ;
         }

         if(open1>0){
             sb.append('(');
            solve(open1-1,close1,open2,close2,sb);
            sb.deleteCharAt(sb.length()-1);
         }
         if(open2>0){
             sb.append('{');
            solve(open1,close1,open2-1,close2,sb);
           sb.deleteCharAt(sb.length()-1);
         }
          if(open1<close1){
             sb.append(')');
            solve(open1,close1-1,open2,close2,sb);
           sb.deleteCharAt(sb.length()-1);
         }
         if(open2<close2){
             sb.append('}');
            solve(open1,close1,open2,close2-1,sb);
           sb.deleteCharAt(sb.length()-1);
         }

     }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        
         int n = sc.nextInt();
         int m = sc.nextInt();
         
        StringBuilder sb =  new StringBuilder("");

       solve(n,n,m,m,sb);
    }
}