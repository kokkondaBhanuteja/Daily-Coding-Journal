#include<bits/stdc++.h>
using namespace std;
int missingNumber(int n, vector<int> &arr){
    int oddOne = 0;
    for(int num: arr){
        oddOne^=num;
    }
    return oddOne;
}
int main(){
	vector<int> arr = {1, 2, 3, 2, 3};
	int n = 5;
	cout<<missingNumber(n,arr)<<endl;
}