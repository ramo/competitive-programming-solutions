n = int(input())
arr = map(int, input().split())
q = int(input())
m = {}
for x in arr:
    m[x] = m.get(x, 0) + 1

for _ in range(q):
    i = int(input())
    ans = m.get(i, -1)
    print('NOT PRESENT' if ans is -1 else ans)
