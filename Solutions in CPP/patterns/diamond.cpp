#include <bits/stdc++.h>
#include <iostream>
using namespace std;
// A diamond is a simple program that combines both the upright triangle and
// it's inverse in a singlr program
void print_diamond(int n)
{
    // this is upper triangle
    for (int i = 1; i <= n; i++)
    {
        // spaces before printing
        for (int j = n - i; j >= 0; j--)
        {
            cout << '*';
        }
        for (int j = 1; j <= (2 * i - 1); j++)
        {
            cout << ' ';
        }
        for (int j = n - i; j >= 0; j--)
        {
            cout << '*';
        }
        cout << "\n";
    }
    //  now printing the lower triangle
    for (int i = n - 1; i >= 0; i--)
    {
        for (int j = n - i; j >= 0; j--)
        {
            cout << '*';
        }
        for (int j = 1; j <= (2 * i - 1); j++)
        {
            cout << ' ';
        }
         for (int j = n - i; j >= 0; j--)
        {
            cout << '*';
        }
        cout << "\n";
    }
    
}

int main()
{
    int n;
    cout << "Enter the number:" << endl;
    cin >> n;
    cout << n << endl;
    print_diamond(n);
    return 0;
}