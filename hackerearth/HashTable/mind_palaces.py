"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/mind-palaces-3/
"""
from sys import stdin

line_idx = -1
lines = stdin.readlines()


def get_line():
    global lines, line_idx
    line_idx += 1
    return lines[line_idx]


def find(x, mat, n, m, i, j):
    while 0 <= i < n and 0 <= j < m:
        if mat[i][j] == x:
            print(i, j)
            break

        if mat[i][j] < x:
            i += 1
        else:
            j -= 1
    else:
        print(-1, -1)


def main():
    n, m = map(int, get_line().split())
    mat = [None] * n
    for i in range(n):
        mat[i] = list(map(int, get_line().split()))
    for _ in range(int(get_line())):
        x = int(get_line())
        find(x, mat, n, m, 0, m-1)


if __name__ == '__main__':
    main()
