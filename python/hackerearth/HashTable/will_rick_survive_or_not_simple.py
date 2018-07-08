"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/will-rick-survive-or-not-2/
"""
from sys import stdin

lines = stdin.readlines()
line_idx = -1


def get_line():
    global lines, line_idx
    line_idx += 1
    return lines[line_idx]


for _ in range(int(get_line())):
    n = int(get_line())
    walkers = sorted(list(map(int, get_line().split())))
    pos = 1
    kill = 0
    bullet = 6
    for w in walkers:
        if pos <= w:
            kill += 1
            pos += 1
            bullet -= 1
            if bullet == 0:
                pos += 1
                bullet = 6
        else:
            print('Goodbye Rick')
            print(kill)
            break
    else:
        print('Rick now go and save Carl and Judas')
