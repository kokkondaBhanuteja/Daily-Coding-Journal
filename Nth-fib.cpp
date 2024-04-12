#include<iostream>
#include<stdio.h>
using namespace std;
class fib_calc{
	public:
	
	void multiply(long long a[2][2],long long b[2][2]){
		
		long long w = a[0][0]*b[0][0] + a[0][1]*b[1][0];
		
		long long x = a[0][0]*b[0][1] + a[0][1]*b[1][1];
		
		long long y = a[1][0]*b[0][0] + a[1][1]*b[1][0];
		
		long long z = a[1][0]*b[0][1] + a[1][1]*b[1][1];
		
		a[0][0] = w;
		a[0][1] = x;
		a[1][0] = y;
		a[1][1] = z;
		
	}
	void expo(long long a[2][2],int n){
		if(n ==1 || n==0){
			return;
		}
	long long b[2][2]= {{1,1},{1,0}};
		expo(a,n/2);
		multiply(a,a);
		if((n&1) ==1){
			 multiply(a , b);
		}
	}
	long long n_fib(int n){
		long long a[2][2] = { {1,1},{1,0} };
		if(n ==0){
			return 0;
		}
		expo(a,n);
		return a[1][0];
	}
};
int main(){
	fib_calc obj;
	cout<<obj.n_fib(6);
	return 0;
}