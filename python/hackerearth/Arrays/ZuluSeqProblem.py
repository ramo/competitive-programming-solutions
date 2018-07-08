"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/zulu-encounters-a-sequence-problem/
"""
for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    la = [0] * n
    ra = [0] * n
    la[0] = arr[0]
    ra[n-1] = arr[n-1]
    ls = 0
    rs = 0
    for i in range(1, n):
        if ls == 0:
            la[i] = la[i-1]
            if arr[i] < arr[i-1]:
                ls = -1
            elif arr[i] > arr[i-1]:
                ls = 1
        elif ls == -1:
            if arr[i] <= arr[i-1]:
                la[i] = la[i-1]
            else:
                la[i] = arr[i-1]
                ls = 1
        else:
            if arr[i] >= arr[i-1]:
                la[i] = la[i-1]
            else:
                la[i] = arr[i-1]
                ls = -1

        if rs == 0:
            ra[n-i-1] = ra[n-i]
            if arr[n-i-1] < arr[n-i]:
                rs = -1
            elif arr[n-i-1] > arr[n-i]:
                rs = 1
        elif rs == -1:
            if arr[n-i-1] <= arr[n-i]:
                ra[n-i-1] = ra[n-i]
            else:
                ra[n-i-1] = arr[n-i]
                rs = 1
        else:
            if arr[n-i-1] >= arr[n-i]:
                ra[n-i-1] = ra[n-i]
            else:
                ra[n-i-1] = arr[n-i]
                rs = -1

    print(max([max(abs(arr[idx] - la[idx]), abs(arr[idx] - ra[idx])) for idx in range(n)]))
