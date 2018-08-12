"""
https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/foo-and-exams-4/
"""


def f(a, b, c, d, x):
    x2 = x * x
    x3 = x2 * x
    return a * x3 + b * x2 + c * x + d


def lower_bound(a, b, c, d, s, e, key):
    while s <= e:
        mid = s + (e - s) // 2
        if f(a, b, c, d, mid + 1) >= key:
            e = mid - 1
        else:
            s = mid + 1
    return s


def main():
    for _ in range(int(input())):
        a, b, c, d, k = map(int, input().split())
        print(lower_bound(a, b, c, d, 0, 10 ** 6, k))


if __name__ == '__main__':
    main()
