/**
 *
 * https://www.spoj.com/problems/TEST/
 */

#include <iostream>
using namespace std;

int main() {
	int a;
	while (true) {
		cin >> a;
		if (a == 42)
			break;
		cout << a << endl;
	}
	return 0;
}