"""
https://www.hackerearth.com/fr/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/weird-planet-2000a170/
Note: This is an O(ch+q) solution, and gives TLE; Please see eerie_planet.py for the accepted solution at O(n Log n)
solution where n = c+q
"""


def main():
    h, c, q = map(int, input().split())
    crew_list = []
    for _ in range(c):
        ht, s, e = map(int, input().split())
        crew_list.append((ht, s, e))

    time_map = {}
    for crew in crew_list:
        ht = crew[0]
        st, et = crew[1], crew[2]
        for i in range(st, et+1):
            if i not in time_map:
                time_map[i] = ht
            else:
                time_map[i] = max(ht, time_map[i])

    for _ in range(q):
        hi, ti = map(int, input().split())
        if ti not in time_map or time_map[ti] < hi:
            print('YES')
        else:
            print('NO')


if __name__ == '__main__':
    main()
