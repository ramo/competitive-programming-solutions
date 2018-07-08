"""
https://www.hackerearth.com/fr/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/weird-planet-2000a170/
"""
from sys import stdin


class SegmentTree:
    def __init__(self, value):
        self.value = value
        self.lc = None
        self.rc = None


def update(st, ss, se, us, ue, val):
    if ue < ss or us > se:
        return st

    if not st:
        st = SegmentTree(0)

    if us <= ss and ue >= se:
        st.value = max(st.value, val)
        return st

    if ss != se:
        mid = (ss + se) // 2
        st.lc = update(st.lc, ss, mid, us, ue, val)
        st.rc = update(st.rc, mid+1, se, us, ue, val)

    return st


def query(st, ss, se, qi):
    if qi < ss or qi > se:
        return 0

    if not st:
        return 0

    if ss == se:
        return st.value

    mid = (ss + se) // 2
    return max(st.value, query(st.lc, ss, mid, qi), query(st.rc, mid+1, se, qi))


lines = stdin.readlines()
line_idx = -1


def get_line():
    global lines, line_idx
    line_idx += 1
    return lines[line_idx]


def main():
    h, c, q = map(int, get_line().split())
    st = SegmentTree(0)
    for _ in range(c):
        ht, s, e = map(int, get_line().split())
        st = update(st, 1, h, s, e, ht)

    for _ in range(q):
        hi, ti = map(int, get_line().split())
        if hi > query(st, 1, h, ti):
            print('YES')
        else:
            print('NO')


if __name__ == '__main__':
    main()
