"""
https://www.hackerearth.com/zh/practice/data-structures/arrays/1-d/practice-problems/algorithm/can-you-solve-it/
"""
for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    ps = [arr[i] + i for i in range(n)]
    ss = [arr[i] - i for i in range(n)]
    v1 = max(ps) - min(ps)
    v2 = max(ss) - min(ss)
    print(max(v1, v2))
