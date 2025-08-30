class Solution {
public:
    int factorial(int num){
        if(num<2) return 1;

        return num*factorial(num-1);
    }

    string solve(int n,int k,set<int>&available){
       

        if(n==0){
            return "";
        }

       
        int cnt = factorial(n-1);
        int track = cnt;
        string ans = "";
        for(auto it = available.begin();it!=available.end();it++){
           if(cnt<k){
            cnt+= track;
           }else{
            int temp = *it;
          k -= (cnt-track);
            char ch = '0'+temp;
            available.erase(temp);
             ans += ch;
             ans += solve(n-1,k,available);

             break;
           }
        }
       return ans;
    }

    string getPermutation(int n, int k) {
        set<int>available;

        for(int i=1;i<=n;i++){
            available.insert(i);
        }

        return solve(n,k,available);
    }
};