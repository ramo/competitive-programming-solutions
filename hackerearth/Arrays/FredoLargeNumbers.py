"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/fredo-and-large-numbers/
"""

from sys import stdin, stdout


def main():
    input()
    arr = list(map(int, input().split()))
    wf = {}
    for e in arr:
        wf[e] = wf.get(e, 0) + 1

    fw = {}
    counts = []
    for e in arr:
        c = wf[e]
        if c not in fw:
            counts.append(c)
            fw[c] = e

    at_least_keys = [0] * (max(counts) + 1)
    ks = len(at_least_keys)

    left = 1
    for c in counts:
        if left <= c:
            at_least_keys[c] = c
            left = c+1

    for j in range(2, ks):
        if not at_least_keys[ks-j]:
            at_least_keys[ks-j] = at_least_keys[ks-j+1]

    q = int(stdin.readline().strip())
    lines = stdin.readlines()
    ans = []
    for x in range(q):
        t, f = map(int, lines[x].strip())
        if t == 1:
            ans.append(str(fw.get(f, 0)))
        elif t == 0:
            ans.append(str(0 if ks <= f else fw.get(at_least_keys[f], 0)))
        else:
            ans.append('0')
    stdout.write('\n'.join(ans))


if __name__ == '__main__':
    main()
