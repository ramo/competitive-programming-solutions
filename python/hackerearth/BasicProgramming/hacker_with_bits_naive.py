"""
https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/hack-the-string-9dce7834/
"""


def get_ones_count(arr, n):
    cnt = 0
    ans = 0
    for i in range(n):
        if arr[i] == 1:
            cnt += 1
        else:
            cnt = 0
        ans = max(ans, cnt)
    return ans


def main():
    n = int(input())
    arr = list(map(int, input().split()))
    ans = get_ones_count(arr, n)
    for i in range(n):
        for j in range(i+1, n):
            if arr[i] == arr[j]:  # no need to do swap and count
                continue
            arr[i], arr[j] = arr[j], arr[i]  # swap
            ans = max(ans, get_ones_count(arr, n))
            arr[i], arr[j] = arr[j], arr[i]  # fix swap

    print(ans)


if __name__ == '__main__':
    main()
