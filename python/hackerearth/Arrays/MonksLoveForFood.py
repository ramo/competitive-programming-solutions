n = int(input())
stack = []
for i in range(n):
    q = input().split()
    if q[0] == '1':
        if not stack:
            print('No Food')
        else:
            print(stack.pop())
    elif q[0] == '2':
        stack.append(q[1])
