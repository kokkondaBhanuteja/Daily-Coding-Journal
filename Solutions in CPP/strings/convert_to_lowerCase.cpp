#include <iostream>
#include <string>

using namespace std;

string toLowerCase(const string& str) {
    string result;
    result.reserve(str.length()); // Pre-allocate space for efficiency
    
    for (char ch : str) {
        result += (ch >= 'A' && ch <= 'Z') ? (ch | 32) : ch; // Convert only uppercase letters
    }

    return result;
}

int main() {
    cout << toLowerCase("HeLLo WoRLD!") << endl; // Output: hello world!
    return 0;
}
