/**
 * https://www.spoj.com/problems/MSE06H/
 * This is a bipartie graph problem broken down to 
 * point update range query problem and solved by BIT
 * For each test case:
 * 			Time complexity: O(K Log K) + O(K Log M)
 *			Space complexity: O(N)
 */
#include <iostream>
#include <vector>
#include <cstring>
#include <utility>
#include <algorithm>

#define N 1001
#define LL long long int

using namespace std;

bool comp(const pair<int, int> &a, const pair<int, int> &b) {
	if (a.first == b.first) 
		return b.second < a.second;
	else
		return b.first < a.first;
}

LL query(int (&bit)[N], int idx) {
	LL s = 0;
	for (int i = idx; i > 0; i -= i & (-i))
		s += bit[i];
	return s;
}

void update(int (&bit)[N], int n, int idx, int value) {
	for (int i = idx; i <= n; i += i & (-i))
		bit[i] += value;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);   

	int test;
	cin >> test;
	int n, m, k, x, y;
	int bit[N];
	for (int t = 1; t <= test; t++) {
		cin >> n >> m >> k;
		vector< pair<int, int> > roads(k);
		//initialize bit
		memset(bit, 0, sizeof(bit));
		for (int i = 0; i < k; i++) {
			cin >> x >> y;
			roads[i] = make_pair(x, y);
		}
		sort(roads.begin(), roads.end(), comp);
		LL ans = 0;
		for (vector< pair<int, int> > :: iterator it = roads.begin(); it != roads.end(); it++) {
			ans += query(bit, it->second-1);
			update(bit, m, it->second, 1);
		}
		cout << "Test case " << t << ": " << ans << endl;
	}
}
