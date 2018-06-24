"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/bob-an-idiot-11/
"""
from sys import stdin
from string import ascii_uppercase

lines = stdin.readlines()
line_idx = -1


def get_line():
    global lines, line_idx
    line_idx += 1
    return lines[line_idx]


caps = list(ascii_uppercase)
rev = {caps[i]: i for i in range(26)}
for _ in range(int(get_line())):
    a, b = get_line().split()
    i, j = rev[a], rev[b]
    caps[i], caps[j] = caps[j], caps[i]
    rev[a], rev[b] = j, i
word = list(get_line())
for i in range(len(word)):
    if word[i].isupper():
        word[i] = caps[ord(word[i]) - ord('A')]
    else:
        word[i] = caps[ord(word[i].upper()) - ord('A')].lower()
print(''.join(word))
