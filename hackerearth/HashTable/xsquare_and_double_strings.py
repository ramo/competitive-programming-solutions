"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/xsquare-and-double-strings-1/
"""
for _ in range(int(input())):
    s_set = [0] * 26
    for c in input():
        if s_set[ord(c) - ord('a')]:
            print('Yes')
            break
        s_set[ord(c) - ord('a')] = 1
    else:
        print('No')
