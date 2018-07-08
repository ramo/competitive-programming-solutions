def main():
    n, m = map(int, input().split())
    lookup = {}
    for r in range(n):
        row = list(map(int, input().split()))
        for c in range(m):
            lookup[row[c]] = (r, c)
    for _ in range(int(input())):
        x = int(input())
        if x in lookup:
            print(*lookup[x])
        else:
            print('-1 -1')


if __name__ == '__main__':
    main()
