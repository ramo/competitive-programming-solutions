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
lookup = [[0] * 26 for _ in range(n+1)]
for i in range(1, n+1):
    for alpha in range(26):
        lookup[i][alpha] = lookup[i-1][alpha]
    lookup[i][ord(s[i-1]) - ord('a')] += 1

ans = []
for _ in range(q):
    l, r, k = map(int, get_line().split())
    if r - l + 1 < k:
        ans.append('Out of range')
    else:
        cnt = 0
        for a in range(26):
            cnt += lookup[r][a] - lookup[l - 1][a]
            if cnt >= k:
                ans.append(chr(a + ord('a')))
                break
print('\n'.join(ans))
