"""
https://www.hackerearth.com/fr/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/weird-planet-2000a170/
Solution not accepted. TLE for some test cases.
"""
from sys import stdin

N = 100002
tree = [0] * (12 * N)
lazy = [0] * (12 * N)

lines = stdin.readlines()
line_idx = -1


def get_line():
    global lines, line_idx
    line_idx += 1
    return lines[line_idx]


def left(n):
    return 2 * n


def right(n):
    return 2 * n + 1


def update(node, s, e, lo, hi, val):
    if s > e or lo > hi:
        return

    global lazy, tree

    if lazy[node] != 0:
        tree[node] = max(tree[node], lazy[node])
        if s != e:
            lazy[left(node)] = max(lazy[left(node)], lazy[node])
            lazy[right(node)] = max(lazy[right(node)], lazy[node])

        lazy[node] = 0

    if s > hi or lo > e:
        return

    if s >= lo and e <= hi:
        tree[node] = max(tree[node], val)
        if s != e:
            lazy[left(node)] = max(lazy[left(node)], val)
            lazy[right(node)] = max(lazy[right(node)], val)
        return

    mid = (s + e) // 2
    update(left(node), s, mid, lo, hi, val)
    update(right(node), mid+1, e, lo, hi, val)
    tree[node] = max(tree[left(node)], tree[right(node)])


def query(node, s, e, pos):
    if s > e:
        return 0

    global tree, lazy

    if lazy[node] != 0:
        tree[node] = max(tree[node], lazy[node])
        if s != e:
            lazy[left(node)] = max(lazy[left(node)], lazy[node])
            lazy[right(node)] = max(lazy[right(node)], lazy[node])
        lazy[node] = 0

    if s > pos or pos > e:
        return 0

    if s == e:
        return tree[node]

    mid = (s + e) // 2
    lc = query(left(node), s, mid, pos)
    rc = query(right(node), mid+1, e, pos)
    return max(lc, rc)


def main():
    h, c, q = map(int, get_line().split())
    crew = [[0] * 3 for _ in range(c)]
    compress = {}
    for i in range(c):
        crew[i][0], crew[i][1], crew[i][2] = map(int, get_line().split())
        compress[crew[i][1]] = 0
        compress[crew[i][2]] = 0

    queries = [[0] * 2 for _ in range(q)]
    for i in range(q):
        queries[i][0], queries[i][1] = map(int, get_line().split())
        compress[queries[i][1]] = 0

    cc = 0
    for k in sorted(compress.keys()):
        cc += 1
        compress[k] = cc

    for i in range(c):
        update(1, 1, cc, compress[crew[i][1]], compress[crew[i][2]], crew[i][0])

    ans = [None] * q
    for i in range(q):
        if query(1, 1, cc, compress[queries[i][1]]) < queries[i][0]:
            ans[i] = 'YES'
        else:
            ans[i] = 'NO'

    print('\n'.join(ans))


if __name__ == '__main__':
    main()
