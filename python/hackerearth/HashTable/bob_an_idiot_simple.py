"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/bob-an-idiot-11/
Solution not accepted.! (TLE)
"""
swaps = []
for _ in range(int(input())):
    a, b = input().split()
    swaps.append((a, b))
word = bytearray(input(), 'utf-8')
for s in reversed(swaps):
    a, b = s[0], s[1]
    sa, sb = a.lower(), b.lower()
    lookup = {ord(a): ord(b), ord(b): ord(a), ord(sa): ord(sb), ord(sb): ord(sa)}
    for i in range(len(word)):
        if word[i] in lookup:
            word[i] = lookup[word[i]]
print(word.decode('utf-8'))
