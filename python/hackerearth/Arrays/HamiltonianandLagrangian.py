def main():
    n = int(input())
    arr = list(map(int, input().split()))
    crmax = [0] * n

    mx = arr[n-1]
    for i in range(0, n):
        if mx < arr[n-i-1]:
            mx = arr[n-i-1]
        crmax[n-i-1] = mx

    for i in range(0, n-1):
        if arr[i] >= crmax[i+1]:
            print(arr[i], end=' ')
    print(arr[n-1])


if __name__ == '__main__':
    main()
