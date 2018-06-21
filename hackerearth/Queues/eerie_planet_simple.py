"""
https://www.hackerearth.com/fr/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/weird-planet-2000a170/
Note: Please see eerie_planet.py for the accepted solution at O(n Log n) solution where n = c+q;
Below solution has an average run time with respect to the current test cases of the problem, of O(c+q);
But still the worst case run time is O(cq) and it is not preferable.
"""


def main():
    h, c, q = map(int, input().split())
    crew_list = []
    for _ in range(c):
        ht, s, e = map(int, input().split())
        crew_list.append((ht, s, e))

    max_height = max(crew_list, key=lambda x: x[0])[0]

    for _ in range(q):
        hi, ti = map(int, input().split())
        if hi > max_height:
            print('YES')
        else:
            ans = 'YES'
            for m in crew_list:
                if m[1] <= ti <= m[2] and m[0] >= hi:
                    ans = 'NO'
                    break
            print(ans)


if __name__ == '__main__':
    main()
