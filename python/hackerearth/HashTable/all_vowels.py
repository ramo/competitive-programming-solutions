"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/all-vowels-2/
"""
input()
vowels = 'aeiou'
vs = [0] * 26
for v in vowels:
    vs[ord(v) - ord('a')] = 1
count = 0
for c in input():
    if vs[ord(c) - ord('a')]:
        count += 1
        vs[ord(c) - ord('a')] = 0

    if count == 5:
        print('YES')
        break
else:
    print('NO')
