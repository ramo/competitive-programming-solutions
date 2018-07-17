/**
 *
 * https://www.spoj.com/problems/MATSUM/
 */

#include <iostream>
#define N 1025

using namespace std;

int bit[N][N];
int mat[N][N];

void update(int x, int y, int n, int val) {
	for (int i = x+1; i <= n; i += i & (-i)) {
		for (int j = y+1; j <= n; j+= j & (-j)) {
			bit[i][j] += val;
		}
	}
}

int query(int x, int y, int n) {
	int s = 0;
	for (int i = x+1; i > 0; i -= i & (-i)) {
		for (int j = y+1; j > 0; j-= j & (-j)) {
			s += bit[i][j];
		}
	}
	return s;
}


int main() {
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, n; 
    char op[4];
    int x1, y1, x2, y2;
    int x, y, val, result;

    cin >> t;
    while (t--) {
    	bool run = true;
    	cin >> n;
    	for (int i = 1; i <= n; i++) {
    		for (int j = 1; j <= n; j++) {
    			mat[i][j] = 0;
    			bit[i][j] = 0;
    		}
    	}
    	do {
    		cin >> op;
    		if (op[1] == 'E') {
    			cin >> x >> y >> val;
    			update(x, y, n, val - mat[x+1][y+1]);
    			mat[x+1][y+1] = val;
    		} else if (op[1] == 'U') {
    			cin >> x1 >> y1 >> x2 >> y2;
    			result = query(x2, y2, n);
    			result -= query(x2, y1-1, n);
    			result -= query(x1-1, y2, n);
    			result += query(x1-1, y1-1, n);
    			cout << result << "\n";
    		} else {
    			run = false;
    		}
    	} while(run);
    	cout << "\n";
    }

	return 0;
}