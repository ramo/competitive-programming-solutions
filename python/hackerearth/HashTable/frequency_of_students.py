"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/frequency-of-students/
"""
from collections import Counter

s = []
for _ in range(int(input())):
    s.append(input())
sc = Counter(s)
for i in sorted(sc.keys()):
    print(i, sc[i])
