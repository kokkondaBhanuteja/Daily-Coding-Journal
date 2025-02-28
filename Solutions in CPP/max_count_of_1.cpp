#include<bits/stdc++.h>
using namespace std;

/*
For Example:
ARR = [0, 1, 1, 0, 0, 1, 1, 1], 
here you can see the maximum length of consecutive 1’s is 3. 
Hence the answer is 3.
*/

int consecutiveOnes(vector<int>& arr){
    //Write your code here.
    int count =0;
    int max_count =0;
    for(int i=0;i<arr.size();i++){
        if(arr[i] == 1){
            count+=1;
        }
        if(count >= max_count){
            count =0;
            max_count = count;
        }
    }
    return max_count;
}