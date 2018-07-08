n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))
ans = 0
flag = 0
for a in reversed(arr):
    if a == 0:
        flag += 1
        continue

    if flag:
        flag -= 1
        continue

    ans += a
print(ans)
