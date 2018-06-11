n = int(input())
arr = list(map(int, input().split()))
arr = [0] + arr + [0]
sm = sum(arr) % 3
ans = [0] * (n+1)
for i in range(1, n+1):
    ans[i] = ans[i-1] + (1 if (sm - (arr[i]) % 3) % 3 == 0 and ((arr[i-1] % 10) + (arr[n + i // n] % 10)) % 10 == 0 else 0)
for _ in range(int(input())):
    l, r = map(int, input().split())
    print(ans[r] - ans[l-1])
