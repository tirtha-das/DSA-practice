class Solution {
public:
    int romanToInt(string s) {
        unordered_map<string,int>mp;
        string symbol[] = {"I", "V", "X", "L","C","D","M","IV","IX","XL","XC","CD","CM"};
        int val[]={1,5,10,50,100,500,1000,4,9,40,90,400,900};


        for(int i=0;i<13;i++){
            mp[symbol[i]]=val[i];
        }

        int sum = 0;

        for(int i=0;i<s.size();i++){
            string temp = "";
                temp+=s[i];
            if(i<s.size()-1 && (s[i]=='I'|| s[i]=='X' || s[i]=='C')){
            
                    
                temp +=s[i+1];
                if(mp.find(temp)!= mp.end()){
                     sum +=mp[temp];
                    i++;
                }
               else{
                   sum+=mp[temp.substr(0,1)];
               }
                
                
            }else{
                
                sum+= mp[temp];
            }
        }

        return sum;
    }
};