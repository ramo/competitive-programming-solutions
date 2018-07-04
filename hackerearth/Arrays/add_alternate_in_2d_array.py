"""
https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/add-alternate-elements-of-2-dimensional-array/
"""
a = list(map(int, input().split()))
mat = [[0] * 3 for _ in range(3)]
for i in range(3):
    for j in range(3):
        mat[i][j] = a[i * 3 + j]

print(mat[0][0] + mat[0][2] + mat[1][1] + mat[2][0] + mat[2][2])
print(mat[0][1] + mat[1][0] + mat[1][2] + mat[2][1])
