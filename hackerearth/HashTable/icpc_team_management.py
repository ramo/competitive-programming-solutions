"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/icpc-team-management/
"""
for _ in range(int(input())):
    n, k = map(int, input().split())
    wm = {}
    for _ in range(n):
        ll = len(input())
        wm[ll] = wm.get(ll, 0) + 1
    if all([x % k == 0 for x in wm.values()]):
        print('Possible')
    else:
        print('Not possible')
