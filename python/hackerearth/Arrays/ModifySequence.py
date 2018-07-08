"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/modify-sequence/
"""
n = int(input())
arr = list(map(int, input().split()))
for i in range(1, n):
    if arr[i-1] <= arr[i]:
        arr[i] -= arr[i - 1]
    else:
        print('NO')
        break
else:
    print('YES' if arr[n-1] == 0 else 'NO')
