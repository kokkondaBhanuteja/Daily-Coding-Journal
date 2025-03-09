#include <bits/stdc++.h>

using namespace std;

void helper(int index, int N, string str, vector<string> &ans) {
    if (index == N) {
        ans.push_back(str);
        return;
    }
    helper(index + 1, N, str + '0', ans);

    if (index == 0 || str[index - 1] != '1') {
        helper(index + 1, N, str + '1', ans);
    }
}

vector<string> generateString(int N) {
    vector<string> ans;
    string temp = "";
    helper(0, N, temp, ans);
    return ans;
}

int main() {
    int N;
    cout << "Enter the value of N: ";
    cin >> N;

    vector<string> result = generateString(N);

    cout << "Generated strings: " << endl;
    for (const string &s : result) {
        cout << s << endl;
    }

    return 0;
}
