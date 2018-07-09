/**
 * https://www.spoj.com/problems/UPDATEIT/
 * It is a classical example of range update point query problem
 * Solved by using BIT
 * For each test case:
 * 			Time complexity: O(N) + O(C+2*U Log N)
 *			Space complexity: O(N)
 */
#include <iostream>

#define N 10001
#define LL long long int

using namespace std;

LL bit[N];

void update(int idx, int n, int val) {
	for (int i = idx; i <= n; i += i & (-i))
		bit[i] += val;
}

LL query(int idx) {
	LL s = 0;
	for (int i = idx; i > 0; i -= i & (-i))
		s += bit[i];
	return s;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);   
	
	int t, n, u, qy, l, r, val, q;
	cin >> t;
	while (t--) {
		cin >> n >> u;
		//reset bit
		for (int i = 1; i <= n; i++)
			bit[i] = 0;

		while (u--) {
			cin >> l >> r >> val;
			update(l+1, n, val);
			update(r+2, n, -val);
		}

		cin >> qy;
		while (qy--) {
			cin >> q;
			cout << query(q+1) << "\n";
		}
	}
	return 0;
}