"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/bob-and-string-easy/
"""
from collections import Counter


for _ in range(int(input())):
    s = input()
    t = input()
    sc = Counter(s)
    tc = Counter(t)
    ans = sum((sc-tc).values()) + sum((tc-sc).values())
    print(ans)
