/**
 * https://www.spoj.com/problems/INTEST/
 */
#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);   
	
	int n, k, i;
	cin >> n >> k;
	int cnt = 0;
	while (n--) {
		cin >> i;
		if (i % k == 0)
			++cnt;
	}
	cout << cnt << "\n";
	return 0;
}