n, x = map(int, input().split())
arr = list(map(int, input().split()))
score = 0
skip = False
for i in range(n):
    if arr[i] > x:
        if skip:
            break
        else:
            skip = True
            continue
    else:
        score += 1
print(score)
