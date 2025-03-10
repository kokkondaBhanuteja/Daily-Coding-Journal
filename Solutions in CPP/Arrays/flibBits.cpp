#include <bits/stdc++.h> 
using namespace std;

int flipSomeBits(int num, vector<int> &arr, int n)
{
	vector<int> binary(32,0);
	//converting the number into a binary format using an array.
	for(int i=0;i<32;i++){
		int bit = 1<<i;
		if(num&bit){
			binary[i] = 1;
		}
		else{
			binary[i] = 0;
		}
	}

	//flipping the bits using XOR Operation
	for(int pos: arr){
		binary[pos-1] = binary[pos-1]^1;
	}
	//now convert the array to number;
	int ans = 0;
	int bit = 1;
	for(int i=0;i<32;i++){
		if(binary[i]&1){
			ans+=bit;
		}
		bit*=2;
	}
	return ans;
}
//main method
int main() {
    int num, n;
    cout << "Enter size of the array : ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter positions to flip (1-based index): ";

	for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    cout << "Enter a number to be flipped : ";
    cin >> num;


    int result = flipSomeBits(num, arr, n);
    cout << "Modified number after flipping bits: " << result << endl;

    return 0;
}