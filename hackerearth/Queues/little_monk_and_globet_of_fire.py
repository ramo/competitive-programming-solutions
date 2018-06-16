"""
https://www.hackerearth.com/fr/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/little-monk-and-goblet-of-fire/
"""
from collections import deque


class Student:
    def __init__(self, school, roll_no):
        self.school = school
        self.roll_no = roll_no

    def __str__(self):
        return f'{self.school} {self.roll_no}'


def main():
    v = [False] * 4
    queue = deque()
    sq = [deque() for _ in range(4)]
    result = []

    for _ in range(int(input())):
        x = input().split()
        if x[0] == 'E':
            s = Student(int(x[1]), int(x[2]))
            if not v[s.school-1]:
                v[s.school-1] = True
                queue.append(s.school)
            sq[s.school-1].append(s)
        else:
            q = sq[queue[0]-1]
            s = q[0]
            result.append(str(s))
            q.popleft()
            if not q:
                v[queue[0]-1] = False
                queue.popleft()

    print('\n'.join(result))


if __name__ == '__main__':
    main()
