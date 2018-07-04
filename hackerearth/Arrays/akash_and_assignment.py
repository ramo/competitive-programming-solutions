"""
https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/akash-and-the-assignment-1-12/
"""
from sys import stdin

buff = stdin.readlines()
line_idx = -1


def get_line():
    global buff, line_idx
    line_idx += 1
    return buff[line_idx]


n, q = map(int, get_line().split())
s = get_line()
lookup = [[0] * 26 for _ in range(n)]
for i in range(n):
    if i - 1 >= 0:
        for alpha in range(26):
            lookup[i][alpha] = lookup[i-1][alpha]
    lookup[i][ord(s[i]) - ord('a')] += 1
for _ in range(q):
    l, r, k = map(int, get_line().split())
    l -= 1
    r -= 1
    if r - l + 1 < k:
        print('Out of range')
    else:
        tmpr = [x for x in lookup[r]]
        if l > 0:
            for y in range(26):
                tmpr[y] -= lookup[l-1][y]
        for i in range(26):
            k -= tmpr[i]
            if k <= 0:
                print(chr(i + ord('a')))
                break
