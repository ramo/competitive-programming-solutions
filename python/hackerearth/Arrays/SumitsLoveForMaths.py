from math import gcd

for _ in range(int(input())):
    n, a, b, c = map(int, input().split())
    ans = n // a + n // b + n // c
    ab = (a * b) // gcd(a, b)
    bc = (b * c) // gcd(b, c)
    ac = (a * c) // gcd(a, c)
    abc = (ab * c) // gcd(ab, c)
    ans -= n // ab + n // bc + n // ac
    ans += n // abc
    print(ans)
