#include<iostream>
using namespace std;
int A[10][10];
int N;
void rotate(int arr[][10],int n){
	int l=0,r=n-1;
	while(l<r){
		for(int i=0;i<(r-l);i++){
			int top = l;
			int bottom = r;
			
			int temp = arr[top][l+i];
			
			arr[top][l+i] = arr[bottom-i][l];
			
			arr[bottom-i][l] = arr[bottom][r-i];
			
			arr[bottom][r-i] = arr[top+i][r];
			
			arr[top+i][r] = temp;
		}
		l++;
		r--;
	}
}

int main()
{

	cout<<"Enter the Order of the Matrix:";
	cin>>N;
	cout<<"\n Enter the Matrix Elements:";
	
	for(int i=0;i<N;i++)
	{
		for(int j=0;j<N;j++){
			cin>>A[i][j];
		}
	}
	cout<<"\n The MAtrix is = \n";
	for(int i=0;i<N;i++)
	{
		for(int j=0;j<N;j++){
			cout<<A[i][j]<<"\t";
		}
		cout<<"\n";
	}
	rotate(A,N);
	cout<<"\n After the Rotation is = \n";
	for(int i=0;i<N;i++)
	{
		for(int j=0;j<N;j++){
			cout<<A[i][j]<<"\t";
		}
		cout<<"\n";
	}
	return 0;
}
