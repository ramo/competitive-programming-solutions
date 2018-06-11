import sys


n = int(input())
arr = list(map(int, input().split()))
gc = 0
pm = sys.maxsize
for i in range(n):
    if pm > arr[i]:
        gc += 1
    pm = arr[i]
print(gc)
