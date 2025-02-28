#include<iostream>
#include<stdlib.h>

using namespace std;
int arr[10][10];
void rotate_anti(int arr[][10], int n ){
	int l=0;
	int r = n-1;
	while(l<r){
		int top =l;
		int bot = r;
		for(int i=0;i<(r-l); i++){
			int temp = arr[top][l+i];
			
			arr[top][l+i] = arr[top+i][r];
			
			arr[top+i][r] = arr[bot][r-i];
			
			arr[bot][r-i] = arr[bot-i][l];
			
			arr[bot-i][l] = temp;
		}
		l++;
		r--;
	}
}
int main(){
int N;
cout<<"Enter the Order of the Matrix: "<<endl;
cin>>N;
cout<<"Enter the Matrix Elements: "<<endl;
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			cin>>arr[i][j];
		}
	}
	
	cout<<"\n The MAtrix is = \n";
	for(int i=0;i<N;i++)
	{
		for(int j=0;j<N;j++){
			cout<<arr[i][j]<<"\t";
		}
		cout<<"\n";
	}
	rotate_anti(arr,N);
	cout<<"\n The MAtrix AFTER Rotation is = \n";
	for(int i=0;i<N;i++)
	{
		for(int j=0;j<N;j++){
			cout<<arr[i][j]<<"\t";
		}
		cout<<"\n";
	}
	return 0;
}
