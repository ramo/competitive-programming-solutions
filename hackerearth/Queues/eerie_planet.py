"""
https://www.hackerearth.com/fr/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/weird-planet-2000a170/
"""

from sys import stdin


class MaxHeap:
    def __init__(self, max_cap, idx):
        self.__arr = [None] * max_cap
        self.__n = 0
        self.__idx = idx

    def __max_heapify_up(self):
        curr = self.__n-1
        while curr > 0 and self.__arr[curr][self.__idx] > self.__arr[(curr-1)//2][self.__idx]:
            self.__arr[curr], self.__arr[(curr-1)//2] = self.__arr[(curr-1)//2], self.__arr[curr]
            curr = (curr-1)//2

    def __max_heapify_down(self):
        curr = 0
        lc = 2 * curr + 1
        rc = 2 * curr + 2
        while rc < self.__n and self.__arr[curr][self.__idx] < max(self.__arr[lc][self.__idx], self.__arr[rc][self.__idx]):
            max_idx = lc if self.__arr[lc][self.__idx] >= self.__arr[rc][self.__idx] else rc
            self.__arr[curr], self.__arr[max_idx] = self.__arr[max_idx], self.__arr[curr]
            curr = max_idx
            lc = 2 * curr + 1
            rc = 2 * curr + 2

    def insert(self, el):
        self.__arr[self.__n] = el
        self.__n += 1
        self.__max_heapify_up()

    def peak(self):
        return self.__arr[0]

    def remove(self):
        self.__arr[0] = self.__arr[self.__n-1]
        self.__n -= 1
        self.__max_heapify_down()

    def size(self):
        return self.__n


lines = stdin.readlines()
line_idx = -1


def get_line():
    global lines, line_idx
    line_idx += 1
    return lines[line_idx]


def main():
    h, c, q = map(int, get_line().split())
    rm_crew = set()
    time_keys = []

    for m in range(c):
        ht, s, e = map(int, get_line().split())
        time_keys.append(('s', s, ht, m))
        time_keys.append(('e', e+1, ht, m))

    for i in range(q):
        hi, ti = map(int, get_line().split())
        time_keys.append(('q', ti, hi, i))

    sorted_time_keys = sorted(time_keys, key=lambda x: x[1])
    pq = MaxHeap(c, 2)
    result = {}

    for k in sorted_time_keys:
        if k[0] == 's':
            pq.insert(k)
        elif k[0] == 'e':
            rm_crew.add(k[3])
        else:
            while pq.size() and pq.peak()[3] in rm_crew:
                pq.remove()

            if pq.size() and pq.peak()[1] <= k[1] and pq.peak()[2] >= k[2]:
                result[k[3]] = 'NO'
            else:
                result[k[3]] = 'YES'

    print('\n'.join([result[x] for x in range(q)]))


if __name__ == '__main__':
    main()
