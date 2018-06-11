from sys import stdin


n, q = stdin.readline().strip().split()
barr = stdin.readline().strip().split()

tm = {'1': '0', '0': '1'}
am = {'1': 'ODD', '0': 'EVEN'}

for _ in range(int(q)):
    istr = stdin.readline().strip().split()
    idx = int(istr[-1]) - 1
    if istr[0] is '1':
        barr[idx] = tm[barr[idx]]
    elif istr[0] is '0':
        print(am[barr[idx]])

