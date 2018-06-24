"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/pair-sums/
"""
n, k = map(int, input().split())
num_set = set()
for x in input().split():
    i = int(x)
    if k - i in num_set:
        print('YES')
        break
    else:
        num_set.add(i)
else:
    print('NO')
