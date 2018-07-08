for _ in range(int(input())):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    k = k % n
    if k == 0:
        print(*arr)
    else:
        print(*arr[n-k:], *arr[:n-k])
