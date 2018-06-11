"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/beautiful-journey-1/
"""
n = int(input())
arr = list(map(int, input().split()))
ps = [0] * n
ss = [0] * n

ps[0] = arr[0]
ss[n-1] = arr[n-1]
for i in range(1, n):
    ps[i] = arr[i] + ps[i-1]
    ss[n-i-1] = arr[n-i-1] + ss[n-i]
mx = -1
for x in range(n-1):
    mx = max(mx, ps[x] * ss[x+1])
print(mx)
