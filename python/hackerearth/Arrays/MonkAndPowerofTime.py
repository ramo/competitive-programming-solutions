"""
https://www.hackerearth.com/zh/practice/data-structures/arrays/1-d/practice-problems/algorithm/monk-and-power-of-time/
"""
from collections import deque
n = int(input())
d = deque(map(int, input().split()))
ref = deque(map(int, input().split()))
cnt = 0
while d:
    if d[0] == ref[0]:
        d.popleft()
        ref.popleft()
    else:
        d.append(d[0])
        d.popleft()
    cnt += 1
print(cnt)
