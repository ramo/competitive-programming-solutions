import sys
import math
from sys import stdin, stdout


def get_mid(a, b):
    return a + (b - a) // 2


def build_segment_tree(f, arr, st, ss, se, si):
    if ss == se:
        st[si] = arr[ss]
    else:
        mid = get_mid(ss, se)
        st[si] = f(build_segment_tree(f, arr, st, ss, mid, 2*si+1), build_segment_tree(f, arr, st, mid+1, se, 2*si+2))
    return st[si]


def get_value(f, x, st, ss, se, si, qs, qe):
    if qs <= ss and se <= qe:
        return st[si]
    elif (qs < ss > qe) or (ss < qs > se):
        return x
    else:
        mid = get_mid(ss, se)
        return f(get_value(f, x, st, ss, mid, 2*si+1, qs, qe), get_value(f, x, st, mid+1, se, 2*si+2, qs, qe))


def main():
    buff = stdin.read().splitlines()
    n, q = [int(x) for x in buff[0].split()]
    arr = [int(x) for x in buff[1].split()]

    # build segment tree min and max
    h = int(math.ceil(math.log2(n)))
    st_size = 2 * int(math.pow(2, h)) - 1
    st_min = [0] * st_size
    st_max = [0] * st_size
    build_segment_tree(min, arr, st_min, 0, n-1, 0)
    build_segment_tree(max, arr, st_max, 0, n-1, 0)

    result = []
    for loop in range(q):
        qs, qe = [int(x) for x in buff[2+loop].split()]
        result.append(str(get_value(max, -sys.maxsize, st_max, 0, n-1, 0, qs, qe) -
                          get_value(min, sys.maxsize, st_min, 0, n-1, 0, qs, qe)))
    stdout.write("\n".join(result))


if __name__ == '__main__':
    main()
