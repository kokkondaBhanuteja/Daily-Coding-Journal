#include <bits/stdc++.h>
using namespace std;

vector<int> theOrder(int n, int k)
{
	vector<int> ans;
	list<int> l;
	for(int i=1;i<=n;i++){
		l.push_back(i);
	}
	auto it = l.begin();
	while(!l.empty()){
		// move k steps forward in the circular LinkedList
		for(int i=0;i<k;i++){
			it++;
			if(it == l.end()) it = l.begin();// bring it to forward
		}
		ans.push_back(*it); //store
		it = l.erase(it); //erase from linkedList
		//if after  erasing, we reach the end then wrap around again
		if(it == l.end()) it = l.begin();// bring it to forward	
	}
	return ans;
}
int main(){
	int n = 6, k = 3;
    vector<int> ans = theOrder(n, k);

    for (int num : ans) {
        cout << num << " ";
    }
    cout << endl;
	return 0;
}