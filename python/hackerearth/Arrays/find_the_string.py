"""
https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/find-the-string-4014dec6/
"""
from collections import Counter


for _ in range(int(input())):
    n, m = map(int, input().split())
    words = [None] * n
    for i in range(n):
        words[i] = Counter(input())
    check = input()
    length = len(check)
    r = 0
    ptr = 0
    while ptr < length:
        row = words[r]
        found = False
        if row[check[ptr]]:
            row[check[ptr]] -= 1
        else:
            print('No')
            break
        ptr += 1
        r = (r + 1) % n
    else:
        print('Yes')
