"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/achhe-din-6baeb5d1/
"""
for _ in range(int(input())):
    input()
    arr = input().split()
    print(min(arr, key=arr.count))
