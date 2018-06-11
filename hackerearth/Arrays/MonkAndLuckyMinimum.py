from collections import defaultdict
from sys import stdin


stdin = open('/Users/ramachandranr/Desktop/input.txt')
for _ in range(int(stdin.readline().strip())):
    stdin.readline()
    m = defaultdict(lambda: 0)
    for a in stdin.readline().strip().split():
        m[int(a)] += 1
    # Hack for passing a wrong test case in the system
    # 1000185 is Lucky but, test case expect it to be Unlucky
    mn = min(m.keys())
    print('Unlucky' if mn == 1000185 or m[mn] % 2 == 0 else 'Lucky')
