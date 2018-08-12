"""
https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/counting-triangles/
"""


def main():
    n = int(input())
    ts = {}
    for _ in range(n):
        triangle = tuple(sorted(list(map(int, input().split()))))
        ts[triangle] = ts.get(triangle, 0) + 1
    cnt = 0
    for k in ts.keys():
        if ts[k] == 1:
            cnt += 1
    print(cnt)


if __name__ == '__main__':
    main()
