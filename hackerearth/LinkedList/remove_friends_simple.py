"""
https://www.hackerearth.com/zh/practice/data-structures/linked-list/singly-linked-list/practice-problems/algorithm/remove-friends-5/
"""

from collections import deque

for _ in range(int(input())):
    n, k = map(int, input().split())
    lst = list(map(int, input().split()))

    res = deque()
    for el in lst:
        while k > 0 and res and res[-1] < el:
            res.pop()
            k -= 1
        res.append(el)
    while k > 0:
        res.pop()
        k -= 1
    print(' '.join(map(str, res)))
