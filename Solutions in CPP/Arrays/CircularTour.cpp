#include <bits/stdc++.h> 
using namespace std;

int firstCircularTour(vector<int>& petrol, vector<int>& distance, int N) {
    long minDistance = 0;
    long present = 0;
    long loss = 0;
    
    for (int i = 0; i < petrol.size(); i++) {
        present += petrol[i] - distance[i];
        if (present < 0) {
            minDistance = i + 1;
            loss += present;
            present = 0;
        }
    }
    return (present + loss) >= 0 ? minDistance : -1;
}

int main() {
    // Input
    int N;
    cout << "Enter number of petrol pumps: ";
    cin >> N;

    vector<int> petrol(N), distance(N);
    
    cout << "Enter petrol values: ";
    for (int i = 0; i < N; i++) {
        cin >> petrol[i];
    }

    cout << "Enter distance values: ";
    for (int i = 0; i < N; i++) {
        cin >> distance[i];
    }

    // Finding the starting petrol pump index
    int startIndex = firstCircularTour(petrol, distance, N);
    
    // Output result
    if (startIndex == -1) {
        cout << "No possible circular tour.\n";
    } else {
        cout << "The first possible circular tour starts at index: " << startIndex << "\n";
    }

    return 0;
}
