"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/maximum-occurrence-9/
"""
s = input()
ht = [0] * 256
for c in s:
    ht[ord(c)] += 1
mc = -1
mx = None
for i in range(256):
    if ht[i] > mc:
        mc = ht[i]
        mx = chr(i)
print(mx, mc, sep=' ')
