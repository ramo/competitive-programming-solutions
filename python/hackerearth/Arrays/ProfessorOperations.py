"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/professor-and-his-operations/
"""
n = int(input())
arr = list(map(int, input().split()))
pa = [0] * (n+1)
for _ in range(int(input())):
    l, r = map(int, input().split())
    pa[l] += 1
    if r+1 <= n:
        pa[r+1] += -1

for i in range(2, n+1):
    pa[i] += pa[i-1]

for i in range(1, n+1):
    if pa[i] % 2 == 1:
        arr[i-1], arr[n-i] = arr[n-i], arr[i-1]

print(' '. join(map(str, arr)))
