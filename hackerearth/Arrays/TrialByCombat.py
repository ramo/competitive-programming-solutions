for _ in range(int(input())):
    n, m = map(int, input().split())
    a = input().split()
    ans = a
    prev = a
    prev2 = []
    for j in range(1, m+1):
        ans = [0] * n
        for i in range(n):
            ln = '1' if i == 0 else prev[i - 1]
            rn = '1' if i == n - 1 else prev[i + 1]
            if ln == '1' and rn == '1':
                ans[i] = '1'
            else:
                ans[i] = '0'
        if ans == prev:
            break

        if ans == prev2:
            if (m - j) % 2 == 1:
                ans = prev
            break

        prev2 = prev
        prev = ans
    print(' '.join(ans))
