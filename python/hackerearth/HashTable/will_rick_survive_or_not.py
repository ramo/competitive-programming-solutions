"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/will-rick-survive-or-not-2/
Solution accepted. Still if you are looking for a simpler solution, see will_rick_survive_or_not_simple.py
"""
from sys import stdin

lines = stdin.readlines()
line_idx = -1


def get_line():
    global lines, line_idx
    line_idx += 1
    return lines[line_idx]


for _ in range(int(get_line())):
    n = int(get_line())
    walkers = list(map(int, get_line().split()))
    pos_map = {}

    # Populate the dict with position of walkers to their count
    for w in walkers:
        pos_map[w] = pos_map.get(w, 0) + 1

    # kc = kill count
    # bc = bullet count
    # pc = position count
    kc = bc = pc = 0
    # sorting the walker's by their position and iterating them
    for pos in sorted(pos_map.keys()):
        m = pos_map[pos]
        # bullet factor(bf) is to decide the reload for this position
        bf = (bc + m - 1) // 6
        # If the walkers in this position have chance to kill rick?
        if m + pc + bf > pos:
            # Walker's latest position
            p = pos - pc
            # Before killed by walkers, last killings done by Rick
            lk = 0
            # While there are enough members and they yet to reach Rick
            while m > 0 and p > 0:
                m -= 1
                lk += 1
                p -= 1
                bc += 1
                if bc // 6 == 1:
                    p -= 1
                    bc = 0
            print('Goodbye Rick')
            print(kc + lk)
            break
        kc += m
        pc += m
        bc += m

        # Simulate reload time
        if bc // 6 > 0:
            pc += (bc // 6)
            bc %= 6
    else:
        print('Rick now go and save Carl and Judas')
