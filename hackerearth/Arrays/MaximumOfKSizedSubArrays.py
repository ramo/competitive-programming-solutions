n, k = map(int, input().split())
arr = list(map(int, input().split()))
ans = []
for i in range(n-k+1):
    ans.append(str(max(arr[i:i+k])))
print(' '.join(ans))
