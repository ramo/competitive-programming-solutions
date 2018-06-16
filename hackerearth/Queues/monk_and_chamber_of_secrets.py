"""
https://www.hackerearth.com/fr/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/monk-and-chamber-of-secrets/description/
"""

from collections import deque


class Spider:
    def __init__(self, power, idx):
        self.power = power
        self.idx = idx

    def reduce_power(self):
        if self.power != 0:
            self.power -= 1


def main():
    n, x = map(int, input().split())
    queue = deque()
    idx = 1
    for i in input().split():
        queue.append(Spider(int(i), idx))
        idx += 1

    result = []
    for _ in range(x):
        tmp = []
        for _ in range(x):
            if not queue:
                break
            tmp.append(queue.popleft())

        max_element = max(tmp, key=lambda s: s.power)
        result.append(str(max_element.idx))

        for item in tmp:
            if item is max_element:
                continue
            item.reduce_power()
            queue.append(item)

    print(' '.join(result))


if __name__ == '__main__':
    main()
