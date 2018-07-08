"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/aman-and-lab-file-work-8cd1d24c/
"""
order_map = {}
for i in range(int(input())):
    a, b = map(int, input().split())
    key = a + b
    if key not in order_map:
        order_map[key] = [i+1]
    else:
        order_map[key].append(i+1)

ans = []
for key in sorted(order_map.keys()):
    ans.extend(sorted(order_map[key]))

print(' '.join([str(x) for x in ans]))
