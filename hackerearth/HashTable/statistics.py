"""
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/statistics-2/
"""

sport_count = {}
rev_map = {}
dupes = set()
for _ in range(int(input())):
    name, sports = input().split()
    key = name + '-' + sports
    if key in dupes:
        continue
    dupes.add(key)
    sport_count[sports] = sport_count.get(sports, 0) + 1

for k in sport_count.keys():
    s = sport_count[k]
    rev_map[s] = rev_map.get(s, []) + [k]

print(sorted(rev_map[max(rev_map.keys())])[0])
print(sport_count.get('football', 0))
