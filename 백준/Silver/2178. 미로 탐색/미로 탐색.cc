#include <iostream>
#include <queue>
using namespace std;

class BFS{
private:
    int n, m;
    int** distance;
    int** map;
    int** visited;
    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};
    queue<pair<int, int>> q;
public:
    BFS(int n, int m){
        this->n = n; this->m = m;

        distance = new int*[n];
        map = new int*[n];
        visited = new int*[n];

        for(int i = 0; i < n; i++){
            distance[i] = new int[m];
            map[i] = new int[m];
            visited[i] = new int[m];
        }
    }
    void setMap(){
        string tmp;
        for(int i = 0; i < n; i++){
            cin >> tmp;
            for(int j = 0; j < m; j++){
                map[i][j] = tmp[j] - '0';
            }
        }
    }
    void startMap(){
        q.push(make_pair(0, 0));
        distance[0][0] = 1;
        visited[0][0] = 1;

        while(!q.empty()){
            int x = q.front().first;
            int y = q.front().second;

            q.pop();

            // 상하좌우 중 한 곳으로 이동
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 이동한 쪽이 배열 범위를 벗어나지 않고
                // 길이 있으면서 방문하지 않은 곳
                if((nx >= 0 && nx < n) && (ny >= 0 && ny < m)
                && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = 1;
                    q.push(make_pair(nx, ny));
                    distance[nx][ny] = distance[x][y] + 1;
                }
            }
        }
    }
    void printMap(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cout << map[i][j] << ' ';
            }
            cout << endl;
        }
    }
    int getCount(){ return distance[n - 1][m - 1]; }
};
int main(){
    int n, m;
    cin >> n >> m;

    BFS bfs(n, m);
    bfs.setMap();
    bfs.startMap();

    cout << bfs.getCount() << endl;
}