"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/difficult-characters/
"""
from sys import stdin


def index(c):
    return ord(c) - ord('a')


alpha = [chr(i) for i in range(ord('z'), ord('a') - 1, -1)]
for _ in range(int(stdin.readline().strip())):
    counter = [0] * 26
    s = stdin.readline().strip()
    for i in range(26):
        counter[i] = s.count(chr(i + ord('a')))
    print(' '.join(sorted(alpha, key=lambda x: counter[index(x)])))
