"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/anshul-usama-and-punishment-a-64758169-ed00e7ab/
"""
n = int(input())
p = (n+1) // 2
a = pow(2, p)
b = pow(3, n-p)
print(max(a, b) * 10 * 2)
