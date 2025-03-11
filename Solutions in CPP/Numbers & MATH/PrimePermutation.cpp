#include <bits/stdc++.h>
using namespace std;

bool isPrime(int num) {
    if (num <= 1) return false;
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) return false;
    }
    return true;
}

int findPrimePermutations(int n) {
    long long int primes = 1LL;
    long long int comps = 1LL;
    long long int p = 1LL;
    long long int c = 1LL;
    int MOD = 1e9 + 7;

    for (int i = 1; i <= n; i++) {
        if (isPrime(i)) {
            primes = (primes * p) % MOD;
            p++;
        } else {
            comps = (comps * c) % MOD;
            c++;
        }
    }
    return (primes * comps) % MOD;
}

int main() {
    int n;
    cout << "Enter the value of n: ";
    cin >> n;

    int result = findPrimePermutations(n);
    cout << "Prime Permutations for n = " << n << " is: " << result << endl;

    return 0;
}
