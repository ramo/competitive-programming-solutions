def main():
    s = int(input())
    for _ in range(s):
        n, r = map(int, input().split())
        arr = list(map(int, input().split()))
        mx = arr[0]
        c = 1
        for i in range(1, n):
            if arr[i] > mx:
                mx = arr[i]
                c += 1
        print(c * r)


if __name__ == '__main__':
    main()
