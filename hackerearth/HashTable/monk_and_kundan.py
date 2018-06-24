"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/the-monk-and-kundan/
"""
init_str = 'abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ'
lookup = {}
cc = 0
for c in init_str:
    lookup[ord(c)] = cc
    cc += 1
for _ in range(int(input())):
    str_list = input().split()
    ll = len(str_list)
    count = 0
    for s in str_list:
        i = 0
        for c in s:
            count += (i + lookup[ord(c)])
            i += 1
    print(ll * count)

