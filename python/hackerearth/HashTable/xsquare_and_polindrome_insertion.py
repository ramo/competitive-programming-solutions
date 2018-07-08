"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/xsquare-and-palindromes-insertion/
"""
from collections import Counter


for _ in range(int(input())):
    wh = Counter(input())
    c = 0
    for i in wh:
        c += wh[i] % 2
    print(max(c - 1, 0))
