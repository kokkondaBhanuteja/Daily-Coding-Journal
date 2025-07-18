#include <bits/stdc++.h> 
using namespace std;
bool isValid(string str){
    int flag = 0;
    for(char ch: str){
        if(ch == '(')flag++;
        else if(ch == ')')flag--;

        if(flag < 0)return false;
    }
    return flag == 0;
}
vector<string> minRemovaltoMakeStringValid(string &str)
{
    vector<string> ans;
    set<string> s;
    queue<string> q;
    q.push(str);
    while(!q.empty()){
        int n = q.size();
        while( n-- ){
            string temp = q.front();
            q.pop();
            if(s.find(temp) != s.end()) continue;
            else s.insert(temp);
            if(isValid(temp)){
                ans.push_back(temp);
            }
            for(int i=0;i<temp.size();i++){
                if(temp[i] == '(' || temp[i] == ')'){
                    string temp2 = temp.substr(0,i) + temp.substr(i+1);
                    q.push(temp2);
                }
            }
        }
        if(ans.size() != 0 )return ans;
    }
    return ans;
}

int main(){
    string str = "()(x))()";
    vector<string> ans = minRemovaltoMakeStringValid(str);
    for(string s: ans){
        cout<< s<<" , ";
    }
    cout<<"\n";
    return 0;
}