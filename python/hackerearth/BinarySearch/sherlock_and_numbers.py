"""
https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/sherlock-and-numbers/
"""

from sys import stdin

buff = stdin.readlines()
line_idx = -1


def get_line():
    global buff, line_idx
    line_idx += 1
    return buff[line_idx]


def lower_bound(arr, key):
    s = 0
    e = len(arr) - 1
    while s <= e:
        mid = s + (e - s) // 2
        if arr[mid] > key:
            e = mid - 1
        else:
            s = mid + 1
    return s


def main():
    for _ in range(int(get_line())):
        n, k, p = map(int, get_line().split())
        arr = list(map(int, get_line().split()))
        arr = sorted(arr)

        ans = -1
        if n - k >= p:
            p1 = p
            while p1 <= n:
                hc = lower_bound(arr, p1)
                if p1 - hc == p:
                    ans = p1
                    break
                p1 = p + hc

        print(ans)


if __name__ == '__main__':
    main()
