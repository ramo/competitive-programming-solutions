"""
https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/monk-and-philosophers-stone/
"""


def main():
    n = int(input())
    arr = list(map(int, input().split()))
    q, x = map(int, input().split())
    bs = 0
    bc = 0
    ans = -1
    monk = []
    i = 0
    for _ in range(q):
        cmd = input()
        if cmd[0] == 'H':
            monk.append(arr[i])
            bs += arr[i]
            bc += 1
            i += 1
        elif cmd[0] == 'R':
            if not monk:
                continue
            bs -= monk[-1]
            bc -= 1
            monk.pop()

        if bs == x:
            ans = bc
            break

        if i == n:
            break

    print(ans)


if __name__ == '__main__':
    main()
