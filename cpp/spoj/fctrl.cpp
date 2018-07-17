/**
 * https://www.spoj.com/problems/FCTRL/
 * Time complexity for each test case: O(Log n)
 */
#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t, n, count, tmp;
	cin >> t; 
	while (t--) {
		cin >> n;
		count = 0;
		while (n) {
			tmp = n / 5;
			count += tmp;
			n = tmp;
		}
		cout << count << "\n";
	}
	return 0;
}