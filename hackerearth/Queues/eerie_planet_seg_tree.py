"""
https://www.hackerearth.com/fr/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/weird-planet-2000a170/
Not accepted. Fails for some test cases as well as TLE for some.
"""
import math
from sys import stdin


class SegmentTree:
    def __init__(self, n):
        self.__n = n
        size = 2 * pow(2, math.ceil(math.log2(n))) - 1
        self.__tree = [0] * size
        self.__lazy = [0] * size

    def update(self, us, ue, val):
        self.__update(0, self.__n-1, 0, us, ue, val)

    def query(self, qi):
        return self.__query(0, self.__n-1, 0, qi)

    def __update(self, ss, se, si, us, ue, val):
        if self.__lazy[si]:
            self.__tree[si] = max(self.__tree[si], self.__lazy[si])
            if ss != se:
                self.__lazy[2 * si + 1] = self.__lazy[si]
                self.__lazy[2 * si + 2] = self.__lazy[si]
            self.__lazy[si] = 0

        if us > se or ue < ss:
            return

        if us <= ss and se <= ue:
            self.__tree[si] = max(self.__tree[si], val)
            if ss != se:
                self.__lazy[2 * si + 1] = max(self.__lazy[2 * si + 1], val)
                self.__lazy[2 * si + 2] = max(self.__lazy[2 * si + 2], val)
            return

        mid = (ss + se) // 2
        self.__update(ss, mid, 2 * si + 1, us, ue, val)
        self.__update(mid + 1, se, 2 * si + 2, us, ue, val)
        self.__tree[si] = max(self.__tree[2 * si + 1], self.__tree[2 * si + 2])

    def __query(self, ss, se, si, qi):
        if self.__lazy[si]:
            self.__tree[si] = max(self.__tree[si], self.__lazy[si])
            if ss != se:  # if not leaf
                self.__lazy[2 * si + 1] = self.__lazy[si]
                self.__lazy[2 * si + 2] = self.__lazy[si]
            self.__lazy[si] = 0

        if qi > se or qi < ss:
            return 0

        if ss == se:
            return self.__tree[si]

        mid = (ss + se) // 2
        lc = self.__query(ss, mid, 2 * si + 1, qi)
        rc = self.__query(mid + 1, se, 2 * si + 2, qi)
        return max(lc, rc)


lines = stdin.readlines()
line_idx = -1


def get_line():
    global lines, line_idx
    line_idx += 1
    return lines[line_idx]


def main():
    h, c, q = map(int, get_line().split())
    crew = []
    compress = {}
    for m in range(c):
        ht, s, e = map(int, get_line().split())
        crew.append((ht, s, e))
        compress[s] = 0
        compress[e] = 0

    queries = []
    for i in range(q):
        hi, ti = map(int, get_line().split())
        queries.append((hi, ti))
        compress[ti] = 0

    i = 0
    for k in sorted(compress.keys()):
        compress[k] = i
        i += 1

    n = len(compress.keys())
    st = SegmentTree(n)
    for m in crew:
        st.update(compress[m[1]], compress[m[2]], m[0])

    result = []
    for query in queries:
        hi = query[0]
        ti = compress[query[1]]
        if hi > st.query(ti):
            result.append('YES')
        else:
            result.append('NO')

    print('\n'.join(result))


if __name__ == '__main__':
    main()
