#include<bits/stdc++.h>
using namespace std;
string findDivision(int x, int y, int n) {
	string str= "";
	if((x<0 && y >0) || (x > 0 && y < 0)){
		str+="-";
		x = abs(x);
		y = abs(y);
	}
	int d = x/y;
	int i =0; 
	for(i=0;i<=n;i++){
		
		str+=to_string(d);
		if( i ==0){
			str+=".";
		}
		x = x-(y*d);
		if( x == 0) break;
		x = x*10;
		d = x/y;
		
		
	}
	while(i<n){
		str+='0';
		i++;
	}
	return str;
}
int main(){
    int x, y, n;
    cin >> x >> y >> n;
    cout<<findDivision(x, y, n)<<endl;
    return 0;
}