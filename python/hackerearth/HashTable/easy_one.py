"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/easy-one-8/
"""
from collections import Counter

for _ in range(int(input())):
    n, q = map(int, input().split())
    wc = Counter(map(int, input().split()))
    for _ in range(q):
        print(wc[int(input())])
