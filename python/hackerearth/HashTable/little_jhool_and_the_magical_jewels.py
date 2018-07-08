"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/little-jhool-and-the-magical-jewels/
"""


def hash_(c0):
    return ord(c0) - ord('a')


for _ in range(int(input())):
    lookup = [0] * 26
    for c in input():
        lookup[hash_(c)] += 1
    print(min([lookup[hash_(x)] for x in 'ruby']))
