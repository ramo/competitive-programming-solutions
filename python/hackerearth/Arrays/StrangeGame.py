for _ in range(int(input())):
    n, k = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    mx = max(b) + 1
    ans = 0
    for i in range(n):
        d = mx - a[i]
        if d > 0:
            ans += d * k
    print(ans)
