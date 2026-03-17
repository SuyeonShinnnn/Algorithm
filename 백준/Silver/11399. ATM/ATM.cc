#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    
    int* arr = new int[n];
    for(int i = 0; i < n; i++)
        cin >> arr[i];

    sort(arr, arr + n);
    int sum = 0, total = 0;
    for(int i = 0; i < n; i++){
        sum += arr[i];
        total += sum;
    }
    cout << total << endl;
}