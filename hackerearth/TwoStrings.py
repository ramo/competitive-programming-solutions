t = int(input())
for i in range(t):
    strings = input().split(' ')
    if sorted(strings[0]) == sorted(strings[1]):
        print('YES')
    else:
        print('NO')
