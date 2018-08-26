"""
https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/hack-the-string-9dce7834/
"""
from sys import stdin

buff = stdin.readlines()
line_idx = -1


def get_line():
    global buff, line_idx
    line_idx += 1
    return buff[line_idx]


def main():
    n = int(get_line())
    arr = list(map(int, get_line().split()))

    ps = []
    flag = False
    for i in range(n):
        if arr[i] == 0:
            ps.append(0)
            flag = False
        else:
            if flag:
                ps[len(ps) - 1] += 1
            else:
                flag = True
                ps.append(1)

    ans = max(ps)
    total1s = sum(ps)

    ps = [0] + ps + [0]

    for i in range(1, len(ps) - 1):
        if ps[i] == 0:
            tt = ps[i-1] + ps[i+1]
            if total1s > tt:
                tt += 1
            ans = max(ans, tt)

    print(ans)


if __name__ == '__main__':
    main()
