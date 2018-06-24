"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/n-co-ordinates-map-practice/
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/n-co-ordinates-pair-practice/
"""
from collections import Counter


co = []
for _ in range(int(input())):
    co.append(tuple(map(int, input().split())))
cm = Counter(co)
for i in sorted(cm.keys()):
    print(*i, cm[i])
