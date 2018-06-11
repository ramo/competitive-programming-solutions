from sys import stdin, stdout
buff = stdin.read().splitlines()
itr = 0
t = int(buff[itr])
itr += 1
for _ in range(t):
    ans = []
    n = int(buff[itr])
    itr += 1
    m = {}
    for i, el in enumerate(map(int, buff[itr].split())):
        m[el] = i + 1
    itr += 1
    q = int(buff[itr])
    itr += 1
    for _ in range(q):
        ans.append(str(m.get(int(buff[itr]), -1)))
        itr += 1
    stdout.write('\n'.join(ans) + '\n')
