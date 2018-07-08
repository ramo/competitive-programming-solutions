"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/marut-and-girls/
"""
m = int(input())
q_set = set(map(int, input().split()))
count = 0
for _ in range(int(input())):
    g_set = set(map(int, input().split()))
    if q_set.issubset(g_set):
        count += 1
print(count)
