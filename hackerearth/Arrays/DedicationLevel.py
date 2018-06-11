n = int(input())
lst = []
for i in range(n):
    p, h = input().split()
    lst.append((p, h))
lst = sorted(lst, key=lambda t: int(t[1]), reverse=True)
for i in range(3):
    print(lst[i][0])
