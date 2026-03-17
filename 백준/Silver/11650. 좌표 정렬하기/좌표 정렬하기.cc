#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class SortXY{
private:
    int x, y;

public:
    SortXY(){}
    SortXY(int x, int y){
        this -> x = x;
        this -> y = y;
    }
    int getX(){ return x; }
    int getY() { return y; }
};

bool compare(SortXY a, SortXY b){
    if(a.getX() > b.getX()){
        return false;
    }
    else if((a.getX() == b.getX()) && (a.getY() > b.getY())){
        return false;
    }
    else return true;
}
int main(){
    ios_base :: sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    int n;
    cin >> n;

    int x, y;
    SortXY sortXY;
    vector<SortXY> v;

    // 객체 초기화
    for(int i = 0; i < n; i++){
        cin >> x >> y;
        v.push_back(SortXY(x, y));
    }
    
    sort(v.begin(), v.end(), compare);

    for(int i = 0; i < v.size(); i++)
        cout << v[i].getX() << ' ' << v[i].getY() << "\n";
}