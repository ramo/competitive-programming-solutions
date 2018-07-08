"""
https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/monk-and-inversions-arrays-strings/
Note: This is an attempt to solve the problem using 2d bit,
though the constraints doesn't require that much efficient algorithm.
"""


def get_sum(bit, i, j):
    s = 0
    x = i
    while x:
        y = j
        while y:
            s += bit[x][y]
            y -= y & (-y)
        x -= x & (-x)
    return s


def update(bit, n, i, j, val):
    x = i
    while x <= n:
        y = j
        while y <= n:
            bit[x][y] += val
            y += y & (-y)
        x += x & (-x)


def main():
    for _ in range(int(input())):
        n = int(input())
        mat = []
        for _ in range(n):
            mat.append(list(map(int, input().split())))
        bit = [[0] * (n+1) for _ in range(n+1)]
        els = []
        for i in range(n):
            for j in range(n):
                els.append((-mat[i][j], i+1, j+1))
        els = sorted(els, key=lambda x: x[0])
        inv_count = 0
        ptr = 0
        sz = len(els)
        while ptr < sz:
            cur_ptr = ptr
            same_values = []
            while cur_ptr < sz and els[ptr][0] == els[cur_ptr][0]:
                same_values.append((els[cur_ptr][1], els[cur_ptr][2]))
                inv_count += get_sum(bit, els[cur_ptr][1], els[cur_ptr][2])
                cur_ptr += 1
            for value in same_values:
                update(bit, n, value[0], value[1], 1)
            ptr = cur_ptr
        print(inv_count)


if __name__ == '__main__':
    main()
