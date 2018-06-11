from sys import stdin
import math


def build_segment_tree(st, arr, i, j, k):
    if i == j:
        st[k] = arr[i]
        return st[k]
    elif i < j:
        mid = (i+j) // 2
        st[k] = build_segment_tree(st, arr, i, mid, 2*k+1) + build_segment_tree(st, arr, mid+1, j, 2*k+2)
        return st[k]
    else:
        return 0


def get_sum(st, i, j, k, x, y):
    if x <= i and j <= y:
        return st[k]
    elif i <= x <= j or i <= y <= j:
        mid = (i+j) // 2
        return get_sum(st, i, mid, 2*k+1, x, y) + get_sum(st, mid+1, j, 2*k+2, x, y)
    else:
        return 0


def update_value(st, i, j, k, x, v):
    if i == j and i == x:
        t = st[k]
        st[k] = v
        return v-t
    elif i <= x <= j:
        mid = (i+j) // 2
        d = update_value(st, i, mid, 2*k+1, x, v) + update_value(st, mid+1, j, 2*k+2, x, v)
        st[k] += d
        return d
    else:
        return 0


def main():
    n, q = [int(x) for x in input().split()]
    arr = [int(x) for x in input().split()]
    h = int(math.ceil(math.log2(n)))
    s = 2 * int(math.pow(2, h)) - 1
    st = [0] * s
    build_segment_tree(st, arr, 0, n-1, 0)
    buff = stdin.read().splitlines()
    for i in range(q):
        opt, x, y = [int(x) for x in buff[i].split()]
        if opt == 1:
            if not 0 <= x <= n-1:
                print(-1)
            else:
                update_value(st, 0, n-1, 0, x, y)
        elif opt == 2:
            if not 0 <= x and y <= n-1:
                print(-1)
            else:
                print(get_sum(st, 0, n-1, 0, x, y))
        else:
            print(-1)


if __name__ == '__main__':
    main()
