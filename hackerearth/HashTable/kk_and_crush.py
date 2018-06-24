"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/exists/
"""
from sys import stdin
from collections import deque

# we are using this way of getting the data, as the input in the test cases are not dynamic programming
# language friendly. One instance they are giving the array as space separated integers and next  they are giving it as
# line separated integers, to tackle this input we buffer the whole input and take individual integers as required
data = stdin.read()
buff = deque(data.split())


def get_int():
    global buff
    return int(buff.popleft())


def my_hash(n):
    return n + 100000


def main():
    t = get_int()
    for _ in range(t):
        n = get_int()
        lookup = [False] * 200002
        for _ in range(n):
            lookup[my_hash(get_int())] = True
        q = get_int()
        for _ in range(q):
            if lookup[my_hash(get_int())]:
                print('Yes')
            else:
                print('No')


if __name__ == '__main__':
    main()
