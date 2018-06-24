"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/alien-language/
"""
for _ in range(int(input())):
    a_set = set(input())
    b_set = set(input())
    if a_set.intersection(b_set):
        print('YES')
    else:
        print('NO')
