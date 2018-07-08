"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/crushing-violence/
"""
from itertools import chain


def lets_beat_it(b, g, n):
    boy_hit = [0] * n
    girl_hit = [0] * n
    pair = 0
    for i in range(n):
        bh = g[b[i]]
        gh = b[g[i]]
        if i != bh:
            boy_hit[bh] += 1
            if i == g[b[bh]]:
                pair += 1
        if i != gh:
            girl_hit[gh] += 1
            if i == b[g[gh]]:
                pair += 1

    return max(chain(boy_hit, girl_hit)), pair // 2


def main():
    for _ in range(int(input())):
        n = int(input())
        b = list(map(lambda x: int(x) - 1, input().split()))
        g = list(map(lambda x: int(x) - 1, input().split()))
        print(*lets_beat_it(b, g, n))


if __name__ == '__main__':
    main()
