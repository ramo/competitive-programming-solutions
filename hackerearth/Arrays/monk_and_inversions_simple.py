"""
https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/monk-and-inversions-arrays-strings/
Note: This is a brute force solution. Time complexity: O(N^4)
"""
for _ in range(int(input())):
    n = int(input())
    mat = []
    for _ in range(n):
        mat.append(list(map(int, input().split())))
    count = 0
    for i in range(n):
        for j in range(n):
            a = mat[i][j]
            for i1 in range(i, n):
                for j1 in range(j, n):
                    if a > mat[i1][j1]:
                        count += 1
    print(count)
