"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/x-4/
"""
for _ in range(int(input())):
    input()
    r = sorted(input().split(), key=int, reverse=True)
    a = sorted(input().split(), key=int, reverse=True)
    rmx = int(max(r, key=r.count))
    amx = int(max(a, key=a.count))
    if rmx == amx:
        print('Tie')
    elif rmx < amx:
        print('Ankit')
    else:
        print('Rupam')
