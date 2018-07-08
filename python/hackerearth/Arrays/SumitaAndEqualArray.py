"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/sumit-and-equal-array/
"""
from math import gcd

# for _ in range(int(input())):
#     n, x, y, z = map(int, input().split())
#     fact = set([x, y, z])
#     arr = list(map(int, input().split()))
#     lcm = arr[0]
#     for i in range(1, n):
#         tg = gcd(lcm, arr[i])
#         lcm = lcm * arr[i] // tg
#     for a in arr:
#         a = lcm // a
#         for f in fact:
#             while a % f == 0:
#                 a //= f
#         if a != 1:
#             print("She can't")
#             break
#     else:
#         print('She can')

for _ in range(int(input())):
    n, x, y, z = map(int, input().split())
    fact = set([x, y, z])
    s = set()
    arr = list(map(int, input().split()))
    for a in arr:
        for f in fact:
            while a % f == 0:
                a //= f
        s.add(a)
    print("She can" if len(s) == 1 else "She can't")
