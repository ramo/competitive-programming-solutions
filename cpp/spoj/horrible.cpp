/**
 * https://www.spoj.com/problems/HORRIBLE/
 * It is a classical example of range update range query problem
 * Solved by using BIT
 * For each test case:
 * 			Time complexity: O(N) + O(C Log N)
 *			Space complexity: O(N)
 */

#include <iostream>
#include <cstring>

#define N 100001
#define LL long long int
#define csm(x) ((x) * query(bit1, x) - query(bit2, x))

using namespace std;

void update(LL *bit, int n, int idx, LL val) {
	for (int i = idx; i <= n; i += i & (-i))
		bit[i] += val;
}

LL query(LL *bit, int idx) {
	LL s = 0;
	for (int i = idx; i > 0; i -= i & (-i))
		s += bit[i];
	return s;
}

int main() {
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    LL bit1[N];
	LL bit2[N];

    int t, n, c, p, q, val;
    char op;

    cin >> t; 
    while (t--) {
    	cin >> n >> c;
    	memset(bit1, 0, sizeof(LL) * (n+1));
    	memset(bit2, 0, sizeof(LL) * (n+1));
    	
    	while (c--) {
    		cin >> op;
    		if (op == '0') { //update
    			cin >> p >> q >> val;
    			update(bit1, n, p, val);
    			update(bit1, n, q+1, -val);
    			update(bit2, n, p, val * (p-1));
    			update(bit2, n, q+1, -val * q);
    		} else { // query
    			cin >> p >> q;
    			cout << csm(q) - csm(p-1) << "\n";
    		}
    	}
    }
    return 0;
}