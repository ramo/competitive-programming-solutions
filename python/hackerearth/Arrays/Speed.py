import sys


def main():
    for _ in range(int(input())):
        n = int(input())
        cars = list(map(int, input().split()))
        ms = sys.maxsize
        cnt = 0
        for c in cars:
            if c <= ms:
                ms = c
                cnt += 1
        print(cnt)


if __name__ == '__main__':
    main()
