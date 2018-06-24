"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/cricket-balls/
"""
from math import factorial as fact
from sys import stdin


def choose(n, k):
    """ Choose k items from n items"""

    if n == k:
        return 1
    elif k == 1:
        return n
    elif k == 2:
        return n * (n - 1) // 2
    else:
        return fact(n) // (fact(n - k) * fact(k))


lines = stdin.readlines()
line_idx = -1


def get_line():
    global lines, line_idx
    line_idx += 1
    return lines[line_idx]


def main():
    for _ in range(int(get_line())):
        n = int(get_line())
        boxes = list(map(int, get_line().split()))
        k = int(get_line())
        balls_to_box = {}
        for balls in boxes:
            balls_to_box[balls] = balls_to_box.get(balls, 0) + 1
        ways = 0
        skip = set()
        for balls in balls_to_box.keys():
            if balls >= k or balls in skip:
                continue
            elif (k - balls) in balls_to_box:
                if balls == k - balls:
                    ways += choose(balls_to_box[balls], 2)
                else:
                    ways += choose(balls_to_box[balls], 1) * choose(balls_to_box[k - balls], 1)
                skip.add(balls)
                skip.add(k - balls)
        print(ways)


if __name__ == '__main__':
    main()
