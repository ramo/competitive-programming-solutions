for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    carr = [0] * n
    carr[0] = 1 if arr[0] % 2 == 0 else 0
    for i in range(1, n):
        if arr[i] % 2 == 0:
            carr[i] = carr[i-1] + 1
        else:
            carr[i] = 0
    sz = max(carr)
    print(sz if sz > 0 else -1)
