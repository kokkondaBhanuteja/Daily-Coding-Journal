#include <bits/stdc++.h> 
using namespace std;
vector<vector<int>> solve(vector<vector<int>> &arr, int k)
{
    // Write your code here.
    int n = arr.size();
    k = k%n;
    vector<vector<int>>temp(n,vector<int>(n,0));
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            int set  = (j+k)%n;
            temp[i][set] = arr[i][j];
        }
    }
    return temp;
}
void printMatrix(vector<vector<int>> mat) {
        for (vector<int> row: mat) {
            for (int val : row) {
				cout<<val<<"\t";
            }
            cout<<"\n";
        }
}

int main(){
	 vector<vector<int>>arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int k = 1;
		cout<<"BEFORE"<<endl;
		        printMatrix(arr);
         vector<vector<int>> result = solve(arr, k);
		 cout<<"AFTER"<<endl;
        printMatrix(result);
	return 0;
}