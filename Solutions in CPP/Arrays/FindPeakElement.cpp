#include<bits/stdc++.h>
using namespace std;
int findPeakElement(vector<int> &arr) {
    int left = 0;
    int right = arr.size()-1;
    if(right == left)return 0;
    if(arr[left] > arr[left+1]){
        return left;
    }
    if(arr[right] > arr[right-1]){
        return right;
    }
    left++;
    right--;
    while(left<=right){
        int mid =  left + (right-left)/2;
        if(arr[mid] > arr[mid+1] &&arr[mid]> arr[mid-1]){
            return mid;
        }
        else if(arr[mid] > arr[mid+1]){
            right = mid-1;
        }else{
            left = mid+1;
        }
    }
    return -1;
}
int main(){
    vector<int> arr = {1, 8, 1, 5, 3};
    cout<<findPeakElement(arr)<<endl;
}